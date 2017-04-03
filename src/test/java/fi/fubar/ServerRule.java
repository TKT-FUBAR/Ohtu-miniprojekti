package fi.fubar;

import fi.fubar.bibtex.Main;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class ServerRule extends ExternalResource {
    private final int port;
    private final WebDriver driver = new ChromeDriver();
    
    public ServerRule(int port) {
        this.port = port;
    }

    @Override
    protected void before() throws Throwable {
        Main.main(null);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public int getPort() {
        return port;
    }

    @Override
    protected void after() {
        
    }
    
    
}
