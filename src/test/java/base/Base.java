package base;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class Base {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger logger = Logger.getLogger(Base.class);

    protected static Actions actions;
    protected static Set<String> windowHandles;

    @Before
    public void setUp() {

        logger.info("Test Başlıyor");

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-extensions");
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);

        actions = new Actions(driver);

    }

    @After
    public void tearDown() {

        logger.info("Test bitti");
        driver.quit();

    }

}
