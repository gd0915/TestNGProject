package allover_commerce.tests.US_13;

import allover_commerce.pages.HomePageUS_12;
import allover_commerce.pages.LoginPageUS_12;
import allover_commerce.pages.VendorMyAccountPageUS_12;
import allover_commerce.utilities.ConfigReader;
import allover_commerce.utilities.Driver;
import allover_commerce.utilities.JSUtils;
import allover_commerce.utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class US_13_TC_06 {

    // US_13 : "Vendor should be able to add Shipping Address. (My Account > Addresses > Shipping Address)"

    // Acceptance Criteria : Vendor should enter First name, Last name, Country/Region, Street address, Town / City, State, ZIP Code.

    // TC_06 : Vendor should not be able to save shipping address without entering any of the required fields
    //          (First name, Last name, Country/Region, Street address, Town / City, State, ZIP Code.)

    /*
    Given User should navigate to Allover Commerce url
    When Click on sign in button
    And Enter username into username/email box
    And Enter password into password box
    And Click on sign in button
    And Click on user icon to navigate My Account page
    And Click on Addresses button
    And Click add button under the Shipping Address
    And Click on save address button
    Then Verify the application is not able to save address with any missing data in the required fields
    (First name, Last name, Country/Region, Street address, Town / City, State, ZIP Code)
     */

    HomePageUS_12 homePageUS_12 = new HomePageUS_12();
    LoginPageUS_12 loginPageUS_12 = new LoginPageUS_12();
    VendorMyAccountPageUS_12 vendorMyAccountPageUS_12 = new VendorMyAccountPageUS_12();


    public void login() {
        //    User should navigate to Allover Commerce url https://allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        //    Click on sign in button
        homePageUS_12.singInButton.click();

        //    Enter username into username/email box
        loginPageUS_12.usernameInput.sendKeys(ConfigReader.getProperty("app_vendor_valid_email3"));

        //    Enter password into password box
        loginPageUS_12.passwordInput.sendKeys(ConfigReader.getProperty("app_vendor_valid_password3"));

        //    Click on sign in button
        loginPageUS_12.signInButton.click();
    }

    @Test
    public void TC_06() {

        login();

        //    Click on user icon to navigate My Account page
        JSUtils.clickElementByJS(homePageUS_12.signOutButton);

        //    Click on Addresses button
        JSUtils.clickElementByJS(vendorMyAccountPageUS_12.addressesOption);

        //    Click add button under the Shipping Address
        JSUtils.clickElementByJS(vendorMyAccountPageUS_12.addShippingAddressButton);

        //    Click on save address button
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(vendorMyAccountPageUS_12.saveAddressButton);

        //    Verify the application is not able to save shipping address with any missing data in the required fields
        for(WebElement eachAlert : vendorMyAccountPageUS_12.invalidDataAlertList){
            Assert.assertTrue(eachAlert.isDisplayed());
        }

        ReusableMethods.waitFor(3);
        Assert.assertEquals(vendorMyAccountPageUS_12.invalidDataAlertList.size(), 7);

    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}
