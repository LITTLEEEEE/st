package cn.tju.selenium;

import java.util.regex.Pattern;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.junit.*;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;

import cn.tju.selenium.readExcel.student;
import jxl.read.biff.BiffException;
@Listeners({cn.tju.selenium.AssertionListener.class})
public class lab2Test {
  private static WebDriver driver;
  private static String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  String driverPath = System.getProperty("user.dir") + "/src/resource/driver/geckodriver.exe";
	  System.setProperty("webdriver.gecko.driver", driverPath);
	  System.setProperty ( "webdriver.firefox.bin" , "D:\\applications\\FireFox\\firefox.exe" );
	  driver = new FirefoxDriver();
	  baseUrl = "http://121.193.130.195:8800";
	  //driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	 
  }
  

  @Test
  public void testBaidu() {
	    readExcel readExcel=new readExcel();
		List<student> list = null;
		try {
			list = readExcel.readFromExcel("C:/Users/91208/Desktop/list.xls");
		} catch (BiffException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<student>webList = new ArrayList<student>();
		int size = list.size();
		for(int i = 100 ; i < size ; i++) {
			driver.get(baseUrl + "/login");
		    driver.findElement(By.name("id")).clear();
		    String id = list.get(i).getid();
		    driver.findElement(By.name("id")).sendKeys(list.get(i).getid());
		    driver.findElement(By.name("password")).clear();
		    driver.findElement(By.name("password")).sendKeys(id.substring(id.length() - 6));
		    driver.findElement(By.id("btn_login")).click();
		    String name = list.get(i).getname();
		    String git= list.get(i).getgit();

		    //Öð¸ö±È½Ï
		    Assertion.verifyEquals(id, driver.findElement(By.id("student-id")).getText());
		    Assertion.verifyEquals(name, driver.findElement(By.id("student-name")).getText());
		    Assertion.verifyEquals(git, driver.findElement(By.id("student-git")).getText());
		    //assertEquals(git, driver.findElement(By.id("student-git")).getText());
		    driver.findElement(By.id("btn_logout")).click();
		    driver.findElement(By.id("btn_return")).click();
		 }
	
  }

  @After
  public void tearDown() throws Exception {
//    driver.quit();
//    String verificationErrorString = verificationErrors.toString();
//    if (!"".equals(verificationErrorString)) {
//      fail(verificationErrorString);
//    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
