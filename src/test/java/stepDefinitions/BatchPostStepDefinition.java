package stepDefinitions;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.JSONObject;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.Config;

public class BatchPostStepDefinition extends BaseClass {
	
	String uri;
	public RequestSpecification request;
	Response response;
	
	@Given("User sets request for Batch module with valid base URL and valid request body")
	public void user_sets_request_for_batch_module_with_valid_base_url_and_valid_request_body() {
		this.uri = Config.PostBatch_URL;
		this.request = RestAssured.given().header("Content-Type", "application/json");
		logger.info("Request set for Batch module with valid base URL and valid data");
	}
	
	@When("User sends POST request for branch with valid URL and data from {string} and {int}")
	public void user_sends_post_request_for_branch_with_valid_url_and_data_from_and(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		createBatchPostRequest(SheetName, Rownumber);   
		logger.info("Post Batch Request sent with valid request body");
	}
	
	//Created common method to post batch request and test each case	
		@SuppressWarnings("unchecked")
			public void createBatchPostRequest(String SheetName, int Rownumber) throws InvalidFormatException, IOException {
			String batchName = getDataFromExcel(SheetName,Rownumber).get("batchName");
			String batchDescription = getDataFromExcel(SheetName,Rownumber).get("batchDescription");
			String batchStatus = getDataFromExcel(SheetName,Rownumber).get("batchStatus");
			String batchNoOfClasses = getDataFromExcel(SheetName,Rownumber).get("batchNoOfClasses");
			String programId = getDataFromExcel(SheetName,Rownumber).get("programId");

			JSONObject body = new JSONObject();
			body.put("batchName", batchName);
			body.put("batchDescription", batchDescription);
			body.put("batchStatus", batchStatus);
			body.put("batchNoOfClasses", batchNoOfClasses);
			body.put("programId", programId);
			
			response = this.request
					.body(body.toJSONString())
					.when()
					.post(this.uri)
					.then()
					.log().all().extract().response();	
			
		}
		
	@Then("Request should be successfull with status code {string} Post request valid URL")
	public void request_should_be_successfull_with_status_code_post_request_valid_url(String statuscode) {
		int Poststatuscode = response.getStatusCode();
		System.out.println("Poststatuscode : " +Poststatuscode);
		if (Poststatuscode == 201) {
			response.then().statusCode(Integer.parseInt(statuscode));
			logger.info("Post Request Successful");
		}	
		else 
			logger.info("Post Request unsuccessful with status code " + statuscode);
		}
	
	@Given("User sets request for Batch module with invalid base URL and valid request body")
	public void user_sets_request_for_batch_module_with_invalid_base_url_and_valid_request_body() {
		this.uri = Config.PostBatch_URL;
		this.request = RestAssured.given().header("Content-Type", "application/json");
		logger.info("Request set for Batch module with invalid base URL and valid data");
	}
	@When("User sends POST request for branch with invalid URL and data from {string} and {int}")
	public void user_sends_post_request_for_branch_with_invalid_url_and_data_from_and(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
	    
		String batchName = getDataFromExcel(SheetName,Rownumber).get("batchName");
		String batchDescription = getDataFromExcel(SheetName,Rownumber).get("batchDescription");
		String batchStatus = getDataFromExcel(SheetName,Rownumber).get("batchStatus");
		String batchNoOfClasses = getDataFromExcel(SheetName,Rownumber).get("batchNoOfClasses");
		String programId = getDataFromExcel(SheetName,Rownumber).get("programId");

		JSONObject body = new JSONObject();
		body.put("batchName", batchName);
		body.put("batchDescription", batchDescription);
		body.put("batchStatus", batchStatus);
		body.put("batchNoOfClasses", batchNoOfClasses);
		body.put("programId", programId);
		
		response = this.request
				.body(body.toJSONString())
				.when()
				.post(this.uri +"/batches")
				.then()
				.log().all().extract().response();
		
		logger.info("Valid request body sent");
	}
	
	@Then("Bad request error message should be displayed with status code {string} for Post request with invalid URL")
	public void bad_request_error_message_should_be_displayed_with_status_code_for_post_request_with_invalid_url(String statuscode) {
	    
		int Poststatuscode = response.getStatusCode();
		if (Poststatuscode == 404) {
		response.then().statusCode(Integer.parseInt(statuscode));
		logger.info("Bad request error message received with " + statuscode);
	}
	
	else 
		logger.info("Statuscode received" + statuscode + ". Error to be reported");
	}
	
	@Given("User sets request for Batch module with valid base URL and empty request body")
	public void user_sets_request_for_batch_module_with_valid_base_url_and_empty_request_body() {
		this.uri = Config.PostBatch_URL;
		this.request = RestAssured.given().header("Content-Type", "application/json");
		logger.info("Request set for Batch module with valid base URL and empty request body");
	}
	
