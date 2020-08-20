package MeerQATS_Cucumber.StepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import com.qats.page.Create_QAReview_ManualCase;
import com.qats.page.MyWork;
import com.qats.page.QATS_HomePage;
import com.qats.page.QATS_LoginPage;
import com.qats.page.Util;

import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class Step {
	Actions act;
	WebDriver driver;

	Properties prop;

	Create_QAReview_ManualCase createcase;

	QATS_LoginPage loginpage;
	QATS_HomePage homepage;
	MyWork mywork;
	Util util;

	@Given("User Launch Chrome Browser")
	public void User_Launch_Chrome_Browser() throws IOException {

		FileInputStream ip = new FileInputStream("D:\\Users/VermaC/Workspace1/MeerQATS_Cucumber_POM/Config.Properties");
		prop = new Properties();

		prop.load(ip);

		System.setProperty("webdriver.chrome.driver",
				"D:\\Users/VermaC/Workspace1/MeerQATS_Cucumber_POM/Drivers/chromedriver.exe");
		/* Launching the browser? */
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		util = new Util(driver);

	}

	@When("User enter the the MeerQATS login page")
	public void User_enter_the_the_MeerQATS_login_page() {

		driver.get("https://pega-orp-qa-11.ad.moodys.net:8443/prweb/PRServlet/");

	}

	@When("After Verifying login page title")
	public void After_Verifying_login_page_title() {
		loginpage = new QATS_LoginPage(driver);

		String title = loginpage.LoginPageTitle();
		System.out.println(title);
	}

	@When("Manager enters Username and Password and click login")
	public void Manager_enters_Username_and_Password_and_click_login() throws InterruptedException, IOException {

		homepage = loginpage.Login(prop.getProperty("ManagerUserName"), prop.getProperty("ManagerPassword"));

		Thread.sleep(4000);

	}

	@When("Reviewer enters Username and Password and click login")
	public void Reviewer_enters_Username_and_Password_and_click_login() throws InterruptedException, IOException {

		homepage = loginpage.Login(prop.getProperty("ReviewerUserName"), prop.getProperty("ReviewerPassword"));

		Thread.sleep(4000);

	}

	@Then("User enter MeerQATS HomePage")
	public void User_enter_MeerQATS_HomePage() {

		System.out.println(homepage.HomePageTitle());
		createcase = new Create_QAReview_ManualCase(driver);
		mywork = new MyWork(driver);

	}

	@When("User Clicks Create QA Review")
	public void User_Clicks_Create_QA_Review() throws InterruptedException {

		homepage.clickonQAReview();

		Thread.sleep(4000);

		driver.switchTo().frame(1);

		Thread.sleep(4000);

	}

	@When("After clicking on Create Manual Case")
	public void After_clicking_on_Create_Manual_Case() {

		createcase.clickoncreatemanualcase();
	}

	@When("User Clicks Create Manual Case")
	public void User_Clicks_Create_Manual_Case() throws InterruptedException {

		homepage.clickonCreateManualCase();

		Thread.sleep(4000);

	}

	@When("After entering Manual Case fields user clicks on create case")
	public void After_entering_Manual_Case_fields_user_clicks_on_create_case() throws InterruptedException {

		createcase.createmanualcaseandclick(prop.getProperty("ActionID"), prop.getProperty("CaseDesc"),
				prop.getProperty("Sourcename"));
		mywork.displaynewlycreatedreviewcase(prop.getProperty("ActionID"));

	}

	@When("After selecting two review cases and click on Create Case")
	public void After_selecting_two_review_cases_and_click_on_Create_Case() throws InterruptedException {

		List<WebElement> ls = homepage.CreateCase_CheckBoxList();
		ls.get(0).click();

		Thread.sleep(3000);
		createcase.clickoncreatecase();

	}

	@Then("Go to Dashboard")
	public void Go_to_Dashboard() throws InterruptedException {

		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		homepage.clickonDashboard();
		Thread.sleep(3000);

	}

	@Then("Assign newly created cases to Reviewer")
	public void Assign_newly_created_cases_to_Reviewer() throws InterruptedException {

		driver.switchTo().frame("PegaGadget2Ifr");
		Thread.sleep(3000);
		Actions act = new Actions(driver);

		act.moveToElement(driver.findElement(By.xpath("//span[text()='QualityReview']"))).doubleClick().build()
				.perform();
		Thread.sleep(2000);
		System.out.println(driver.findElements(By.xpath("//img[@src='webwb/px-explorer-drag-icon.png']")).size());

		act.clickAndHold(driver.findElement(By.xpath("//img[@src='webwb/px-explorer-drag-icon.png']")))
				.moveToElement(driver.findElement(By.xpath("//span[@data-name='QATS User']"))).build().perform();

		Thread.sleep(5000);

	}

	@When("User Clicks on My Work")
	public void User_Clicks_on_My_Work() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='My Work']")).click();
		Thread.sleep(2000);

	}

	@When("on Selecting a Review Case")
	public void on_Selecting_a_Review_Case() throws InterruptedException {

		mywork.selectuploadvitalrecordsreviewcase();
	}

	@Then("After Completing the Questionnaire Click on Submit Review")
	public void After_Completing_the_Questionnaire_Click_on_Submit_Review() throws InterruptedException {

		util.PerformQuestionnaire();
	}

	@After
	public void teardown() throws InterruptedException {

		util.teardown();

	}

}
