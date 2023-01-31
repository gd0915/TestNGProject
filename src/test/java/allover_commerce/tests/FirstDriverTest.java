package allover_commerce.tests;

import allover_commerce.utilities.Driver;
import allover_commerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import allover_commerce.utilities.Driver;

import java.io.IOException;

public class FirstDriverTest {

    @Test
    public void firstDriverTest() throws IOException {

//          driver ==> Driver.getDriver() (We do not need to extend to Driver class)
        Driver.getDriver().get("https://www.techproeducation.com");
        ReusableMethods.getScreenshot("Screenshot");

//          close the driver
        Driver.closeDriver();
    }

}
