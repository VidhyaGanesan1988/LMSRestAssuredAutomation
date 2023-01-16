Feature: Program-Get Requests
@Get1
  Scenario: Verifying GET request to retrieve all program data in valid URL
    Given User sets request for Program module with valid base URL
    When User sends GET request 
    Then Request should be successfull with status code "200" for GET All programs
    
  Scenario: Verifying GET request to retrieve all program data with invalid URL
    Given User sets request for Program module with invalid base URL
    When User sends GET request with invalid URL
    Then Not found error message should be displayed with status code "404" for GET All programs
    
  Scenario Outline: Verifying GET request to retrieve single program data with valid program ID
  	Given User sets request for Program module with valid base URL and valid path
  	When User sends GET request with valid program ID from "<SheetName>" and <Rownumber> 
  	Then Request should be successfull with status code "200" for GET single program  
  	
  	Examples: 
      | SheetName        | Rownumber |
      | getsingleprogram |     0     |
      
  
  Scenario: Verifying GET request to retrieve single program data with invalid program ID
  	Given User sets request for Program module with valid base URL and invalid path
  	When User sends GET request with invalid program ID
  	Then Bad request error message should be displayed with status code "400" for GET single program
  	
  Scenario: Verifying GET request to retrieve single program data with invalid input
  	Given User sets request for Program module with valid base URL and invalid path
  	When User sends GET request with invalid input
    Then Bad request error message should be displayed with status code "400" for GET single program with invalid input
    
  