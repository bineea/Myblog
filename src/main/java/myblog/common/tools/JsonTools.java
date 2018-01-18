package myblog.common.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTools {

	public static final String FILTER_NAME = "myFilter";
	protected static Logger logger = LoggerFactory.getLogger(JsonTools.class);
	protected static ObjectMapper mapper ;
	
	static{
		mapper = new ObjectMapper();
		
	}
	
	public static void main(String[] args){
		logger.info("test");
	}
}
