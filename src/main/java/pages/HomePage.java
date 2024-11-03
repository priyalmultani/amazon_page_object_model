package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	// WebElement representing the search box on the home page
    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    // WebElement representing the search button on the home page
    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;

    // Constructor to initialize the HomePage elements and inherit from BasePage
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Method to perform a search for a product by name
    public void searchForProduct(String productName) {
        searchBox.sendKeys(productName);
        searchButton.click();
    }
}
