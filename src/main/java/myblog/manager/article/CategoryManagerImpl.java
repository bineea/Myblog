package myblog.manager.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import myblog.dao.entity.Category;
import myblog.dao.repo.jpa.CategoryRepo;
import myblog.manager.AbstractManager;

@Service
public class CategoryManagerImpl extends AbstractManager implements CategoryManager {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public List<Category> findAll() {
		return categoryRepo.findAll();
	}

	@Override
	public Category findById(String id) {
		Assert.hasText(id, "id不能为空");
		return categoryRepo.findById(id).orElse(null);
	}

}
