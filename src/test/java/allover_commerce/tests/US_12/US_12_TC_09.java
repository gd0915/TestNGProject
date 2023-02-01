package allover_commerce.tests.US_12;

import allover_commerce.pages.HomePageUS_12;
import allover_commerce.pages.LoginPageUS_12;
import allover_commerce.pages.VendorMyAccountPageUS_12;
import allover_commerce.utilities.ConfigReader;
import allover_commerce.utilities.Driver;
import allover_commerce.utilities.JSUtils;
import allover_commerce.utilities.ReusableMethods;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US_12_TC_09 {

    // US_12 : "Vendor should be able to add Billing Address. (My Account > Addresses > Billing Address)"

    // Acceptance Criteria : After clicking 'Save Address', the Billing Address should be added.

    // TC_09 : After saving shipping address with valid credentials, vendor should be able to see editing billing address option

    /*
    Given User should navigate to Allover Commerce url
    When Click on sign in button
    And Enter username into username/email box
    And Enter password into password box
    And Click on sign in button
    And Click on user icon to navigate My Account page
    And Click on Addresses button
    And Click add button under the Billing Address
    And Enter firstname into First name box
    And Enter lastname into Last name box
    And Enter Country/Region into County/Region box
    And Enter a Street address into Street address box
    And Enter a Town/City into Town/City box
    And Enter a state into State box
    And Enter a Zip Code into ZipCode box
    And Enter a Phone number
    And Click on save address button
    Then Verify Edit Your Billing Address Option is clickable
    When Click on edit your billing address button
    Then Verify edit your billing address button is clickable
     */

    HomePageUS_12 homePageUS_12 = new HomePageUS_12();
    LoginPageUS_12 loginPageUS_12 = new LoginPageUS_12();
    VendorMyAccountPageUS_12 vendorMyAccountPageUS_12 = new VendorMyAccountPageUS_12();

    @DataProvider
    public Object[][] vendorData(){
        //  TEST DATA
        Object [][] vendorCredentials = {

                {"Laura", "Brown", "100 William F Bell Street", "Richmond Hill", "L4S 0K1", "4204569874"},
        };
        return vendorCredentials;
    }

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

    @Test(dataProvider = "vendorData")
    public void TC_09(String firstname, String lastname, String street, String city, String zipcode, String phone) {

        login();

        //     Click on user icon to navigate My Account page
        JSUtils.clickElementByJS(homePageUS_12.signOutButton);

        //     Click on Addresses button
        JSUtils.clickElementByJS(vendorMyAccountPageUS_12.addressesOption);

        //     Click add button under the Billing Address
        ReusableMethods.waitFor(1);
        JSUtils.clickElementByJS(vendorMyAccountPageUS_12.editBillingAddressButton);

        //     Enter invalid firstname into First name box
        vendorMyAccountPageUS_12.vendorFirstnameInput.clear();
        vendorMyAccountPageUS_12.vendorFirstnameInput.sendKeys(firstname);

        //    Enter invalid lastname into Last name box
        vendorMyAccountPageUS_12.vendorLastnameInput.clear();
        vendorMyAccountPageUS_12.vendorLastnameInput.sendKeys(lastname);

        //    Enter Country/Region into County/Region box
        Select selectCountry = new Select(vendorMyAccountPageUS_12.countryDropdown);
        selectCountry.selectByVisibleText("Canada");

        //    Enter a Street address into Street address box
        vendorMyAccountPageUS_12.streetInput.clear();
        vendorMyAccountPageUS_12.streetInput.sendKeys(street);

        //    Enter a Town/City into Town/City box
        vendorMyAccountPageUS_12.cityInput.clear();
        vendorMyAccountPageUS_12.cityInput.sendKeys(city);

        //    Enter a state into State box
        Select selectState = new Select(vendorMyAccountPageUS_12.stateDropdown);
        selectState.selectByVisibleText("Ontario");

        //    Enter a Zip Code into ZipCode box
        vendorMyAccountPageUS_12.zipcodeInput.clear();
        ReusableMethods.waitFor(1);
        vendorMyAccountPageUS_12.zipcodeInput.sendKeys(zipcode);

        //     Enter a Phone number
        vendorMyAccountPageUS_12.vendorPhoneInput.clear();
        vendorMyAccountPageUS_12.vendorPhoneInput.sendKeys(phone);

        //     Click on save address button
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(vendorMyAccountPageUS_12.saveAddressButton);

        //    Verify Edit Your Shipping Address Option is displayed
        Assert.assertTrue(vendorMyAccountPageUS_12.editBillingAddressButton.isDisplayed());

        //    Click on edit your shipping address button
        JSUtils.clickElementByJS(vendorMyAccountPageUS_12.editBillingAddressButton);

        //    Verify edit your shipping address button is clickable
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("edit-address"));

    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}
