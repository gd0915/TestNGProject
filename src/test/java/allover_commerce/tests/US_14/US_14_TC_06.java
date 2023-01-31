package allover_commerce.tests.US_14;

import allover_commerce.pages.HomePage;
import allover_commerce.pages.LoginPage;
import allover_commerce.pages.StoreManagerPageUS_14;
import allover_commerce.pages.VendorMyAccountPage;
import allover_commerce.utilities.ConfigReader;
import allover_commerce.utilities.Driver;
import allover_commerce.utilities.JSUtils;
import allover_commerce.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class US_14_TC_06 {
    /*
    Given User should navigate to Allover Commerce url
    When Click on sign in button
    And Enter username into username/email box
    And Enter password into password box
    And Click on sign in button
    And Click on user icon to navigate My Account page
    And Vendor should navigate to store manager url
    And Click on Products option
    And Click on Add New button
    And Click on Submit button
    Then Verify user should not be able to add a new product without uploading gallery and featured images.
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
    public void TC_05() {

        login();

        //  Click on user icon to navigate My Account page
        homePage.signOutButton.click();

        //  Click on Store Manager to navigate to store manager url
        vendorMyAccountPage.storeManager.click();

        //  Click on Products option
        storeManagerPageUS_14.productsOption.click();

        //  Click on Add New option
        storeManagerPageUS_14.addNewButton.click();

        //  Click on Submit button
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(storeManagerPageUS_14.productSubmitButton);

        //  Verify user should not be able to add a new product without uploading gallery and featured images.
        ReusableMethods.waitFor(1);
        //System.out.println(storeManagerPageUS_14.errorMessageRequiredFields.get(0).getText());
        Assert.assertTrue(storeManagerPageUS_14.errorMessageRequiredFields.get(0).getText().contains("Featured img: This field is required."));
        Assert.assertTrue(storeManagerPageUS_14.errorMessageRequiredFields.get(0).getText().contains("Gallery Images: This field is required."));


    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
