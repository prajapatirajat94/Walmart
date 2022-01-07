package walmart.basepackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import walmart.utils.Walmartutils;

public class Walmartbasepackage {
	public static WebDriver driver;
	public static Properties prop;

	public Walmartbasepackage(){
		try {
		FileInputStream file = new FileInputStream("C:\\Users\\praja\\eclipse-workspace\\Walmart_Project\\src\\test\\java\\"
				+ "Environmental variable\\config.properties");
		prop = new Properties();
		prop.load(file);
	}
		catch(FileNotFoundException e) {
			e.getStackTrace();
		}
		catch(IOException f){
			f.getStackTrace();			
		}
		
		}
	public static void initialize() {
		String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();		
		}	
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Walmartutils.Pageloadtime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Walmartutils.Implicitytime, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();	
		
	}
	
	public  String getScreenshot() {
		
		File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path= "C:\\Users\\praja\\eclipse-workspace\\Walmart_Project\\src\\test\\java\\walmart.Screenshot"+System.currentTimeMillis()+".jpg";
		try {
			FileUtils.copyFile(file, new File(path));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return path;
	}
}
