package features;
//import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import Utils.AutomationConstants;
import Utils.BrowserFactory;
import Utils.Utils;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import pages.LoginPage;


public class CreateOrderStepDef {
	
	  public WebDriver driver;
	  LoginPage loginPage;

    @Before
    public void start()
    {
        driver = BrowserFactory.getDriver();
    }

    @Given("^user is on crareate order page$")
    public void user_is_on_crareate_order_page() throws Throwable {
    	loginPage = new LoginPage();
    	loginPage.login(AutomationConstants.USERNAME,AutomationConstants.PASSWORD );
    	Thread.sleep(5000);
    	driver.findElement(By.xpath("html/body/div[2]/div[1]/ul/li[3]/a")).click();
    	driver.findElement(By.xpath("//html/body/div[2]/div[1]/ul/li[3]/ul/li[1]/a")).click();
    	Assert.assertTrue(driver.findElement(By.xpath("//*[@id='createorder']/div[1]/div/div[1]/h1")).getText().contains("Create Order"));
    }

    @When ("^user enter vaild data$")
    public void user_enter_vaild_data() throws Throwable {
    	//select supplier
    	Utils.selectFromDropDown(By.id("supplier"),"SwapnaTraders");
        Thread.sleep(3000);
        //select quality 
        Select sel = new Select(driver.findElement(By.id("quality")));
           sel.selectByVisibleText("Jeans");
        Thread.sleep(5000);
        //select Buyer
        Utils.selectFromDropDown(By.id("buyer"),"Santosh");
             driver.findElement(By.xpath("html/body/div[2]/div[1]/ul/li[3]/a")).click();
             Thread.sleep(3000);
             //enter customer reference
             driver.findElement(By.name("custref")).sendKeys("123");
             //select order date 24/3/2016
             driver.findElement(By.name("orddate")).sendKeys("26/03/2016");
             
            // Thread.sleep(3000);
             //select season
             Utils.selectFromDropDown(By.id("season"),"Winter");
             //select style reference number
             driver.findElement(By.name("styleref")).sendKeys("345");
             driver.findElement(By.name("proceed")).click();
             //order page step 2
             Utils.selectFromDropDown(By.id("color"),"Red");
             Thread.sleep(3000);
             //comments
             driver.findElement(By.id("comments")).sendKeys("abc");
             //quantity
             driver.findElement(By.id("quantity")).sendKeys("10");
             Utils.selectFromDropDown(By.id("units"),"500");
             Thread.sleep(3000);
             //unit price
             driver.findElement(By.id("uprice")).sendKeys("5");
             //currency
             driver.findElement(By.id("currency")).sendKeys("Rs");
             //Shipping Mode
             Utils.selectFromDropDown(By.id("shipping"),"Road");
             Thread.sleep(3000);
             //payment terms
             Utils.selectFromDropDown(By.id("pterms"),"Debit Card");
             Thread.sleep(3000);
             //delivery mode
             Utils.selectFromDropDown(By.name("dmode"),"Road");
             Thread.sleep(3000);
             //delivery date
             driver.findElement(By.id("deldate")).sendKeys("25/04/2016");
             //Test Required
             driver.findElement(By.xpath("//*[@id='createorder']/div[2]/div[2]/div/div/div[3]/div/div[1]/div/p/div/div/span[3]")).click();
             Thread.sleep(3000);
             //Test Details
             Utils.selectFromDropDown(By.id("testing"),"DRYRUB WET RUB");
             Thread.sleep(3000);
            
             //delivery address
             Select sel1 = new Select(driver.findElement(By.name("daddress")));
             sel1.selectByVisibleText("Chennai India");
             Thread.sleep(3000);
          
             
             //select group
             Utils.selectFromDropDown(By.id("group"),"Group A");
             Thread.sleep(3000);
             
             //care wordings
             Utils.selectFromDropDown(By.id("careword"),"Dry Clean");
            
             //care symbols
             driver.findElement(By.className("overSelect")).click();
             driver.findElement(By.xpath("//*[@id='terms']")).click();
           
             //proceed to next
             driver.findElement(By.xpath("//*[@id='createorder']/div[1]/div/div[2]/input")).click();
            
             
              }

    @When("^user submit all data$")
    public void user_submit_all_data() throws Throwable {
    	 //create order step3
        driver.findElement(By.name("submit")).click();
        
    }

    @Then("^order should successfully created with message$")
    public void order_should_successfully_created_with_message() throws Throwable {
    	Assert.assertTrue(driver.findElement(By.xpath("//*[@id='mytrm']/div/div/div[1]/font")).getText().contains("Order created successfully."));
    	
    }
    
    
    
    
   
   /* @Given("^user is on crareate order page$")
    public void user_is_on_crareate_order_page() throws Throwable {
    	loginPage = new LoginPage();
    	loginPage.login(AutomationConstants.USERNAME,AutomationConstants.PASSWORD );
    	Thread.sleep(5000);
    	driver.findElement(By.xpath("html/body/div[2]/div[1]/ul/li[3]/a")).click();
    	driver.findElement(By.xpath("//html/body/div[2]/div[1]/ul/li[3]/ul/li[1]/a")).click();
    	Assert.assertTrue(driver.findElement(By.xpath("//*[@id='createorder']/div[1]/div/div[1]/h1")).getText().contains("Create Order"));
    }
         
    

    @When("^I create New Quality$")
    public void i_create_New_Quality() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	driver.findElement(By.xpath("//*[@id='main1']/div[4]/a")).click();
    	Utils.selectFromDropDown(By.id("supplier"),"sudhaandco");
    	driver.findElement(By.xpath("//*[@id='qrc']")).sendKeys("jeans");
    	driver.findElement(By.xpath("//*[@id='weight']")).sendKeys("500");
    	driver.findElement(By.xpath("//*[@id='construction']")).sendKeys("500");
    	driver.findElement(By.xpath(".//*[@id='width']")).sendKeys("10");
    	Utils.selectFromDropDown(By.id("fabric_type"),"Cotton");
    	Utils.selectFromDropDown(By.xpath("//*[@id='Cloth_Type']"),"Cotton");
    	driver.findElement(By.xpath("//*[@id='Percentage']")).sendKeys("50");
    	driver.findElement(By.xpath("id=getpercentage")).click();
    	Utils.selectFromDropDown(By.xpath("//*[@id='Cloth_Type1']"),"Silk");
    	driver.findElement(By.id("Percents1")).sendKeys("50");
    	driver.findElement(By.id("getpercentage")).click();
    	driver.findElement(By.id("submit")).click();
    }
   
    
     @Then("^I should see my created new Quality  listed on Quality Library page$")
    public void i_should_see_my_created_new_Quality_listed_on_Quality_Library_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	Assert.assertTrue(driver.findElement(By.xpath("//html/body/div[2]/div[2]/div/div[1]/div/div[1]/h1")).getText().contains("Quality Library"));  
        
        
   
    }*/
        
        @After
  
    public void embedScreenshot() {
    
    	
    	driver.quit();
    	driver.close();
   
    }
}
   
