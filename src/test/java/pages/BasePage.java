package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Web Locator
    @FindBy(xpath = "//div[@data-qa='header-menu-wrapper']/div[@data-qa='logo-wrapper']")
    public WebElement webLogo;

    //mobile locator
    @FindBy(xpath = "//div[@data-qa='header-menu-mobile-wrapper']/div[@data-qa='logo-wrapper']")
    public WebElement mobileLogo;
}
