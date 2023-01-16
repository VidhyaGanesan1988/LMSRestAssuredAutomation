Feature: ProgramPut Method

Scenario: Verify put request by providing invalid URL
Given User set invalid URL with valid request body 
When User send put request 
Then Service unavailable error message should be displayed with 503 status code

Scenario: Verify put request by providing invalid endpoint
Given User set put request with valid request body  
When User send put request with invalid endpoint
Then Not found error message should be displayed with 404 status code

Scenario: Verify put request by providing programID as endpoint with Empty payload
Given User set Valid URL with empty request body 
When User send put request by program id
Then Bad request error message should be displayed with 400 status code

Scenario: Verify put request by program id for already existing data
Given User set valid URL with valid Payload 
When User send put request with valid URL
Then Request should be successfull with status code 200

Scenario: Verify put request by program id for non existing data on server
Given User set valid URL with invalid Payload (Program is not available on server) 
When User send put request by program id not on server
Then Program with id not found error message should be displayed with 400 bad request status code

Scenario: Verify put request by program name for non existing data on server
Given User set valid URL with invalid Payload (Program is not available on server)
When User send put request by program name
Then Program name not found error message should be displayed with 400 bad request status code

Scenario: Verify put request by Program id with Program Id details in payload
Given User set Valid URL with valid program id
When User send put request by programId
Then Request should be successfull by program id with status code 200


Scenario: Verify put request by program id to update program details without Program description
Given User set put request by providing program id, payload without program description
When User send put request by proid
Then Program should be created with null value for program description with status code 200

Scenario: Verify put request by program name to update program details without Program description
Given User set put request by providing program name, payload without program description
When User send put request by proname
Then Program should be created with null value for program description with status code 200 by name

Scenario: Verify put request by Program Name to update program description
Given User set put request with program name, updated Description
When User send put request with description by program name 
Then Program details should be updated with updated description and 200 status code should be displayed

Scenario: Verify put request by Program id to update program description
Given User set put request with program id, updated Description
When User send put request with description by program id 
Then Program details should be updated with updated description, 200 status code should be displayed

Scenario: Verify put request by program id to update program status
Given User set put request with program id , updated status
When User send put request with status by program id
Then Program status should be updated with status code 200

Scenario: Verify put request by program name to update program status
Given User set put request with program name, updated status
When User send put request with status by program name 
Then Updated status should be displayed with status code 200

Scenario: Verify put request by program id to update program created time
Given User set put request with program id , updated created time
When User send put request with creationTime by program id 
Then Program created time should be updated with status code 200

Scenario: Verify put request by Program id to update program mode time
Given User set put request with program id, updated mode time
When User send put request with modeTime by program id 
Then Program last modified time should be updated with status code 200

Scenario: Verify put request by program name to update program mode time
Given User set put request with program name, updated mode time
When User send put request with modeTime by program name
Then Program last mod time should be updated with status code 200



