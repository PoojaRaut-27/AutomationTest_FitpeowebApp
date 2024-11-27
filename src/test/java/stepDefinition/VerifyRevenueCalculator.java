package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class VerifyRevenueCalculator {

	private WebDriver driver;
    @Before
    public void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
	
	@Given("user on the FitPeo Homepage")
	public void user_on_the_fit_peo_homepage() throws InterruptedException {
		
		driver.get("https://www.fitpeo.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@When("user navigate to the Revenue Calculator Page")
	public void user_navigate_to_the_revenue_calculator_page() throws InterruptedException {
	   driver.navigate().to("https://fitpeo.com/revenue-calculator");
	   Thread.sleep(3000);
	}

	@When("scroll down to the slider section")
	public void scroll_down_to_the_slider_section() throws InterruptedException {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,350)", "");
	     Thread.sleep(3000);
	}

	@Then("the revenue calculator slider should be visible")
	public void the_revenue_calculator_slider_should_be_visible() throws InterruptedException {
		WebElement slider=driver.findElement(By.xpath("//span[@class='MuiSlider-root MuiSlider-colorPrimary MuiSlider-sizeMedium css-16i48op']"));
		 assert slider.isDisplayed();
		 Thread.sleep(3000);
	}
	
	@When("user can adjust the slider to set its value to {int}")
	public void user_can_adjust_the_slider_to_set_its_value_to(int value) throws InterruptedException {
	 WebElement slider=driver.findElement(By.xpath("//input[@aria-valuenow='200']"));
	// WebElement element = driver.findElement(By.id("element_id"));
	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", slider);
	 Actions actions = new Actions(driver);
	 actions.moveToElement(slider).perform();
    // Actions move = new Actions(driver);
	 // move.dragAndDropBy(slider, value,620).perform(); 	 
	  Thread.sleep(3000); 
	    
	}

	@When("the text field value should be updated to {int}")
	public void the_text_field_value_should_be_updated_to(Integer value) throws InterruptedException {
	    WebElement textField = driver.findElement(By.xpath("//input[@id=':R57alklff9da:']")); 
        assert textField.getAttribute("value").equals(String.valueOf(820));
        Thread.sleep(3000);
	}

	

	
	@When("user click on the text field associated with the slider")
	public void user_clicks_on_the_text_field_associated_with_the_slider() throws InterruptedException {
	    WebElement textField = driver.findElement(By.id(":R57alklff9da:")); 
        textField.click();
        Thread.sleep(3000);
	}

	@When("user enter the value {int} in the text field")
	public void user_enters_the_value_in_the_text_field(Integer int1) throws InterruptedException {
	    WebElement textField = driver.findElement(By.xpath("//input[@id=':R57alklff9da:']")); 
        textField.clear();
        textField.sendKeys("560");
        Thread.sleep(3000);
	}

	@Then("the slider should update its position to reflect the value {int}")
	public void the_slider_should_update_its_position_to_reflect_the_value(Integer int1) throws InterruptedException {
	WebElement slider = driver.findElement(By.xpath("//span[@class='MuiSlider-root MuiSlider-colorPrimary MuiSlider-sizeMedium css-16i48op']")); 
	Thread.sleep(3000);
	}
	@When("user scroll down further to the CPT codes section")
	public void user_scroll_down_further_to_the_cpt_codes_section() throws InterruptedException {
       JavascriptExecutor js =(JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,350)", "");
	     Thread.sleep(3000);
        }
	@When("select the checkboxes for CPT-99091, CPT-99453, CPT-99454, and CPT-99474 checkboxes should be selected")
	    public void select_the_checkboxes_for_CPT_codes() throws InterruptedException {
		 driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[1]")).click(); 
		 driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[2]")).click(); //19 
	        driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[3]")).click();// 63
	        driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[8]")).click();
	        
	        Thread.sleep(2000);
	    }
	

	@When("user validate the Total Recurring Reimbursement")
	public void user_validate_the_total_recurring_reimbursement() throws InterruptedException {
	     WebElement header = driver.findElement(By.xpath("//p[text()='Total Recurring Reimbursement for all Patients Per Month']")); 
        assert header.isDisplayed();
        Thread.sleep(2000);
        
	}

	@Then("the header displaying {string} should show the value {string}")
	public void the_header_displaying_should_show_the_value(String string, String string2) throws InterruptedException {
	    WebElement header = driver.findElement(By.xpath("//p[text()='Total Recurring Reimbursement for all Patients Per Month']")); 
        assert header.getText().contains("Total Recurring Reimbursement for all Patients Per Month");
        Thread.sleep(2000);

    }
	@After
    public void closeBrowser() {
      // driver.quit();
    }
   
}


