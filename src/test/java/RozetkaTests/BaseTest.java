package RozetkaTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import pages.HomePage;
import pages.SearchResultsPage;
import util.RozetkaFilter;
import util.WebdriverMultitone;
import util.WebdriverSingletone;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class BaseTest {

    public WebDriver getDriver() {
        return WebdriverMultitone.getMultiDriver();
    }

    @BeforeTest
    public void set() {
        WebdriverSingletone.setProperties();
    }

    @BeforeMethod
    public void setUpTest() {
        getDriver();
    }

    @AfterMethod
    public void close() {
        WebdriverMultitone.closeMultiDriver();
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(getDriver());
    }

    @DataProvider(name = "useFilter", parallel = true)
    public Object[][] useFilterData() throws JAXBException {
        File file = new File("src\\main\\resources\\rozetkaFilterData.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(RozetkaFilter.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        RozetkaFilter rozetkaFilter = (RozetkaFilter) unmarshaller.unmarshal(file);
        Object[][] array = rozetkaFilter.getFilterDataList().stream()
                .map(x -> new Object[]{
                        x.getProductType(), x.getBrand(), x.getPriceBounds()
                }).toArray(Object[][]::new);
        return array;
    }

}