import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CarvanaHomePage;

import java.net.MalformedURLException;
import java.net.URL;


public class Demo {

    CarvanaHomePage carvanaMenuPage;

    @Test
    public void firstTest() throws InterruptedException, MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "pixel_4_29");
        caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        //caps.setCapability("appPackage", "com.android.chrome");
        //caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");

        /*
        YOU CAN USE BELOW CODE START APPIUM SERVER WITH NO MANUAL EFFORT
        AndroidDriver<AndroidElement> driver = null; //new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4773/wd/hub"), dc);;
        AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        driver = new AndroidDriver<AndroidElement>(service, dc);
         */


        URL url = new URL("http://127.0.0.1:4723/wd/hub/");
        //AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url, caps);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //driver.findElementById("com.android.chrome:id/search_box_text").sendKeys("TechGlobal");

        //Thread.sleep(10000);


        //BROWSER TESTING FOR WEB APPLICATION BUT ON MOBILE DEVICES
        WebDriver driver = new RemoteWebDriver(url, caps);

        driver.get("https://www.carvana.com");
        driver.findElement((By.cssSelector("div[data-cv-test='headerMobileMenuOpen']"))).click();


        Thread.sleep(1100);

        System.out.println("TEST IS HERE!!!");
        Assert.assertTrue(true);
    }

    @Test
    public void CarvanaMenuItemTest() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "pixel_4_29");
        caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        URL url = new URL("http://127.0.0.1:4723/wd/hub/");
        WebDriver driver = new RemoteWebDriver(url, caps);

        driver.get("https://www.carvana.com");
        Thread.sleep(4);
        driver.findElement((By.cssSelector("div[data-cv-test='headerMobileMenuOpen']"))).click();
        Thread.sleep(1200);

        driver.findElement((By.cssSelector("a[data-cv-test='headerMobileCarFinderLink']"))).click();
        Thread.sleep(1200);
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "WHAT CAR SHOULD I GET?");
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "Car Finder can help! Answer a few quick questions to find the right car for you.");

        driver.findElement(By.cssSelector("a[data-qa='router-link']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div[data-qa='headline']")).getText(), "WHAT IS MOST IMPORTANT TO YOU IN YOUR NEXT CAR?");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[data-qa='sub-heading']")).getText(), "Select up to 4 in order of importance");

    }

    @Test(priority = 1,description = "validate car finder menu item")
    public void CarvanaMenuItemTest1() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "pixel_4_29");
        caps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        URL url = new URL("http://127.0.0.1:4723/wd/hub/");

    }
}