$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Feature/Manager.feature");
formatter.feature({
  "name": "Manager functionalities",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "Launch the browser",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "User Launch Chrome Browser",
  "keyword": "Given "
});
formatter.match({
  "location": "MeerQATS_Cucumber.StepDefinitions.Step.User_Launch_Chrome_Browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enter the the MeerQATS login page",
  "keyword": "When "
});
formatter.match({
  "location": "MeerQATS_Cucumber.StepDefinitions.Step.User_enter_the_the_MeerQATS_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "After Verifying login page title",
  "keyword": "And "
});
formatter.match({
  "location": "MeerQATS_Cucumber.StepDefinitions.Step.After_Verifying_login_page_title()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Manager enters Username and Password and click login",
  "keyword": "And "
});
formatter.match({
  "location": "MeerQATS_Cucumber.StepDefinitions.Step.Manager_enters_Username_and_Password_and_click_login()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enter MeerQATS HomePage",
  "keyword": "Then "
});
formatter.match({
  "location": "MeerQATS_Cucumber.StepDefinitions.Step.User_enter_MeerQATS_HomePage()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Create Review Cases and assign to Reviewer",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Fourth"
    }
  ]
});
formatter.step({
  "name": "User Clicks Create QA Review",
  "keyword": "When "
});
formatter.match({
  "location": "MeerQATS_Cucumber.StepDefinitions.Step.User_Clicks_Create_QA_Review()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "After clicking on Create Manual Case",
  "keyword": "And "
});
formatter.match({
  "location": "MeerQATS_Cucumber.StepDefinitions.Step.After_clicking_on_Create_Manual_Case()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "After entering Manual Case fields user clicks on create case",
  "keyword": "And "
});
formatter.match({
  "location": "MeerQATS_Cucumber.StepDefinitions.Step.After_entering_Manual_Case_fields_user_clicks_on_create_case()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});