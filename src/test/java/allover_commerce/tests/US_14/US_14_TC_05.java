package allover_commerce.tests.US_14;

import allover_commerce.pages.HomePageUS_12;
import allover_commerce.pages.LoginPageUS_12;
import allover_commerce.pages.StoreManagerPageUS_14;
import allover_commerce.pages.VendorMyAccountPageUS_12;
import allover_commerce.utilities.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class US_14_TC_05 extends ExtentReportUtils{

    //  US_14 "User should be able to see the options to add items as a Vendor #1.
    //        (My Account > Store Manager > Product > Add New)"

    // Acceptance Criteria : Vendor should be able to add a gallery product Photo.

    //  TC_05 - Vendor should be able to add a gallery product Photo.

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
    And	Click on gallery image display
    And	Select an image file from computer
    And	Click on select button to complete uploading image
    Then Verify image is displayed on the page
     */

    HomePageUS_12 homePageUS_12 = new HomePageUS_12();
    LoginPageUS_12 loginPageUS_12 = new LoginPageUS_12();

    VendorMyAccountPageUS_12 vendorMyAccountPageUS_12 = new VendorMyAccountPageUS_12();

    StoreManagerPageUS_14 storeManagerPageUS_14 = new StoreManagerPageUS_14();

   // ExtentReportUtils extentReportUtils = new ExtentReportUtils();

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
    public void TC_05() throws IOException {

        login();

        //  Click on user icon to navigate My Account page
        JSUtils.clickElementByJS(homePageUS_12.signOutButton);
        extentTest.info("clicked on user icon to navigate My Account page");


        //  Click on Store Manager to navigate to store manager url
        JSUtils.clickElementByJS(vendorMyAccountPageUS_12.storeManager);
        extentTest.info("clicked on Store Manager to navigate to store manager url");

        //  Click on Products option
        JSUtils.clickElementByJS(storeManagerPageUS_14.productsOption);
        extentTest.info("clicked on Products option");

        //  Click on Add New option
        JSUtils.clickElementByJS(storeManagerPageUS_14.addNewButton);
        extentTest.info("clicked on add new option");

        //  Click on gallery image display
        JSUtils.clickElementByJS(storeManagerPageUS_14.addGalleryPhotoIcon);
        extentTest.info("clicked on gallery image display");

        //  Select an image file from computer
        String userHOME=System.getProperty("user.home");
        String pathOfFile = userHOME + "\\Downloads\\ballimage.jpg";
        storeManagerPageUS_14.selectFilesButton.sendKeys(pathOfFile);
        extentTest.info("selected a file from computer");

        //  Click on select button to complete uploading image
        ReusableMethods.waitFor(3);
        storeManagerPageUS_14.addToGalleryButton.click();
        extentTest.info("clicked on select button to complete uploading image");

        // Verify image is displayed on the page
        ReusableMethods.waitFor(2);
        ReusableMethods.getScreenshot("screenshot");
        Assert.assertTrue(storeManagerPageUS_14.removeGalleryImgButton.isDisplayed());
        extentTest.pass("verified the uploaded image is displayed on the web page");

    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}
