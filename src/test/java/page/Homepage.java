package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

public class Homepage extends BasePage {

    By loginButton = By.xpath("//div[@class=\"gekhq4-4 egoSnI\"]");
    By loginButton2 = By.xpath("//div[@class='sc-12t95ss-3 fDarBX']");
    By searchField = By.xpath("//input[@name='k']");
    By searchButton = By.xpath("//button[@class='qjixn8-0 sc-1bydi5r-0 gaMakD']");
    By myAccountButton = By.xpath("//div[@class=\"gekhq4-4 egoSnI\"]");
    By favButton = By.xpath("//a[@title=\"Favorilerim\"]");
    By cartButton = By.xpath("//div[@name=\"cart\"]");
    By searchCheckElement = By.xpath("//div[@data-cy=\"no_result_container\"]/h1/b");
    By logoutButton = By.xpath("//a[@title=\"Çıkış\"]");
    By loginPageCheckElement = By.xpath("//div[@class=\"gg-login-head\"]");

    String searchCheck;

    public void goToHomepage(WebDriver driver){

        driver.get("https://www.gittigidiyor.com/");
        readyState(driver);
        logger.info("Anasayfa Açıldı");

    }

    //Login sayfasına gidiş
    public void goToLoginPage(WebDriver driver) throws InterruptedException {

        logger.info("Giriş yapma sayfası açılıyor");

        actions.moveToElement(driver.findElement(loginButton)).click().build().perform();
        TimeUnit.SECONDS.sleep(1);
        actions.moveToElement(driver.findElement(loginButton2)).click().build().perform();

        String loginPageCheck = driver.findElement(loginPageCheckElement).getText();

        Assert.assertEquals("Üye Girişi\n?", loginPageCheck);
        logger.info("Giriş yapma sayfası açıldı");

    }

    //Arama yapma
    public void search(WebDriver driver,String input) {

        logger.info("Arama Yapılıyor");

        WebElement search = driver.findElement(searchField);
        search.sendKeys(input);

        actions.moveToElement(driver.findElement(searchButton)).click().build().perform();

        //"Başarılı arama yapıldı" kontrolü
        searchCheck = driver.findElement(searchCheckElement).getText();
        Assert.assertEquals(input, searchCheck);
        logger.info("Başarılı Arama");

    }

    //Favoriler sayfasına gidiş
    public void goToFav(WebDriver driver) throws InterruptedException {

        logger.info("Favoriler sayfasına gidiliyor");

        actions.moveToElement(driver.findElement(myAccountButton)).build().perform();
        TimeUnit.SECONDS.sleep(1);
        actions.moveToElement(driver.findElement(favButton)).click().build().perform();

        //Favoriler sayfası kontrolü
        By favPageCheckElement = By.xpath("//h1[@class=\"robot-watchproducts-title\"]");
        String favPageCheckElementText = driver.findElement(favPageCheckElement).getText();

        Assert.assertEquals("Favori Ürünlerim",favPageCheckElementText);
        logger.info("Favoriler sayfasına gidildi");

    }

    //Çıkış yapma
    public void logout(WebDriver driver) throws InterruptedException {

        logger.info("Çıkış yapılıyor");

        actions.moveToElement(driver.findElement(loginButton)).click().build().perform();
        TimeUnit.SECONDS.sleep(1);
        actions.moveToElement(driver.findElement(logoutButton)).click().build().perform();

        logger.info("Çıkış yapıldı");

        currentWindow = driver.getWindowHandle();

        driver.switchTo().window(currentWindow).close();

        TimeUnit.SECONDS.sleep(1);

    }

}
