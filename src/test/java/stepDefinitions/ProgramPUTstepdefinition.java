package stepDefinitions;



import org.json.simple.JSONObject;

import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.Config;
import utilities.CurrentDate;


public class ProgramPUTstepdefinition {
	RequestSpecification request;
	Response response;
	String uri;
	CurrentDate cd;

	public ProgramPUTstepdefinition() {
		cd = new CurrentDate();
	}

	//<=============Scenario : Verify put request by providing invalid URL-------->
	@Given("User set invalid URL with valid request body")
	public void user_set_invalid_url_with_valid_request_body() {

		this.uri = Config.BASE_Invalid_URL + Config.BASE_Invalid_URL;
		// RestAssured.baseURI="http://lms-backend-service.herokuapp.com/lms/";

		JSONObject reBody = new JSONObject();
		// JsonObject job=new JsonObject();
		// HashMap<String,String> map= new HashMap<String,String>();
		reBody.put("programName", "jan23SDET1");
		reBody.put("programStatus", "Active");
		reBody.put("creationTime", "2023-01-07T04:13:00.000+00:00");
		reBody.put("lastModTime", cd.getCurrentDate());
		System.out.println(reBody);

		// request =RestAssured.given().contentType("application/json").body(reBody);
		// request.log().all();

		// this.uri = Config.GetAllProgram_URL;
		this.request = RestAssured.given().header("Content-Type", "application/json").body(reBody);
	}

	@When("User send put request")
	public void user_send_put_request() {
		response = this.request.when().put(this.uri);
	}

	@Then("Service unavailable error message should be displayed with {int} status code")
	public void Service_unavailable_error_message_should_be_displayed_with_status_code(Integer int1) {
		// this.response.then().log().all();

		int statusCode = this.response.statusCode();
		Assert.assertEquals(503, statusCode);

	}
	
