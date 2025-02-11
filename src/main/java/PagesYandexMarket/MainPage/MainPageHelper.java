package PagesYandexMarket.MainPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;



public class MainPageHelper extends MainPage{


public void searchFor(String keyWords){

    $(searchInputField).shouldBe(visible, Duration.ofSeconds(150))
            .setValue(keyWords);
}

public void searchButtonClick(){

    $(startSearchButton).click();
}

public void clickOnItemByNumberOnPage(int itemNumberOnPage){

    String itemName =  itemsOnPageList.get(itemNumberOnPage).getText();
    System.out.println(itemName);

    itemsOnPageList.get(itemNumberOnPage).click();

    $(itemCardTitle).shouldBe(visible);
}








}
