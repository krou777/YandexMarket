package MainPageTests;

import PagesYandexMarket.MainPage.MainPageHelper;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SearchTests {

    MainPageHelper mainPageHelper = new MainPageHelper();


    @BeforeEach
    public void siteLogin() {




        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "117.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            /* How to add test badge */
            put("name", "Test badge...");

            /* How to set session timeout */
            put("sessionTimeout", "15m");

            /* How to set timezone */
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});

            /* How to add "trash" button */
            put("labels", new HashMap<String, Object>() {{
                // put("manual", "true");
            }});

            /* How to enable video recording */
            put("enableVideo", true);
            put("enableVNC", true);
        }});
        try {
            RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;

        open("https://market.yandex.ru/");
        getWebDriver().manage().window().maximize();

    }
    @Test
    public void executeSearch() {

//        try {
//            Thread.sleep(125000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        mainPageHelper.searchFor("Айфон 15");
        mainPageHelper.searchButtonClick();
        mainPageHelper.clickOnItemByNumberOnPage(1);

        Configuration.holdBrowserOpen = true;

    }

    @AfterEach
    public void tearDown(){
        closeWebDriver();
    }



}
