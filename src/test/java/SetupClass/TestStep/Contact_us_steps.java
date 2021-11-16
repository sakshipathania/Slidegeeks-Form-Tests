package SetupClass.TestStep;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;

import SetupClass.Setup;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Contact_us_steps extends Setup {
	
	// contact us form
	WebDriverWait wait = new WebDriverWait(driver, 50);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	@Given("^user is already on contact us form$")
	public void user_is_already_on_contact_us_form()  throws Throwable {
		driver.get(AppURL);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		log.info("It's opening the website URL");
		/*Thread.sleep(1000);
		driver.get("https://www.slidegeeks.com/contact");
		try {
			WebElement iframe = driver.findElement(By.id("livechat-full-view"));
			if(iframe.isDisplayed()) {
				driver.switchTo().frame(iframe);   
				 Actions act = new Actions(driver);
				 act.moveToElement(driver.findElement(By.cssSelector("#title .icon-minimize"))).build().perform();
				 Thread.sleep(2000);
					WebElement chat1=driver.findElement(By.cssSelector("#title .icon-minimize"));
					 Thread.sleep(1000);
						chat1.click();
						 Thread.sleep(1000);
						 driver.switchTo().defaultContent();
						 Thread.sleep(1000);
						 driver.switchTo().parentFrame();
					 Thread.sleep(1000);
			}
			else {
				

			System.out.println("chat window does not open");
			}
		}
				catch(NoSuchElementException NCP) {
					
				}*/
		try {
		Thread.sleep(3000);
		WebElement Contact= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Contact Us']")));
		js.executeScript("arguments[0].scrollIntoView();",Contact);
		
		Contact.click();
		Thread.sleep(1000);
		}
		catch(NoSuchElementException NCP) {
					
				}
	}

	

	@Then("^user enter email$")
	public void user_enter_email()throws Throwable
	{
		Thread.sleep(1000);
		driver.findElement(By.id("inputEmail")).sendKeys("slidetech.qa@gmail.com");
		Thread.sleep(1000);
	}
	
	@Then("^user enter name$")
	public void user_enter_name() throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.id("inputName")).sendKeys("SlideGeeks Testing");
		Thread.sleep(1000);
	    
	}
	
	@Then("^user enter mobile number$")
	public void user_enter_mobile_number()  throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.id("inputPhone")).sendKeys("877566756657");
		Thread.sleep(1000);
	}

	@Then("^user enter comment$")
	public void user_enter_comment()throws Throwable  {
		Thread.sleep(1000);
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss z"); 
	    Date date = new Date(System.currentTimeMillis());  
	    message_write_time=formatter.format(date);
	    System.out.println(Button_Click_Time);  
		driver.findElement(By.id("inputMessage")).sendKeys("This is a text message for QA purposes sent by an automated program. Please ignore."+ "\n"+""+""+
								"Page URL is:-> https://www.slideteam.net/contacts"+"\n"+""+""+ 
								"Current Time is:->"+message_write_time);		
		Thread.sleep(2000);
	}

	@Then("^user enter captcha comment$")
 	public void user_enter_captcha_comment() throws Throwable {
        Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//input[@id='captchtext']")).sendKeys("Y3Tt6bfwI");
	    Thread.sleep(1000);
	}
	
	@Then("^user click on submit button$")
	public void user_click_on_submit_button()throws Throwable  {
		Thread.sleep(1000);
		driver.findElement(By.id("submit_contact_form")).click();
		Thread.sleep(1000);
		System.out.print("form is submitted at:->> ");
	    //System.out.println(System.currentTimeMillis()/1000);
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss z"); 
	    Date date = new Date(System.currentTimeMillis());  
	    String Button_Click_Time=formatter.format(date);
	    System.out.println(Button_Click_Time);
           //verify the message 
		
		String verifySuccessfullMessage = wait
				.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//strong[normalize-space()='Thank You! Your message has been sent.']")))
				.getText();
		System.out.println("message = " + verifySuccessfullMessage);
		Assert.assertTrue("Contact_us form is not submitted successfully", verifySuccessfullMessage
				.contentEquals("Thank You! Your message has been sent."));
		System.out.println("Contact Us form is submitted successfully");
	}
	
}
