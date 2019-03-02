package myblog.manager.comment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import myblog.common.pub.MyManagerException;
import myblog.common.tools.JsonTools;
import myblog.common.tools.WebTools;
import myblog.dao.entity.Comment;
import myblog.dao.entity.dict.CommentStatus;
import myblog.dao.entity.dict.CommentType;
import myblog.dao.entity.dict.ContentModule;
import myblog.dao.repo.Spe.CommentPageSpe;
import myblog.dao.repo.jpa.CommentRepo;
import myblog.dao.repo.jpa.ContentRepo;
import myblog.manager.AbstractManager;
import myblog.model.comment.CommentModel;

@Service
public class CommentManagerImpl extends AbstractManager implements CommentManager {

	@Autowired
	private CommentRepo commentRepo;
	@Autowired
	private ContentRepo contentRepo;
	
	@Override
	public void test()
	{
		try {
			Optional<Comment> commentOptional = commentRepo.findById("123123");
			commentOptional.ifPresent(comment -> {
				System.out.println(comment.toString());
			});
			if(!commentOptional.isPresent())
				System.out.println("未查询到数据");
				logger.info("info---{} 未查询到数据", "commentOptional");
				logger.debug("debug---{} 未查询到数据", "commentOptional");
				logger.warn("warn---{} 未查询到数据", "commentOptional");
				logger.error("error---{} 未查询到数据", "commentOptional");
				logger.info(JsonTools.entityToJson(new Comment()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<Comment> page1 = commentRepo.pageQuery(null, PageRequest.of(0, 16));
		logger.info("分页查询数据共{}条",page1.getContent().size());
		logger.info(page1.toString());
		
		CommentPageSpe spe = new CommentPageSpe();
		spe.setText("");
		Page<Comment> page2 = commentRepo.findAll(spe.handleSpecification(), PageRequest.of(0, 16));
		logger.info("分页查询数据共{}条",page2.getContent().size());
		logger.info(page2.toString());
	}

	@Override
	public List<CommentModel> allCommentsByContent(String contentId) {
		List<CommentModel> modelList = new ArrayList<>();
		commentRepo.findByContentId(contentId).stream()
				.filter(c -> c.getStatus() == CommentStatus.NORMAL)
				.filter(c -> c.getParentComment() == null)
				.forEach(c -> {
					modelList.add(comment2CommentModel(c));
				});
		return modelList;
	}
	
	private CommentModel comment2CommentModel(Comment comment) {
		CommentModel model = new CommentModel();
		model.setParentIsReplay(comment.getParentComment() != null && comment.getParentComment().getParentComment() != null ? true : false );
		model.setHasParentComment(comment.getParentComment() == null ? false : true);
		model.setComment(comment);
		model.setParentComment(comment.getParentComment());
		commentRepo.findByParentCommentId(comment.getId()).stream()
				.filter(c -> c.getStatus() == CommentStatus.NORMAL)
				.sorted(Comparator.comparing(Comment :: getCreateTime))
				.forEach(c -> {
					model.setHasReplies(true);
					model.getReplyComment().add(comment2CommentModel(c));
				});
		return model;
	}

	@Transactional
	@Override
	public void addComment(Comment comment, HttpServletRequest request) throws MyManagerException {
		validComment(comment);
		updateParentComment(comment);
		if(comment.getCommentType() == CommentType.REPLY)
			comment.setParentComment(commentRepo.findById(comment.getParentCommentId()).get());
		else
			comment.setParentComment(null);
		comment.setContent(contentRepo.findById(comment.getContentId()).get());
		comment.setContentModule(ContentModule.ARTICLE);
		comment.setCommentCount(0);
		comment.setOrderNum(0);
		comment.setStatus(CommentStatus.NORMAL);
		comment.setIp(WebTools.getIpAddress(request));
		comment.setAgent(WebTools.getAgentInfo(request));
		comment.setCreateTime(LocalDateTime.now());
		comment.setSlug(null);
		comment.setVoteUp(0);
		comment.setVoteDown(0);
		comment.setFlag(null);
		comment.setLat(null);
		comment.setLng(null);
	}
	
	private void validComment(Comment comment) throws MyManagerException {
		if(!StringUtils.hasText(comment.getContentId()))
			throw new MyManagerException("系统异常，无法获取文章");
		if(comment.getCommentType() == null)
			throw new MyManagerException("系统异常，无法获取评论类型");
		if(StringUtils.hasText(comment.getAuthor()))
			throw new MyManagerException("名称不能为空");
		if(StringUtils.hasText(comment.getEmail()))
			throw new MyManagerException("邮箱地址不能为空");
		if(StringUtils.hasText(comment.getText()))
			throw new MyManagerException("评论内容不能为空");
		if(comment.getCommentType() == CommentType.REPLY && !StringUtils.hasText(comment.getParentCommentId()))
			throw new MyManagerException("系统异常，无法获取原评论");
		if(!contentRepo.findById(comment.getContentId()).isPresent())
			throw new MyManagerException("系统异常，无法评论，文章不存在");
		if(comment.getCommentType() == CommentType.REPLY 
				&& StringUtils.hasText(comment.getParentCommentId())
				&& !commentRepo.findById(comment.getParentCommentId()).isPresent())
			throw new MyManagerException("系统异常，无法回复，原评论不存在");
	}
	
	private void updateParentComment(Comment comment) {
		if(comment.getCommentType() == CommentType.REPLY 
				&& StringUtils.hasText(comment.getParentCommentId())
				&& commentRepo.findById(comment.getParentCommentId()).isPresent()) {
			//TODO 多线程并发计数（乐观锁是否适用，是否需要考虑ABA问题）
		}
	}
}
