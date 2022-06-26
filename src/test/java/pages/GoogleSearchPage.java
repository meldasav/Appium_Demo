package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

    public GoogleSearchPage(AndroidDriver<AndroidElement> androidDriver){
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy(id = "")
    public AndroidElement element;
}