	@When("User sends POST request for branch with empty request body")
	public void user_sends_post_request_for_branch_with_empty_request_body() {
		response = this.request
				.when()
				.post(this.uri)
				.then()
				.log().all().extract().response();
		logger.info("No data sent in request body");
	}
	
	@Then("Bad request error message should be displayed with status code {string} for Post request with empty request body")
	public void bad_request_error_message_should_be_displayed_with_status_code_for_post_request_with_empty_request_body(String statuscode) {
		int Poststatuscode = response.getStatusCode();
		if (Poststatuscode == 415) {
		response.then().statusCode(Integer.parseInt(statuscode));
		logger.info("Bad request error message received with " + statuscode);
	}
	
	else 
		logger.info("Statuscode received" + statuscode + ". Error to be reported");
	}

	@Given("User sets request for Batch module with valid base URL and invalid data")
	public void user_sets_request_for_batch_module_with_valid_base_url_and_invalid_data() {
		this.uri = Config.PostBatch_URL;
		this.request = RestAssured.given().header("Content-Type", "application/json");
		logger.info("Request set with invalid data in the request body");
	}
	
	@When("User sends POST request without Batch Name parameter in request body from {string} and {int}")
	public void user_sends_post_request_without_batch_name_parameter_in_request_body_from_and(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		createBatchPostRequest(SheetName, Rownumber);
		logger.info("Post request sent without batchName parameter");
	}
	
	@Then("Bad Request error message should be displayed with status code {string}")
	public void bad_request_error_message_should_be_displayed_with_status_code(String statuscode) {
		int Statuscode400 = response.getStatusCode();
		System.out.println("Statuscode400:" +Statuscode400);
		if (Statuscode400 == 400) {
		response.then().statusCode(Integer.parseInt(statuscode));
		logger.info("Bad request error message displayed with statuscode " + statuscode);
		}
		else 
		logger.info("Statuscode received" + statuscode + ". Error to be reported");
	}
	
	
	@When("User sends POST request with empty String value for batch name parameter in request body from {string} and {int}")
	public void user_sends_post_request_with_empty_string_value_for_batch_name_parameter_in_request_body_from_and(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		createBatchPostRequest(SheetName, Rownumber);
		logger.info("Post request sent without batchName parameter");
	}
	
	@Then("Bad request error message should be displayed with status code {string} invalid data")
	public void bad_request_error_message_should_be_displayed_with_status_code_invalid_data(String statuscode) {
		int Statuscode400 = response.getStatusCode();
		if (Statuscode400 == 400) {
		response.then().statusCode(Integer.parseInt(statuscode));
		logger.info("Bad request error message displayed with statuscode " + statuscode);
	}
	
	else 
		logger.info("Statuscode received" + statuscode + ". Error to be reported");
	}
/*//    Need to check	
	@When("User sends POST request with null value for Batch Name parameter from {string} and {int}")
	public void user_sends_post_request_with_null_value_for_batch_name_parameter_from_and(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		createBatchPostRequest(SheetName, Rownumber);
		logger.info("Post request sent with null batchName parameter");
	} */
	
	@When("User sends POST request without Batch Description parameter from {string} and {int}")
	public void user_sends_post_request_without_batch_description_parameter_from_and(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		createBatchPostRequest(SheetName, Rownumber);
		logger.info("Post request sent with out batchDescription parameter");
	}
	@Then("Request should be successfull with status code {string} Post request")
	public void request_should_be_successfull_with_status_code_post_request(String statuscode) {
		int Poststatuscode = response.getStatusCode();
		System.out.println("Poststatuscode : " +Poststatuscode);
		if (Poststatuscode == 201) {
			response.then().statusCode(Integer.parseInt(statuscode));
			logger.info("Post Request Successful");
		}	
		else 
			logger.info("Post Request unsuccessful with status code " + statuscode);
	}
	
	@When("User sends POST request with empty String value for batch description parameter from {string} and {int}")
	public void user_sends_post_request_with_empty_string_value_for_batch_description_parameter_from_and(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		createBatchPostRequest(SheetName, Rownumber);
		logger.info("Post request sent with empty batchDescription parameter");
	}
	
	@When("User sends POST request with null value for Batch Description parameter from {string} and {int}")
	public void user_sends_post_request_with_null_value_for_batch_description_parameter_from_and(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		createBatchPostRequest(SheetName, Rownumber);
		logger.info("Post request sent with null value for batchDescription parameter");
	}
// Need to check	
	@When("User sends POST request without Batch Status parameter from {string} and {int}")
	public void user_sends_post_request_without_batch_status_parameter_from_and(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		createBatchPostRequest(SheetName, Rownumber);
		logger.info("Post request sent without  batchStatus parameter");
	}
	// Need to check		
	@When("User sends POST request with empty String value for batch status parameter from {string} and {int}")
	public void user_sends_post_request_with_empty_string_value_for_batch_status_parameter_from_and(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		createBatchPostRequest(SheetName, Rownumber);
		logger.info("Post request sent with empty  batchStatus parameter");
	}
    //Need to check
	@When("User sends POST request with null value for Batch Status parameter from {string} and {int}")
	public void user_sends_post_request_with_null_value_for_batch_status_parameter_from_and(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		createBatchPostRequest(SheetName, Rownumber);
		logger.info("Post request sent with null value for  batchStatus parameter");
	}
	
