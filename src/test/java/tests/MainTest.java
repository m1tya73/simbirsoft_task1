package tests;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.*;
import utils.DriverWrapper;
import globalsqa.CreatedCustomers;
import globalsqa.ListCustomers;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainTest {

    final DriverWrapper driverWrapper = new DriverWrapper();

    @BeforeEach
    public void setUp() {
        driverWrapper.init();
    }

    @AfterEach
    public void tearDown() {
        driverWrapper.close();
    }

    @Test
    public void createCustomer() {
        CreatedCustomers createdCustomers = new CreatedCustomers(driverWrapper.getDriver());
        createdCustomers.openAddCustomer();
        createdCustomers.inputFirstName("Tom");
        createdCustomers.inputLastName("Riddle");
        createdCustomers.inputPostCode("E173RU");
        createdCustomers.addCustomer();
        Assertions.assertEquals("Customer added successfully with customer id :6", driverWrapper.getDriver().switchTo().alert().getText());
        driverWrapper.getDriver().switchTo().alert().accept();
    }

    @Test
    public void sortCustomerUp() {
        ListCustomers listCustomers = new ListCustomers(driverWrapper.getDriver());
        listCustomers.openListCustomers();
        List offSort = listCustomers.checkSortUp();
        Collections.sort(offSort);
        List<String> offSortReverse = Lists.reverse(offSort);
        listCustomers.sortFirstName();
        List onSort = listCustomers.checkSortUp();
        Assertions.assertEquals(offSortReverse, onSort);
    }

    @Test
    public void sortCustomerDown() {
        ListCustomers listCustomers = new ListCustomers(driverWrapper.getDriver());
        listCustomers.openListCustomers();
        List offSort = listCustomers.checkSortUp();
        Collections.sort(offSort);
        listCustomers.sortFirstName();
        listCustomers.sortFirstName();
        List onSort = listCustomers.checkSortUp();
        Assertions.assertEquals(offSort, onSort);
    }

    @Test
    public void searchCustomer() {
        String name = "Harry";
        ListCustomers listCustomers = new ListCustomers(driverWrapper.getDriver());
        listCustomers.openListCustomers();
        listCustomers.searchNameCustomer(name);
        Assertions.assertEquals(name, listCustomers.getResultSearch());
    }
}