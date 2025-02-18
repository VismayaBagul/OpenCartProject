
Feature: Login

Background: common steps for login
Given opens URL "https://demo.opencart.com.gr/"

    When Go to login option
    
		Then Login page should be open
		
		Scenario Outline: To check login functionality with Invalid data
  
    When Enter email as "<emailAddress>"
    And Enter password as "<password>" 
    And Click on Login 
    Then Login should not be successful

    Examples: 
      | emailAddress | password  |
      | dbc@gmail.com  | abc@123 |
      | vyz@gmail.com  | xyz@123    |
		

  Scenario:To check login functionality with valid data
   
    When Enter valid email address and password
    And Click on Login 
    Then Login should be successful
   	And User should be logout


  