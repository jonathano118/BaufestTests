package pages;

import org.apache.commons.lang3.RandomStringUtils;


public class userSingleton {

	private static userSingleton user = new userSingleton();
	
	
	public String username;
	public String passw;
	
	private userSingleton() {
		String r = RandomStringUtils.randomAlphabetic(6);
		username = r + "@user.com";
		passw = "12345";
	}
	
	public static userSingleton getUser() {
		if(user == null){
            user = new userSingleton();
        }

        return user;
	}
	
	
	
}
