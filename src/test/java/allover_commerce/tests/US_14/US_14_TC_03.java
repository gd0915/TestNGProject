package allover_commerce.tests.US_14;

import allover_commerce.pages.HomePage;
import allover_commerce.pages.LoginPage;
import allover_commerce.pages.StoreManagerPageUS_14;
import allover_commerce.pages.VendorMyAccountPage;
import allover_commerce.utilities.ConfigReader;
import allover_commerce.utilities.Driver;
import allover_commerce.utilities.ReusableMethods;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class US_14_TC_03 {
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
    And Click on dropdown to see all dropdown options
    And Click on a space field to collapse dropdown menu
    Then Verify dropdown menu has collapsed
     */

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    VendorMyAccountPage vendorMyAccountPage = new VendorMyAccountPage();

    StoreManagerPageUS_14 storeManagerPageUS_14 = new StoreManagerPageUS_14();

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
    public void TC_03() {

        login();

        //  Click on user icon to navigate My Account page
        homePage.signOutButton.click();

        //  Click on Store Manager to navigate to store manager url
        vendorMyAccountPage.storeManager.click();

        //  Click on Products option
        storeManagerPageUS_14.productsOption.click();

        //  Click on Add New option
        storeManagerPageUS_14.addNewButton.click();

        //   Click on dropdown to see all dropdown options
        storeManagerPageUS_14.productTypeDropdown.click();

        //  Click on a space field to collapse dropdown menu
        storeManagerPageUS_14.spaceField.click();

        //  Verify dropdown menu has collapsed
        ReusableMethods.waitFor(2);
        Select select = new Select(storeManagerPageUS_14.productTypeDropdown);
        Assert.assertFalse(select.getFirstSelectedOption().getText().equals("Variable Product"));


    }

    @AfterMethod
    public void tearDown(){
        //Driver.closeDriver();
    }
}
