package stepDefinitions;

import org.json.simple.JSONObject;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.Config;
import utilities.CurrentDate;

public class BatchPUTstepDefination {
	String uri;
	CurrentDate cd;
	RequestSpecification request;
	Response response;
	
	public BatchPUTstepDefination() {
		cd=new CurrentDate();
	}

	//<======================Scenario: Verify put request for batch by providing invalid URL=======>
	@Given("User set put request with valid request body for batch")
	public void user_set_put_request_with_valid_request_body_for_batch() {
		
		JSONObject body = new JSONObject();
		body.put("batchId", "71");
		body.put("batchName", "APIUpdated");
		body.put("batchDescription", "APIDescription001");
		body.put("batchStatus", "Inactive");
		body.put("batchNoOfClasses", 45);
		body.put("programId","329");
		body.put("programName","batchUpdated");
		System.out.println(body);

		// request =RestAssured.given().contentType("application/json").body(body);
		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);
		
	}

	@When("User send put request with invalid URL")
	public void user_send_put_request_with_invalid_url() {
		this.uri = Config.BASE_Invalid_URL+ Config.Invalid_BatchPut;
		response = this.request.when().put(this.uri);
	}

	@Then("Server unavailable error message should be displayed with {int} status code")
	public void server_unavailable_error_message_should_be_displayed_with_status_code(Integer int1) {
		int statusCode = this.response.statusCode();
		Assert.assertEquals(503, statusCode);
	}

	//<======================Scenario: Verify put request by providing invalid endpoint=======>
	@Given("User set put request with valid payload")
	public void user_set_put_request_with_valid_payload() {
		
		JSONObject body = new JSONObject();
		body.put("batchId", "71");
		body.put("batchName", "APIUpdated");
		body.put("batchDescription", "APIDescription001");
		body.put("batchStatus", "Inactive");
		body.put("batchNoOfClasses", 45);
		body.put("programId","329");
		body.put("programName","batchUpdated");
		System.out.println(body);

		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);
	}

	@When("User send put request with invalid endpoint for batch")
	public void user_send_put_request_with_invalid_endpoint_for_batch() {
		this.uri = Config.BASE_URL+ Config.Invalid_BatchPut;
		response = this.request.when().put(this.uri);
	}
	
	
	@Then("Not found validation error message should be displayed with {int} status code")
	public void not_found_validation_error_message_should_be_displayed_with_status_code(Integer int1){
		int statusCode = this.response.statusCode();
		Assert.assertEquals(404, statusCode);
	}
	
	//<======================Scenario: Verify put request by providing batchId as endpoint with Empty payload=======>
	@Given("User set put request with empty request body")
	public void user_set_put_request_with_empty_request_body() {
		JSONObject body = new JSONObject();
		body.put("batchName", " ");
		body.put("batchDescription", "");
		body.put("batchStatus", " ");
		body.put("batchNoOfClasses", null);
		body.put("programId"," ");
		body.put("programName"," ");
		System.out.println(body);

		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);
	}

	@When("User send put request with Valid URL")
	public void user_send_put_request_with_valid_url() {
		this.uri = Config.BASE_URL+ Config.Valid_BatchPut;
		response = this.request.when().put(this.uri);
	}
	
	@Then("Bad request error message should be displayed with {int} status code for batch")
	public void not_found_error_message_should_be_displayed_with_status_code_for_batch(Integer int1){
		int statusCode = this.response.statusCode();
		Assert.assertEquals(400, statusCode);
	}

	
	//<================Verify put request by Batch Id for already existing data======================>
	@Given("User set put request with valid Payload for Existing data")
	public void user_set_put_request_with_valid_payload_for_existing_data() {
		JSONObject body = new JSONObject();
		body.put("batchId", "467");
		body.put("batchName", "APIUpdated");
		body.put("batchDescription", "APIDescription001");
		body.put("batchStatus", "Inactive");
		body.put("batchNoOfClasses", 45);
		body.put("programId","329");
		body.put("programName","SDET005");
		System.out.println(body);

		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);
	}
	
	@When("User send put request for batch")
	public void user_send_put_request_for_batch() {
		this.uri = Config.BASE_URL+ Config.Valid_BatchPut;
		response = this.request.when().put(this.uri);
	}
	
	
	@Then("Request should be successfull with status code {int} for batch")
	public void request_should_be_successsfull_with_status_code_for_batch(Integer int1){
		int statusCode = this.response.statusCode();
		Assert.assertEquals(200, statusCode);
	}
	
    //<==============Verify put request by Batch Id for non existing data on server===================>
	@Given("User set put request with invalid Payload \\(batch details is not available on server)")
	public void user_set_put_request_with_invalid_payload_batch_details_is_not_available_on_server() {
		JSONObject body = new JSONObject();
		body.put("batchId", "71");
		body.put("batchName", "APIUpdated");
		body.put("batchDescription", "APIDescription001");
		body.put("batchStatus", "Inactive");
		body.put("batchNoOfClasses", 45);
		body.put("programId","329");
		body.put("programName","batchUpdated");
		System.out.println(body);

		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);
	}

	@When("User send request with Valid batch URL")
	public void user_send_request_with_valid_batch_url() {
		this.uri = Config.BASE_URL+ Config.Invalid_BatchPut;
		response = this.request.when().put(this.uri);
	}

	@Then("{string} error message should be displayed with {int} bad request status code")
	public void error_message_should_be_displayed_with_bad_request_status_code(String string, Integer int1) {
		int statusCode = this.response.statusCode();
		Assert.assertEquals(404, statusCode);
	}

	//=============Verify put request by Batch Id with Batch Id details in payload==============
	@Given("User set put request with valid batch id")
	public void user_set_put_request_with_valid_batch_id() {
		JSONObject body = new JSONObject();
		body.put("batchId", "467");
		body.put("batchName", "APIUpdated");
		body.put("batchDescription", "APIDescription001");
		body.put("batchStatus", "Inactive");
		body.put("batchNoOfClasses", 45);
		body.put("programId","329");
		body.put("programName","SDET005");
		System.out.println(body);

		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);
	}
	
	@When("User requested put request with Valid URL")
	public void user_requested_put_request_with_valid_url() {
		this.uri = Config.BASE_URL+ Config.Valid_BatchPut;
		response = this.request.when().put(this.uri);
	}

	@Then("Request should be successfull by having status code {int}")
	public void request_should_be_successfull_by_having_status_code(Integer int1) {
		int statusCode = this.response.statusCode();
		Assert.assertEquals(200, statusCode);
	}

	//<===================================Verify put request by Batch Id and payload without Batch Id============>
	@Given("User set Valid URL without batch id")
	public void user_set_valid_url_without_batch_id() {
		JSONObject body = new JSONObject();
		body.put("batchName", "APIUpdated");
		body.put("batchDescription", "APIDescription001");
		body.put("batchStatus", "Inactive");
		body.put("batchNoOfClasses", 45);
		body.put("programId","329");
		body.put("programName","SDET005");
		System.out.println(body);

		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);
	}
	
	 
		@When("User send put request along with valid url")
		public void user_send_put_request_along_with_valid_url() {
			this.uri = Config.BASE_URL+ Config.Valid_BatchPut;
			response = this.request.when().put(this.uri);
		}
	
	@Then("successfull message should be displayed by having status code {int}")
	public void successfull_message_should_be_displayed_by_having_status_code(Integer int1) {
		int statusCode = this.response.statusCode();
		Assert.assertEquals(200, statusCode);
	}
	
	
	//==================Verify put request by Batch Id to update batch details without batch description=======
	@Given("User set put request without batch description")
	public void user_set_put_request_without_batch_description() {
		JSONObject body = new JSONObject();
		body.put("batchId", "467");
		body.put("batchName", "APIUpdated");
		body.put("batchStatus", "Inactive");
		body.put("batchNoOfClasses", 45);
		body.put("programId","329");
		body.put("programName","SDET005");
		System.out.println(body);

		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);
	}
	
	
	@When("User requested put, with Valid URL")
	public void user_requested_put_with_valid_url() {
		this.uri = Config.BASE_URL+ Config.Valid_BatchPut;
		response = this.request.when().put(this.uri);
	}
	
	@Then("Batch should be created with null value for program description with status code {int}")
	public void program_should_be_created_with_null_value_for_program_description_with_status_code(Integer int1) {
		int statusCode = this.response.statusCode();
		Assert.assertEquals(200, statusCode);
	}
	
