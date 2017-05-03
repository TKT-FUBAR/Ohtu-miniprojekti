package fi.fubar.bibtex;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.io.File;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Stepdefs {

    WebDriver driver;

    public Stepdefs() {
        File file;
        if (System.getProperty("os.name").matches("Mac OS X")) {
            file = new File("lib/macgeckodriver");
        } else {
            file = new File("lib/geckodriver");
        }
        String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.gecko.driver", absolutePath);

        this.driver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("^user is logged in$")
    public void user_is_logged_in() throws Throwable {
        logInWith("foo", "bar");
    }

    @Given("^user navigates to the \"([^\"]*)\" page$")
    public void user_navigates_to_the_page(String str1) throws Throwable {
        driver.get("http://localhost:" + 8080 + "/" + str1);
        Thread.sleep(1000);
    }

    @Given("^has navigated to the \"([^\"]*)\" tab")
    public void user_navigates_to_the_tab(String str1) throws Throwable {
        Thread.sleep(1000);
        driver.findElement(By.name(str1)).click();
        Thread.sleep(1000);
    }

    @Given("^has navigated to the \"([^\"]*)\" page$")
    public void has_navigated_to_the_page(String arg1) throws Throwable {
        assertTrue(driver.getCurrentUrl().contains(arg1));
    }

    @Given("^clicks the \"([^\"]*)\" link$")
    public void clicks_the_link(String arg1) throws Throwable {
        Thread.sleep(1000);
        driver.findElement(By.linkText(arg1)).click();
        Thread.sleep(1000);
    }

    @When("^the entry \"([^\"]*)\" is entered into the field \"([^\"]*)\"$")
    public void the_entry_is_entered_into_the_field(String entry, String field) throws Throwable {
        driver.findElement(By.id(field)).sendKeys(entry);
    }

    @When("^the entry \"([^\"]*)\" is entered into the field \"([^\"]*)\" of \"([^\"]*)\" form$")
    public void the_entry_is_entered_into_the_field_of_form(String entry, String field, String form) throws Throwable {
        driver.findElement(By.id(form)).findElement(By.name(field)).sendKeys(entry);
    }

    @When("^the entry \"([^\"]*)\" is entered into the login field \"([^\"]*)\"$")
    public void the_entry_is_entered_into_the_login_field(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.name(arg2)).sendKeys(arg1);
    }

    @When("^the entry \"([^\"]*)\" is entered into the password field \"([^\"]*)\"$")
    public void the_entry_is_entered_into_the_password_field(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.name(arg2)).sendKeys(arg1);
    }

    @When("^the form is submitted$")
    public void the_form_is_submitted() throws Throwable {
        driver.findElement(By.name("submit")).click();
        Thread.sleep(1000l);
    }

    @When("^the delete button is pressed$")
    public void the_delete_button_is_pressed() throws Throwable {
        driver.findElement(By.id("delete")).findElement(By.name("submit")).click();
        Thread.sleep(1000l);
    }

    @Given("^test reference is added$")
    public void test_reference_is_added() throws Throwable {
        Thread.sleep(1000l);
        if (!driver.getPageSource().contains("testTitle")) {
            driver.findElement(By.linkText("Add a reference")).click();
            Thread.sleep(500l);
            driver.findElement(By.name("add_book")).click();
            Thread.sleep(500l);
            driver.findElement(By.id("form-book")).findElement(By.name("handle")).sendKeys("testHandle");
            driver.findElement(By.id("form-book")).findElement(By.name("title")).sendKeys("testTitle");
            driver.findElement(By.id("form-book")).findElement(By.name("author")).sendKeys("testAuthor");
            driver.findElement(By.id("form-book")).findElement(By.name("publisher")).sendKeys("testPublisher");
            driver.findElement(By.id("form-book")).findElement(By.name("year")).sendKeys("1111");
            driver.findElement(By.name("submit")).click();
            Thread.sleep(1000l);
        }
    }

    @When("^user clicks on the \"([^\"]*)\" reference$")
    public void user_clicks_on_the_reference(String arg1) throws Throwable {
        driver.findElement(By.linkText(arg1)).click();
        Thread.sleep(1000l);
    }

    @When("^the form \"([^\"]*)\" is submitted$")
    public void the_form_x_is_submitted(String str1) throws Throwable {
        driver.findElement(By.id(str1)).findElement(By.name("submit")).click();
        Thread.sleep(1000l);
    }

    @When("^user changes the field \"([^\"]*)\" to \"([^\"]*)\"$")
    public void user_changes_the_field_to_in_the_form(String arg1, String arg2) throws Throwable {
        driver.findElement(By.name(arg1)).clear();
        driver.findElement(By.name(arg1)).sendKeys(arg2);
    }

    @When("^user searches for \"([^\"]*)\"$")
    public void user_searches_for(String arg1) throws Throwable {
        driver.findElement(By.id("form-search")).findElement(By.name("search")).sendKeys(arg1);
        driver.findElement(By.id("form-search")).findElement(By.name("submit")).click();
        Thread.sleep(500l);
    }

    @Then("^\"([^\"]*)\" is shown$")
    public void is_shown(String arg1) throws Throwable {
        pageHasContent(arg1);
    }

    @Then("^\"([^\"]*)\" is not shown$")
    public void is_not_shown(String arg1) throws Throwable {
        pageDoesNotHaveContent(arg1);
    }

    @Then("^the reference to \"([^\"]*)\" is removed\\.$")
    public void the_reference_to_is_removed(String arg1) throws Throwable {
        pageDoesNotHaveContent(arg1);
    }

    @Then("^reference to \"([^\"]*)\" is added\\.$")
    public void reference_to_is_added(String arg1) throws Throwable {
        pageHasContent(arg1);
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

    @Then("^user is succesfully logged in$")
    public void user_is_succesfully_logged_in() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        pageHasContent("reference");
    }

    @Then("^user is not logged in and error is shown$")
    public void user_is_not_logged_in_and_error_is_shown() throws Throwable {
        pageHasContent("credentials");
    }

    @Then("^user sees populated fields on the edit form$")
    public void user_sees_populated_fields_on_the_edit_form() throws Throwable {
        pageHasContent("testTitle");
        pageHasContent("testHandle");
        pageHasContent("testAuthor");
        pageHasContent("1111");
        pageHasContent("testPublisher");
    }

    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }

    private void pageDoesNotHaveContent(String content) {
        assertTrue(!driver.getPageSource().contains(content));
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
