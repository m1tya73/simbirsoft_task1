package globalsqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class AddCust {

    final WebDriver driver;

    public AddCust(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;}

    @FindBy(xpath = "//button[@ng-class=\"btnClass1\"]")
    WebElement btnCreateCustomer;

    @FindBy(xpath = "//input[@ng-model = 'fName']")
    WebElement fieldFirstName;

    @FindBy(xpath = "//input[@ng-model = 'lName']")
    WebElement fieldLastName;

    @FindBy(xpath = "//input[@ng-model = 'postCd']")
    WebElement fieldPostCode;

    @FindBy(xpath = "//button[@class = 'btn btn-default']")
    WebElement btnAddCustomer;

    public void openAddCustomer(){
        btnCreateCustomer.click();
    }

    public void inputFirstName(String first) {
        fieldFirstName.sendKeys(first);
    }

    public void inputLastName(String last) {
        fieldLastName.sendKeys(last);
    }

    public void inputPostCode(String code) {
        fieldPostCode.sendKeys(code);
    }
    public void addCustomer(){
        btnAddCustomer.click();
    }
    public String checkAlertComplete() {
        return driver.switchTo().alert().getText();
    }
    public void acceptAlertComplete() {
        driver.switchTo().alert().accept();
    }
}
