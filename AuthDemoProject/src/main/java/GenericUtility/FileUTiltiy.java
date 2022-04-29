package GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUTiltiy {
	
	
	 public String getPropertyKeyValue(String key) throws Throwable {
    	 FileInputStream fis = new FileInputStream("");
    	 Properties pobj = new Properties();
    	 pobj.load(fis);
    	 String value = pobj.getProperty(key);
		 return value;
    }

}
