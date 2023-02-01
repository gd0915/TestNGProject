package allover_commerce.pages;

import allover_commerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VendorMyAccountPageUS_12 {

    public VendorMyAccountPageUS_12(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //*******************HATICE US_12, US_13, US_14*******************
    @FindBy(xpath = "(//h2)[1]")
    public WebElement myAccountTitle;

    @FindBy(linkText = "Addresses")
    public WebElement addressesOption;

    @FindBy(xpath = "(//a[@class='edit btn btn-link btn-primary btn-underline mb-4'])[1]")
    public WebElement editBillingAddressButton;

    @FindBy(id = "billing_first_name")
    public WebElement vendorFirstnameInput;

    @FindBy(id = "billing_last_name")
    public WebElement vendorLastnameInput;

    @FindBy(id = "billing_country")
    public WebElement countryDropdown;

    @FindBy(id = "billing_address_1")
    public WebElement streetInput;

    @FindBy(id = "billing_city")
    public WebElement cityInput;

    @FindBy(id = "billing_state")
    public WebElement stateDropdown;

    @FindBy(id = "billing_postcode")
    public WebElement zipcodeInput;

    @FindBy(id = "billing_phone")
    public WebElement vendorPhoneInput;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement saveAddressButton;

    @FindBy(xpath = "(//table[@class='address-table'])[1]//td")
    public List<WebElement> allBillingAddressTableElements;

    @FindBy(xpath = "//ul[@role='alert']")
    public WebElement invalidDataAlert;

    @FindBy(xpath = "//ul[@role='alert']//li")
    public List<WebElement> invalidDataAlertList; // all required address fields

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement addressChangeSuccessMessage;

    @FindBy(xpath = "(//a[@class='edit btn btn-link btn-primary btn-underline mb-4'])[2]")
    public WebElement addShippingAddressButton;

    @FindBy(id = "shipping_first_name")
    public WebElement vendorShippingFirstNameInput;

    @FindBy(id = "shipping_last_name")
    public WebElement vendorShippingLastNameInput;

    @FindBy(id = "shipping_country")
    public WebElement shippingCountryDropdown;

    @FindBy(id = "shipping_address_1")
    public WebElement shippingStreetInput;

    @FindBy(id = "shipping_city")
    public WebElement shippingCityInput;

    @FindBy(id = "shipping_state")
    public WebElement shippingStateDropdown;

    @FindBy(id = "shipping_postcode")
    public WebElement shippingZipcodeInput;

    @FindBy(xpath = "(//table[@class='address-table'])[2]//td")
    public List<WebElement> allShippingAddressTableElements;

    @FindBy(linkText = "Store Manager")
    public WebElement storeManager;




    //******************END*********************************************



}
