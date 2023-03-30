package globalsqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListCust {

    final WebDriver driver;

    public ListCust(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;}

    @FindBy(xpath = "//button[@ng-class = 'btnClass3']" )
    WebElement btnListCustomers;

    @FindBy(xpath = "//a[@ng-click = \"sortType = 'fName'; sortReverse = !sortReverse\"]")
    WebElement sortFirstName;

    @FindBy(xpath = "//span[@ng-show = \"sortType == 'fName' && sortReverse\"]")
    WebElement sortUp;

    @FindBy(xpath = "//span[@ng-show = \"sortType == 'fName' && !sortReverse\"]")
    WebElement sortDown;

    @FindBy(xpath = "//input[@ng-model = 'searchCustomer']")
    WebElement fieldSearch;

    public void openListCustomers() {
        btnListCustomers.click();
    }

    public void SortFirstName() {
        sortFirstName.click();
    }

    public String checkSortUp() {
        return sortUp.getAttribute("class");
    }

    public String checkSortDown() {
        return sortDown.getAttribute("class");
    }

    public void searchNameCustomer(String name) {
        fieldSearch.sendKeys(name);
    }

    public String checkResultSearch() {
        return driver.findElement(By.xpath("//td[@class= 'ng-binding'][text() = 'Harry']")).getText();
    }
}
