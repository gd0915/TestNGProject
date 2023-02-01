package allover_commerce.tests.US_12;

import allover_commerce.pages.HomePageUS_12;
import allover_commerce.pages.LoginPageUS_12;
import allover_commerce.pages.VendorMyAccountPageUS_12;
import allover_commerce.utilities.ConfigReader;
import allover_commerce.utilities.Driver;
import allover_commerce.utilities.JSUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_12_TC_06 {

    // US_12 : "Vendor should be able to add Billing Address. (My Account > Addresses > Billing Address)"

    // Acceptance Criteria : The registered email address should be filled in automatically.

    // TC_06 : The registered email address should be filled in automatically.

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

    HomePageUS_12 homePageUS_12 = new HomePageUS_12();
    LoginPageUS_12 loginPageUS_12 = new LoginPageUS_12();
    VendorMyAccountPageUS_12 vendorMyAccountPageUS_12 = new VendorMyAccountPageUS_12();

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
    public void TC_06(){
        login();

//        Click on user icon to navigate My Account page
        JSUtils.clickElementByJS(homePageUS_12.signOutButton);

//        And Click on Addresses button
        JSUtils.clickElementByJS(vendorMyAccountPageUS_12.addressesOption);

//        And Click add button under the Billing Address
        JSUtils.clickElementByJS(vendorMyAccountPageUS_12.editBillingAddressButton);

//        Then Verify the registered email is displayed on the site
        Assert.assertEquals(JSUtils.getValueInStringByJS("billing_email"), "tiselamono@jollyfree.com");

    }

}
