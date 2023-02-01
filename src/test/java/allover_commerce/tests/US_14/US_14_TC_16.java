package allover_commerce.tests.US_14;

import allover_commerce.pages.HomePageUS_12;
import allover_commerce.pages.LoginPageUS_12;
import allover_commerce.pages.StoreManagerPageUS_14;
import allover_commerce.pages.VendorMyAccountPageUS_12;
import allover_commerce.utilities.ConfigReader;
import allover_commerce.utilities.Driver;
import allover_commerce.utilities.JSUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US_14_TC_16 {

    // US_14 "User should be able to see the options to add items as a Vendor #1.
    //        (My Account > Store Manager > Product > Add New)"

    // Acceptance Criteria : Catalog visibility; should be selectable as Shop and search results, Shop only, Search results only, Hidden.

    // TC_16 - Catalog visibility; should be selectable as Shop and search results, Shop only, Search results only, Hidden.
/*
    Given User should navigate to Allover Commerce url
    When Click on sign in button
    And Enter username into username/email box
    And Enter password into password box
    And Click on sign in button
    And Click on user icon to navigate My Account page
    And Vendor should navigate to store manager url
    And Click on Products option
    And Click on Add New button
    And Click on Catalog visibility dropdown
    Then Verify dropdown has 4 options named as Shop and search results, Shop only, Search results only, Hidden
 */

    HomePageUS_12 homePageUS_12 = new HomePageUS_12();
    LoginPageUS_12 loginPageUS_12 = new LoginPageUS_12();

    VendorMyAccountPageUS_12 vendorMyAccountPageUS_12 = new VendorMyAccountPageUS_12();

    StoreManagerPageUS_14 storeManagerPageUS_14 = new StoreManagerPageUS_14();

    public void login() {
        //    User should navigate to Allover Commerce url https://allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        //    Click on sign in button
        homePageUS_12.singInButton.click();

        //    Enter username into username/email box
        loginPageUS_12.usernameInput.sendKeys(ConfigReader.getProperty("app_vendor_valid_email2"));

        //    Enter password into password box
        loginPageUS_12.passwordInput.sendKeys(ConfigReader.getProperty("app_vendor_valid_password2"));

        //    Click on sign in button
        loginPageUS_12.signInButton.click();
    }

    @Test
    public void TC_16() {

        login();

        //  Click on user icon to navigate My Account page
        JSUtils.clickElementByJS(homePageUS_12.signOutButton);

        //  Click on Store Manager to navigate to store manager url
        JSUtils.clickElementByJS(vendorMyAccountPageUS_12.storeManager);

        //  Click on Products option
        JSUtils.clickElementByJS(storeManagerPageUS_14.productsOption);

        //  Click on Add New option
        JSUtils.clickElementByJS(storeManagerPageUS_14.addNewButton);

        //  Click on Catalog visibility dropdown
        //  Verify dropdown has 4 options named as Shop and search results, Shop only, Search results only, Hidden
        Select select = new Select(storeManagerPageUS_14.catalogVisibilityDropdown);
        List<WebElement> allDropdownOptions = select.getOptions();
        List<String> optionNames = new ArrayList<>(Arrays.asList("Shop and search results", "Shop only", "Search results only", "Hidden"));
        boolean isOptionsExist = false;
        int idx = 0;
        for(WebElement eachOption : allDropdownOptions){
            if(eachOption.getText().equals(optionNames.get(idx)));
            isOptionsExist = true;
            idx++;
        }
        Assert.assertTrue(isOptionsExist);

    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }


}
