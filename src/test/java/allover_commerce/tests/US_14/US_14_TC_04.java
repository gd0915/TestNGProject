package allover_commerce.tests.US_14;

import allover_commerce.pages.HomePage;
import allover_commerce.pages.LoginPage;
import allover_commerce.pages.StoreManagerPageUS_14;
import allover_commerce.pages.VendorMyAccountPage;
import allover_commerce.utilities.ConfigReader;
import allover_commerce.utilities.Driver;
import allover_commerce.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_14_TC_04 {
    /*
    Given User should navigate to Allover Commerce url
    When Click on sign in button
    And Enter username into username/email box
    And Enter password into password box
    And Click on sign in button
    And Click on user icon to navigate My Account page
    And	Vendor should navigate to store manager url
    And	Click on Products option
    And	Click on Add New button
    And	Click on featured image display
    And	Select an image file from computer
    And	Click on select button to complete uploading image
    Then Verify image is displayed on the page
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
    public void TC_04() {

        login();

        //  Click on user icon to navigate My Account page
        homePage.signOutButton.click();

        //  Click on Store Manager to navigate to store manager url
        vendorMyAccountPage.storeManager.click();

        //  Click on Products option
        storeManagerPageUS_14.productsOption.click();

        //  Click on Add New option
        storeManagerPageUS_14.addNewButton.click();

        //	Click on image display
        storeManagerPageUS_14.addDisplayPhotoIcon.click();

        //  Select an image file from computer
        String userHOME=System.getProperty("user.home");
        String pathOfFile = userHOME + "\\Downloads\\ballimage.jpg";
        storeManagerPageUS_14.selectFilesButton.sendKeys(pathOfFile);

        //  Click on select button to complete uploading image
        ReusableMethods.waitFor(2);
        storeManagerPageUS_14.selectToUploadButton.click();

        // Verify image is displayed on the page
        Assert.assertTrue(storeManagerPageUS_14.removeImgButton.isDisplayed());

    }
}
