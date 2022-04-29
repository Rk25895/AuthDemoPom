package GenericUtility;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber() {
		Random random = new Random();
		int intRandom = random.nextInt(1000);
        return intRandom;
       }

	public String getSystemDateAndTime() {
		Date date = new Date();
		return date.toString();
		}
    public String getSystemDateWithFormat() {
		Date date = new Date();
		String dateAndTime = date.toString();
		
    	String YYYY = dateAndTime.split(" ")[5];
    	String DD = dateAndTime.split(" ")[2];
    	int MM = date.getMonth()+1;
    	
    	String finalFormat = YYYY +"-"+MM+"-"+DD;
 
    	return finalFormat;
    	
    }

}
