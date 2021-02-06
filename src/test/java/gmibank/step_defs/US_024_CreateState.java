package gmibank.step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmibank.utilities.ConfigurationReader;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class US_024_CreateState {

    Response response;
    JsonPath json;
    List<Map<String,Object>> list;
    List<Map<String,Object>> allStatesList;

    @Given("Get data from states end point {string} and create the states using {string} and {string}")
    public void get_data_from_states_end_point_and_create_the_states_using_and(String statesUrl, String type, String state) {
//        response=given().headers(
//                "Authorization",
//                "Bearer "+ ConfigurationReader.getProperty("token"),
//                "Content-Type",
//                        ContentType.JSON)
//                       .when().
//                        body("{\""+type+"\":\""+state+"\"}").
//                        post(statesUrl).
//                        then().
//                        contentType(ContentType.JSON).
//                        extract().
//                        response();
//       response.prettyPrint();
    }

    @Given("Get data from api end point {string}")
    public void get_data_from_api_end_point(String states_url) {
        response = given()
                .auth()
                .oauth2(ConfigurationReader.getProperty("token"))
                .contentType(JSON)
                .get(states_url);
        response.prettyPrint();
    }


    @Given("user deserialization all states Json to Java")
    public void user_deserialization_all_states_Json_to_Java() {
        json = response.jsonPath();
        list = response.as(ArrayList.class);
    }

    @Then("Validate your created all states one by one")
    public void validate_your_created_all_states_one_by_one() {
        list= json.getList("$");
        System.out.println(list);

        for(Map<String,Object> w: list) {
            if (w.get("name") != null && w.get("name").equals("Igdir")) {
                Assert.assertEquals(72767, w.get("id"));
                System.out.println(w.toString());
            }

        }

        for(Map<String,Object> w2: list) {
            if (w2.get("name") != null && w2.get("name").equals("Van")) {
                Assert.assertEquals(72768, w2.get("id"));
                System.out.println(w2.toString());
            }

        }

    }

}
