package UI.pageObjects;

import UI.helperMethods.HelperUI;
import UI.utils.Driver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public HelperUI helper = new HelperUI();
}
