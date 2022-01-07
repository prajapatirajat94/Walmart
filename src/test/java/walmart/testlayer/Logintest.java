package walmart.testlayer;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pom.Walmart.PomLoginpage;
import walmart.basepackage.Walmartbasepackage;

public class Logintest extends Walmartbasepackage {
	public static PomLoginpage login;
	public static JavascriptExecutor js;
		
	public Logintest() {
		super();
	}
	
	@BeforeMethod
	public void openwalmartsignuppage() {
		initialize();
		driver.get(prop.getProperty("url"));	
		login = new PomLoginpage();
	}

@Test(priority =1)
public void Login_TC1validfirstname () {
	login.tpFirstname("Rajatkumar");	
	
}
@Test(priority=2)
public void Login_TC2invalidfirstnamelessthentwochar() {
	login.tpFirstname("R");	
	login.tpLastname("Prajapati");
	String invalidfname= login.FirstnameERR1();
	Assert.assertEquals(invalidfname, "Please enter a valid first name.");	
}
@Test(priority=3)
public void Login_TC3Emptydfirstname() {
	login.tpFirstname("");	
	login.tpLastname("Prajapati");
	String blankfname= login.FirstnameERRblank();
	Assert.assertEquals(blankfname, "Please enter your first name.");	
}

@Test(priority=4)
public void Login_TC4Enternumberfirstname() {
	login.tpFirstname("123456");	
	login.tpLastname("Prajapati");
	
	String invalidfname= login.FirstnameERR1();
	Assert.assertEquals(invalidfname, "Please enter a valid first name.");
}
@Test(priority=5)
public void Login_TC5_validlastname() {
	login.tpFirstname("Rajat");
	login.tpLastname("Prajapati");
}
@Test(priority=6)
public void Login_TC6invalidlastnamelessthentwochar() {
	login.tpFirstname("Rajat");	
	login.tpLastname("P");
	login.tpPhonenumber("");
	String invalidlstname= login.LastnameinvalidErr();
	Assert.assertEquals(invalidlstname, "Please enter a valid last name.");	
	
}
@Test(priority=7)
public void Login_TC7blanklastnamelessthentwochar() {
	login.tpFirstname("Rajat");	
	login.tpLastname("");
	login.tpPhonenumber("");
	String blanklstname= login.LastnameblankErr();
	Assert.assertEquals(blanklstname, "Please enter your last name.");	
}
@Test(priority=8)
public void Login_TC8Enternumberlastname(){
	login.tpFirstname("Rajat");	
	login.tpLastname("123456");
	login.tpPhonenumber("");
	String invalidlstname= login.LastnameinvalidErr();
	Assert.assertEquals(invalidlstname, "Please enter a valid last name.");
}
@Test(priority=9)
public void Login_TC9validphonenumber() {
	login.tpPhonenumber("1234567890");
}
@Test(priority=10)
public void Login_TC10invalidphonenumber() {
	login.tpPhonenumber("123");
	login.tpemail("");
	String Errmsg =login.Errphone();
	Assert.assertEquals(Errmsg, "Please enter a valid phone number.");
}
@Test(priority=11)
public void Login_TC11invalidphonenumbercharcter() {
	login.tpPhonenumber("Rajat");
	login.tpemail("");
	String Errmsg =login.Errphone();
	Assert.assertEquals(Errmsg, "Please enter a valid phone number.");
}
@Test(priority=12)
public void Login_TC12validemailaddress() {
	login.tpemail("123@gmail.com");
}
@Test(priority=13)
public void Login_TC13invalidemailasddress() {
	login.tpemail("123");
	login.tpPhonenumber("");
	String Errmsg = login.Erroremail();
	Assert.assertEquals(Errmsg,"Please enter a valid email address.");
}
@Test(priority =14)
public  void Login_TC14passwordcombinationcharspecialcharnum(){
login.tppassword("Tsting@1234");	
String SP = login.strengthpassword();
Assert.assertEquals(SP,"Password Strength: strong");
} 
@Test(priority=15)
public void Login_TC15PasswordcombinationCharandspecialchar() {
	login.tppassword("Tsting@");
	String ModerateP = login.strengthpassword();
	Assert.assertEquals(ModerateP,"Password Strength: moderate");	
}
@Test(priority=16)
public void Login_TC15PasswordcombinationCharonly() {
	login.tppassword("Tstingh");
	String WeakP = login.strengthpassword();
	Assert.assertEquals(WeakP,"Password Strength: weak");	
}
@Test(priority=17)
public void Login_TC17passwordinvisibilitysecurity() {	
	WebElement pvisiblity = driver.findElement(By.id("password"));
	boolean pswrddots= pvisiblity.getAttribute("type").equals("password");
	Assert.assertEquals(pswrddots, true);
}
@Test(priority=18)
public void Login_TC18Showbutton() {
	login.tppassword("Tsting@1234");
	login.showbtn();
	WebElement pvisiblity = driver.findElement(By.id("password"));
	boolean pswrddots= pvisiblity.getAttribute("type").equals("text");
	Assert.assertEquals(pswrddots, true);
}
@Test(priority=19)
public void Login_TC19Passwordempty() {
	login.tppassword("");
	login.tpPhonenumber("");
	String errorpswrd = login.blnkErrpswrd();
	Assert.assertEquals(errorpswrd, "Password is a required field.");
}
@Test(priority=20)
public void Login_TCinvalidpassword() {
	login.tppassword("123");
	login.tpPhonenumber("");
	String invalidpwrd = login.invalidpswrd();
	Assert.assertEquals(invalidpwrd, "Your password must be at least 6 characters long.");
}
@Test(priority=21)
public void Login_20Emailmecheckboxcheck() throws InterruptedException {
	js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,500)");
	Thread.sleep(500);
	login.checkboxMarket();
	Assert.assertTrue(login.CheckboxMarketconfirm());
}
@Test(priority=22)
public void Login_TC21Emailmecheckboxuncheck() throws InterruptedException {
	js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,500)");
	Thread.sleep(100);
	login.checkboxMarketunchec();
	Assert.assertFalse(login.CheckboxMarketconfirm());
}
@Test(priority=23)
public void Login_TC22CheckboxTandCchecked() throws InterruptedException {
	js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,500)");
	Thread.sleep(200);
	login.checkboxTandC();
	Assert.assertTrue(login.CheckboxTandCconfirm());
}
@Test(priority=24)
public void Login_TC23CheckboxTandCuncheckedErr() throws InterruptedException {
	js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,500)");
	js.executeScript("window.scrollBy(0,400)");
	Thread.sleep(200);
	login.checkbox_Tandcunchecunchecked();
	Assert.assertFalse(login.CheckboxTandCconfirm());
	//String Err = login.Errtermsandcond();
	//Assert.assertEquals(Err,"You must read and accept Walmart’s Terms of Use to subscribe.");
}
@Test(priority=25)
public void Login_TCCheckboxTandCuncheckedErr() throws InterruptedException {
	js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,500)");
	Thread.sleep(200);
	login.checkbox_Tandcunchecunchecked();
	String Err = login.Errtermsandcond();
	Assert.assertEquals(Err,"You must read and accept Walmart’s Terms of Use to subscribe.");
}
@AfterMethod
public void Screenshot(ITestResult result) {
		/*if(ITestResult.FAILURE== result.getStatus() ) {
	File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(file, new File("C:\\Users\\praja\\eclipse-workspace\\Walmart_Project\\src\\test\\java\\walmart.Screenshot"
					+ result.getName() + ".jpg"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		}*/
	driver.quit();
}
}