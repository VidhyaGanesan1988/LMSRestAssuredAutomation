@Batch
Feature: Batch-POST Feature
	
  @Batch_Post_001	
  Scenario Outline: Verify POST request to post data into branch with valid base URL  and  valid data
    Given User sets request for Batch module with valid base URL and valid request body
    When User sends POST request for branch with valid URL and data from "<SheetName>" and <Rownumber>
    Then Request should be successfull with status code "201" Post request valid URL
    
    Examples: 
      | SheetName            | Rownumber |
      | PostValidDataBatch       |     0     |   
    
    @Batch_Post_002  
   Scenario Outline: Verify POST request to post data into branch with invalid base URL  and  valid data
    Given User sets request for Batch module with invalid base URL and valid request body
    When User sends POST request for branch with invalid URL and data from "<SheetName>" and <Rownumber>
    Then Bad request error message should be displayed with status code "405" for Post request with invalid URL
    
Examples: 
      | SheetName              | Rownumber |
      | PostValidDataBatch       |     0     |   
    
    @Batch_Post_003  
    Scenario: Verify POST request to post data into branch with valid base URL  and empty data
    	Given User sets request for Batch module with valid base URL and empty request body
    	When User sends POST request for branch with empty request body
    	Then Bad request error message should be displayed with status code "415" for Post request with empty request body

    @Batch_Post_004
    Scenario Outline: Verify POST request to post data into branch with valid base URL  and  invalid data
    Given User sets request for Batch module with valid base URL and invalid data
    When User sends POST request without Batch Name parameter in request body from "<SheetName>" and <Rownumber>
    Then Bad Request error message should be displayed with status code "400"
    
Examples: 
      | SheetName     | Rownumber |
      | NobatchName   |     0     |	
      
    @Batch_Post_005
    Scenario Outline: Verify POST request to post data into branch with valid base URL  and invalid data
    	Given User sets request for Batch module with valid base URL and invalid data
    	When User sends POST request with empty String value for batch name parameter in request body from "<SheetName>" and <Rownumber>
    	Then Bad request error message should be displayed with status code "400" invalid data
    
    Examples: 
      | SheetName     | Rownumber |
      | PostInvalidDataBatch   |     0     |		
 #       Throwing Java Null Pointer Exception     
#      @Batch_Post_006
#      Scenario Outline: Verify POST request to post data into branch with valid base URL  and invalid data
#		Given User sets request for Batch module with valid base URL and invalid data
#    When User sends POST request with null value for Batch Name parameter from "<SheetName>" and <Rownumber>
#    Then Bad request error message should be displayed with status code "400" 
#    
#Examples: 
#      | SheetName       | Rownumber |
#      | PostInvalidDataBatch   |     1     |
      
      @Batch_Post_007
      Scenario Outline: Verify POST request to post data into branch with valid base URL  and invalid data
		Given User sets request for Batch module with valid base URL and invalid data
    When User sends POST request without Batch Description parameter from "<SheetName>" and <Rownumber>
    Then Request should be successfull with status code "201" Post request
    
Examples: 
      | SheetName           | Rownumber |
      | NoBatchDescription  |     0     |
      
      @Batch_Post_008     
Scenario Outline: Verify POST request to post data into branch with valid base URL  and invalid data
    Given User sets request for Batch module with valid base URL and invalid data
    When User sends POST request with empty String value for batch description parameter from "<SheetName>" and <Rownumber>
    Then Request should be successfull with status code "201" Post request
    
    Examples: 
      | SheetName       | Rownumber |
      | PostInvalidDataBatch   |     2     |
      
      @Batch_Post_009    
Scenario Outline: Verify POST request to post data into branch with valid base URL  and invalid data
		Given User sets request for Batch module with valid base URL and invalid data
    When User sends POST request with null value for Batch Description parameter from "<SheetName>" and <Rownumber>
    Then Request should be successfull with status code "201" Post request
    
    Examples: 
      | SheetName       | Rownumber |
      | PostInvalidDataBatch   |     3     |
       
      @Batch_Post_010      
Scenario Outline: Verify POST request to post data into branch with valid base URL  and invalid data
	Given User sets request for Batch module with valid base URL and invalid data
    When User sends POST request without Batch Status parameter from "<SheetName>" and <Rownumber>
    Then Bad Request error message should be displayed with status code "400"
    
Examples: 
      | SheetName           | Rownumber |
      | NoBatchStatus  |     0     |
      
      @Batch_Post_011      
Scenario Outline: Verify POST request to post data into branch with valid base URL  and invalid data
    Given User sets request for Batch module with valid base URL and invalid data
    When User sends POST request with empty String value for batch status parameter from "<SheetName>" and <Rownumber>
    Then Bad Request error message should be displayed with status code "400"

    Examples: 
      | SheetName       | Rownumber |
      | PostInvalidDataBatch   |     4     |
 #Supposed to throw error but taking null as string     
      @Batch_Post_012    
Scenario Outline: Verify POST request to post data into branch with valid base URL  and invalid data
	Given User sets request for Batch module with valid base URL and invalid data
    When User sends POST request with null value for Batch Status parameter from "<SheetName>" and <Rownumber>
    Then Bad Request error message should be displayed with status code "400"
    
Examples: 
      | SheetName              | Rownumber |
      | PostInvalidDataBatch   |     5     |
#    
@Batch_Post_013      
      Scenario Outline: Verify POST request to post data into branch with valid base URL  and invalid data
		Given User sets request for Batch module with valid base URL and invalid data
    When User sends POST request without Batch Noofclasses parameter from "<SheetName>" and <Rownumber>
    Then Bad Request error message should be displayed with status code "400"
    
