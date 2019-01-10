package myblog.dao.repo.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import myblog.dao.entity.Comment;
//接口可以多继承，接口中都是抽象方法，允许多继承
public interface CommentRepo extends JpaRepository<Comment, String>, JpaSpecificationExecutor<Comment>{

	@Query(value = "select c from Comment c where c.content.id = ?1 ")
	Page<Comment> pageQuery(String contentId, Pageable pageable);
	
	Page<Comment> findAll(Specification<Comment> spec, Pageable pageable);
	
	@Query(value = "select c from Comment c where c.content.id = ?1")
	List<Comment> findByContentId(String contentId);
	
	@Query(value = "select c from Comment c where c.parentComment.id = ?1")
	List<Comment> findByParentCommentId(String commentId);
}
