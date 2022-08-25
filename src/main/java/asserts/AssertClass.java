package asserts;

import UI.helperMethods.HelperUI;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class AssertClass extends HelperUI {

    public void assertTextWithText(String expected, String actual) {
        assertEquals(expected, actual);
    }

    public void assertTextNotEqualText(String unexpected, String actual) {
        assertNotEquals(unexpected, actual);
    }

    public void assertNumberWithNumber(int expected, int actual) {
        assertEquals(expected, actual);
    }

    public void assertTextWithGetText(String expected, WebElement actual) {
        waitElementToBeDisplayed(actual);
        assertEquals(expected, actual.getText());
    }

    public void assertContainsTextWithText(String expected, String actual) {
        assertTrue(actual.contains(expected));
    }
}
