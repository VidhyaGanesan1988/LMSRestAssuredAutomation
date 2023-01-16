package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.Config;
import utilities.ExcelReader;

public class ProgramGETStepdefinition extends BaseClass{

	String uri;
	public RequestSpecification request;
	Response response;
	
	@Given("User sets request for Program module with valid base URL")
	public void user_sets_request_for_program_module_with_valid_base_url() {
		this.uri = Config.GetAllProgram_URL;
		this.request = RestAssured.given().header("Content-Type", "application/json");
	}

	@When("User sends GET request")
	public void user_sends_get_request() {
		response = this.request.get(this.uri);	
		response.then().log().all();
	}

	@Then("Request should be successfull with status code {string} for GET All programs")
	public void request_should_be_successfull_with_status_code_for_get_all_programs(String statuscode) {
		//Statuscode Validation
		int GetAllstatuscode = response.getStatusCode();
		if (GetAllstatuscode == 200) {
		response.then().statusCode(Integer.parseInt(statuscode));
		//Header Validation
		response.then().assertThat().header("Connection", "keep-alive");
		logger.info("Get Request to fetch all program data is successfull");
	}
	
	else if (GetAllstatuscode == 404) {
		logger.info("Get Request unsuccessful");
	   }
	}
	@Given("User sets request for Program module with invalid base URL")
	public void user_sets_request_for_program_module_with_invalid_base_url() {
		this.uri = Config.GetAllProgram_URL;
		this.request = RestAssured.given().header("Content-Type", "application/json");
	}
	
	@When("User sends GET request with invalid URL")
	public void user_sends_get_request_with_invalid_URL() {
		response = this.request.get(this.uri + "/" + "*" );	
		response.then().log().all();
	}

	@Then("Not found error message should be displayed with status code {string} for GET All programs")
	public void not_found_error_message_should_be_displayed_with_status_code_for_get_all_programs(String statuscode) {
		int GetAllstatuscode = response.getStatusCode();
		if (GetAllstatuscode == 404) {
		response.then().statusCode(Integer.parseInt(statuscode));
		logger.info("Status code 404 received for GET all program with invalid URL");
	}	
	else 
		logger.info("Get Request unsuccessful");
	}

	@Given("User sets request for Program module with valid base URL and valid path")
	public void user_sets_request_for_program_module_with_valid_base_url_and_valid_path() {
		this.uri = Config.GetAllProgram_URL;
		this.request = RestAssured.given().header("Content-Type", "application/json");
	}

	@When("User sends GET request with valid program ID from {string} and {int}")
	public void user_sends_get_request_with_valid_program_id_from_and(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		ExcelReader excelReader = new ExcelReader();
		List<Map<String,String>> getData = 
				excelReader.getData(Config.EXCEL, SheetName);
		
		String programId = getData.get(Rownumber).get("programId");
		
		response = this.request
				.when()
				.get(Config.GetSingleProgram_URL + "/" + programId)
				.then()
				.log().all().extract().response();
	}

	@Then("Request should be successfull with status code {string} for GET single program")
	public void request_should_be_successfull_with_status_code_for_get_single_program(String statuscode) {
		int GetAllstatuscode = response.getStatusCode();
		if (GetAllstatuscode == 200) {
		response.then().statusCode(Integer.parseInt(statuscode));
		response.then().assertThat().header("Connection", "keep-alive");
		//Json Schema Validation
		response.then().assertThat()
		.body(JsonSchemaValidator.matchesJsonSchema(new File("./src/test/resources/JsonSchemas/GetSingleProgram.json")));
		logger.info("Get Request to fetch single program data is successful");
	}
	
	else if (GetAllstatuscode == 400) {
		logger.info("Get Request unsuccessful");
	    }
	}

	@Given("User sets request for Program module with valid base URL and invalid path")
	public void user_sets_request_for_program_module_with_valid_base_url_and_invalid_path() {
		this.uri = Config.GetAllProgram_URL;
		this.request = RestAssured.given().header("Content-Type", "application/json");
	}

	@When("User sends GET request with invalid program ID")
	public void user_sends_get_request_with_invalid_program_id() {
		response = this.request.get(Config.GetSingleProgram_URL + "/" + randomestring());	
		response.then().log().all();
	}

	@Then("Bad request error message should be displayed with status code {string} for GET single program")
	public void bad_request_error_message_should_be_displayed_with_status_code_for_get_single_program(String statuscode) {
		int GetAllstatuscode = response.getStatusCode();
		if (GetAllstatuscode == 400) {
		response.then().statusCode(Integer.parseInt(statuscode));
		logger.info("Status code 400 received for GET single program with invalid program ID");
	}
	else 
		logger.info("Get Request unsuccessful");
	}

	@When("User sends GET request with invalid input")
	public void user_sends_get_request_with_invalid_input() {
		response = this.request.get(Config.GetSingleProgram_URL + "/" + "*" );	
		response.then().log().all();
	}

	@Then("Bad request error message should be displayed with status code {string} for GET single program with invalid input")
	public void bad_request_error_message_should_be_displayed_with_status_code_for_get_single_program_with_invalid_input(String statuscode) {
		int GetAllstatuscode = response.getStatusCode();
		if (GetAllstatuscode == 400) {
		response.then().statusCode(Integer.parseInt(statuscode));
		logger.info("Status code 400 received for GET single program with invalid input *");
	}
	else 
		logger.info("Get Request unsuccessful");
	}

}


