package mytests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import configreader.ConfigPropReader;
import factory.DriverFactory;
import org.testng.Assert;
import pages.HomePage;

public class HomePageTest {

	  DriverFactory df;
	  ConfigPropReader cp;
	  Properties prop ;
	  WebDriver driver ;
	  HomePage homepage;
	  
	  @BeforeTest
	  public void setUp()
	  {
		  cp = new ConfigPropReader();
		  prop = cp.initLangProp();
		  df = new DriverFactory();
		  driver = df.initDriver("chrome", prop);
		  homepage = new HomePage(driver);
	  }
	  
	  @Test(priority = 1)
	  public void headerTest()
	  {
		  Assert.assertTrue(homepage.isHeaderExist(prop.getProperty("header")));
	  }
	  	
	  @Test(priority = 2)
	  public void contactTest()
	  {
		  Assert.assertTrue(homepage.isContactExist(prop.getProperty("contact")));
	  }
	  
	  @AfterTest
	  public void tearDown()
	  {
		  driver.quit();
	  }
	
	  
}
