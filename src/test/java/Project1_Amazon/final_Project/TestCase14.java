package Project1_Amazon.final_Project;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;
import resources.LaunchnQuit;
import resources.Test_Data;

public class TestCase14 extends  LaunchnQuit
{
	@Test
	public void rating() throws EncryptedDocumentException, IOException
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
		Amazon_Orders_Page a3=new Amazon_Orders_Page(driver);
		a3.selectOrdersandReturns();
		a3.selectOrdersSortbyTime();
//		a3.productReview();
//		a3.rateFiveStar();
		
		assertEquals(a1.search_tf.getAttribute("value"), "");
	}
}