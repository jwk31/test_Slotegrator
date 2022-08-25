package stepDefs;

import dataProviders.ConfigReader;
import UI.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FilterPlayersListSteps extends BaseUITest {

    @Given("login with given credentials as admin")
    public void login_with_given_credentials_as_admin() {
        Driver.getDriver().get(ConfigReader.getProperty("environment"));
        loginPage.loginToSystem(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"));
    }

    @Then("admin should see admin-index page")
    public void admin_should_see_admin_index_page() {
        indexPage.waitPageToBeLoaded();
        assertClass.assertTextWithText(ConfigReader.getProperty("indexPageUrl"), Driver.getDriver().getCurrentUrl());
    }

    @When("admin clicks on players button")
    public void admin_clicks_on_players_button() {
        indexPage.clickButtonUsers().clickButtonPlayers();
    }

    @Then("admin should see Player Management page")
    public void admin_should_see_player_management_page() {
        assertClass.assertTextWithGetText("Player management", playersListPage.playersPageText);
    }

    int index;

    @When("admin fills given data to user name filter input field")
    public void admin_fills_given_data_to_user_name_filter_input_field() {
        index = playersListPage.SendKeysToFilter();
    }

    @Then("admin should see pla players list with only given data on user name filter field")
    public void admin_should_see_pla_players_list_with_only_given_data_on_user_name_filter_field() {
        List<WebElement> listOfRow = playersListPage.getListOfRowFromTable();
        if (listOfRow.size() <= 1) {
            if (listOfRow.get(0).getText().equals("No results found.")) {
                return;
            }
        }
        for (WebElement row : listOfRow) {
            List<WebElement> listOfColumn = row.findElements(By.tagName("td"));
            assertClass.assertContainsTextWithText(ConfigReader.getProperty("filterNameWord"), listOfColumn.get(index).getText());
        }

        Driver.closeDriver();
    }
}
