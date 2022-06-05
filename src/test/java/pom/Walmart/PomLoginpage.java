package pom.Walmart;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import walmart.basepackage.Walmartbasepackage;

public class PomLoginpage extends Walmartbasepackage {
	
public static Actions action;
	@FindBy (id ="firstName") WebElement Firstname;
	@FindBy (xpath= "//span[contains(text(),'Please enter your first name.')]" ) WebElement blankErrname;
	@FindBy (xpath="//span[contains(text(),'Please enter a valid first name.')]") WebElement invalidErrname;
	@FindBy (id = "lastName") WebElement Lastname;
	@FindBy (xpath= "//span[contains(text(),'Please enter your last name.')]" ) WebElement blankErrlstname;
	@FindBy (xpath="//span[contains(text(),'Please enter a valid last name.')]") WebElement invalidErrlstname;
	@FindBy ( id="phoneNumber") WebElement Phonenumber ;
	@FindBy ( xpath="//span[contains(text(),'Please enter a valid phone number.')]") WebElement ErrPhonenumber ;
	@FindBy (id ="email") WebElement Email;
	@FindBy (xpath ="//span[contains(text(),'Please enter a valid email address.')]") WebElement ErrEmail;
	@FindBy (id ="password") WebElement password;
	@FindBy (xpath="//div[@class='password-strength-label']//child::span") WebElement passwordstrength;
	@FindBy (xpath="//span[contains(text(),'Password is a required field.')]") WebElement blankErrpassword;
	@FindBy (xpath="//span[contains(text(),'Your password must be at least 6 characters long.')]") WebElement invalidpassword;
	@FindBy (xpath="//button[@class='css-sz4mv8 erl5ymg1']") WebElement show;
	@FindBy (xpath="//label[@class='css-1jg09os ega94xn0']//parent::div//input[@id='marketingPreference']") WebElement Marketpref;
	@FindBy(xpath="//label[@class='css-1jg09os ega94xn0']//parent::div//input[@id='TAndC']") WebElement Termsandcondition;
	@FindBy (xpath="//div[contains(text(),'You must read and accept Walmart’s Terms of Use to subscribe.')]") WebElement ErrTandC;
	
	public PomLoginpage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public void tpFirstname(String fname) {
		Firstname.sendKeys(fname);		
	}	
	public String FirstnameERR1() {
		 
		return invalidErrname.getText();
	}
	public String FirstnameERRblank() {
		String msg2= blankErrname.getText();
		return msg2;
	}
	public void tpLastname(String Lname) {
		Lastname.sendKeys(Lname);	
	}
	public String LastnameinvalidErr() {
		String lstnameerr= invalidErrlstname.getText();
		return lstnameerr;
	}
	public String LastnameblankErr() {
		String lstnameerr= blankErrlstname.getText();
		return lstnameerr;
	}
	public void tpPhonenumber(String phone) {
		Phonenumber.sendKeys(phone);
	}
	public String Errphone() {
		return ErrPhonenumber.getText();
	}
	public void tpemail(String typeemail) {
		Email.sendKeys(typeemail);
	}
	public String Erroremail() {
		return ErrEmail.getText();
	}
	public void tppassword(String typepassword) {
		password.sendKeys(typepassword);
	}
	public String strengthpassword() {
		return passwordstrength.getText();
	}
	public void showbtn() {
		show.click();
	}
	public String blnkErrpswrd() {
		return blankErrpassword.getText();	
	}
	public String invalidpswrd() {
		return invalidpassword.getText();
	}
	public void checkboxMarket() {
		Marketpref.click();
	}
	public void checkboxMarketunchec() {
		action = new Actions(getdriver());
		action.doubleClick(Marketpref).perform();	
	}
	public boolean CheckboxMarketconfirm() {
		return Marketpref.isSelected();
	}
	public void checkboxTandC() {
		Termsandcondition.click();
	}
	public boolean CheckboxTandCconfirm() {
		return Termsandcondition.isSelected();
	}
	public void checkbox_Tandcunchecunchecked() {
		action = new Actions(getdriver());
		action.moveToElement(Termsandcondition).doubleClick(Termsandcondition).build().perform();
	}
	
	public String Errtermsandcond() {
		return ErrTandC.getText();
	}
}
