package gmibank.step_defs;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmibank.pojos.Customer;
import gmibank.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static gmibank.utilities.PDFGenerator.pdfGeneratorRowsAndCellsWithList;
import static io.restassured.RestAssured.given;

public class US030_Pdf {

    Response response;

    List<Customer> list;

    @Given("all user provides the api end point to set the response {string}")
    public void user_provides_the_api_end_point_to_set_the_response(String url) {

        response = given().headers(
                "Authorization",
                "Bearer " + ConfigurationReader.getProperty("api_bearer_token"),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).
                when().
                get(url).
                then().
                contentType(ContentType.JSON).
                extract().
                response();

        //response.prettyPrint();
    }

    @Then("All users should be printed as a pdf file")
    public void allUsersShouldBePrintedAsAPdfFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        list = Arrays.asList(objectMapper.readValue(response.asString(), Customer[].class));
        String header = "All Applicants Information";
        String fileName="applicants.pdf";
        pdfGeneratorRowsAndCellsWithList(header,list,fileName);
    }
}
