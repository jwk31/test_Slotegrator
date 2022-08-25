package stepDefs.apiStepDefs;

import API.helperMethods.HelperAPI;
import API.pojo.PlayerPojo;
import com.google.gson.Gson;
import dataProviders.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.Method;
import io.restassured.response.Response;
import stepDefs.BaseUITest;

public class ApiTestSteps extends BaseUITest {

    private String playerToken;

    @Given("get guest token")
    public void get_guest_token() {
        String payload = "{\n" +
                "    \"grant_type\": \"client_credentials\",\n" +
                "    \"scope\": \"guest:default\"\n" +
                "}";
        Response response = HelperAPI.requestWithBasic("/v2/oauth2/token", payload, Method.POST,
                ConfigReader.getProperty("basicToken"));

        assertClass.assertNumberWithNumber(200, response.getStatusCode());
        assertClass.assertTextNotEqualText("", response.jsonPath().getString("access_token"));
        playerToken = response.jsonPath().getString("access_token");
    }

    PlayerPojo player1 = new PlayerPojo();
    int playerId;

    @Then("register a player")
    public void register_a_player() {

        Gson gson = new Gson();
        String playerPayload = gson.toJson(player1);

        Response response = HelperAPI.requestWithBearerToken("/v2/players", playerPayload, Method.POST,
                playerToken);

        assertClass.assertNumberWithNumber(201, response.getStatusCode());
        assertClass.assertTextWithText(response.jsonPath().getString("username"), player1.getUsername());
        assertClass.assertTextWithText(response.jsonPath().getString("email"), player1.getEmail());

        playerId = response.jsonPath().getInt("id");
    }


    @Then("authorize as created player")
    public void authorize_as_created_player() {
        String payload = "{\n" +
                "    \"grant_type\": \"password\",\n" +
                "    \"username\": \"" + player1.getUsername() + "\",\n" +
                "    \"password\": \"" + player1.getPassword_change() + "\"\n" +
                "}";
        Response response = HelperAPI.requestWithBasic("/v2/oauth2/token", payload, Method.POST,
                ConfigReader.getProperty("basicToken"));
        playerToken = response.jsonPath().getString("access_token");

        assertClass.assertNumberWithNumber(200, response.getStatusCode());
        assertClass.assertTextNotEqualText("", response.jsonPath().getString("access_token"));
    }

    @Then("request details of player")
    public void request_details_of_player() {
        Response response = HelperAPI.requestWithBearerTokenGetInfo("/v2/players/" + playerId, Method.GET,
                playerToken);

        assertClass.assertNumberWithNumber(200, response.getStatusCode());
        assertClass.assertTextWithText(response.jsonPath().getString("username"), player1.getUsername());
        assertClass.assertTextWithText(response.jsonPath().getString("email"), player1.getEmail());
    }

    @Then("request detials of another player")
    public void request_detials_of_another_player() {
        String anyPlayerId = "1";
        Response response = HelperAPI.requestWithBearerTokenGetInfo("/v2/players/" + anyPlayerId, Method.GET,
                playerToken);

        assertClass.assertNumberWithNumber(404, response.getStatusCode());
    }
}