//===========Verify put request by batch id to update batch Name=================
	@Given("User set put request with updated Name")
	public void user_set_put_request_with_updated_name() {
		JSONObject body = new JSONObject();
		body.put("batchId", "467");
		body.put("batchName", "APIBatchNameUpdated");
		body.put("batchDescription", "APIDescription001");
		body.put("batchStatus", "Inactive");
		body.put("batchNoOfClasses", 45);
		body.put("programId","329");
		body.put("programName","batchUpdated");
		System.out.println(body);

		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);
	}

	
	@When("User send put request to update batch name")
	public void user_send_put_request_to_update_batch_name() {
		this.uri = Config.BASE_URL+ Config.Valid_BatchPut;
		response = this.request.when().put(this.uri);
	}
	
	@Then("Batch details should be updated with updated name, {int} status code should be displayed")
	public void program_details_should_be_updated_with_updated_name_status_code_should_be_displayed(Integer int1) {
		int statusCode = this.response.statusCode();
		Assert.assertEquals(200, statusCode);
	}

	//=========================Verify put request by batch id to update batch description============
	@Given("User set put request with updated Description")
	public void user_set_put_request_with_updated_description() {
		JSONObject body = new JSONObject();
		body.put("batchId", "467");
		body.put("batchName", "APIBatchNameUpdated");
		body.put("batchDescription", "APIupdateDescription001");
		body.put("batchStatus", "Inactive");
		body.put("batchNoOfClasses", 45);
		body.put("programId","329");
		body.put("programName","batchUpdated");
		System.out.println(body);

		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);
	}
	
	@When("User send put request to update batch description")
	public void user_send_put_request_to_update_batch_description() {
		this.uri = Config.BASE_URL+ Config.Valid_BatchPut;
		response = this.request.when().put(this.uri);
	}

	
	@Then("Response body should be have updated description and {int} status code should be displayed")
	public void response_body_should_be_have_updated_description_and_status_code_should_be_displayed(Integer int1) {
		int statusCode = this.response.statusCode();
		Assert.assertEquals(200, statusCode);
	}

	//=======================Verify put request by batch  id to update batch status==================
	@Given("User set put request with updated status")
	public void user_set_put_request_with_updated_status() {
		JSONObject body = new JSONObject();
		body.put("batchId", "467");
		body.put("batchName", "APIBatchNameUpdated");
		body.put("batchDescription", "APIupdateDescription001");
		body.put("batchStatus", "UpdatedInactive");
		body.put("batchNoOfClasses", 45);
		body.put("programId","329");
		body.put("programName","batchUpdated");
		System.out.println(body);
		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);
	}
	
	@When("User send put request to update batch status")
	public void user_send_put_request_to_update_batch_status() {
		this.uri = Config.BASE_URL+ Config.Valid_BatchPut;
		response = this.request.when().put(this.uri);
	}
	
	@Then("batch status should be updated with status code {int}")
	public void batch_status_should_be_updated_with_status_code(Integer int1) {
		int statusCode = this.response.statusCode();
		Assert.assertEquals(200, statusCode);
	}
	
	//========================Verify put request by batch id to update No of classes=============
	@Given("User set put request with updated No of classes")
	public void user_set_put_request_with_updated_no_of_classes() {
		JSONObject body = new JSONObject();
		body.put("batchId", "467");
		body.put("batchName", "APIBatchNameUpdated");
		body.put("batchDescription", "APIupdateDescription001");
		body.put("batchStatus", "UpdatedInactive");
		body.put("batchNoOfClasses",99);
		body.put("programId","329");
		body.put("programName","batchUpdated");
		System.out.println(body);

		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);
	}

	@When("User send put request to update No of classes")
	public void user_send_put_request_to_update_no_of_classes() {
		this.uri = Config.BASE_URL+ Config.Valid_BatchPut;
		response = this.request.when().put(this.uri);
	}
	
	
	@Then("batch No of classes should be updated with status code {int}")
	public void batch_no_of_classes_should_be_updated_with_status_code(Integer int1) {
		int statusCode = this.response.statusCode();
		Assert.assertEquals(200, statusCode);
	}

	//========================Verify put request by batch id to update program id============
	@Given("User set put request with updated Program id")
	public void user_set_put_request_with_updated_program_id() {
		JSONObject body = new JSONObject();
		body.put("batchId", "1456");
		body.put("batchName", "APIBatchNameUpdated");
		body.put("batchDescription", "APIupdateDescription001");
		body.put("batchStatus", "UpdatedInactive");
		body.put("batchNoOfClasses",99);
		body.put("programId","2977");
		body.put("programName","batchUpdated");
		System.out.println(body);

		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);
	}
	
	@When("User send put request to update program id")
	public void user_send_put_request_to_update_program_id() {
		this.uri = Config.BASE_URL+ Config.Valid_BatchPut;
		response = this.request.when().put(this.uri);
	}
	

	@Then("Program id should be updated with status code {int}")
	public void program_id_should_be_updated_with_status_code(Integer int1) {
		int statusCode = this.response.statusCode();
		Assert.assertEquals(200, statusCode);
	}

	//========================Verify put request by batch id to update program name=================
	@Given("User set put request with updated Program name")
	public void user_set_put_request_with_updated_program_name() {
		JSONObject body = new JSONObject();
		body.put("batchId", "467");
		body.put("batchName", "APIBatchNameUpdated");
		body.put("batchDescription", "APIupdateDescription001");
		body.put("batchStatus", "UpdatedInactive");
		body.put("batchNoOfClasses",99);
		body.put("programId","2977");
		body.put("programName","sdet005_updated");
		System.out.println(body);
		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);
	}

	@When("User send put request to update program name")
	public void user_send_put_request_to_update_program_name() {
		this.uri = Config.BASE_URL+ Config.Valid_BatchPut;
		response = this.request.when().put(this.uri);
	}
	
	@Then("Program name should be updated with status code {int}")
	public void program_name_should_be_updated_with_status_code(Integer int1) {
		int statusCode = this.response.statusCode();
		Assert.assertEquals(200, statusCode);
	}

	//=========Verify put request by Batch Id to update batch details without batch Name===============
	@Given("User set put request with valid payload except batch name")
	public void user_set_put_request_with_valid_payload_except_batch_name() {
		JSONObject body = new JSONObject();
		body.put("batchId", "467");
		body.put("batchDescription", "APIupdateDescription001");
		body.put("batchStatus", "UpdatedInactive");
		body.put("batchNoOfClasses",99);
		body.put("programId","2977");
		body.put("programName","sdet005_updated");
		System.out.println(body);

		System.out.println(body);

		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);
	}

	@When("User send put request to update batch details")
	public void user_send_put_request_to_update_batch_details() {
		this.uri = Config.BASE_URL+ Config.Valid_BatchPut;
		response = this.request.when().put(this.uri);
	}
	
	@Then("Validation error should be displayed with {int} bad request")
	public void validation_error_should_be_displayed_with_bad_request(Integer int1) {
		int statusCode = this.response.statusCode();
		Assert.assertEquals(400, statusCode);
	}

	//========================Verify put request by Batch Id to update batch details without batch status========
	@Given("User set put request with valid payload except batch status")
	public void user_set_put_request_with_valid_payload_except_batch_status() {
		JSONObject body = new JSONObject();
		body.put("batchId", "467");
		body.put("batchName", "APIBatchNameUpdated");
		body.put("batchDescription", "APIupdateDescription001");
		body.put("batchNoOfClasses",99);
		body.put("programId","2977");
		body.put("programName","sdet005_updated");
		System.out.println(body);

		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);
	}

	@When("User send put request to check without batch status")
	public void user_send_put_request_to_check_without_batch_status() {
		this.uri = Config.BASE_URL+ Config.Valid_BatchPut;
		response = this.request.when().put(this.uri);
	}
	
	@Then("Error {string} should be displayed with {int} bad request")
	public void error_should_be_displayed_with_bad_request(String string, Integer int1) {
		int statusCode = this.response.statusCode();
		Assert.assertEquals(400, statusCode);
	}

	//======================Verify put request by Batch Id to update batch details without batch No of classes===========
	@Given("User set put request with valid payload except batch no of classes")
	public void user_set_put_request_with_valid_payload_except_batch_no_of_classes() {
	    
		JSONObject body = new JSONObject();
		body.put("batchId", "467");
		body.put("batchName", "APIBatchNameUpdated");
		body.put("batchDescription", "APIupdateDescription001");
		body.put("batchStatus", "UpdatedInactive");
		body.put("programId","2977");
		body.put("programName","sdet005_updated");
		System.out.println(body);

		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);
	}
	
	@When("User send put request to check without no of classes")
	public void user_send_put_request_to_check_without_no_of_classes() {
		this.uri = Config.BASE_URL+ Config.Valid_BatchPut;
		response = this.request.when().put(this.uri);
	}
	
	@Then("Validation error  No of Classes is needed; It should be a positive number  should be displayed with {int} bad request")
	public void validation_error_no_of_classes_is_needed_it_should_be_a_positive_number_should_be_displayed_with_bad_request(Integer int1) {
		int statusCode = this.response.statusCode();
		Assert.assertEquals(400, statusCode);
	}

	//================Verify put request by Batch Id to update batch details without Program id============
	@Given("User set put request with valid payload except Program id")
	public void user_set_put_request_with_valid_payload_except_program_id() {
		JSONObject body = new JSONObject();
		body.put("batchId", "467");
		body.put("batchName", "APIBatchNameUpdated");
		body.put("batchDescription", "APIupdateDescription001");
		body.put("batchStatus", "UpdatedInactive");
		body.put("batchNoOfClasses",99);
		body.put("programName","sdet005_updated");
		System.out.println(body);

		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);
	}
	
	@When("User send put request to check without Program id")
	public void user_send_put_request_to_check_without_program_id() {
		this.uri = Config.BASE_URL+ Config.Valid_BatchPut;
		response = this.request.when().put(this.uri);
	}

	
	@Then("{string} error message should be displayed with {int} bad request")
	public void error_message_should_be_displayed_with_bad_request(String string, Integer int1) {
		int statusCode = this.response.statusCode();
		Assert.assertEquals(400, statusCode);
	}

	//=======================Verify put request by Batch Id to update batch details without  program name=============
	@Given("User set put request with valid payload except Program name")
	public void user_set_put_request_with_valid_payload_except_program_name() {
		JSONObject body = new JSONObject();
		body.put("batchId", "467");
		body.put("batchName", "APIBatchNameUpdated");
		body.put("batchDescription", "APIupdateDescription001");
		body.put("batchStatus", "UpdatedInactive");
		body.put("programId","329");
		System.out.println(body);

		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);
	}
	
	@When("User send put request to check without Program name")
	public void user_send_put_request_to_check_without_program_name() {
		this.uri = Config.BASE_URL+ Config.Valid_BatchPut;
		response = this.request.when().put(this.uri);
	}
	

	@Then("error message should be dsiplayed with status code {int} bad request")
	public void error_message_should_be_dsiplayed_with_status_code_bad_request(Integer int1) {
		int statusCode = this.response.statusCode();
		Assert.assertEquals(400, statusCode);
	}

	//==========Verify put request by Batch Id to update batch details with empty Program id===========
	@Given("User set put request with valid payload, Program id is empty")
	public void user_set_put_request_with_valid_payload_program_id_is_empty() {
		JSONObject body = new JSONObject();
		body.put("batchId", " ");
		body.put("batchName", "APIUpdated");
		body.put("batchDescription", "APIDescription001");
		body.put("batchStatus", "Inactive");
		body.put("batchNoOfClasses", 45);
		body.put("programId","329");
		body.put("programName","batchUpdated");
		System.out.println(body);

		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);
	}
	
	@When("User send put request to check with empty program id")
	public void user_send_put_request_to_check_with_empty_program_id() {
		this.uri = Config.BASE_URL+ Config.Valid_BatchPut;
		response = this.request.when().put(this.uri);
	}
	

	
	@Then("Validation {string} message should be displayed with {int} bad request.")
	public void validation_message_should_be_displayed_with_bad_request(String string, Integer int1) {
		int statusCode = this.response.statusCode();
		Assert.assertEquals(400, statusCode);
	}
	
	
	
}
