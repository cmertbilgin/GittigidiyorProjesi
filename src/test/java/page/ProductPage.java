package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ProductPage extends BasePage {

    By product = By.xpath("//ul[@class=\"sp-specOption\"]/li");
    By addButton = By.xpath("//button[@class=\"control-button gg-ui-button plr10 gg-ui-btn-default\"]");

    //Sepete ekle butonuna tıklama
    public void addProduct(WebDriver driver) throws InterruptedException {

        logger.info("Sepete ekle butonuna tıklanıyor");

        try {

            TimeUnit.SECONDS.sleep(1);
            actions.moveToElement(driver.findElement(product)).click().build().perform();
            TimeUnit.SECONDS.sleep(1);
            actions.moveToElement(driver.findElement(addButton)).doubleClick().build().perform();

            logger.info("Sepete ekle butonuna tıklandı");

        } catch (Exception e) {
        }

    }

}
