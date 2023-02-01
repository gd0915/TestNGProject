package allover_commerce.tests.US_14;

import allover_commerce.pages.HomePageUS_12;
import allover_commerce.pages.LoginPageUS_12;
import allover_commerce.pages.StoreManagerPageUS_14;
import allover_commerce.pages.VendorMyAccountPageUS_12;
import allover_commerce.utilities.ConfigReader;
import allover_commerce.utilities.Driver;
import allover_commerce.utilities.JSUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class US_14_TC_07 {

    //  US_14 "User should be able to see the options to add items as a Vendor #1.
    //        (My Account > Store Manager > Product > Add New)"

    // Acceptance Criteria : Vendor should be able to write a Product Title, Short Description and Description

    //  TC_07 - Vendor should be able to write a Product Title, Short Description and Description

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
    And Enter a product title
    And Enter a short description
    Then Verify data has been entered
    And Enter a description
    Then Verify data has been entered
    Then Verify product title is visible on the page
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
    public void TC_07() {

        login();

        //  Click on user icon to navigate My Account page
        JSUtils.clickElementByJS(homePageUS_12.signOutButton);

        //  Click on Store Manager to navigate to store manager url
        JSUtils.clickElementByJS(vendorMyAccountPageUS_12.storeManager);

        //  Click on Products option
        JSUtils.clickElementByJS(storeManagerPageUS_14.productsOption);

        //  Click on Add New option
        JSUtils.clickElementByJS(storeManagerPageUS_14.addNewButton);

        //  Enter a product title
        storeManagerPageUS_14.productTitleInput.sendKeys("Plastic Ball");

        //  Enter a short description
        Driver.getDriver().switchTo().frame(0);
        JSUtils.scrollIntoViewJS(storeManagerPageUS_14.shortDescriptionInput);
        storeManagerPageUS_14.shortDescriptionInput.sendKeys("Plastic red ball");

        //  Verify data has been entered
        Assert.assertTrue(storeManagerPageUS_14.verifyTextOfDescription.getText().equals("Plastic red ball"));

        //  Enter a description
        Driver.getDriver().switchTo().defaultContent();
        Driver.getDriver().switchTo().frame("description_ifr");
        JSUtils.scrollIntoViewJS(storeManagerPageUS_14.descriptionInput);
        storeManagerPageUS_14.descriptionInput.sendKeys("Plastic ball for infants");

        //  Verify data has been entered
        Assert.assertTrue(storeManagerPageUS_14.verifyTextOfDescription.getText().equals("Plastic ball for infants"));
        Driver.getDriver().switchTo().defaultContent();

        //  Verify entered data is visible on the page
        Assert.assertTrue(JSUtils.getValueInStringByJS("pro_title").contains("Plastic Ball"));

    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
