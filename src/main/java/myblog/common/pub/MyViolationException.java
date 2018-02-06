package myblog.common.pub;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.validation.ValidationException;

import myblog.common.tools.JsonTools;

public class MyViolationException extends ValidationException {

	private static final long serialVersionUID = -8483944036908660701L;

	private Map<String, String> violations = new HashMap<String, String>(); 
	
	public MyViolationException() {
		
		super();
	}
	
	public MyViolationException(String property, String msg) {
		
		violations.put(property, msg);
	}
	
	public boolean hasViolation() {
		
		return !violations.isEmpty();
	}
	
	public void addViolation(String property, String msg) {
		
		violations.put(property, msg);
	}
	
	public String toJson() {
		
		try {
			return JsonTools.writeValueAsString(violations);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}
