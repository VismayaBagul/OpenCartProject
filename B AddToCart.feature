
Feature: Add To cart
  
Background: common steps for login
Given opens URL "https://demo.opencart.com.gr/"
    When Go to login option
		Then Login page should be open
		When Enter valid email address and password
    And Click on Login 
    Then Login should be successful

 Scenario: To check functionality of Add to cart
    When Click on Desktop 
    And Click on mac 
    And Click on imac 
    And Click on Add to Cart
    Then succecc msg will be displayed
    And User should be logout
    
  Scenario: To check availbility of product in shopping cart
  	When click on shopping cart
  	And check the product is same which was added to the cart
  	And Click on Checkout 
  #	And Enter mandetory checkout details
  	And Enter shipping details
  	And Enter Payment details 
  	And Click on Confirm Order
  	Then Order Confirmation msg
    And User should be logout
