package Project1_Amazon.final_Project;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import resources.LaunchnQuit;
import resources.Test_Data;

public class TestCase12 extends  LaunchnQuit
{
	@Test(retryAnalyzer =resources.RetryFailed.class)
	public void payment() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Amazon_Home_Page a1=new Amazon_Home_Page(driver);
		a1.hoverover(driver);
		a1.signin_click();
		Amazon_Login_Page a2=new Amazon_Login_Page(driver);
		Test_Data ddt=new Test_Data();
		ddt.data_fetching();
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
		a4.goToCart();		
		Amazon_Cart_Page a5=new Amazon_Cart_Page(driver);
		a5.selectQuantity_dd();
		a5.proceedToBuy();
		Amazon_CheckOut_Page a6=new Amazon_CheckOut_Page(driver);
		a6.selectAddress();
		a6.useThisAddress();
		a6.selectCardRadioBtn();
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='a-container content-container']")));
		a6.clickOnEnterCardDetails();
		a6.switchToIframe(driver);
//		Thread.sleep(500);
		WebDriverWait wait01=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait01.until(ExpectedConditions.visibilityOf(a6.cardNumber));
		a6.enterCardNumber();
		a6.enterName();
		a6.expiryMonth();
		a6.expiryYear();
		a6.saveCardDetails();
		a6.switchToMain(driver);
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait1.until(ExpectedConditions.visibilityOf(a6.cvvNumber));
//		Thread.sleep(500);
		a6.enterCvvNumber();
//		ChromeOptions options=new ChromeOptions();
//		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		a6.continueWithOutSave_Btn();
//		WebDriverWait wait2=new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait2.until(ExpectedConditions.visibilityOf(a6.useThisPaymentMethod));
//		a6.useThisPaymentMethod();
		
		
//		assertTrue(a6.chooseDeleveryOptions());
	}
}