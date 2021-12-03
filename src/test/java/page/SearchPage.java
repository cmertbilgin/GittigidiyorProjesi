package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SearchPage extends BasePage {

    List<String> product = new LinkedList<String>();
    String[] favProduct = new String[4];
    List<Integer> chechkNumber = new ArrayList<Integer>();

    By favori;
    By product7 = By.xpath("(//h2[@class=\"sc-1ku3a4v-0 sc-7u3xly-0 hYkpAn jytHfD sc-1n49x8z-16 iqsmnF\"])[4]");
    By sel = By.xpath("(//button[@class=\"qjixn8-0 sc-1bydi5r-0 dGNqQc pXiHf sc-1n49x8z-3 bhXnM\"])[7]");
    By addButton = By.id("add-to-basket");
    By cartButton = By.xpath("//a[@class=\"dIB\"]");
    protected String markedProduct;

    Random random = new Random();

    //Sayfadaki ürünleri listeye atma
    public void collectProducts() {

        for (int i = 0; i < 31; i++) {
            product.add("(//div[@data-cy='product-favorite'])[" + i + "]");
        }

    }

    //Rastgele 4 ürünü listeye atma
    public void setFavProducts() {

        Integer randomNumber;

        for (int i = 0; i < 4; i++) {

            randomNumber = random.nextInt(31);

            if (chechkNumber.contains(randomNumber) || randomNumber == 0) {

                i--;

            } else {

                favProduct[i] = product.get(randomNumber);
                chechkNumber.add(randomNumber);

            }

        }

    }

    //Favorilere ekleme
    public void addFav(WebDriver driver) throws InterruptedException {

        collectProducts();
        setFavProducts();

        for (int i = 0; i < 4; i++) {


            By markedProductElement = By.xpath("(//h2[@class=\"sc-1ku3a4v-0 sc-7u3xly-0 hYkpAn jytHfD sc-1n49x8z-16 iqsmnF\"])["+(i+1)+"]");
            favori = By.xpath(favProduct[i]);

            WebElement element = driver.findElement(favori);
            JavascriptExecutor executor = (JavascriptExecutor)driver;

            TimeUnit.SECONDS.sleep(1);

            executor.executeScript("arguments[0].click();", element);

            if (i == 2) {
                //System.out.println(markedProduct);
            }

        }

    }

    //7. ürünü sepete ekleme
    public void addProduct(WebDriver driver) throws InterruptedException {

        String addToProductCheckElement = "//p[@class=\"sc-1tdlrg-0 yf6n83-0 eSdOUH fHxBLh ciohle-1 kjvkGl\"]";

        logger.info("Ürün sepete ekleniyor");

        actions.moveToElement(driver.findElement(product7)).click().build().perform();
        scrollDownMid(driver);
        actions.moveToElement(driver.findElement(addButton)).click().build().perform();
        /*
        //Ürünün sepete eklenme kontrolü
        TimeUnit.SECONDS.sleep(2);
        actions.moveToElement(driver.findElement(cartButton)).perform();
        Assert.assertNotNull(driver.findElement(By.xpath(addToProductCheckElement)));
        logger.info("Ürün sepete eklendi.");*/

    }

    //Sepete gitme
    public void goToCart(WebDriver driver) {

        actions.moveToElement(driver.findElement(cartButton)).click().build().perform();

        //Sepet sayfası kontrol
        By cartPageCheckElement = By.xpath("//h1[@class=\"cart-title cart-header-title\"]");
        String cartPageCheckElementText = driver.findElement(cartPageCheckElement).getText();

        Assert.assertEquals("Alışveriş Sepetim",cartPageCheckElementText);

    }

}
