package employeesTests;

import baseTests.BaseTests;
import org.junit.Test;
import pages.DealsPage;
import pages.EmployeesPage;
import pages.HomePage;

import static org.junit.Assert.assertEquals;

public class EmployeesTests extends BaseTests {
    @Test
    public void successfulEmployeeCreation(){
        HomePage homePage = loginPage.login("Student", "909090");
        homePage.clickDictionary();
        EmployeesPage employeesPage = homePage.clickEmployees();
        String surname = "Surname";
        String name = "Name";
        String middleName = "Middle";
        String phone = "1234567890";
        employeesPage.createEmployee(surname, name, middleName, phone);
        assertEquals("Full name is not equal.", surname + " " + name + " " + middleName, employeesPage.getFullNameEmployeeFromTable());
        assertEquals("Phone is not equal.", phone, employeesPage.getPhoneEmployeeFromTable());
    }
}
