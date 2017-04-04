package fi.fubar.bibtex;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@SpringBootTest
@CucumberOptions(plugin = {"pretty"})
public class RunCukesTest {
    @ClassRule
    public static ServerRule server = new ServerRule(8080);
}