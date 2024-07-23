package Project1_Amazon.final_Project;

import static org.testng.Assert.*;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(amazon_Scenarios.Listener.class)
public class TestCase09 //extends  LaunchnQuit//Listener
{
	RemoteWebDriver driver;
	@Test
	public void addTOCart()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Amazon_Home_Page a1=new Amazon_Home_Page(driver);
		a1.hoverover(driver);
		a1.signin_click();
		Amazon_Login_Page a2=new Amazon_Login_Page(driver);
		a2.enter_mobile();
		a2.continue_click();
		a2.pwd();
		a2.signin();
		Amazon_SearchResult_Page a3=new Amazon_SearchResult_Page(driver);
		a1.searching();
		a3.selcting_1st_product();
		Amazon_product_Page a4=new Amazon_product_Page(driver);
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> p_cid= s1.iterator();
		String p_id=p_cid.next();
		String c_id=p_cid.next();
		driver.switchTo().window(c_id);
		
		a4.addingtocart();
		
		String actual=a4.addedToCartCartAssertion();
		assertEquals(actual, "Added to Cart");
		
	}
}