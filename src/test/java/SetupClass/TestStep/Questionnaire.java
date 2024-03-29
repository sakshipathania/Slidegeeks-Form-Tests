package SetupClass.TestStep;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Alert;
import java.awt.AWTException; 
import java.awt.Robot; 
import java.awt.event.KeyEvent; 
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import SetupClass.Setup;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class Questionnaire extends Setup {

	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebDriverWait wait = new WebDriverWait(driver,50);
	
	@Given("^user is already on questionnaire form page$")
	public void user_is_already_on_questionnaire_form_page() throws Throwable {
		Thread.sleep(1000);
		//driver.get("https://www.slidegeeks.com/design-services-form");
		Actions action = new Actions(driver);
		WebElement ourServices = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@role='button']")));
		action.moveToElement(ourServices)
				.moveToElement(driver.findElement(
						By.xpath("//a[contains(@class,'dropdown-item')][normalize-space()='Design Services']")))
				.click().build().perform();

		Thread.sleep(1000);
		WebElement getStarted = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='btn blue-btn']")));
		js.executeScript("arguments[0].scrollIntoView();", getStarted);
		getStarted.click();

		Thread.sleep(1000);
	}

	@Then("^user enter name on questionnaire form$")
	public void user_enter_name_on_questionnaire_form() throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("SlideGeeks Testing");
		Thread.sleep(1000);
	}

	@Then("^user enter email on questionnaire form$")
	public void user_enter_email_on_questionnaire_form() throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("slidetech.qa@gmail.com");
		Thread.sleep(1000);
	}

	@Then("^user enter phone on questionnaire form$")
	public void user_enter_phone_on_questionnaire_form() throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("852364598");
		Thread.sleep(1000);
	}

	@Then("^user enter number of slides on questionnaire form$")
	public void user_enter_number_of_slides_on_questionnaire_form() throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='num_slides']")).sendKeys("8");
		Thread.sleep(1000);
	}

	@Then("^user enter  Style Requirement on questionnaire form$")
	public void user_enter_Style_Requirement_on_questionnaire_form() throws Throwable {
		Thread.sleep(1000);
	    //driver.findElement(By.cssSelector("div.user-detail:nth-child(4) > ul:nth-child(2) > li:nth-child(2) > textarea:nth-child(2)")).sendKeys("This is a text message for QA purposes sent by an automated program. Please ignore. ");
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss z"); 
	    Date date = new Date(System.currentTimeMillis());  
	    message_write_time=formatter.format(date);
	    System.out.println(Button_Click_Time);  
		driver.findElement(By.cssSelector("#questionnariesForm > div.form-bottom-field > div.form-row > div:nth-child(2) > div > textarea")).sendKeys("This is a text message for QA purposes sent by an automated program. Please ignore."+ "\n"+""+""+
								"Page URL is:-> https://www.slideteam.net/powerpoint_presentation_design_services"+"\n"+""+""+
								"Current Time is:->"+message_write_time);	
		Thread.sleep(1000);
	}
	
	@Then("^User click on Upload button")
	public void User_click_on_Upload_button() throws Throwable {
		Thread.sleep(6000);
	        WebElement Upload= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='dz-default dz-message']")));
		Thread.sleep(2000);
		Upload.click();
		Thread.sleep(3000);
		//Upload.click();
		//Thread.sleep(3000);
		Robot r = new Robot(); 
		r.keyPress(KeyEvent.VK_ESCAPE); 
		r.keyRelease(KeyEvent.VK_ESCAPE);
	}

	@Then("User enters Captcha")
	public void User_enters_Captcha() throws Throwable {
	WebElement captcha = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#captchtext")));
		 Thread.sleep(3000);
		captcha.sendKeys("Y3Tt6bfwI");
		 Thread.sleep(3000);
	}
	
	@Then("^user click on submit on questionnaire form$")
	public void user_click_on_submit_on_questionnaire_form() throws Throwable {
		Thread.sleep(1000);
		WebElement submit= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='save']")));
		submit.click();
		System.out.print("form is submitted at:->> ");
	    //System.out.println(System.currentTimeMillis()/1000);
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss z"); 
	    Date date = new Date(System.currentTimeMillis());  
	    String Button_Click_Time=formatter.format(date);
	    System.out.println(Button_Click_Time); 
		
	//verify the message 
		Thread.sleep(3000);
		String verifySuccessfullMessage = wait
				.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//h4[contains(text(),'Thank You for submitting your request to SlideGeek')]")))
				.getText();
		System.out.println("message = " + verifySuccessfullMessage);
		Assert.assertTrue("custom services form is not submitted successfully", verifySuccessfullMessage
				.contentEquals("Thank You for submitting your request to SlideGeeks Design Services."));
		System.out.println("Custom services form is submitted successfully");
	}

	
}
