package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;  // For Duration

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;


    // Constructor to initialize the WebDriver and WebDriverWait
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

 // Method to open a specified URL in the browser
    public void openUrl(String url) {
        driver.get(url);
    }
}


