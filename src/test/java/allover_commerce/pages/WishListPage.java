package allover_commerce.pages;

import allover_commerce.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {

    public WishListPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