Examples: 
      | SheetName           | Rownumber |
      | NoBatchClasses  |     0     |
  #       Throwing Java Null Pointer Exception        
      @Batch_Post_014      
Scenario Outline: Verify POST request to post data into branch with valid base URL  and invalid data
    Given User sets request for Batch module with valid base URL and invalid data
    When User sends POST request with empty String value for batch classes parameter from "<SheetName>" and <Rownumber>
    Then Bad Request error message should be displayed with status code "400" 
	
Examples: 
      | SheetName              | Rownumber |
      | PostInvalidDataBatch   |     6     |
      
      @Batch_Post_015    
Scenario Outline: Verify POST request to post data into branch with valid base URL  and invalid data
		Given User sets request for Batch module with valid base URL and invalid data
    When User sends POST request with null value for Batch Classes parameter from "<SheetName>" and <Rownumber>
    Then Bad Request error message should be displayed with status code "400" 
    
Examples: 
      | SheetName              | Rownumber |
      | PostInvalidDataBatch   |     7     |
      
      @Batch_Post_016      
Scenario Outline: Verify POST request to post data into branch with valid base URL  and invalid data
		Given User sets request for Batch module with valid base URL and invalid data
    When User sends POST request with negative value for Batch Classes parameter from "<SheetName>" and <Rownumber>
    Then Bad Request error message should be displayed with status code "400"
    
Examples: 
      | SheetName              | Rownumber |
      | PostInvalidDataBatch   |     8     |  
      
   
    @Batch_Post_017      
Scenario Outline: Verify POST request to post data into branch with valid base URL  and invalid data
		Given User sets request for Batch module with valid base URL and invalid data
    When User sends POST request without program ID parameter from "<SheetName>" and <Rownumber>
    Then Bad Request error message should be displayed with status code "400"
    
Examples: 
      | SheetName           | Rownumber |
      | NoProgramId  |     0     |
  #       Throwing Java Null Pointer Exception      
     @Batch_Post_018      
Scenario Outline: Verify POST request to post data into branch with valid base URL  and invalid data
    Given User sets request for Batch module with valid base URL and invalid data
    When User sends POST request with numbers in string format for Program Id parameter from "<SheetName>" and <Rownumber>
    Then Bad Request error message should be displayed with status code "400"

Examples: 
      | SheetName              | Rownumber |
      | PostInvalidDataBatch   |     9     |        
      
      @Batch_Post_019    
Scenario Outline: Verify POST request to post data into branch with valid base URL  and invalid data
	Given User sets request for Batch module with valid base URL and invalid data
    When User sends POST request without value for Program Id parameter from "<SheetName>" and <Rownumber>
    Then Bad Request error message should be displayed with status code "400"
    
Examples: 
      | SheetName     | Rownumber |
      | PostInvalidDataBatch   |     10     |
      
        @Batch_Post_020      
Scenario Outline: Verify POST request to post data into branch with valid base URL  and invalid data
		Given User sets request for Batch module with valid base URL and invalid data
    When User sends POST request with negative value for Program ID parameter from "<SheetName>" and <Rownumber>
    Then Bad Request error message should be displayed with status code "400"
    
Examples: 
      | SheetName              | Rownumber |
      | PostInvalidDataBatch   |     11     | 
      
      @Batch_Post_021      
Scenario Outline: Verify POST request to post data into branch with valid base URL  and invalid data
		Given User sets request for Batch module with valid base URL and invalid data
    When User sends POST request with null value for Program ID parameter from "<SheetName>" and <Rownumber>
    Then Bad Request error message should be displayed with status code "400"
    
Examples: 
      | SheetName              | Rownumber |
      | PostInvalidDataBatch   |     12     |
      
        @Batch_Post_022      
Scenario Outline: Verify POST request to post data into branch with valid base URL  and invalid data
		Given User sets request for Batch module with valid base URL and invalid data
    When User sends POST request with special characters for Program ID parameter from "<SheetName>" and <Rownumber>
    Then Bad Request error message should be displayed with status code "400"
    
Examples: 
      | SheetName              | Rownumber |
      | PostInvalidDataBatch   |     12     | 
      
        @Batch_Post_023      
Scenario Outline: Verify POST request to post data into branch with valid base URL  and invalid data
		Given User sets request for Batch module with valid base URL and invalid data
    When User sends POST request without program Name parameter from "<SheetName>" and <Rownumber>
    Then Request should be successfull with status code "201" Post request
    
Examples: 
      | SheetName           | Rownumber |
      | PostValidDataBatch  |     0     |
      
        @Batch_Post_024      
Scenario Outline: Verify POST request to post data into branch with valid base URL  and invalid data
		Given User sets request for Batch module with valid base URL and invalid data
    When User sends POST request without value for program Name parameter from "<SheetName>" and <Rownumber>
    Then Request should be successfull with status code "201" Post request
    
Examples: 
      | SheetName           | Rownumber |
      | PostValidDataBatch  |     0     |
	  
	  @Batch_Post_025      
Scenario Outline: Verify POST request to post data into branch with valid base URL  and invalid data
		Given User sets request for Batch module with valid base URL and invalid data
    When User sends POST request with null value for program Name parameter from "<SheetName>" and <Rownumber>
    Then Request should be successfull with status code "201" Post request
    
Examples: 
      | SheetName           | Rownumber |
      | PostValidDataBatch  |     1     |
	  
	  @Batch_Post_026      
Scenario Outline: Verify POST request to post data into branch with valid base URL  and invalid data
		Given User sets request for Batch module with valid base URL and invalid data
    When User sends POST request with special characters for program Name parameter from "<SheetName>" and <Rownumber>
    Then Request should be successfull with status code "201" Post request
    
Examples: 
      | SheetName           | Rownumber |
      | PostValidDataBatch  |     2     |