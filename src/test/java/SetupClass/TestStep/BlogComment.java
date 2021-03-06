package SetupClass.TestStep;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Date;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;  
import org.openqa.selenium.Alert; 
import org.openqa.selenium.JavascriptExecutor;

import SetupClass.Setup;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class BlogComment extends Setup {
	
	WebDriverWait wait = new WebDriverWait(driver,500);
	JavascriptExecutor js;
	
	
	@Given("^user is already on blog form$")
	public void user_is_already_on_blog_form() throws Throwable {
		//driver.get(AppURL);
	//driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	//log.info("It's opening the website URL");
	//Thread.sleep(1000);
        driver.get("https://www.slidegeeks.com/");
	
		//Thread.sleep(2000); 
		driver.get("https://www.slidegeeks.com/blog/");
		Thread.sleep(3000);
		driver.manage().deleteAllCookies();
		   Thread.sleep(20000);
	          
	}
	
	
	@Then("^user enter comment on blog form$")
	public void user_enter_comment_on_blog_form() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss z"); 
	    Date date = new Date(System.currentTimeMillis());  
	    message_write_time=formatter.format(date);
	    System.out.println(Button_Click_Time);  
		driver.findElement(By.id("comment")).sendKeys("This is a text message for QA purposes sent by an automated program. Please ignore."+ "\n"+ ""+""+
								"Page URL is:-> https://www.slideteam.net/blog/using-these-smart-goals-can-increase-your-impact-as-a-marketer/"+"\n"+ ""+""+
								"Current Time is:->"+message_write_time);		
		Thread.sleep(8000);

	}
	

	@Then("^user click on Submit button on blog form$")
	public void user_click_on_Submit_button_on_blog_form()throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(.,'Leave a comment')]")).click();;
		Thread.sleep(3000);		
		
	}
	
	
}
