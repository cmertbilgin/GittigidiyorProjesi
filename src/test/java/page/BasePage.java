package page;

import base.Base;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BasePage extends Base {

    //Sayfa yüklenmesinin kontrolü
    public boolean readyState(WebDriver driver) {

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        String readyState = javascriptExecutor.executeScript("return document.readyState").toString();

        Assert.assertEquals(readyState,"complete");
        return true;

    }

    //Sayfa sonuna kaydırma
    public void scrollDown(WebDriver driver) {

        JavascriptExecutor javascript = (JavascriptExecutor) driver;
        javascript.executeScript("window.scrollBy(0,document.body.scrollHeight)");

    }

    //Sayfa kaydırma
    public void scrollDownMid(WebDriver driver) {

        JavascriptExecutor javascript = (JavascriptExecutor) driver;
        javascript.executeScript("window.scrollBy(0,250)");

    }

    //Tab değiştirme
    public void switchTab(WebDriver driver, String currentWindow) {

        windowHandles = driver.getWindowHandles();

        for (String window : windowHandles) {
            if (!currentWindow.equals(window)) {

                driver.switchTo().window(window);

            }
        }

    }

}
