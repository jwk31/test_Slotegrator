package UI.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='UserLogin_username']")
    public WebElement loginInputField;

    @FindBy(xpath = "//input[@id='UserLogin_password']")
    public WebElement passwordInputField;

    @FindBy(xpath = "//input[@value='Sign in']")
    public WebElement loginButton;

    public LoginPage inputUserNameOrEmail(String userNameOrEmail) {
        helper.sendKeys(loginInputField, userNameOrEmail);
        return this;
    }

    public LoginPage inputPassword(String password) {
        helper.sendKeys(passwordInputField, password);
        return this;
    }

    public LoginPage clickLoginButton() {
        helper.click(loginButton);
        return this;
    }

    public void loginToSystem(String userName, String password) {
        inputUserNameOrEmail(userName).inputPassword(password).clickLoginButton();
    }
}
