package allover_commerce.pages;

import allover_commerce.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class StoreManagerPage {

    public StoreManagerPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
