package SetupClass.TestStep;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import java.awt.Robot; 
import java.awt.event.KeyEvent;
import org.openqa.selenium.interactions.Actions;
import SetupClass.Setup;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class ResearchServicesSteps extends Setup {

	WebDriverWait wait = new WebDriverWait(driver, 50);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	@Given("^chat popup$")
        public void chat_pop_up() throws InterruptedException
        {
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
                    
                }
    }
	@Then("^user is already on Submit Your Business Research Requirements form$")
	public void user_is_already_on_Submit_Your_Business_Research_Requirements_form() throws Throwable  {
	
		Thread.sleep(3000);
		try {
			//driver.get("https://www.slidegeeks.com/business-research-services");
		//driver.findElement(By.cssSelector("div.links:nth-child(6) > ul:nth-child(2) > li:nth-child(10) > a:nth-child(1)"));
		
		//*Submit.click();
		Actions action = new Actions(driver);
		WebElement ourServices = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@role='button']")));
		action.moveToElement(ourServices).moveToElement(driver.findElement(By.xpath("//a[@class=' dropdown-item'][normalize-space()='Research Services']"))).click().build().perform();
			Thread.sleep(3000);	
	 }
          catch (NoSuchElementException popup) {
	  }
		
	}
	@Then("^user enter name on rs form$")
	public void user_enter_name_on_rs_form()  throws Throwable {
		Thread.sleep(3000);
		try {
		driver.findElement(By.id("name")).sendKeys("SlideGeeks Testing");
		Thread.sleep(3000);
	} catch (NoSuchElementException popup) {
	  }
		
	}

	@Then("^user enter email on rs form$")
	public void user_enter_email_on_rs_form() throws Throwable {
		Thread.sleep(3000);
		try {
		driver.findElement(By.id("email")).sendKeys("slidetech.qa@gmail.com");
		Thread.sleep(3000);
	} catch (NoSuchElementException popup) {
	  }
		
	}

	@Then("^user enter mobile number on rs form$")
	public void user_enter_mobile_number_on_rs_form()throws Throwable  {
		Thread.sleep(3000);
		try {
		driver.findElement(By.id("phone")).sendKeys("5678912345");
		Thread.sleep(3000);
	} catch  (NoSuchElementException popup) {
	  }
		
	}

	@Then("^user enter comment on rs form$")
	public void user_enter_comment_on_rs_form()  throws Throwable{
		Thread.sleep(3000);
		try {
		//driver.findElement(By.id("comment")).sendKeys("This is a text message for QA purposes sent by an automated program. Please ignore.");
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss z"); 
	    Date date = new Date(System.currentTimeMillis());  
	    message_write_time=formatter.format(date);
	    System.out.println(Button_Click_Time);  
		driver.findElement(By.id("message")).sendKeys("This is a text message for QA purposes sent by an automated program. Please ignore."+ "\n"+
								"Page URL is:-> https://www.slideteam.net/powerpoint_presentation_design_services"+"\n"+ 
								"Current Time is:->"+message_write_time);	
		Thread.sleep(3000);
	} catch (NoSuchElementException popup) {
	  }
		
	}

	@Then("^user enter captcha on rs form$")
	public void user_enter_captcha_on_rs_form() throws Throwable {
		Thread.sleep(3000);
		try {
		driver.findElement(By.id("captchtext")).sendKeys("Y3Tt6bfwI");
		Thread.sleep(3000);
	} catch (NoSuchElementException popup) {
	  }
		
	}

	@Then("^user click on submit button on rs form$")
	public void user_click_on_submit_button_on_rs_form() throws Throwable {
		
		Thread.sleep(3000);
		driver.findElement(By.id("researchFile")).click();
		
		Robot r = new Robot(); 
		r.keyPress(KeyEvent.VK_ESCAPE); 
		r.keyRelease(KeyEvent.VK_ESCAPE);
		
		try {
		driver.findElement(By.id("submit_businessresearch_form")).submit();
		Thread.sleep(2000);
			
			//verify the messsage
			String verifySuccessfullMessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[@class='alert alert-success success-message d-block']//*[contains(text(),'Your query has been successfully submitted')]")))
				.getText();
		System.out.println("message = " + verifySuccessfullMessage);
		Assert.assertTrue("Research form is not submitted successfully",
				verifySuccessfullMessage.contentEquals("Your query has been successfully submitted"));
		System.out.println("Research form is submitted successfully");
			
		
	} catch (NoSuchElementException popup) {
	  }
		
	}
		/*
		 * System.out.print("form is submitted at:->> ");
		 * //System.out.println(System.currentTimeMillis()/1000); SimpleDateFormat
		 * formatter= new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss z"); Date date =
		 * new Date(System.currentTimeMillis()); String
		 * Button_Click_Time=formatter.format(date);
		 * System.out.println(Button_Click_Time);
		 */  
	    
	   


}
