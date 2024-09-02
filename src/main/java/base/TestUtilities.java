package base;

import org.testng.annotations.DataProvider;

public class TestUtilities extends BaseTest{	
	
	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="NegativeLoginTest")
	public String[][] data(){
		return new String[][] {
			{"tomsmith","","Negative","Your password is invalid!"},
			{"","SuperSecretPassword!","Negative","Your username is invalid!"},
			{"","","Negative","Your username is invalid!"}	
		};
		
	}

}
