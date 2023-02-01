package allover_commerce.tests.US_14;

import allover_commerce.pages.HomePageUS_12;
import allover_commerce.pages.LoginPageUS_12;
import allover_commerce.pages.StoreManagerPageUS_14;
import allover_commerce.pages.VendorMyAccountPageUS_12;
import allover_commerce.utilities.ConfigReader;
import allover_commerce.utilities.Driver;
import allover_commerce.utilities.JSUtils;
import allover_commerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class US_14_TC_10 {

    //  US_14 "User should be able to see the options to add items as a Vendor #1.
    //        (My Account > Store Manager > Product > Add New)"

    // Acceptance Criteria : Vendor should be able to add New Categories.

    //  TC_10 - Vendor should be able to add New Categories.

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
    And Click on +Add new category option
    And Enter a new category name
    And Click on add
    Then Verify that new category is created in the main categories section
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
    public void TC_10() {

        login();

        //  Click on user icon to navigate My Account page
        homePageUS_12.signOutButton.click();

        //  Click on Store Manager to navigate to store manager url
        vendorMyAccountPageUS_12.storeManager.click();

        //  Click on Products option
        storeManagerPageUS_14.productsOption.click();

        //  Click on Add New option
        storeManagerPageUS_14.addNewButton.click();

        //  Click on +Add new category option
        JSUtils.clickElementByJS(storeManagerPageUS_14.addNewCategory);

        //  Enter a new category name
        Faker faker = new Faker();
        String newCategoryName = faker.name().name();
        storeManagerPageUS_14.categoryNameInput.sendKeys(newCategoryName);

        //  Click on add
        JSUtils.clickElementByJS(storeManagerPageUS_14.addCategoryNameButton);

        //  Verify that new category is created in the categories section
        ReusableMethods.waitFor(3);
        Assert.assertTrue(storeManagerPageUS_14.allMainCategoryNames.get(0).getText().equals(newCategoryName));

    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
