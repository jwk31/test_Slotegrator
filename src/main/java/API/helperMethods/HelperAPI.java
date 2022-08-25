package API.helperMethods;

import dataProviders.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HelperAPI {

    private static RequestSpecification setup() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri(ConfigReader.getProperty("baseUri"))
                .auth().basic(ConfigReader.getProperty("userNameAPI"), ConfigReader.getProperty("passwordAPI"));
        return requestSpecification;
    }

    public static RequestSpecification preRequest() {
        return setup()
                .contentType(ContentType.JSON).accept(ContentType.JSON);
    }

    public static Response requestWithBasic(String endPoint, String body, Method method, String token) {
        return preRequest()
                .header("Authorization", "Basic " + token)
                .body(body)
                .when()
                .request(method, endPoint);
    }

    public static Response requestWithBearerToken(String endPoint, String body, Method method, String token) {
        return preRequest()
                .header("Authorization", "Bearer " + token)
                .body(body)
                .when()
                .request(method, endPoint);
    }

    public static Response requestWithBearerTokenGetInfo(String endPoint, Method method, String token) {
        return preRequest()
                .header("Authorization", "Bearer " + token)
                .when()
                .request(method, endPoint);
    }
}
