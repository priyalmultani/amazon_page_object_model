package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultsPage extends BasePage {

	// WebElement representing the button to navigate to page 2 of the search results
	@FindBy(xpath = "//a[@class='s-pagination-item s-pagination-button'][1]")
    private WebElement page2Button;
  
	// WebElement representing the link to the fifth product in the search results
    @FindBy(xpath = "//*[@id='search']//div[@data-component-type='s-search-result'][5]//h2/a")
    private WebElement fifthProductLink;

    // Constructor to initialize the SearchResultsPage elements and inherit from BasePage
    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Method to scroll the page to make the page 2 button visible
    public void scrollPageToPage2Button() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", page2Button);	    
    }
    
    // Method to click the button for page 2
    public void clickPage2() {
        wait.until(ExpectedConditions.elementToBeClickable(page2Button));
        page2Button.click();
    }
   
    // Method to scroll the page to the fifth product link
    public void scrollPageToFifthProduct() {
    	wait.until(ExpectedConditions.visibilityOf(fifthProductLink));
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", fifthProductLink);
        
    }
    
    // Method to get the title of the fifth product
    public String getProductTitle(){
        wait.until(ExpectedConditions.visibilityOf(fifthProductLink));
        return fifthProductLink.getText();
    }
    
    // Method to click the fifth product link
    public void clickFifthProduct() throws InterruptedException {
    	wait.until(ExpectedConditions.elementToBeClickable(fifthProductLink));
    	fifthProductLink.click();
    }
    
    // Method to switch to a new browser tab
    public void switchTab() {
    	List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));
    }
}
