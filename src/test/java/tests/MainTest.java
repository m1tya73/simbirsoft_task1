package tests;

import org.junit.jupiter.api.*;
import utils.DriverWrapper;
import globalsqa.AddCust;
import globalsqa.ListCust;

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
        AddCust addCust = new AddCust(driverWrapper.getDriver());
        addCust.openAddCustomer();
        addCust.inputFirstName("Tom");
        addCust.inputLastName("Riddle");
        addCust.inputPostCode("E173RU");
        addCust.addCustomer();
        Assertions.assertEquals("Customer added successfully with customer id :6", addCust.checkAlertComplete());
        addCust.acceptAlertComplete();
    }

    @Test
    public void sortCustomer() {
        ListCust listCust = new ListCust(driverWrapper.getDriver());
        listCust.openListCustomers();
        listCust.SortFirstName();
        Assertions.assertEquals("fa fa-caret-up", listCust.checkSortUp());
        listCust.SortFirstName();
        Assertions.assertEquals("fa fa-caret-down", listCust.checkSortDown());
    }

    @Test
    public void searchCustomer() {
        String name = "Harry";
        ListCust listCust = new ListCust(driverWrapper.getDriver());
        listCust.openListCustomers();
        listCust.searchNameCustomer(name);
        Assertions.assertEquals(name, listCust.checkResultSearch());
    }
}