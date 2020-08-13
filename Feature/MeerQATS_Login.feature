Feature: User is able to login into application

Background: Launch the browser
Given User Launch Chrome Browser

@First
Scenario: Login as Admin
When User enter the the MeerQATS login page
And After Verifying login page title
And User enters Username and Password and click login
Then User enter MeerQATS HomePage

@Second
Scenario: Create Review Cases and assign to Reviewer
When User enter the the MeerQATS login page
And After Verifying login page title
And User enters Username and Password and click login
Then User enter MeerQATS HomePage
When User Clicks Create QA Review
And After selecting two review cases and click on Create Case
Then Go to Dashboard
And Assign newly created cases to Reviewer

@Third
Scenario: Complete Questionnaire and send for Review
When User enter the the MeerQATS login page
And After Verifying login page title
And User enters Username and Password and click login
Then User enter MeerQATS HomePage
When User Clicks on My Work
And on Selecting a Review Case
Then After Completing the Questionnaire Click on Submit Review
