package stepDefination;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//import com.pages.LoginPage;
import framework.DriverFactory;
import framework.Webfunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageUtils.ToDOMainPage;


public class ToDoBasicTest {

	//Application URL
	private WebDriver driver;
	String url = "https://todomvc.com/examples/vue/#/all";

	//Navigate and verify title
    @Given("^the user is in this page$")
    public void the_user_is_in_this_page() throws Throwable {
    	driver = DriverFactory.getDriver();    	
		driver.get(url);
		Assert.assertTrue(driver.getTitle().toString().contains("Vue.js"));	
		//Vue.js • TodoMVC	 
    }

    @Given("^an empty todo list$")
    public void an_empty_todo_list() throws Throwable {
    	driver = DriverFactory.getDriver(); 
    	driver.get(url);
    	Assert.assertTrue(driver.findElement(By.className("new-todo")).isDisplayed());
    }

   

    @When("^I add 'Buy milk' and 'Buy bread'$")
    public void i_add_buy_milk_and_buy_bread() throws Throwable {
    	ToDOMainPage todo = new ToDOMainPage();
    	todo.addItem("Buy milk");
    	todo.addItem("Buy bread");
    	    	
        
    }

    
    //Check if the TODO icon is present
    @Then("^ToDos title should be displayed$")
    public void todos_title_should_be_displayed() throws Throwable {
    	driver = DriverFactory.getDriver();  
    	String toDoIcon = "//h1[text()='todos']";
    	Webfunctions.waitForElement(driver, toDoIcon);
    	boolean toDoIconPresent = driver.findElement(By.xpath(toDoIcon)).isDisplayed();
    	Assert.assertTrue(toDoIconPresent);
    }

    @Then("^two items are listed$")
    public void two_items_are_listed() throws Throwable {        	
    	ToDOMainPage todo = new ToDOMainPage();
    	Assert.assertTrue(todo.verifyItemIsPresent("Buy milk"));
    	Assert.assertTrue(todo.verifyItemIsPresent("Buy bread"));
        
    }

    //Textbox is present 
    @And("^Blank text box is displayed$")
    public void blank_text_box_is_displayed() throws Throwable {
    	Assert.assertTrue(driver.findElement(By.className("new-todo")).isDisplayed());
    }
    //Verify that the place holder text is displayed
    @And("^'What needs to be done' is the place holder$")
    public void what_needs_to_be_done_is_the_place_holder() throws Throwable {
    	String placeholder = driver.findElement(By.className("new-todo")).getAttribute("placeholder").toString();
    	boolean placeholderTextMatches = placeholder.contentEquals("What needs to be done?");
    	Assert.assertTrue(placeholderTextMatches);
    }

    @And("^Footer text is present$")
    public void footer_text_is_present() throws Throwable {
    	String footerXpath = "//footer[@class='info']/p[1]";
    	Assert.assertTrue(driver.findElement(By.xpath(footerXpath)).isDisplayed());
    	
    }

    @And("^Bottom left displays '2 items left'$")
    public void bottom_left_displays_2_items_left() throws Throwable {
    	ToDOMainPage todo = new ToDOMainPage();
    	Assert.assertTrue(todo.verifyFooterNumber("2 items left"));    	
        
    }

    @And("^'All' , 'Active' & 'Complete' are displayed$")
    public void all_active_complete_are_displayed() throws Throwable {
    	ToDOMainPage todo = new ToDOMainPage();
    	Assert.assertTrue(todo.allActiveCompleteDisplayed());    	
    }

    @And("^'Clear completed' is not displayed$")
    public void clear_completed_is_not_displayed() throws Throwable {
    	ToDOMainPage todo = new ToDOMainPage();
    	Assert.assertTrue(todo.clearCompleteNotDisplayed());
    	
    }



}
