package RozetkaTests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class SumInCartIsLessThanRequiredTest extends BaseTest {

    private final int DEFAULT_WAIT_TIME = 50000;

    @Test(dataProvider = "useFilter")
    public void checkIfSumInCartIsLessThanRequired(String type, String brand, int bounds) throws InterruptedException {
        getHomePage().searchByKeyword(type);
        getHomePage().waitReadyStatementOfElement(DEFAULT_WAIT_TIME, getSearchResultsPage().getBrandFilterInput());
        getSearchResultsPage().useBrandFilterInput(brand);
        useAllWaiters();
        Thread.sleep(3000);
//        for (int i = 0; i <20 ; i++) {
//            getSearchResultsPage().emptyClick();
//        }
        getSearchResultsPage().selectFilteredBrand();
        useAllWaiters();
        getSearchResultsPage().useSortFilter();
        useAllWaiters();
        getSearchResultsPage().usePriceFilter();
        useAllWaiters();
        getSearchResultsPage().buyFirstProductFromList();
        useAllWaiters();
        getHomePage().clickOnCart();
        useAllWaiters();
        getHomePage().waitVisibilityOfElement(DEFAULT_WAIT_TIME, getHomePage().getCartDiv());
        boolean isSumInCartLowerThanOneHundredThousands = true;
        if (getHomePage().getSumOfProductsInCart() >= bounds || getHomePage().getSumOfProductsInCart() == 0) {
            isSumInCartLowerThanOneHundredThousands = false;
        }
        Assert.assertTrue(isSumInCartLowerThanOneHundredThousands);
    }

    public void useAllWaiters() {
        getHomePage().implicitWait(DEFAULT_WAIT_TIME);
        getHomePage().waitForPageLoadComplete(DEFAULT_WAIT_TIME);
        getHomePage().loadWait(DEFAULT_WAIT_TIME);
    }


}