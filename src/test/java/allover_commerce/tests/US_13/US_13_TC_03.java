package allover_commerce.tests.US_13;

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

public class US_13_TC_03 {

    // US_13 : "Vendor should be able to add Shipping Address. (My Account > Addresses > Shipping Address)"

    // Acceptance Criteria : Vendor should enter First name, Last name, Country/Region, Street address, Town / City, State, ZIP Code.

    // TC_03 : Zip Code field should accept only valid alphanumeric zip code input from the users.

    /*
    Given User should navigate to Allover Commerce url
    When Click on sign in button
    And Enter username into username/email box
    And Enter password into password box
    And Click on sign in button
    And Click on user icon to navigate My Account page
    And Click on Addresses button
    And Click add button under the Shipping Address
    And Enter firstname into First name box
    And Enter lastname into Last name box
    And Enter Country/Region into County/Region box
    And Enter a Street address into Street address box
    And Enter a Town/City into Town/City box
    And Enter a state into State box
    And Enter an invalid Zip Code into ZipCode box
    And Click on save address button
    And Verify vendor should not be able to save shipping address with invalid zip code
     */

    HomePageUS_12 homePageUS_12 = new HomePageUS_12();
    LoginPageUS_12 loginPageUS_12 = new LoginPageUS_12();
    VendorMyAccountPageUS_12 vendorMyAccountPageUS_12 = new VendorMyAccountPageUS_12();

    @DataProvider
    public Object[][] vendorData(){
        //  TEST DATA
        Object [][] vendorCredentials = {

                {"Laura", "Brown", "100 William F Bell Street", "Richmond Hill", "4S6 7L9"},
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
    public void TC_03(String firstname, String lastname, String street, String city, String zipcode) {

        login();

        //    Click on user icon to navigate My Account page
        JSUtils.clickElementByJS(homePageUS_12.signOutButton);

        //    Click on Addresses button
        JSUtils.clickElementByJS(vendorMyAccountPageUS_12.addressesOption);

        //    Click add button under the Shipping Address
        JSUtils.clickElementByJS(vendorMyAccountPageUS_12.addShippingAddressButton);

        //    Enter firstname into First name box
        vendorMyAccountPageUS_12.vendorShippingFirstNameInput.clear();
        vendorMyAccountPageUS_12.vendorShippingFirstNameInput.sendKeys(firstname);

        //    Enter lastname into Last name box
        vendorMyAccountPageUS_12.vendorShippingLastNameInput.clear();
        vendorMyAccountPageUS_12.vendorShippingLastNameInput.sendKeys(lastname);

        //    Enter Country/Region into County/Region box
        Select selectCountry = new Select(vendorMyAccountPageUS_12.shippingCountryDropdown);
        selectCountry.selectByVisibleText("Canada");

        //    Enter a Street address into Street address box
        vendorMyAccountPageUS_12.shippingStreetInput.clear();
        vendorMyAccountPageUS_12.shippingStreetInput.sendKeys(street);

        //    Enter a Town/City into Town/City box
        vendorMyAccountPageUS_12.shippingCityInput.clear();
        vendorMyAccountPageUS_12.shippingCityInput.sendKeys(city);

        //    Enter a state into State box
        Select selectState = new Select(vendorMyAccountPageUS_12.shippingStateDropdown);
        selectState.selectByVisibleText("Ontario");

        //  Enter an invalid Zip Code into ZipCode box
        vendorMyAccountPageUS_12.shippingZipcodeInput.clear();
        vendorMyAccountPageUS_12.shippingZipcodeInput.sendKeys(zipcode);

        //  Click on save address button
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(vendorMyAccountPageUS_12.saveAddressButton);

        //  Verify vendor should not be able to save shipping address with invalid zip code
        ReusableMethods.waitFor(3);
        Assert.assertTrue(vendorMyAccountPageUS_12.invalidDataAlertList.get(0).isDisplayed());
        System.out.println(vendorMyAccountPageUS_12.invalidDataAlertList.get(0).getText());

    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }



}
