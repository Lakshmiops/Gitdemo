Feature: Login into Application

Scenario: Positive test validating login
Given Initialize the browser with chrome
And Navigate to Site
And Click on Login link in home page to land on Secure sign in Page
When User enters "john" and "123" and logs in
Then Verify that user is succesfully logged in 
And close browsers

