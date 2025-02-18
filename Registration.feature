
Feature: Registration
Background: common steps
Given opens URL "https://demo.opencart.com.gr/"

    When Go to register option
    
		Then Register page should be open
		
Scenario: To check functionality of Registration with mismatch password

	When Enter mandetory data with mismatch password

	And Click on Continue with password msg

	Then  User Should not register successfully


Scenario: To check functionality of Registration with unchecked privacy policy

	When Enter mandetory data without privacy policy

	And Click on Continue with privacy msg

	Then  User Should not register successfully


Scenario: To check functionality of Registration with missing mandetory field

	When Enter data without mandetory field

	And Click on Continue with error msg

	Then  User Should not register successfully

Scenario: To check functionality of Registration with already used email

	When Enter data with same email

	And Click on Continue with msg

	Then  User Should not register successfully

Scenario: Successfull Register with valid data

	When Enter mandetory data

	And Click on Continue

	And User Should register successfully
	
	Then User should logout 
