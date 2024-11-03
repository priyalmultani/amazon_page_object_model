package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.SearchResultsPage;
import pages.ShoppingCartPage;

public class AmazonCart extends BaseTest{
    private HomePage homePageObj;
    private BasePage basePageObj;
    private SearchResultsPage searchResultsPageObj;
    private ProductDetailPage productDetailPageObj;
    private ShoppingCartPage shoppingCartPageObj;

    @BeforeClass
    public void setup() throws IOException {
    	startup();
        
        // Initialize page objects
        basePageObj = new BasePage(driver);
        homePageObj = new HomePage(driver);
        searchResultsPageObj = new SearchResultsPage(driver);
        shoppingCartPageObj = new ShoppingCartPage(driver);
        productDetailPageObj = new ProductDetailPage(driver);
    }

    @Test
    public void testAmazonPurchaseFlow() throws InterruptedException {
        // Step 1: Open URL
    	basePageObj.openUrl("https://www.amazon.in/");

        // Step 2: Search for iPhone 16
    	homePageObj.searchForProduct("iPhone 16");

        // Step 3: Scroll down and click on page 2
    	searchResultsPageObj.scrollPageToPage2Button();
    	searchResultsPageObj.clickPage2();

    	//Step 4: From list go to 5th product
    	searchResultsPageObj.scrollPageToFifthProduct();
        String productTitle = searchResultsPageObj.getProductTitle();
        
    	//Step 5: Click on title to open it
        searchResultsPageObj.clickFifthProduct();
        
        //Switch to new tab
        searchResultsPageObj.switchTab();
        
        // Step 6: Verify title

        String actualTitle = productDetailPageObj.getActualTitle();
        Assert.assertEquals(actualTitle, productTitle, "Titles do not match");

        // Step 7: Click on Add to Cart button
        productDetailPageObj.addToCart();

        //Step 8: Click on Cart button
        productDetailPageObj.clickCartButton();
        
        //Step 9: Verify that product is added into the cart
        String cartProductTitle = shoppingCartPageObj.getCartProductTitle();
	Assert.assertEquals(cartProductTitle, productTitle, "Product is not present in the cart");
    }
}