	@When("User sends POST request without Batch Noofclasses parameter from {string} and {int}")
	public void user_sends_post_request_without_batch_noofclasses_parameter_from_and(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		createBatchPostRequest(SheetName, Rownumber);
		logger.info("Post request sent without  batchNoOfClasses parameter");
	}
	//Need to check
	@When("User sends POST request with empty String value for batch classes parameter from {string} and {int}")
	public void user_sends_post_request_with_empty_string_value_for_batch_classes_parameter_from_and(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		createBatchPostRequest(SheetName, Rownumber);
		logger.info("Post request sent with empty string as value for batchNoOfClasses parameter");
	}
	
	@When("User sends POST request with null value for Batch Classes parameter from {string} and {int}")
	public void user_sends_post_request_with_null_value_for_batch_classes_parameter_from_and(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		createBatchPostRequest(SheetName, Rownumber);
		logger.info("Post request sent with null as value for batchNoOfClasses parameter");
	}
	
	@When("User sends POST request with negative value for Batch Classes parameter from {string} and {int}")
	public void user_sends_post_request_with_negative_value_for_batch_classes_parameter_from_and(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		createBatchPostRequest(SheetName, Rownumber);
		logger.info("Post request sent with negative value as value for batchNoOfClasses parameter");
	}
	
	@When("User sends POST request without program ID parameter from {string} and {int}")
	public void user_sends_post_request_without_program_id_parameter_from_and(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		createBatchPostRequest(SheetName, Rownumber);
		logger.info("Post request sent without programId parameter");
	}
	
	@When("User sends POST request with numbers in string format for Program Id parameter from {string} and {int}")
	public void user_sends_post_request_with_numbers_in_string_format_for_program_id_parameter_from_and(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		createBatchPostRequest(SheetName, Rownumber);
		logger.info("Post request sent with numbers in string for programId parameter");
	}
	
	@When("User sends POST request without value for Program Id parameter from {string} and {int}")
	public void user_sends_post_request_without_value_for_program_id_parameter_from_and(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		createBatchPostRequest(SheetName, Rownumber);
		logger.info("Post request sent without value for programId parameter");
	}
	
	@When("User sends POST request with negative value for Program ID parameter from {string} and {int}")
	public void user_sends_post_request_with_negative_value_for_program_id_parameter_from_and(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		createBatchPostRequest(SheetName, Rownumber);
		logger.info("Post request sent with negative value for programId parameter");
	}
	
	@When("User sends POST request with null value for Program ID parameter from {string} and {int}")
	public void user_sends_post_request_with_null_value_for_program_id_parameter_from_and(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		createBatchPostRequest(SheetName, Rownumber);
		logger.info("Post request sent with null value for programId parameter");
	}
	
	@When("User sends POST request with special characters for Program ID parameter from {string} and {int}")
	public void user_sends_post_request_with_special_characters_for_program_id_parameter_from_and(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		createBatchPostRequest(SheetName, Rownumber);
		logger.info("Post request sent with special characters as  value for programId parameter");
	}
	
	@When("User sends POST request without program Name parameter from {string} and {int}")
	public void user_sends_post_request_without_program_name_parameter_from_and(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		createBatchPostRequest(SheetName, Rownumber);
		logger.info("Post request sent without programDescription parameter");
	}
	
	@When("User sends POST request without value for program Name parameter from {string} and {int}")
	public void user_sends_post_request_without_value_for_program_name_parameter_from_and(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		createBatchPostRequest(SheetName, Rownumber);
		logger.info("Post request sent without value for programName parameter");
	}
	
	@When("User sends POST request with null value for program Name parameter from {string} and {int}")
	public void user_sends_post_request_with_null_value_for_program_name_parameter_from_and(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		createBatchPostRequest(SheetName, Rownumber);
		logger.info("Post request sent with null value as  value for programName parameter");
	}

	@When("User sends POST request with special characters for program Name parameter from {string} and {int}")
	public void user_sends_post_request_with_special_characters_for_program_name_parameter_from_and(String SheetName, Integer Rownumber) throws InvalidFormatException, IOException {
		createBatchPostRequest(SheetName, Rownumber);
		logger.info("Post request sent with special characters as  value for programName parameter");
	}
	
}
	
	