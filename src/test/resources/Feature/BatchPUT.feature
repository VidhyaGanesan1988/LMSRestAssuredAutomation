#Author: Sapna

Feature: Branch Put Method

Scenario: Verify put request for batch by providing invalid URL
Given User set put request with valid request body for batch
When User send put request with invalid URL
Then Server unavailable error message should be displayed with 503 status code


Scenario: Verify put request by providing invalid endpoint
Given User set put request with valid payload
When User send put request with invalid endpoint for batch
Then Not found validation error message should be displayed with 404 status code


Scenario: Verify put request by providing batchId as endpoint with Empty payload
Given User set put request with empty request body
When User send put request with Valid URL
Then Bad request error message should be displayed with 400 status code for batch


Scenario: Verify put request by Batch Id for already existing data
Given User set put request with valid Payload for Existing data
When User send put request for batch
Then Request should be successfull with status code 200 for batch


Scenario: Verify put request by Batch Id for non existing data on server
Given User set put request with invalid Payload (batch details is not available on server)
When User send request with Valid batch URL
Then "batch with id not found" error message should be displayed with 400 bad request status code


Scenario: Verify put request by Batch Id with Batch Id details in payload
Given User set put request with valid batch id
When User requested put request with Valid URL
Then Request should be successfull by having status code 200


Scenario: Verify put request by Batch Id and payload without Batch Id
Given User set Valid URL without batch id 
When User send put request along with valid url
Then successfull message should be displayed by having status code 200


Scenario: Verify put request by Batch Id to update batch details without batch description
Given User set put request without batch description
When User requested put, with Valid URL
Then Batch should be created with null value for program description with status code 200


Scenario: Verify put request by batch id to update batch Name
Given User set put request with updated Name
When User send put request to update batch name
Then Batch details should be updated with updated name, 200 status code should be displayed


Scenario: Verify put request by batch id to update batch description
Given User set put request with updated Description
When User send put request to update batch description
Then Response body should be have updated description and 200 status code should be displayed


Scenario: Verify put request by batch  id to update batch status
Given User set put request with updated status
When User send put request to update batch status
Then batch status should be updated with status code 200


Scenario: Verify put request by batch id to update No of classes
Given User set put request with updated No of classes
When  User send put request to update No of classes
Then batch No of classes should be updated with status code 200

Scenario: Verify put request by batch id to update program id
Given User set put request with updated Program id 
When  User send put request to update program id
Then Program id should be updated with status code 200


Scenario: Verify put request by batch id to update program name
Given User set put request with updated Program name
When User send put request to update program name
Then Program name should be updated with status code 200


Scenario: Verify put request by Batch Id to update batch details without batch Name
Given User set put request with valid payload except batch name
When User send put request to update batch details
Then Validation error should be displayed with 400 bad request


Scenario: Verify put request by Batch Id to update batch details without batch status
Given User set put request with valid payload except batch status
When User send put request to check without batch status
Then Error "batch status is needed" should be displayed with 400 bad request

Scenario: Verify put request by Batch Id to update batch details without batch No of classes
Given User set put request with valid payload except batch no of classes
When User send put request to check without no of classes
Then Validation error  No of Classes is needed; It should be a positive number  should be displayed with 400 bad request

Scenario: Verify put request by Batch Id to update batch details without Program id
Given User set put request with valid payload except Program id
When User send put request to check without Program id
Then " ProgramId field is needed; It should be a positive number " error message should be displayed with 400 bad request

Scenario: Verify put request by Batch Id to update batch details without  program name
Given User set put request with valid payload except Program name
When User send put request to check without Program name
Then error message should be dsiplayed with status code 400 bad request

Scenario: Verify put request by Batch Id to update batch details with empty Program id
Given User set put request with valid payload, Program id is empty
When User send put request to check with empty program id
Then Validation "error ProgramId field is needed; It should be a positive number" message should be displayed with 400 bad request.


