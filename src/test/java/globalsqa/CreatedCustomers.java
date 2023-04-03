package globalsqa;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class CreatedCustomers {

    final WebDriver driver;

    public CreatedCustomers(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//button[@ng-class=\"btnClass1\"]")
    private WebElement btnCreateCustomer;

    @FindBy(xpath = "//input[@ng-model = 'fName']")
    private WebElement fieldFirstName;

    @FindBy(xpath = "//input[@ng-model = 'lName']")
    private WebElement fieldLastName;

    @FindBy(xpath = "//input[@ng-model = 'postCd']")
    private WebElement fieldPostCode;

    @FindBy(xpath = "//button[@class = 'btn btn-default']")
    private WebElement btnAddCustomer;

    @Step
    public void openAddCustomer() {
        btnCreateCustomer.click();
    }

    @Step
    public void inputFirstName(String first) {
        fieldFirstName.sendKeys(first);
    }

    @Step
    public void inputLastName(String last) {
        fieldLastName.sendKeys(last);
    }

    @Step
    public void inputPostCode(String code) {
        fieldPostCode.sendKeys(code);
    }

    @Step
    public void addCustomer() {
        btnAddCustomer.click();
    }
}
