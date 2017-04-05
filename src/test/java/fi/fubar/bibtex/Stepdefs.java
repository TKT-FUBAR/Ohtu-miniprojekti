package fi.fubar.bibtex;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Stepdefs {

    WebDriver driver;

    public Stepdefs() {
        try {
            FirefoxDriverManager.getInstance().setup();
        } catch (Exception e) {
            
        }
        
        this.driver = new FirefoxDriver();
    }

    @Given("^user is logged in$")
    public void user_is_logged_in() throws Throwable {
        logInWith("foo", "bar");
    }

    @Given("^user navigates to the \"([^\"]*)\" page$")
    public void user_navigates_to_the_page(String str1) throws Throwable {
        driver.get("http://localhost:" + 8080 + "/" + str1);
    }

    @Given("^has navigated to the \"([^\"]*)\" page$")
    public void has_navigated_to_the_page(String arg1) throws Throwable {
        assertTrue(driver.getCurrentUrl().contains("references"));
    }

    @When("^the entry \"([^\"]*)\" is entered into the field \"([^\"]*)\"$")
    public void the_entry_is_entered_into_the_field(String entry, String field) throws Throwable {
        driver.findElement(By.name(field)).sendKeys(entry);
    }

    @When("^the form is submitted$")
    public void the_form_is_submitted() throws Throwable {
        driver.findElement(By.name("submit")).click();
        Thread.sleep(1000l);
    }

    @Then("^a reference to \"([^\"]*)\" is added\\.$")
    public void a_reference_to_is_added(String ref) throws Throwable {
        assertTrue(driver.getCurrentUrl().contains("references"));
        assertTrue(driver.getPageSource().contains(ref));
    }

    @Then("^a \"([^\"]*)\" is added\\.$")
    public void a_is_added(String arg1) throws Throwable {
        assertTrue(driver.getCurrentUrl().contains("createuser"));
        assertTrue(driver.getPageSource().contains(arg1));
    }

    private void logInWith(String foo, String bar) throws InterruptedException {
        driver.get("http://localhost:" + 8080);
        assertTrue(driver.getPageSource().contains("Login with Username and Password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(foo);
        element = driver.findElement(By.name("password"));
        element.sendKeys(bar);
        driver.findElement(By.name("submit")).click();
        Thread.sleep(1000l);
    }

}
