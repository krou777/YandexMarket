package PagesYandexMarket.MainPage;


import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$x;


public class MainPage {


    public By startSearchButton = By.xpath("//button[@data-auto='search-button']");

    public By searchInputField =  By.xpath("//input[@data-auto='search-input']");

    public ElementsCollection itemsOnPageList = $$x("//div[@data-apiary-widget-name='@marketfront/SerpEntity']//child::span[@role='link']");

    public By itemCardTitle = By.xpath("//h1[@data-auto='productCardTitle']");




}