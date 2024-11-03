package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCartPage extends BasePage {

	// WebElement representing the product title in the shopping cart
	@FindBy(xpath = "//span[@class='a-truncate-cut']")
	WebElement cartProduct;
	
	// Constructor to initialize the ShoppingCartPage elements and inherit from BasePage
	public ShoppingCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
	
	// Method to get the title of the product in the cart
	public String getCartProductTitle() {
        wait.until(ExpectedConditions.visibilityOf(cartProduct));  
        return cartProduct.getText();
	}
	
}

