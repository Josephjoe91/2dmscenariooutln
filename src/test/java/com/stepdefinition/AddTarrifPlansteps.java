package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;


public class AddTarrifPlansteps {
	
	static WebDriver driver;
	
	@Given("user launch demo telecom site")
	public void user_launch_demo_telecom_site() {
		System.setProperty("webdriver.chrome.driver", "F:\\cucumber\\driver\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/telecom/index.html");
		driver.manage().window().maximize();
	}
	
	@Given("user clicks on add tarrif button")
	public void user_clicks_on_add_tarrif_button() throws Throwable {
		handleframe();

		driver.findElement(By.xpath("//a[text()='Add Tariff Plan']")).click();
	}

	@When("user enters tarrif plan fields")
	public void user_enters_tarrif_plan_fields() throws Throwable {
		handleframe();
		driver.findElement(By.name("rental")).sendKeys("600");
		driver.findElement(By.name("local_minutes")).sendKeys("300");
		driver.findElement(By.name("inter_minutes")).sendKeys("200");
		driver.findElement(By.name("sms_pack")).sendKeys("100");
		driver.findElement(By.name("minutes_charges")).sendKeys("3");
		driver.findElement(By.name("inter_charges")).sendKeys("2");
		driver.findElement(By.name("sms_charges")).sendKeys("1");
		
	}
	
	@When("user enters tarrif plan fields with two dim map")
	public void user_enters_tarrif_plan_fields_with_two_dim_map(DataTable customerdata) throws Throwable {
		handleframe();
        List<Map<String, String>> data = customerdata.asMaps(String.class,String.class);
	    driver.findElement(By.name("rental")).sendKeys(data.get(3).get("MR"));
		driver.findElement(By.name("local_minutes")).sendKeys(data.get(2).get("FLM"));
		driver.findElement(By.name("inter_minutes")).sendKeys(data.get(3).get("FIM"));
		driver.findElement(By.name("sms_pack")).sendKeys(data.get(2).get("FSP"));
		driver.findElement(By.name("minutes_charges")).sendKeys(data.get(2).get("FSP"));
		driver.findElement(By.name("inter_charges")).sendKeys(data.get(2).get("IMC"));
		driver.findElement(By.name("sms_charges")).sendKeys(data.get(2).get("SMC"));
	}

	@When("user enters tarrif plan fields with two dim list")
	public void user_enters_tarrif_plan_fields_with_two_dim_list(DataTable customerdata) throws Throwable {
		handleframe();
	    List<List<String>> data = customerdata.asLists(String.class);
	    
	    driver.findElement(By.name("rental")).sendKeys(data.get(2).get(0));
		driver.findElement(By.name("local_minutes")).sendKeys(data.get(2).get(1));
		driver.findElement(By.name("inter_minutes")).sendKeys(data.get(3).get(2));
		driver.findElement(By.name("sms_pack")).sendKeys(data.get(2).get(3));
		driver.findElement(By.name("minutes_charges")).sendKeys(data.get(2).get(4));
		driver.findElement(By.name("inter_charges")).sendKeys(data.get(2).get(5));
		driver.findElement(By.name("sms_charges")).sendKeys(data.get(2).get(0));
	}
	
	
	@When("user enters tarrif plan fields with two dim list{string},{string},{string},{string},{string},{string},{string}")
	public void user_enters_tarrif_plan_fields_with_two_dim_list(String string, String string2, String string3, String string4, String string5, String string6, String string7) {
	   
		 
	    driver.findElement(By.name("rental")).sendKeys(string);
		driver.findElement(By.name("local_minutes")).sendKeys(string2);
		driver.findElement(By.name("inter_minutes")).sendKeys(string3);
		driver.findElement(By.name("sms_pack")).sendKeys(string4);
		driver.findElement(By.name("minutes_charges")).sendKeys(string5);
		driver.findElement(By.name("inter_charges")).sendKeys(string6);
		driver.findElement(By.name("sms_charges")).sendKeys(string7);

		
	}

	
	@When("user clicks on tarrif submit button")
	public void user_clicks_on_tarrif_submit_button() throws Throwable {

		driver.findElement(By.xpath("//input[@value='submit']")).click();
	}

	@Then("user should be recieved congratulation message")
	public void user_should_be_recieved_congratulation_message() throws Throwable {
		handleframe();
     Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Congratulation you add Tariff Plan']")).isDisplayed());
    String text = driver.findElement(By.xpath("//h2[text()='Congratulation you add Tariff Plan']")).getText();
    System.out.println(text);
     
	}
	public void handleframe() throws Throwable {
		Thread.sleep(3000);
		 driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"flow_close_btn_iframe\"]")));
		 driver.findElement(By.id("closeBtn")).click();
		 driver.switchTo().parentFrame();
	}


}
