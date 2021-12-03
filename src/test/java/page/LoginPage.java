package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    By usernameField = By.id("L-UserNameField");
    By passwordField = By.id("L-PasswordField");
    By loginButton = By.id("gg-login-enter");

    //Siteye giriş yapma
    public void login(WebDriver driver, String usernameLocal, String passwordLocal) {

        By loginCheckElement = By.xpath("//div[@class=\"gekhq4-4 egoSnI\"]/span");
        String loginCheck;

        logger.info("Giriş yapılıyor");

        WebElement username = driver.findElement(usernameField);
        WebElement password = driver.findElement(passwordField);

        username.sendKeys(usernameLocal);
        password.sendKeys(passwordLocal);

        actions.moveToElement(driver.findElement(loginButton)).click().build().perform();

        //login kontrolü
        loginCheck = driver.findElement(loginCheckElement).getText();
        Assert.assertEquals("ahmetseyis228164",loginCheck);
        logger.info("Başarılı Giriş");

    }

}
