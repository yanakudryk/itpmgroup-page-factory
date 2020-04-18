package loginTests;


import libs.ConfigClass;
import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import baseTests.BaseTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class InValidLoginTestWithPageObjectWithExcel extends BaseTests {
    private final String login;
    private final String pass;

    public InValidLoginTestWithPageObjectWithExcel(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData() throws IOException {
        InputStream spreadsheet
                = new FileInputStream(ConfigClass.getCfgValue("DATA_FILE_PATH")
                    +"testDataSuit.xls");
        return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();
    }

    @Test
    public void invalidLogin() {
        loginPage.openPage();
        loginPage.login(login, pass);
        assertEquals("User is not on login page", "Учет запчастей", loginPage.getLoginText());
    }
}
