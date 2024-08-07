package Project1_Amazon.final_Project;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Amazon_CheckOut_Page 
{
	@FindBy(xpath="(//input[@name='submissionURL'])[last()]")
	WebElement addressRadio;
	public void selectAddress()
	{
		addressRadio.click();
	}
	@FindBy(css = "[data-testid='Address_selectShipToThisAddress']")
	WebElement useThisAddress;
	public void useThisAddress()
	{
		useThisAddress.click();
	}
	@FindBy(xpath="//input[@value='SelectableAddCreditCard']") 
	WebElement card;
	public void selectCardRadioBtn() 
	{
		card.click();
	}
	@FindBy(xpath = "(//a[.='Enter card details'])[1]")
	WebElement enterCardDetails;
	public void clickOnEnterCardDetails()
	{
		enterCardDetails.click();
	}

	@FindBy(name = "ApxSecureIframe")
	WebElement iFrame;
	public void switchToIframe(WebDriver driver)
	{
		driver.switchTo().frame(iFrame);		
	}

	@FindBy(name = "addCreditCardNumber")
	WebElement cardNumber;
	public void enterCardNumber()
	{
		cardNumber.sendKeys("6523000805088478");
	}
	@FindBy(xpath = "//input[@name='ppw-accountHolderName']")
	WebElement nicName;
	public void enterName()
	{
		nicName.clear();
		nicName.sendKeys("veer's SBI DEBIT");
	}
	@FindBy(name = "ppw-expirationDate_month")
	WebElement selectExpiryMonth;
	public void expiryMonth() 
	{
		Select selectDate = new Select(selectExpiryMonth);
		selectDate.selectByValue("9");
	}
	@FindBy(name = "ppw-expirationDate_year")
	WebElement selectExpiryYear;
	public void expiryYear() 
	{
		Select selectYear = new Select(selectExpiryYear);
		selectYear.selectByValue("2028");
	}
	@FindBy(name = "ppw-widgetEvent:AddCreditCardEvent")
	WebElement enterButton;
	public void saveCardDetails() 
	{
		enterButton.click();
	}

	public void switchToMain(WebDriver driver)
	{
		driver.switchTo().defaultContent();		
	}


	@FindBy(name = "addCreditCardVerificationNumber0")
	WebElement cvvNumber;
	public void enterCvvNumber() 
	{
		cvvNumber.sendKeys("257" + Keys.ENTER);
	}
	
	

	@FindBy(xpath = "(//span[.='Continue without saving'])[2]")
	WebElement continueWithOutSave;
	public void continueWithOutSave_Btn() 
	{
		continueWithOutSave.click();
	}		

	@FindBy(xpath="(//input[@name='ppw-instrumentRowSelection'])[2]") 
	WebElement netBanking;
	public void selectNetBanking() 
	{
		netBanking.click();
	}
	@FindBy(xpath="//select[@name='ppw-bankSelection_dropdown']") 
	WebElement netBankingdd;
	public void selectNetBanking_dd() 
	{
		Select s1=new Select(netBankingdd);
		s1.selectByValue("SBI DIRECT");
	}
	
	@FindBy(xpath="(//select[@id='quantity'])[1]")
	WebElement qty_dd;
	public void selectQuantity_dd()
	{
		Select s1=new Select(qty_dd);
		s1.selectByIndex(1);
	}
	@FindBy(xpath="(//input[@name='ppw-instrumentRowSelection'])[3]") 
	WebElement upi;
	public void selectUPIPayment() 
	{
		upi.click();
	}
	@FindBy(xpath="(//input[@name='ppw-instrumentRowSelection'])[4]") 
	WebElement emi;
	public void selectEMI() 
	{
		emi.click();
	}
	@FindBy(xpath="(//input[@name='ppw-instrumentRowSelection'])[5]") 
	WebElement cashONDelevery;
	public void selectCashONDelevery() 
	{
		cashONDelevery.click();
	}
	@FindBy(xpath="(//input[@class='a-button-input a-button-text'])[3]") 
	WebElement useThisPaymentMethod;
	public void useThisPaymentMethod() 
	{
		useThisPaymentMethod.click();
	}
	@FindBy(className="shipping-speeds-title") 
	WebElement deleveryOptions;
	public boolean chooseDeleveryOptions() 
	{
		return deleveryOptions.isDisplayed();
	}
	@FindBy(name="ppw-claimCode") 
	WebElement coupon;
	public void enterCouponCode() 
	{
		coupon.sendKeys("PRIMEDAY"+Keys.ENTER);
	}
	@FindBy(xpath="//div[@class='a-alert-content' and .='The promotional code you entered is not valid.']") 
	WebElement promoERR;
	public String promoERRMsg() 
	{
		return promoERR.getText();
	}

	public Amazon_CheckOut_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
