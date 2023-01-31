package allover_commerce.tests.US_12;

import allover_commerce.pages.HomePage;
import allover_commerce.pages.LoginPage;
import allover_commerce.pages.VendorMyAccountPage;
import allover_commerce.utilities.ConfigReader;
import allover_commerce.utilities.Driver;
import allover_commerce.utilities.JSUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_12_TC_06 {
    /*
    Given User should navigate to Allover Commerce url
    When Click on sign in button
    And Enter username into username/email box
    And Enter password into password box
    And Click on sign in button
    And Click on user icon to navigate My Account page
    And Click on Addresses button
    And Click add button under the Billing Address
    Then Verify the registered email is displayed on the site
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
        loginPage.usernameInput.sendKeys(ConfigReader.getProperty("app_vendor_valid_email2"));

        //    Enter password into password box
        loginPage.passwordInput.sendKeys(ConfigReader.getProperty("app_vendor_valid_password2"));

        //    Click on sign in button
        loginPage.signInButton.click();
    }

    @Test
    public void TC_06(){
        login();

//        Click on user icon to navigate My Account page
        homePage.signOutButton.click();

//        And Click on Addresses button
        vendorMyAccountPage.addressesOption.click();

//        And Click add button under the Billing Address
        vendorMyAccountPage.editBillingAddressButton.click();

//        Then Verify the registered email is displayed on the site
        Assert.assertEquals(JSUtils.getValueInStringByJS("billing_email"), "tiselamono@jollyfree.com");

    }

}
