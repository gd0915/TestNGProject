package allover_commerce.tests.US_13;

import allover_commerce.pages.HomePage;
import allover_commerce.pages.LoginPage;
import allover_commerce.pages.VendorMyAccountPage;
import allover_commerce.utilities.ConfigReader;
import allover_commerce.utilities.Driver;
import allover_commerce.utilities.JSUtils;
import allover_commerce.utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US_13_TC_06 {
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

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    VendorMyAccountPage vendorMyAccountPage = new VendorMyAccountPage();


    public void login() {
        //    User should navigate to Allover Commerce url https://allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        //    Click on sign in button
        homePage.singInButton.click();

        //    Enter username into username/email box
        loginPage.usernameInput.sendKeys(ConfigReader.getProperty("app_vendor_valid_email3"));

        //    Enter password into password box
        loginPage.passwordInput.sendKeys(ConfigReader.getProperty("app_vendor_valid_password3"));

        //    Click on sign in button
        loginPage.signInButton.click();
    }

    @Test
    public void TC_06() {

        login();

        //    Click on user icon to navigate My Account page
        homePage.signOutButton.click();

        //    Click on Addresses button
        vendorMyAccountPage.addressesOption.click();

        //    Click add button under the Shipping Address
        vendorMyAccountPage.addShippingAddressButton.click();

        //    Click on save address button
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(vendorMyAccountPage.saveAddressButton);

        //    Verify the application is not able to save shipping address with any missing data in the required fields
        for(WebElement eachAlert : vendorMyAccountPage.invalidDataAlertList){
            Assert.assertTrue(eachAlert.isDisplayed());
        }

        ReusableMethods.waitFor(3);
        Assert.assertEquals(vendorMyAccountPage.invalidDataAlertList.size(), 7);

    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}
