package allover_commerce.pages;

import allover_commerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage (){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    //*******************HATICE US_12, US_13, US_14*******************
    @FindBy(linkText = "Sign In")
    public WebElement singInButton;

    @FindBy(linkText = "Sign Out")
    public WebElement signOutButton;





}







