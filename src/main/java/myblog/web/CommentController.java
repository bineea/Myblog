package myblog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import myblog.manager.CommentManager;

@Controller
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private CommentManager manager;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test()
	{
		manager.test();
	}
}
