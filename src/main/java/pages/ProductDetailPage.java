package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ProductDetailPage extends BasePage {

	// WebElement representing the product title on the product detail page
	@FindBy(xpath = "//span[@id='productTitle']")
    private WebElement productTitle;

	// WebElement representing the "Add to Cart" button
    @FindBy(xpath = "(//input[@id='add-to-cart-button'])[2]")
    private WebElement addToCartButton;
    
    // WebElement representing the cart button
    @FindBy(xpath = "//span[@id='attach-sidesheet-view-cart-button']/span/input")
    private WebElement cartButton;

    // Constructor to initialize the ProductDetailPage elements and inherit from BasePage
    public ProductDetailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Method to get the actual title of the product
    public String getActualTitle() {
        return productTitle.getText();
    }

    // Method to add the product to the cart
    public void addToCart() {
        wait.until(ExpectedConditions.visibilityOf(addToCartButton));
        addToCartButton.click();
    }
    
    // Method to click the cart button 
    public void clickCartButton() {
        wait.until(ExpectedConditions.visibilityOf(cartButton));
        cartButton.click();
    	
    }
}
