package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CarvanaHomePage;
import utils.ConfigReader;
import utils.Driver;
import utils.Environment;

public class Base extends Environment {

    WebDriver driver;
    String applicationURL = ConfigReader.getProperty("applicationURL");
    CarvanaHomePage carvanaHomePage;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        driver.get(applicationURL);
        carvanaHomePage=new CarvanaHomePage();
    }

    @AfterMethod
    public void teardown(){
        Driver.quitDriver();
    }
}


