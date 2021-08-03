package pages;

import elements.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@class='sidebar-block__inner ng-star-inserted']//input[@class='sidebar-search__input ng-untouched ng-pristine ng-valid']")
    private Input brandFilterInput;

    @FindBy(xpath = "//button[@aria-label='Купить']")
    private List<Button> buyButtonListOfProducts;

    @FindBy(xpath = "//div[@class='sidebar-block ng-star-inserted']//ul[@class='checkbox-filter ng-star-inserted'][2]//li//a")
    private List<A> listOfBrandCheckboxes;

    @FindBy(xpath = "//div[@class='sidebar-block ng-star-inserted']//ul[@class='checkbox-filter ng-star-inserted'][2]//li//a//label")
    private List<Label> listOfBrandLabel;

    @FindBy(xpath = "//rz-sort[@class='catalog-settings__sorting']//select[@class='select-css ng-untouched ng-pristine ng-valid ng-star-inserted']")
    private Select sortFilter;

    @FindBy(xpath = "//rz-sort[@class='catalog-settings__sorting']//select[@class='select-css ng-untouched ng-pristine ng-valid ng-star-inserted']//option[contains(text(),' От дорогих к дешевым ')]")
    private Option sortFromHighToLowPrice;

    @FindBy(xpath = "//div[@class='sidebar-block ng-star-inserted']//ul[@class='checkbox-filter ng-star-inserted'][2]")
    private UL listOfBrand;

    @FindBy(xpath = "//h1")
    private H1 title;

    public List<A> getListOfBrandCheckboxes() {
        return listOfBrandCheckboxes;
    }

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void useBrandFilterInput(String keyword) {
        brandFilterInput.sendKeys(keyword, Keys.ENTER);
    }

    public WebElement getBrandFilterInput() {
        return brandFilterInput;
    }


    public List<Button> getBuyButtonListOfProducts() {
        return buyButtonListOfProducts;
    }
    public WebElement getListOfBrand() {
        return listOfBrand;
    }
    public WebElement getSortFilter() {
        return sortFilter;
    }
    public WebElement getSortFromHighToLowPrice() {
        return sortFromHighToLowPrice;
    }

    public void selectFilteredBrand() {
        listOfBrandCheckboxes.get(0).click();
    }
    public void buyFirstProductFromList() {
        buyButtonListOfProducts.get(0).click();
    }
    public void useSortFilter(){
        sortFilter.click();
    }
    public void usePriceFilter(){
        sortFromHighToLowPrice.click();
    }
    public String getText(){
        return listOfBrandLabel.get(0).getText();
    }
    public void emptyClick(){
        title.click();
    }


}