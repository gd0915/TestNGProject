package allover_commerce.tests.US_12;

import allover_commerce.pages.HomePage;
import allover_commerce.pages.LoginPage;
import allover_commerce.pages.VendorMyAccountPage;
import allover_commerce.utilities.ConfigReader;
import allover_commerce.utilities.Driver;
import allover_commerce.utilities.JSUtils;
import allover_commerce.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US_12_TC_01 {

    /*
    Given User should navigate to Allover Commerce url https://allovercommerce.com/
    When Click on sign in button
    And Enter username into username/email box
    And Enter password into password box
    And Click on sign in button
    Then Verify sign out is displayed on the website
    And Click on user icon to navigate My Account page
    Then Verify My Account is visible on the website
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
    Then Verify data has been entered in all required blank fields
     */

    @DataProvider
    public Object[][] vendorData(){
        //  TEST DATA
        Object [][] vendorCredentials = {

                {"Laura", "Brown", "100 William F Bell Street", "Richmond Hill", "L4S 0K1", "4204569874"},
        };
        return vendorCredentials;
    }
    @Test(dataProvider = "vendorData")
    public void TC_01(String firstname, String lastname, String street, String city, String zipcode, String phone){
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        VendorMyAccountPage vendorMyAccountPage = new VendorMyAccountPage();

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

        //    Verify sign out is displayed on the website
        ReusableMethods.waitFor(2);
        Assert.assertTrue(homePage.signOutButton.isDisplayed());

        //    Click on user icon to navigate My Account page
        homePage.signOutButton.click();

        //    Verify My Account title is visible on the website
        Assert.assertTrue(vendorMyAccountPage.myAccountTitle.isDisplayed());

        //    Click on Addresses button
        vendorMyAccountPage.addressesOption.click();

        //    Click add button under the Billing Address
        ReusableMethods.waitFor(1);
        vendorMyAccountPage.editBillingAddressButton.click();

        //    Enter firstname into First name box
        vendorMyAccountPage.vendorFirstnameInput.clear();
        vendorMyAccountPage.vendorFirstnameInput.sendKeys(firstname);

        //    Enter lastname into Last name box
        vendorMyAccountPage.vendorLastnameInput.clear();
        vendorMyAccountPage.vendorLastnameInput.sendKeys(lastname);

        //    Enter Country/Region into County/Region box
        Select selectCountry = new Select(vendorMyAccountPage.countryDropdown);
        selectCountry.selectByVisibleText("Canada");

        //    Enter a Street address into Street address box
        vendorMyAccountPage.streetInput.clear();
        vendorMyAccountPage.streetInput.sendKeys(street);

        //    Enter a Town/City into Town/City box
        vendorMyAccountPage.cityInput.clear();
        vendorMyAccountPage.cityInput.sendKeys(city);

        //    Enter a state into State box
        Select selectState = new Select(vendorMyAccountPage.stateDropdown);
        selectState.selectByVisibleText("Ontario");

        //    Enter a Zip Code into ZipCode box
        vendorMyAccountPage.zipcodeInput.clear();
        ReusableMethods.waitFor(1);
        vendorMyAccountPage.zipcodeInput.sendKeys(zipcode);

        //    Enter a Phone number
        vendorMyAccountPage.vendorPhoneInput.clear();
        vendorMyAccountPage.vendorPhoneInput.sendKeys(phone);

        //    Click on save address button
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(vendorMyAccountPage.saveAddressButton);

        //    Verify data has been entered in all required blank fields
        for(WebElement eachBillingAddressTableElement : vendorMyAccountPage.allBillingAddressTableElements){
            ReusableMethods.waitFor(1);
            Assert.assertTrue(eachBillingAddressTableElement.isDisplayed());
        }


    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}
