package globalsqa;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ListCustomers {

    final WebDriver driver;

    public ListCustomers(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//button[@ng-class = 'btnClass3']")
    private WebElement btnListCustomers;

    @FindBy(xpath = "//a[@ng-click = \"sortType = 'fName'; sortReverse = !sortReverse\"]")
    private WebElement sortFirstName;

    @FindBy(xpath = "//span[@ng-show = \"sortType == 'fName' && sortReverse\"]")
    private WebElement sortUp;

    @FindBy(xpath = "//span[@ng-show = \"sortType == 'fName' && !sortReverse\"]")
    private WebElement sortDown;

    @FindBys({
            @FindBy(xpath = "//tr[@class='ng-scope']//td[@class='ng-binding'][1]")
    })
    private List<WebElement> elements;

    @FindBy(xpath = "//input[@ng-model = 'searchCustomer']")
    private WebElement fieldSearch;

    @Step
    public void openListCustomers() {
        btnListCustomers.click();
    }

    @Step
    public void sortFirstName() {
        sortFirstName.click();
    }

    @Step
    public List checkSortUp() {
        ArrayList<String> people = new ArrayList<String>();;
        for (WebElement element : elements) {
            people.add(element.getText());
        }
        return people;
    }

    @Step
    public String checkSortDown() {
        return sortDown.getAttribute("class");
    }

    @Step
    public void searchNameCustomer(String name) {
        fieldSearch.sendKeys(name);
    }

    @Step
    public String getResultSearch() {
        return driver.findElement(By.xpath("//td[@class= 'ng-binding'][text() = 'Harry']")).getText();
    }
}
