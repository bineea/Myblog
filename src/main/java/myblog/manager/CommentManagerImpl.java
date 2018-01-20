package myblog.manager;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myblog.common.tools.JsonTools;
import myblog.dao.entity.Comment;
import myblog.dao.repo.jpa.CommentRepo;

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
		
	}
}
