package allover_commerce.tests.US_13;

import allover_commerce.pages.HomePage;
import allover_commerce.pages.LoginPage;
import allover_commerce.pages.VendorMyAccountPage;
import allover_commerce.utilities.ConfigReader;
import allover_commerce.utilities.Driver;
import allover_commerce.utilities.JSUtils;
import allover_commerce.utilities.ReusableMethods;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US_13_TC_07 {
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
    And Enter a Zip Code into ZipCode box
    And Click on save address button
    And Verify Edit Your Shipping Address Option is  clickable
     */

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    VendorMyAccountPage vendorMyAccountPage = new VendorMyAccountPage();

    @DataProvider
    public Object[][] vendorData() {
        //  TEST DATA
        Object[][] vendorCredentials = {

                {"Laura", "Brown", "100 William F Bell Street", "Richmond Hill", "L4S 0K1"},
        };
        return vendorCredentials;
    }

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

    @Test(dataProvider = "vendorData")
    public void TC_07(String firstname, String lastname, String street, String city, String zipcode) {

        login();

        //    Click on user icon to navigate My Account page
        homePage.signOutButton.click();

        //    Click on Addresses button
        vendorMyAccountPage.addressesOption.click();

        //    Click add button under the Shipping Address
        vendorMyAccountPage.addShippingAddressButton.click();

        //    Enter firstname into First name box
        vendorMyAccountPage.vendorShippingFirstNameInput.clear();
        vendorMyAccountPage.vendorShippingFirstNameInput.sendKeys(firstname);

        //    Enter lastname into Last name box
        vendorMyAccountPage.vendorShippingLastNameInput.clear();
        vendorMyAccountPage.vendorShippingLastNameInput.sendKeys(lastname);

        //    Enter Country/Region into County/Region box
        Select selectCountry = new Select(vendorMyAccountPage.shippingCountryDropdown);
        selectCountry.selectByVisibleText("Canada");

        //    Enter a Street address into Street address box
        vendorMyAccountPage.shippingStreetInput.clear();
        vendorMyAccountPage.shippingStreetInput.sendKeys(street);

        //    Enter a Town/City into Town/City box
        vendorMyAccountPage.shippingCityInput.clear();
        vendorMyAccountPage.shippingCityInput.sendKeys(city);

        //    Enter a state into State box
        Select selectState = new Select(vendorMyAccountPage.shippingStateDropdown);
        selectState.selectByVisibleText("Ontario");

        //    Enter a Zip Code into ZipCode box
        vendorMyAccountPage.shippingZipcodeInput.clear();
        vendorMyAccountPage.shippingZipcodeInput.sendKeys(zipcode);

        //    Click on save address button
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(vendorMyAccountPage.saveAddressButton);

        //    Verify Edit Your Shipping Address Option is displayed
        Assert.assertTrue(vendorMyAccountPage.addShippingAddressButton.isDisplayed());

        //    Click on edit your shipping address button
        vendorMyAccountPage.addShippingAddressButton.click();

        //    Verify edit your shipping address button is clickable
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("edit-address"));

    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}
