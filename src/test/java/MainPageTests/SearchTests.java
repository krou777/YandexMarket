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
import java.util.Arrays;
import java.util.HashMap;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SearchTests {

    MainPageHelper mainPageHelper = new MainPageHelper();


    @BeforeEach
    public void siteLogin() {


        Configuration.pageLoadTimeout = 180000L;
        Configuration.baseUrl = "";
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.remoteConnectionTimeout = 180000L;
        Configuration.browserCapabilities = getDesiredCapabilities("chrome", true);

        open("https://market.yandex.ru/");
        getWebDriver().manage().window().maximize();

    }
    private static DesiredCapabilities getDesiredCapabilities(final String browserName, final Boolean enableVideo) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", new HashMap<String, Object>() {
            {
                this.put("enableVNC", true);
                this.put("enableVideo", enableVideo);
                this.put("browserName", browserName);
                this.put("env", Arrays.asList("LANG=ru_RU.UTF-8", "LANGUAGE=ru:ru", "LC_ALL=ru_RU.UTF-8"));
            }
        });
        return capabilities;
    }

    @Test
    public void executeSearch() throws InterruptedException {

        mainPageHelper.searchFor("Айфон 15");
        mainPageHelper.searchButtonClick();
        mainPageHelper.clickOnItemByNumberOnPage(1);

        Thread.sleep(3000);

    }

    @AfterEach
    public void tearDown(){
        closeWebDriver();
    }



}
