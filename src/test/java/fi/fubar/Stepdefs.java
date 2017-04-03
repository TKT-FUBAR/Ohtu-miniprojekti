package fi.fubar;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static fi.fubar.RunCukesTest.server;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Stepdefs {
    @Given("^user is logged in$")
    public void user_is_logged_in() throws Throwable {
        logInWith("foo", "bar");
    }

    @Given("^has navigated to the \"([^\"]*)\" page$")
    public void has_navigated_to_the_page(String arg1) throws Throwable {
        assertTrue(server.getDriver().getCurrentUrl().contains("references"));
    }

    @When("^the entry \"([^\"]*)\" is entered into the field \"([^\"]*)\"$")
    public void the_entry_is_entered_into_the_field(String entry, String field) throws Throwable {
        WebElement elem = server.getDriver().findElement(By.name(field));
        elem.sendKeys(entry);
    }

    @When("^the form is submitted$")
    public void the_form_is_submitted() throws Throwable {
        WebElement elem = server.getDriver().findElement(By.name("submit"));
        elem.submit();
    }

    @Then("^a reference to \"([^\"]*)\" is added\\.$")
    public void a_reference_to_is_added(String ref) throws Throwable {
        WebDriver driver = server.getDriver();
        assertTrue(driver.getCurrentUrl().contains("references"));
        assertTrue(driver.getPageSource().contains(ref));
    }

    private void logInWith(String foo, String bar) throws InterruptedException {
        WebDriver driver = server.getDriver();
        driver.get("http://localhost:" + server.getPort());
        assertTrue(driver.getPageSource().contains("Login with Username and Password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(foo);
        element = driver.findElement(By.name("password"));
        element.sendKeys(bar);
        element.findElement(By.name("submit"));
        element.submit();
        Thread.sleep(1000l);
    }

}
