package base;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	protected WebDriver driver;
	protected Logger log;
	protected String testName;
	protected Properties p;
	protected String testMethodName;
	protected String testSuiteName;
	
	@Parameters({"browser"})
	@BeforeMethod(alwaysRun = true)
	public void setUp(Method method,String browser, ITestContext ctx) throws IOException {
		String testName = ctx.getCurrentXmlTest().getName();
		log = LogManager.getLogger(testName);
		
		BrowserDriverFactory factory = new BrowserDriverFactory(browser,log);
		driver = factory.createDriver();
			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		p = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
		p.load(file);		
		driver.get(p.getProperty("appUrl"));
		driver.manage().window().maximize();
		log.info("Setup method executed");
		
		this.testMethodName = method.getName();
		this.testSuiteName = ctx.getSuite().getName();
		this.testName = testName;
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		log.info("Executing Teardown method");
		driver.close();
		log.info("Driver closed");
	}
	

}
