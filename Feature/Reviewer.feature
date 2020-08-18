Feature: Reviewer functionalities

Background: Launch the browser
Given User Launch Chrome Browser
When User enter the the MeerQATS login page
And After Verifying login page title
And Reviewer enters Username and Password and click login
Then User enter MeerQATS HomePage

@First
Scenario: Login as Reviewer
Then User enter MeerQATS HomePage

@Second
Scenario: Create Review Cases 
When User Clicks Create Manual Case
And After entering Manual Case fields user clicks on create case
Then User clicks on create case

@Third
Scenario: Complete Questionnaire and send for Review
When User Clicks on My Work
And on Selecting a Review Case
Then After Completing the Questionnaire Click on Submit Review
