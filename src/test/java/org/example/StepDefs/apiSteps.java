package org.example.StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class apiSteps {
    private String endpoint;
    private Response response;

    @Given("I have the API endpoint {string}")
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    @When("I send a GET request to the API")
    public void sendGetRequest() {
        RequestSpecification request = given();
        response = request.get(endpoint);
    }

    @Then("the response status code should be {int}")
    public void verifyStatusCode(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        assertEquals(expectedStatusCode, actualStatusCode);
    }

    @Then("the response body should contain {string}")
    public void verifyResponseBody(String expectedBody) {
        String responseBody = response.getBody().asString();
        assertTrue(responseBody.contains(expectedBody));
    }
}



