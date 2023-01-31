package allover_commerce.tests.US_14;

import allover_commerce.pages.*;
import allover_commerce.utilities.ConfigReader;
import allover_commerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Trash {
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
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    VendorMyAccountPage vendorMyAccountPage = new VendorMyAccountPage();

    StoreManagerPageUS_14 storeManagerPageUS_14 = new StoreManagerPageUS_14();




    @Test
    public void TC_01() {

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

        //  Click on user icon to navigate My Account page
        homePage.signOutButton.click();

        //  Click on Store Manager to navigate to store manager url
        vendorMyAccountPage.storeManager.click();

        //  Click on Products option
        storeManagerPageUS_14.productsOption.click();

        //  Click on Add New option
        storeManagerPageUS_14.addNewButton.click();

        //  Verify Simple Product, Variable Product, Grouped Product, External - Affiliate Product options are available
        Select select = new Select(storeManagerPageUS_14.productTypeDropdown);
        List<WebElement> allOptions = select.getOptions();
        List<String> optionsNames = new ArrayList<>(Arrays.asList("Simple Product", "Variable Product", "Grouped Product", "External/Affiliate Product"));
        boolean isAllOptionsExist = false;
        int idx = 0;
        for (WebElement eachOption : allOptions) {
            if (eachOption.getText().equals(optionsNames.get(idx))) {
                isAllOptionsExist = true;
                idx++;
            }
        }
        Assert.assertTrue(isAllOptionsExist);


        Driver.closeDriver();


    }
}