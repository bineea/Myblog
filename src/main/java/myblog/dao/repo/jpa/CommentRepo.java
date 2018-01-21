package myblog.dao.repo.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import myblog.common.repo.jpa.MyRespository;
import myblog.dao.entity.Comment;

public interface CommentRepo extends MyRespository<Comment, String>{

	@Query(value = "select c from Comment c where c.content.id = ?1 ")
	Page<Comment> pageQuery(String contentId, Pageable pageable);
}
