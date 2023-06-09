package emailservice;

import java.util.UUID;

public class RandomNumber {
	
	 public  String generateString() {
	        String uuid = UUID.randomUUID().toString();
	        return  uuid.replace("-", "");
	    }
}
