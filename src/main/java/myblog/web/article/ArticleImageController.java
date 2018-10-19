package myblog.web.article;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import myblog.common.pub.MyManagerException;
import myblog.common.tools.HttpResponseHelper;
import myblog.common.tools.ImageUploadTools;
import myblog.model.article.CkeditorImageModel;
import myblog.web.AbstractController;

@Deprecated
@Controller
public class ArticleImageController extends AbstractController {
	
	@RequestMapping(value = "article/image/upload")
	public void imageUpload(MultipartHttpServletRequest  multipartRequest, HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		CkeditorImageModel model = new CkeditorImageModel();
		try {
			String fileDir = File.separator + "home" + File.separator + "article" + File.separator;
			File file = ImageUploadTools.uploadImage(multipartRequest, fileDir);
			model = CkeditorImageModel.initModel(file, true, null);
		} catch(MyManagerException e) {
			model = CkeditorImageModel.initModel(null, false, e.getMessage());
		}
        // 结合ckeditor功能
        // imageContextPath为图片在服务器地址，如upload/123.jpg,非绝对路径
        HttpResponseHelper.responseJson(model.toJson(), response);
	}
}
