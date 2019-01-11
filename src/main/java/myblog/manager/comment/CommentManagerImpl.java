package myblog.manager.comment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import myblog.common.tools.JsonTools;
import myblog.dao.entity.Comment;
import myblog.dao.entity.dict.CommentStatus;
import myblog.dao.repo.Spe.CommentPageSpe;
import myblog.dao.repo.jpa.CommentRepo;
import myblog.manager.AbstractManager;
import myblog.model.comment.CommentModel;

@Service
public class CommentManagerImpl extends AbstractManager implements CommentManager {

	@Autowired
	private CommentRepo commentRepo;
	
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
}
