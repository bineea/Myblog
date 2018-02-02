package myblog.manager.comment;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import myblog.common.tools.JsonTools;
import myblog.dao.entity.Comment;
import myblog.dao.repo.Spe.CommentSpecification;
import myblog.dao.repo.jpa.CommentRepo;
import myblog.manager.AbstractManager;

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
		
		CommentSpecification spe = new CommentSpecification();
		spe.setText("");
		Page<Comment> page2 = commentRepo.findAll(spe.pageAll(), PageRequest.of(0, 16));
		logger.info("分页查询数据共{}条",page2.getContent().size());
		logger.info(page2.toString());
	}
}
