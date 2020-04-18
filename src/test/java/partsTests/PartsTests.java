package partsTests;

import baseTests.BaseTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PartsTests extends BaseTests {
    @Test
    public void partCreation(){
        loginPage.openPage();
        loginPage.login("Student", "909090");
        homePage.clickDictionary();
        homePage.clickParts();
        String partName = "part";
        String partType = "Механика";
        partsPage.createPart(partName, partType);
        assertEquals("Part name is not equal", partName, partsPage.getPartName());
        assertEquals("Part type is not equal", partType, partsPage.getPartType());
    }
}