	//<---------Scenario 2 : Verify put request by providing invalid endpoint-------->
	@Given("User set put request with valid request body")
	public void user_set_put_request_with_valid_request_body() {

		

		/*
		 * ExcelReader excelReader = new ExcelReader(); List<Map<String,String>>
		 * postData = excelReader.getData(Config.EXCEL, sheetName);
		 * 
		 * String programId = postData.get(rowNumber).get("programId"); String
		 * programName = postData.get(rowNumber).get("programName"); String programDesc=
		 * postData.get(rowNumber).get("programDescription"); String programStatus =
		 * postData.get(rowNumber).get("programStatus"); String creationTime =
		 * postData.get(rowNumber).get("creationTime"); //String lastModTime =
		 * postData.get(rowNumber).get("lastModTime");
		 * 
		 * 
		 * JSONObject body = new JSONObject(); body.put("programId", programId);
		 * body.put("programName", programName); body.put("programDescription",
		 * programDesc); body.put("programStatus",programStatus);
		 * body.put("creationTime", programStatus); body.put("lastModTime",
		 * creationTime); body.put("lastModTime", cd.getCurrentDate());
		 * System.out.println(body);
		 */

		JSONObject body = new JSONObject();
		// body.put("programId", " ");
		body.put("programName", "jan23SDET1");
		body.put("programDescription", "TestingBatch");
		body.put("programStatus", "Inactive");
		body.put("creationTime", cd.getCurrentDate());
		body.put("lastModTime", cd.getCurrentDate());
		System.out.println(body);

		// request =RestAssured.given().contentType("application/json").body(body);
		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);
	}

	@When("User send put request with invalid endpoint")
	public void user_send_put_request_with_invalid_endpoint() {
		this.uri = Config.BASE_URL + Config.Invalid_Endpoint_PutProgram;
		response = this.request.when().put(this.uri);
	}
	

	@Then("Not found error message should be displayed with {int} status code")
	public void Not_found_error_message_should_be_displayed_with_status_code(Integer int1) {
		int statusCode = this.response.getStatusCode();
		Assert.assertEquals(404, statusCode);
	}

	//<---------Scenario 3 : Verify put request by providing programID as endpoint with Empty payload-------->
	@Given("User set Valid URL with empty request body")
	public void user_set_valid_url_with_empty_request_body() {

		JSONObject body = new JSONObject();
		 body.put("programId", " ");
		body.put("programName", " ");
		 body.put("programDescription", " ");
		 body.put("programStatus"," ");
		body.put("creationTime", " ");
		body.put("lastModTime", " ");
		System.out.println(body);

		// request =RestAssured.given().contentType("application/json").body(body);
		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);
	}
	
	@When("User send put request by program id")
	public void user_send_put_request_by_program_id() {
		this.uri = Config.BASE_URL + Config.Valid_Endpoint_PutProgram;
		response = this.request.when().put(this.uri);
	}

	@Then("Bad request error message should be displayed with {int} status code")
	public void Bad_request_error_message_should_be_dsiplayed_with_status_code(Integer int1) {
		int statusCode = this.response.getStatusCode();
		Assert.assertEquals(400, statusCode);
	}

	//<---------Scenario 4 : Verify put request by program id for already existing data-------->
	@Given("User set valid URL with valid Payload")
	public void user_set_valid_url_with_valid_payload() {

		//this.uri = Config.BASE_URL + Config.Valid_Endpoint_PutProgram;

		JSONObject body = new JSONObject();
	    body.put("programId",4421);
		body.put("programName", "jan23SDET1");
		body.put("programDescription","TestingBatch");
		body.put("programStatus", "Inactive");
		body.put("creationTime", "2023-01-14T01:57:46.503+00:00");
		body.put("lastModTime", cd.getCurrentDate());
		System.out.println(body);

		// request =RestAssured.given().contentType("application/json").body(body);
		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);

	}

	@When("User send put request with valid URL")
	public void user_send_put_request_with_valid_url() {
		this.uri = Config.BASE_URL + Config.Valid_Endpoint_PutProgram;
		response = this.request.when().put(this.uri);
	}

	@Then("Request should be successfull with status code {int}")
	public void request_should_be_successfull_with_status_code(Integer int1) {
		int statusCode = this.response.getStatusCode();
		Assert.assertEquals(200, statusCode);
		//JsonPath path=new JsonPath(this.response.toString());
		

	}

	//<---------Scenario 5 : Verify put request by program id for non existing data on server-------->
	@Given("User set valid URL with invalid Payload \\(Program is not available on server)")
	public void user_set_valid_url_with_invalid_payload_program_is_not_available_on_server() {

		JSONObject body = new JSONObject();
		body.put("programName", "jan23SDET1");
		body.put("programDescription", "TestingBatch");
		body.put("programStatus", "Inactive");
		body.put("creationTime", cd.getCurrentDate());
		body.put("lastModTime", cd.getCurrentDate());

		// request =RestAssured.given().contentType("application/json").body(body);
		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);

	}
	
	@When("User send put request by program id not on server")
	public void user_send_put_request_by_program_id_not_on_server() {
		this.uri = Config.BASE_URL + Config.ProgramId_NotOnServer;
		response = this.request.when().put(this.uri);
	}

	@Then("Program with id not found error message should be displayed with {int} bad request status code")
	public void program_with_id_not_found_error_message_should_be_displayed_with_bad_request_status_code(Integer int1) {
		int statusCode = this.response.getStatusCode();
		Assert.assertEquals(400, statusCode);
	}

	//<---------Scenario 6: Verify put request by program name for non existing data on server-------->
	@Given("User set valid URL with invalid Payload for non existing data by program name")
	public void user_set_valid_url_with_invalid_payload_for_non_existing_data_by_program_name() {

		//this.uri = Config.BASE_URL + Config.InValidEndPoint_ProgramName;

		JSONObject body = new JSONObject();
		body.put("programName", "jan23SDET1");
		body.put("programDescription", "TestingBatch");
		body.put("programStatus", "Inactive");
		body.put("creationTime", cd.getCurrentDate());
		body.put("lastModTime", cd.getCurrentDate());

		// request =RestAssured.given().contentType("application/json").body(body);
		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);

	}
	
	@When("User send put request by program name")
	public void user_send_put_request_by_program_name() {
		this.uri = Config.BASE_URL + Config.InValidEndPoint_ProgramName;
		response = this.request.when().put(this.uri);
	}

	@Then("Program name not found error message should be displayed with {int} bad request status code")
	public void program_name_not_found_error_message_should_be_displayed_with_bad_request_status_code(Integer int1) {
		int statusCode = this.response.getStatusCode();
		Assert.assertEquals(400, statusCode);
	}

	//<---------Scenario 7 : Verify put request by Program id with Program Id details in payload-------->
	@Given("User set Valid URL with valid program id")
	public void user_set_valid_url_with_valid_program_id() {
		//this.uri = Config.BASE_URL + Config.Valid_Endpoint_PutProgram;

		JSONObject body = new JSONObject();
		body.put("programId",4421);
		body.put("programName", "jan23SDET1");
		body.put("programDescription", "TestingBatch");
		body.put("programStatus", "Inactive");
		body.put("creationTime", cd.getCurrentDate());
		body.put("lastModTime", cd.getCurrentDate());

		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);
	}
	
	@When("User send put request by programId")
	public void user_send_put_request_by_programId() {
		this.uri = Config.BASE_URL + Config.Valid_Endpoint_PutProgram;
		response = this.request.when().put(this.uri);
	}
	
	@Then("Request should be successfull by program id with status code {int}")
	public void request_should_be_successfull_by_program_id_with_status_code(Integer int1) {
		int statusCode = this.response.getStatusCode();
		Assert.assertEquals(200, statusCode);
	}
	

	
	//<---------Scenario 8 : Verify put request by program id to update program details without Program description-------->
	@Given("User set put request by providing program id, payload without program description")
	public void user_set_put_request_by_providing_program_id_payload_without_program_description() {

		//this.uri = Config.BASE_URL + Config.Valid_Endpoint_PutProgram;

		JSONObject body = new JSONObject();
		body.put("programId",4421);
		body.put("programName", "jan23SDET1");
		body.put("programStatus", "Inactive");
		body.put("creationTime", cd.getCurrentDate());
		body.put("lastModTime", cd.getCurrentDate());
		System.out.println(body);
		// request =RestAssured.given().contentType("application/json").body(body);
		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);

	}
	
	@When("User send put request by proid")
	public void user_send_put_request_by_proid() {
		this.uri = Config.BASE_URL + Config.Valid_Endpoint_PutProgram;
		response = this.request.when().put(this.uri);
	}
	

	@Then("Program should be created with null value for program description with status code {int}")
	public void program_should_be_created_with_null_value_for_program_description_with_status_code(Integer int1) {
		int statusCode = this.response.getStatusCode();
		Assert.assertEquals(200, statusCode);
	}

	//<---------Scenario 9 : Verify put request by program name to update program details without Program description-------->
	@Given("User set put request by providing program name, payload without program description")
	public void user_set_put_request_by_providing_program_name_payload_without_program_description() {
		//this.uri = Config.BASE_URL + Config.ValidEndPoint_ProgramName;

		JSONObject body = new JSONObject();
		body.put("programId",4421);
		body.put("programName", "jan23SDET1");
		body.put("programStatus", "Inactive");
		body.put("creationTime", cd.getCurrentDate());
		body.put("lastModTime", cd.getCurrentDate());
		System.out.println(body);

		// request =RestAssured.given().contentType("application/json").body(body);
		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);
	}

	
	@When("User send put request by proname")
	public void user_send_put_request_by_proname() {
		this.uri = Config.BASE_URL + Config.ValidEndPoint_ProgramName;
		response = this.request.when().put(this.uri);
	}
	
	@Then("Program should be created with null value for program description with status code {int} by name")
	public void program_should_be_created_with_null_value_for_program_description_with_status_code_by_name(Integer int1) {
		int statusCode = this.response.getStatusCode();
		Assert.assertEquals(200, statusCode);
	}
	 
	//<---------Scenario 10 : Verify put request by Program Name to update program description-------->
	@Given("User set put request with program name, updated Description")
	public void user_set_put_request_with_program_name_updated_description() {
		//this.uri = Config.BASE_URL + Config.ValidEndPoint_ProgramName;

		JSONObject body = new JSONObject();
		body.put("programName", "jan23SDET1");
		body.put("programDescription", "updatedDescription");
		body.put("programStatus", "Inactive");
		body.put("creationTime", "2023-01-14T01:57:46.503+00:00");
		body.put("lastModTime", cd.getCurrentDate());
		System.out.println(body);

		// request =RestAssured.given().contentType("application/json").body(body);
		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);
	}
	
	@When("User send put request with description by program name")
	public void user_send_put_request_with_description_by_program_name() {
		this.uri = Config.BASE_URL + Config.ValidEndPoint_ProgramName;
		response = this.request.when().put(this.uri);
	}
	

	@Then("Program details should be updated with updated description and {int} status code should be displayed")
	public void program_details_should_be_updated_with_updated_description_and_status_code_should_be_displayed(
			Integer int1) {
		int statusCode = this.response.getStatusCode();
		Assert.assertEquals(200, statusCode);
	}
	
	
	//<------scenario :Verify put request by Program id to update program description--------->
	@Given("User set put request with program id, updated Description")
	public void user_set_put_request_with_program_id_updated_description() {
		
		JSONObject body = new JSONObject();
		body.put("programId",4421);
		body.put("programName", "jan23SDET1");
		body.put("programDescription", "updatedDescription");
		body.put("programStatus", "Inactive");
		body.put("creationTime", "2023-01-14T01:57:46.503+00:00");
		body.put("lastModTime", cd.getCurrentDate());
		System.out.println(body);

		// request =RestAssured.given().contentType("application/json").body(body);
		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);
	}
	
	@When("User send put request with description by program id")
	public void user_send_put_request_with_description_by_program_id() {
		this.uri = Config.BASE_URL + Config.Valid_Endpoint_PutProgram;
		response = this.request.when().put(this.uri);
	}
	
	@Then("Program details should be updated with updated description, {int} status code should be displayed")
	public void program_details_should_be_updated_with_updated_description_status_code_should_be_displayed(Integer int1) {
		int statusCode = this.response.getStatusCode();
		Assert.assertEquals(200, statusCode);
	}

	

	//<---------Scenario 11 :  Verify put request by program id to update program status-------->
	@Given("User set put request with program id , updated status")
	public void user_set_put_request_with_program_id_updated_status() {
		//this.uri = Config.BASE_URL + Config.Valid_Endpoint_PutProgram;

		JSONObject body = new JSONObject();
		body.put("programId",4421);
		body.put("programName", "jan23SDET1");
		body.put("programDescription", "updatedDescription");
		body.put("programStatus", "UpdatedStatusById");
		body.put("creationTime", "2023-01-14T01:57:46.503+00:00");
		body.put("lastModTime", cd.getCurrentDate());
		System.out.println(body);

		// request =RestAssured.given().contentType("application/json").body(body);
		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);
	}

	@When("User send put request with status by program id")
	public void user_send_put_request_with_status_by_program_id() {
		this.uri = Config.BASE_URL + Config.Valid_Endpoint_PutProgram;
		response = this.request.when().put(this.uri);
	}
	
	
	@Then("Program status should be updated with status code {int}")
	public void program_status_should_be_updated_with_status_code(Integer int1) {
		int statusCode = this.response.getStatusCode();
		Assert.assertEquals(200, statusCode);
		
	}

	//<---------Scenario 12 :  Verify put request by program name to update program status-------->
	@Given("User set put request with program name, updated status")
	public void user_set_put_request_with_program_name_updated_status() {
		
		//this.uri = Config.BASE_URL + Config.ValidEndPoint_ProgramName;

		JSONObject body = new JSONObject();
		body.put("programName", "jan23SDET1");
		body.put("programDescription", "updatedDescription");
		body.put("programStatus", "UpdatedStatusTo-Active");
		body.put("creationTime", "2023-01-14T01:57:46.503+00:00");
		body.put("lastModTime", cd.getCurrentDate());
		System.out.println(body);

		// request =RestAssured.given().contentType("application/json").body(body);
		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);
	}
	
	@When("User send put request with status by program name")
	public void user_send_put_request_with_status_by_program_name() {
		this.uri = Config.BASE_URL + Config.ValidEndPoint_ProgramName;
		response = this.request.when().put(this.uri);
	}
	
	
	@Then("Updated status should be displayed with status code {int}")
	public void updated_status_should_be_displayed_with_status_code(Integer int1) {
		int statusCode = this.response.getStatusCode();
		Assert.assertEquals(200, statusCode);
		
	}

	//<---------Scenario  13: Verify put request by program id to update program created time-------->
	@Given("User set put request with program id , updated created time")
	public void user_set_put_request_with_program_id_updated_created_time() {
		//this.uri = Config.BASE_URL + Config.Valid_Endpoint_PutProgram;

		JSONObject body = new JSONObject();
		body.put("programId",4421);
		body.put("programName", "jan23SDET1");
		body.put("programDescription", "updatedDescription");
		body.put("programStatus", "UpdatedStatusById");
		body.put("creationTime", cd.getCurrentDate());
		body.put("lastModTime", cd.getCurrentDate());
		System.out.println(body);

		// request =RestAssured.given().contentType("application/json").body(body);
		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);
	}

	@When("User send put request with creationTime by program id")
	public void user_send_put_request_with_creationTime_by_program_id() {
		this.uri = Config.BASE_URL + Config.Valid_Endpoint_PutProgram;
		response = this.request.when().put(this.uri);
	}
	
	
	@Then("Program created time should be updated with status code {int}")
	public void program_created_time_should_be_updated_with_status_code(Integer int1) {
		int statusCode = this.response.getStatusCode();
		Assert.assertEquals(200, statusCode);
	}

	//<---------Scenario 14: Verify put request by Program id to update program mode time-------->
	@Given("User set put request with program id, updated mode time")
	public void user_set_put_request_with_program_id_updated_mode_time() {
		//this.uri = Config.BASE_URL + Config.Valid_Endpoint_PutProgram;

		JSONObject body = new JSONObject();
		body.put("programId",4421);
		body.put("programName", "jan23SDET1");
		body.put("programDescription", "updatedDescription");
		body.put("programStatus", "UpdatedStatusById");
		body.put("creationTime", cd.getCurrentDate());
		body.put("lastModTime", cd.getCurrentDate());
		System.out.println(body);

		// request =RestAssured.given().contentType("application/json").body(body);
		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);
	}

	@When("User send put request with modeTime by program id")
	public void user_send_put_request_with_modeTime_by_program_id() {
		this.uri = Config.BASE_URL + Config.Valid_Endpoint_PutProgram;
		response = this.request.when().put(this.uri);
	}
	
	@Then("Program last modified time should be updated with status code {int}")
	public void program_last_modified_time_should_be_updated_with_status_code(Integer int1) {
		int statusCode = this.response.getStatusCode();
		Assert.assertEquals(200, statusCode);
	}

	//<---------Scenario 15: Verify put request by program name to update program mode time-------->
	@Given("User set put request with program name, updated mode time")
	public void user_set_put_request_with_program_name_updated_mode_time() {
		//this.uri = Config.BASE_URL + Config.ValidEndPoint_ProgramName;

		JSONObject body = new JSONObject();
		body.put("programName", "jan23SDET1");
		body.put("programDescription", "updatedDescription");
		body.put("programStatus", "UpdatedStatusById");
		body.put("creationTime", "2023-08-07T04:13:00.000+00:00");
		body.put("lastModTime", cd.getCurrentDate());
		System.out.println(body);

		// request =RestAssured.given().contentType("application/json").body(body);
		this.request = RestAssured.given().header("Content-Type", "application/json").body(body);
	}
	
	@When("User send put request with modeTime by program name")
	public void user_send_put_request_with_modeTime_by_program_name() {
		//this.uri = Config.BASE_URL + Config.ValidEndPoint_ProgramName;
		response = this.request.when().put("https://lms-backend-service.herokuapp.com/lms/program/jan23SDET1");
	}
	
	@Then("Program last mod time should be updated with status code {int}")
	public void program_last_mod_time_should_be_updated_with_status_code(Integer int1) {
		int statusCode = this.response.getStatusCode();
		Assert.assertEquals(200, statusCode);
	}

	
}