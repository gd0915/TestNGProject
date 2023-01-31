package allover_commerce.pages;

import allover_commerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StoreManagerPageUS_14 {

    public StoreManagerPageUS_14(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(partialLinkText = "Products")
    public WebElement productsOption;

    @FindBy(xpath = "//span[text()='Add New']")
    public WebElement addNewButton;
    @FindBy(id = "product_type")
    public WebElement productTypeDropdown;

    @FindBy(id = "main")
    public WebElement spaceField;

    @FindBy(xpath = "//option[text()='Variable Product']")
    public WebElement variableProductOption;

    @FindBy(id = "featured_img_display")
    public WebElement addDisplayPhotoIcon;

//    @FindBy(id = "__wp-uploader-id-1")
//    public WebElement selectFilesButton;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement selectFilesButton;

    @FindBy(xpath = "//button[text()='Select']")
    public WebElement selectToUploadButton;

    @FindBy(id = "featured_img_remove_button")
    public WebElement removeImgButton;

    @FindBy(id = "gallery_img_gimage_0_display")
    public WebElement addGalleryPhotoIcon;

//    @FindBy(xpath = "//button[text()='Add to Gallery']")
//    public WebElement addToGalleryButton;

    @FindBy(xpath = "(//button[@type='button'])[83]")
    public WebElement addToGalleryButton;

    @FindBy(id = "gallery_img_gimage_0_remove_button")
    public WebElement removeGalleryImgButton;

    @FindBy(id = "wcfm_products_simple_submit_button")
    public WebElement productSubmitButton;

    @FindBy(xpath = "//div[@class='wcfm-message wcfm-error']")
    public List<WebElement> errorMessageRequiredFields;

    @FindBy(id = "pro_title")
    public WebElement productTitleInput;

    @FindBy(xpath = "(//body[@id='tinymce'])[1]")
    public WebElement shortDescriptionInput;

    @FindBy(xpath = "//body[@id='tinymce']")
    public WebElement descriptionInput;

    @FindBy(xpath = "//*[@id='tinymce']/p")
    public WebElement verifyTextOfDescription;
}
