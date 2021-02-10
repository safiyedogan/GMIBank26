package gmibank.step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmibank.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class US_025_CreateCountry {

    Response response;
    JsonPath json;
    List<Map<String,Object>> list;
    List<Map<String,Object>> allStatesList;

    @Given("get data from country end point {string} and create the country using {string} and {string}")
    public void get_data_from_states_end_point_and_create_the_country_using_and(String countryUrl, String type, String country) {
//        response=given().headers(
//                "Authorization",
//                "Bearer "+ ConfigurationReader.getProperty("token"),
//                "Content-Type",
//                        ContentType.JSON)
//                       .when().
//                        body("{\""+type+"\":\""+country+"\"}").
//                        post(countryUrl).
//                        then().
//                        contentType(ContentType.JSON).
//                        extract().
//                        response();
//       response.prettyPrint();
    }

    @Given("get data from api end point {string}")
    public void get_data_from_api_end_point(String country_url) {
        response = given()
                .auth()
                .oauth2(ConfigurationReader.getProperty("token"))
                .contentType(JSON)
                .get(country_url);
        response.prettyPrint();
    }


    @Given("User deserialization all country Json to Java")
    public void user_deserialization_all_country_Json_to_Java() {
        json = response.jsonPath();
        list = response.as(ArrayList.class);
    }

    @Then("validate your created all country one by one")
    public void validate_your_created_all_country_one_by_one() {
        list= json.getList("$");
        System.out.println(list);

        for(Map<String,Object> w: list) {
            if (w.get("name") != null && w.get("name").equals("New Zealand")) {
                Assert.assertEquals(73969, w.get("id"));
                System.out.println(w.toString());
            }

        }

        for(Map<String,Object> w2: list) {
            if (w2.get("name") != null && w2.get("name").equals("Costa Rica")) {
                Assert.assertEquals(73973, w2.get("id"));
                System.out.println(w2.toString());
            }

        }

    }

}

