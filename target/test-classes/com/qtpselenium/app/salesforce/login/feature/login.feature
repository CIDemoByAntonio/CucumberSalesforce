Feature: Loggin into salesforce

In order to work 
As a sales person
I want to login

Scenario: Logging in salesforce

Given I go to "produrl" on "browser"
And I enter my "loginusername" as "antonioseraus@digitaslbi.com"
And I enter "loginpassword" as "antonio seraus"
And I click on "loginButton"
Then login should be "success"
