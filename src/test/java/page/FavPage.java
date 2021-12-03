package page;

import org.openqa.selenium.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class FavPage extends BasePage {

    ProductPage productPage = new ProductPage();
    SearchPage searchPage = new SearchPage();

    By productButton = By.xpath("(//h2[@class=\"robot-watchproducts-product-title\"])[2]");
    By productCheckMark;
    By removeButton = By.xpath("//button[@class=\"delete-watch-products robot-delete-all-button\"]");
    By homePageButton = By.xpath("//a[@class=\"header-gg-logo robot-header-logoContainer-logo\"]");
    By favProductElement = By.xpath("(//span[@class=\"checkmark\"])[4]");

    Set<String> windowHandles;
    List<String> favProductText = new LinkedList<String>();

    //ürün sayfasını yan tab içerside açıp ekleme ve tab kapama işlemi
    public void addToProduct(WebDriver driver) throws InterruptedException {

        currentWindow = driver.getWindowHandle();
        String currentWindow2;

        actions.moveToElement(driver.findElement(productButton)).keyDown(Keys.CONTROL).perform();
        TimeUnit.SECONDS.sleep(1);
        actions.click().perform();
        actions.keyUp(Keys.CONTROL).build().perform();

        //Yan tab geçişi
        switchTab(driver, currentWindow);

        currentWindow2 = driver.getWindowHandle();

        productPage.addProduct(driver);

        driver.switchTo().window(currentWindow2).close();
        driver.switchTo().window(currentWindow);
    }

    /*public void setFavProductList() {

        for (int i = 0; i < 4; i++) {

            int tempCount = 1;

            String favProductElement = "(//h2[@class=\"robot-watchproducts-product-title\"])["+tempCount+"]";
            String favProductElement = "(//h2[@class=\"robot-watchproducts-product-title\"])["+tempCount+"]";
            String favProductElement = "(//td[@class=\"watch-products-price robot-watchproducts-product-price\"])["+tempCount+"]";
            String tempText;

            System.out.println(driver.findElement(By.xpath(favProductElement)).getText());
            String favProductText2 = driver.findElement(By.xpath(favProductElement)).getText();
            favProductText.add(favProductText2);
            tempCount++;


        }

    }*/

    //Ürünü silme işlemleri
    public void removeFavProduct(WebDriver driver) throws InterruptedException {

        //setFavProductList();

        /*for (int i = 0; i < 4; i++) {

            if (favProductText.get(i) == searchPage.markedProduct) {

                productCheckMark = By.xpath("(//span[@class=\\\"checkmark\\\"])["+(i+1)+"]\"");

            }

        }*/

        actions.moveToElement(driver.findElement(favProductElement)).click().build().perform();
        TimeUnit.SECONDS.sleep(1);
        actions.moveToElement(driver.findElement(removeButton)).click().build().perform();

    }

    //Tab üzerinden anasayfayı açma
    public void newTabHomepage(WebDriver driver) throws InterruptedException {

        String currentWindow = driver.getWindowHandle();

        TimeUnit.SECONDS.sleep(2);

        actions.moveToElement(driver.findElement(homePageButton)).keyDown(Keys.CONTROL).click().build().perform();

        TimeUnit.SECONDS.sleep(2);

        actions.keyUp(Keys.CONTROL).build().perform();

        switchTab(driver,currentWindow);

    }

}
