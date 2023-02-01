package allover_commerce.tests.US_14;

import allover_commerce.pages.*;
import allover_commerce.utilities.ConfigReader;
import allover_commerce.utilities.Driver;
import allover_commerce.utilities.JSUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US_14_TC_01 {

    //  US_14 "User should be able to see the options to add items as a Vendor #1.
    //        (My Account > Store Manager > Product > Add New)"

    // Acceptance Criteria : There should be Simple Product, Variable Product, Grouped Product, External - Affiliate Product options.

    //  TC_01 - All the dropdown options (Simple Product, Variable Product, Grouped Product, External - Affiliate Product options)should be selectable.

    /*
    Given User should navigate to Allover Commerce url
    When Click on sign in button
    And Enter username into username/email box
    And Enter password into password box
    And Click on sign in button
    And Click on user icon to navigate My Account page
    And Click on Store Manager to navigate to store manager url
    And Click on Products option
    And Click on Add New option
    Then Verify Simple Product, Variable Product, Grouped Product, External - Affiliate Product options are available
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
    public void TC_01(){

        login();

        //  Click on user icon to navigate My Account page
        JSUtils.clickElementByJS(homePageUS_12.signOutButton);

        //  Click on Store Manager to navigate to store manager url
        JSUtils.clickElementByJS(vendorMyAccountPageUS_12.storeManager);

        //  Click on Products option
        JSUtils.clickElementByJS(storeManagerPageUS_14.productsOption);

        //  Click on Add New option
        JSUtils.clickElementByJS(storeManagerPageUS_14.addNewButton);

        //  Verify Simple Product, Variable Product, Grouped Product, External - Affiliate Product options are available
        Select select = new Select(storeManagerPageUS_14.productTypeDropdown);
        List<WebElement> allOptions = select.getOptions();
        List<String> optionsNames =new ArrayList<>(Arrays.asList("Simple Product", "Variable Product", "Grouped Product", "External/Affiliate Product"));
        boolean isAllOptionsExist=false;
        int idx = 0;
        for (WebElement eachOption : allOptions){
            if (eachOption.getText().equals(optionsNames.get(idx))){
                isAllOptionsExist=true;
                idx++;
            }
        }
        Assert.assertTrue(isAllOptionsExist);


    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}
