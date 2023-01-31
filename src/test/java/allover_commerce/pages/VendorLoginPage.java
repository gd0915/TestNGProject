package allover_commerce.pages;

import allover_commerce.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class VendorLoginPage {

    public VendorLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
