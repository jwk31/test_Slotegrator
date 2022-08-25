package UI.pageObjects;

import dataProviders.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class PlayersListPage extends BasePage {

    @FindBy(xpath = "//a[text()='Player management']")
    public WebElement playersPageText;

    @FindBy(xpath = "//input[@name='PlayerSearch[login]']")
    public WebElement filterByUserNameInput;
    @FindBy(xpath = "//input[@name='PlayerSearch[unique_alias]']")
    public WebElement filterByExternalIDInput;
    @FindBy(xpath = "//input[@name='PlayerSearch[name]']")
    public WebElement filterByNameInput;
    @FindBy(xpath = "//input[@name='PlayerSearch[surname]']")
    public WebElement filterByLastNameInput;
    @FindBy(xpath = "//input[@name='PlayerSearch[email]']")
    public WebElement filterByEmailInput;
    @FindBy(xpath = "//input[@name='PlayerSearch[phone_number]']")
    public WebElement filterByPhoneInput;
    @FindBy(xpath = "//input[@name='PlayerSearch[last_visit]']")
    public WebElement filterByLastVisitInput;
    @FindBy(xpath = "//input[@name='PlayerSearch[last_visit_ip]']")
    public WebElement filterByLastVisitIPInput;

    @FindBy(xpath = "//table[@class='table table-hover table-striped table-bordered table-condensed']/tbody")
    public WebElement tableAllDataOfPlayers;

    @FindBy(xpath = "//span[text() = 'No results found.']")
    public WebElement noResultsFoundText;

    public int SendKeysToFilter() {
        int i = 0;
        switch (ConfigReader.getProperty("filterBy").toLowerCase()) {

            default:
                System.out.println("---------Было введено не правильное название колонки--------");
                ;
                break;

            case "username":
                helper.sendKeysWithClear(filterByUserNameInput, ConfigReader.getProperty("filterNameWord"));
                i = 1;
                break;
            case "external id":
                helper.sendKeysWithClear(filterByExternalIDInput, ConfigReader.getProperty("filterNameWord"));
                i = 2;
                break;
            case "name":
                helper.sendKeysWithClear(filterByNameInput, ConfigReader.getProperty("filterNameWord"));
                i = 3;
                break;
            case "last name":
                helper.sendKeysWithClear(filterByLastNameInput, ConfigReader.getProperty("filterNameWord"));
                i = 4;
                break;
            case "e-mail":
                helper.sendKeysWithClear(filterByEmailInput, ConfigReader.getProperty("filterNameWord"));
                i = 5;
                break;
            case "phone":
                helper.sendKeysWithClear(filterByPhoneInput, ConfigReader.getProperty("filterNameWord"));
                i = 6;
                break;
            case "last visit":
                helper.sendKeysWithClear(filterByLastVisitInput, ConfigReader.getProperty("filterNameWord"));
                i = 10;
                break;
            case "last visit ip":
                helper.sendKeysWithClear(filterByLastVisitIPInput, ConfigReader.getProperty("filterNameWord"));
                i = 11;
                break;
        }
        return i;
    }

    public List<WebElement> getListOfRowFromTable() {
        helper.pause(3000);
        return tableAllDataOfPlayers.findElements(By.tagName("tr"));
    }
}
