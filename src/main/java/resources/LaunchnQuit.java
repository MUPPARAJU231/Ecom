package resources;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class LaunchnQuit 
{      
	public static WebDriver driver;
//	public static  String screenshotsSubFolderName;
	@BeforeMethod
	@Parameters("browser")
	public void launch(String nameofbrowser)
	{
		switch (nameofbrowser) 
		{
		case "chrome": 
			driver=new ChromeDriver();
			break;
		case "edge": 
			driver=new EdgeDriver();
			break;
		case "firefox": 
			driver=new FirefoxDriver();
			break;
		default:System.err.println("Invalid Browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
	}
	@AfterMethod
	public void quit()
	{
		//driver.quit();
	}

	public void captureScreenShot(String fileName)
	{
//		if(screenshotsSubFolderName == null) 
//		{
		LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
	  String  screenshotsSubFolderName = myDateObj.format(myFormatObj);
//		}
		
		TakesScreenshot t1= (TakesScreenshot) driver;
		File source=t1.getScreenshotAs(OutputType.FILE);
		File destination=new File("./ScreenShots/"+screenshotsSubFolderName+"/"+fileName);
		try 
		{
			FileUtils.copyFile(source, destination);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
