package com.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.maven.surefire.shade.common.org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;


public class Stepdefs {


    private String convertResponseToString(HttpResponse response) throws IOException {
        InputStream responseStream = response.getEntity().getContent();
        Scanner scanner = new Scanner(responseStream, "UTF-8");
        String responseString = scanner.useDelimiter("\\Z").next();
        scanner.close();
        return responseString;
    }


    private String addURI;
    private StatusLine responseStatusLine = null;
    private final CloseableHttpClient httpClient = HttpClients.createDefault();
    //private String headers;
    private String responseString = StringUtils.EMPTY;




    @Given("^I Set GET api endpoint$")
    public void setGetEndpoint(){
        addURI = "https://mocktarget.apigee.net/json";
        System.out.println("Add URL :"+addURI);
    }

    @When ("^Send a GET HTTP request$")
    public void sendGetRequest() throws IOException {
        HttpGet request = new HttpGet(addURI);
        request.addHeader("accept", "APPLICATION_JSON");
        HttpResponse httpResponse = httpClient.execute(request);
        responseString = convertResponseToString(httpResponse);
        responseStatusLine = httpResponse.getStatusLine();
        System.out.println("responseStatusLine7="+request.getHeaders("accept"));
    }
    @Then("^I receive valid ResponseCode 200$")
    public void GetReturnASuccessStatus() {
        assertEquals(200, responseStatusLine.getStatusCode());
    }

    @Then("^Response is Json True$")
    public void theServerShouldReturnAJson() {
        assertTrue((responseString.startsWith("{") && responseString.endsWith("}")));
    }

    @Then("^Required Param is not empty$")
    public void RequiredResponseParamIs() {
        JSONObject myObject = new JSONObject(responseString);
        assertFalse(myObject.get("firstName").equals(""));
        //assertFalse(request.getHeaders("accept"))
    }





    //Post Request Start
    @Given("^I Set POST api endpoint$")
    public void setPostEndpoint(){
        addURI = "https://mocktarget.apigee.net/json";
        System.out.println("Add URL :"+addURI);
    }

    @When ("^Send a POST HTTP request$")
    public void sendPostRequest() throws IOException {
        HttpGet request = new HttpGet(addURI);
        request.addHeader("accept", "APPLICATION_JSON");
        //request.getMethod();
        HttpResponse httpResponse = httpClient.execute(request);
        responseString = convertResponseToString(httpResponse);
        responseStatusLine = httpResponse.getStatusLine();
        //System.out.println("responseStatusLine=1"+request.getHeaders("accept").toString());
    }



}