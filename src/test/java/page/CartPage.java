package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.LinkedList;
import java.util.List;

public class CartPage extends BasePage {

    List<String> productList = new LinkedList<String>();

    By quantity = By.xpath("//select[@class=\"amount\"]");
    By confirmButton = By.xpath("//input[@type=\"submit\"]");
    By saveButton = By.xpath("//button[@class=\"gg-ui-btn-primary gg-btn post-address gg-ui-btn-fluid post-address-button gg-ui-btn-lg\"]");
    By editButton = By.xpath("(//a[@class=\"header-link pl10\"])[2]");

    //Ürün miktarını arttırma
    public void quantityUp(WebDriver driver) {

        logger.info("Ürün adedi arttırılıyor");

        Select select = new Select(driver.findElement(quantity));

        select.selectByVisibleText("2");

        logger.info("Ürün adedi arttırıldı");

    }

    //Alışverişi onaylama
    public void confirmShopping(WebDriver driver){

        logger.info("Alışveriş onay ekranına geçiliyor");

        actions.moveToElement(driver.findElement(confirmButton)).click().build().perform();

        //Alışveriş onay sayfası kontrolü
        By confirmShoppingElement = By.xpath("//h3[@class=\"header-title\"]");
        String confirmShoppingElementText=driver.findElement(confirmShoppingElement).getText();

        Assert.assertEquals("Adres Ekle",confirmShoppingElementText);
        logger.info("Alışveriş onay ekranına geçildi");


    }

    //Adres kaydetme
    public void saveAddress(WebDriver driver) throws InterruptedException {

        logger.info("Adres kaydediliyor");

        actions.moveToElement(driver.findElement(saveButton)).click().build().perform();
        Thread.sleep(2);

        //Başarısız adres kaydı kontrolü
        By errorElement = By.xpath("//div[@class=\"gg-input-error-text gg-d-24\"]/p");
        String errorElementText = driver.findElement(errorElement).getText();

        Assert.assertEquals("Adres başlığınızı yazmayı unuttunuz.",errorElementText);
        logger.info("Adres kaydı başarısız");

    }

    //Sepeti düzenleme
    public void editCart(WebDriver driver) {

        logger.info("Sepete gidiliyor");

        actions.moveToElement(driver.findElement(editButton)).click().build().perform();

        //Sepet safyası kontrolü
        By cartPageCheckElement = By.xpath("//h1[@class=\"cart-title cart-header-title\"]");
        String cartPageCheckElementText = driver.findElement(cartPageCheckElement).getText();

        Assert.assertEquals("Alışveriş Sepetim",cartPageCheckElementText);
        logger.info("Sepete gidildi");
    }

}
