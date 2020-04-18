package devicesTests;

import baseTests.BaseTests;
import libs.ConfigClass;
import libs.ExcelDriver;
import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class DevicesTests extends BaseTests {
    private String number;
    private String comment;

    public DevicesTests(String number, String comment) {
        this.number = number;
        this.comment = comment;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData() throws IOException {
        InputStream spreadsheet
                = new FileInputStream(ConfigClass.getCfgValue("DATA_FILE_PATH")
                +"testData.xls");
        return new SpreadsheetData(spreadsheet, "devices").getData();
    }

    @Test
    public void successDeviceCreation() {
        loginPage.openPage();
        loginPage.login("Student", "909090");
        homePage.clickDictionary();
        homePage.clickDevices();

        devicesPage.createDevice(number, comment);
        assertEquals("Number is not equal.", number, devicesPage.getDeviceNumberFromTable());
        assertEquals("Comment is not equal.", comment, devicesPage.getDeviceCommentFromTable());
    }
}
