package test;

import base.Base;
import org.junit.Test;
import page.*;

public class GittiGidiyorTestCase extends Base {

    BasePage basePage = new BasePage();
    Homepage homepage = new Homepage();
    LoginPage loginPage = new LoginPage();
    SearchPage searchPage = new SearchPage();
    CartPage cartPage = new CartPage();
    FavPage favPage = new FavPage();

    @Test
    //Proje test senaryosu
    public void testCase1() throws InterruptedException {

        homepage.goToHomepage(driver);
        homepage.goToLoginPage(driver);
        loginPage.login(driver,"alllegro103@gmail.com","m123456");
        homepage.search(driver,"Gömlek");
        basePage.scrollDown(driver);
        searchPage.addFav(driver);
        homepage.goToHomepage(driver);
        homepage.search(driver, "Çanta");
        searchPage.addProduct(driver);
        searchPage.goToCart(driver);
        cartPage.quantityUp(driver);
        cartPage.confirmShopping(driver);
        cartPage.saveAddress(driver);
        cartPage.editCart(driver);
        homepage.goToHomepage(driver);
        homepage.goToFav(driver);
        favPage.addToProduct(driver);
        favPage.removeFavProduct(driver);
        favPage.newTabHomepage(driver);
        homepage.logout(driver);

    }

}
