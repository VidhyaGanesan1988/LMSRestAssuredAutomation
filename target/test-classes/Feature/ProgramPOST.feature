Feature: Program-POST Requests

  Scenario Outline: Verify POST request to post data into program with valid base URL and valid data
    Given User sets request for Program module with valid base URL and valid request body
    When User sends POST request with data from "<SheetName>" and <Rownumber>
    Then Request should be successfull with status code "201" for POST request
    
    Examples: 
      | SheetName            | Rownumber |
      | postvaliddataprogram |     0     |
     
  Scenario Outline: Verify POST request to post data into program with invalid base URL and valid data
		Given User sets request for Program module with invalid base URL and valid request body
		When User sends POST request with invalid URL and data from "<SheetName>" and <Rownumber>
		Then  Bad request error message should be displayed with status code "404" for POST request with invalid URL
	
		Examples: 
      | SheetName            | Rownumber |
      | postvaliddataprogram |     1     |
      
   Scenario: Verify POST request to post data into program with valid URL and no data     
 			Given User sets request for Program module with valid base URL and empty request body
 			When User sends POST request with empty request body
 			Then Bad request error message should be displayed with status code "400" for POST request with empty request body
 	    
 	 Scenario: Verify POST request to post data into program with valid base URL and invalid data
 	 		Given User sets request for Program module with valid base URL and invalid data
 	 		When User sends POST request without programName parameter in request body 
 	 		Then Bad request error message should be displayed with status code "400"
 		
 	 Scenario: Verify POST request to post data into program with valid base URL and invalid data
 	 		Given User sets request for Program module with valid base URL and invalid data
 	 		When User sends POST request with null value for programName parameter in the request body	
 	 		Then Bad request error message should be displayed with status code "400" for null value in programName parameter

 	 		
 	 Scenario: Verify POST request to post data into program with valid base URL and invalid data
 	 		Given User sets request for Program module with valid base URL and invalid data 
 	 		When User sends POST request without programDescription parameter in the request body
 	 		Then Request should be successfull with status code "201" for no programDescription parameter
 	 	
 	 Scenario Outline: Verify POST request to post data into program with valid base URL and invalid data
 	 		Given User sets request for Program module with valid base URL and invalid data
 	 		When User sends POST request with null value for programDescription parameter from "<SheetName>" and <Rownumber>
 	 		Then Request should be successfull with status code "201"
 	 		
 	 		Examples: 
      | SheetName               | Rownumber |
      | RequestBodyInvalidData  |     1     |
 	 		      
    Scenario Outline: Verify POST request to post data into program with valid base URL and invalid data  
    	 Given User sets request for Program module with valid base URL and invalid data
    	 When User sends POST request without programStatus parameter from "<SheetName>" and <Rownumber>
    	 Then Bad request error message should be displayed with status code "400"
 	 		
 	 		Examples: 
      | SheetName            | Rownumber |
      | NoProgStaus          |     0     |
      
   Scenario Outline: Verify POST request to post data into program with valid base URL and invalid data  
    	 Given User sets request for Program module with valid base URL and invalid data
    	 When User sends POST request with null value for programStatus parameter from "<SheetName>" and <Rownumber>
    	 Then Bad request error message should be displayed with status code "400"
 	 		
 	 		Examples: 
      | SheetName                | Rownumber |
      | RequestBodyInvalidData   |     2     |
      
    Scenario: Verify POST request to post data into program with valid base URL and invalid data  
    	 Given User sets request for Program module with valid base URL and invalid data 
    	 When User sends POST request without creationTime parameter in the request body
    	 Then Bad request error message should be displayed with status code "400"
      
    Scenario: Verify POST request to post data into program with valid base URL and invalid data  
    	 Given User sets request for Program module with valid base URL and invalid data
    	 When User sends POST request without value for creationTime parameter in the request body
    	 Then Bad request error message should be displayed with status code "400"
     
     Scenario: Verify POST request to post data into program with valid base URL and invalid data  
    	 Given User sets request for Program module with valid base URL and invalid data
    	 When User sends POST request with creationTime parameter value as alphabets in the request body
    	 Then Bad request error message should be displayed with status code "400"
    	 
     Scenario: Verify POST request to post data into program with valid base URL and invalid data  
    	 Given User sets request for Program module with valid base URL and invalid data
    	 When User sends POST request with creationTime parameter value as special characters in the request body  
       Then Bad request error message should be displayed with status code "400"
    	 
     Scenario: Verify POST request to post data into program with valid base URL and invalid data  
    	 Given User sets request for Program module with valid base URL and invalid data
    	 When User sends POST request with creationTime parameter value as Date(yyyy-mm-dd) format in the request body  
       Then Request should be successfull with status code "201" for timestamp parameter in date format
     
     Scenario: Verify POST request to post data into program with valid base URL and invalid data 
       Given User sets request for Program module with valid base URL and invalid data
       When User sends POST request with lastMOdTime parameter value as numbers in the request body	 		
       Then Request should be successfull with status code "201"
      
   Scenario: Verify POST request to post data into program with valid base URL and invalid data 
       Given User sets request for Program module with valid base URL and invalid data
       When User sends POST request without lastModTime parameter in the request body 
       Then Bad request error message should be displayed with status code "400"
    	
    Scenario: Verify POST request to post data into program with valid base URL and invalid data 
       Given User sets request for Program module with valid base URL and invalid data
       When User sends POST request with lastModTime parameter value as empty string in the request body
       Then Bad request error message should be displayed with status code "400"
           
     Scenario: Verify POST request to post data into program with valid base URL and invalid data 
       Given User sets request for Program module with valid base URL and invalid data
       When User sends POST requestwith lastModTime parameter value as alphabets in the request body
       Then Bad request error message should be displayed with status code "400" 
     
     Scenario: Verify POST request to post data into program with valid base URL and invalid data 
       Given User sets request for Program module with valid base URL and invalid data
       When User sends POST requestwith lastModTime parameter value as special characters in the request body
       Then Bad request error message should be displayed with status code "400"
      
     Scenario Outline: Verify POST request to post data into program with valid base URL and invalid data 
       Given User sets request for Program module with valid base URL and invalid data
       When User sends POST request with lastModTime parameter value as Date format from "<SheetName>" and <Rownumber>
       Then Request should be successfull with status code "201" for timestamp parameter in date format
        
        Examples: 
      | SheetName                | Rownumber |
      | LastModDateFormat        |     0     |   
 	 
 	     
 	 
 	 
 	 
 	 
 	 
 	 
 	 
 	 
 	 
 	 
 	 
 	 
 	 