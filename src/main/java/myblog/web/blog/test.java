package myblog.web.blog;

public class test {

	public static void main(String[] args) {
		
		String text = Html2Text.getContent("<div><p>测试</p><br/><span>       +123</span></div>");
		System.out.println(text);
	}
}
