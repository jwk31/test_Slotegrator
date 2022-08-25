package UI.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends BasePage {

    @FindBy(xpath = "//span[text()='Dashboard']")
    public WebElement dashboardText;

    @FindBy(xpath = "(//span[@class='icon-bg bg-success'])[2]")
    public WebElement buttonUsers;

    @FindBy(xpath = "(//a[@href='/user/player/admin'])[1]")
    public WebElement buttonPlayers;

    public IndexPage waitPageToBeLoaded(){
        helper.waitElementToBeDisplayed(dashboardText);
        return this;
    }

    public IndexPage clickButtonUsers() {
        helper.click(buttonUsers);
        return this;
    }

    public IndexPage clickButtonPlayers() {
        helper.click(buttonPlayers);
        return this;
    }
}
