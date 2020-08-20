package com.qats.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Create_QAReview_ManualCase {
	WebDriver driver;

	public Create_QAReview_ManualCase(WebDriver driver) {

		this.driver = driver;
	}

	public void clickoncreatecase() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Create Case']")).click();
	}

	public void clickoncreatemanualcase() {
		driver.findElement(By.xpath("//button[text()='Create Manual Case']")).click();
	}

	public void createmanualcaseandclick(String actid, String CaseDesc,String Source) throws InterruptedException {
		if (driver.getTitle().equals("QA Manager")) {

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget1Ifr");
			Thread.sleep(2000);
		}
		
	

		driver.findElement(By.xpath("//input[@name='$PpyDisplayHarness$pManualRatingAction$l1$pRatingActionID']"))
				.sendKeys(actid);

		driver.findElement(By.xpath("//input[@name='$PpyDisplayHarness$pManualRatingAction$l1$pRatingActionDesc']"))
				.sendKeys(CaseDesc);

		Select sel = new Select(driver
				.findElement(By.xpath("//select[@name='$PpyDisplayHarness$pManualRatingAction$l1$pSourceName']")));

		sel.selectByVisibleText(Source);

		driver.findElement(By.xpath("//img[@name='CalendarImg-74605107']")).click();

		driver.findElement(By.xpath("//a[@class='today-link']")).click();

		driver.findElement(By.xpath("//label[text()='Lead Analyst Name']/following-sibling::div/input[@type='text']"))
				.sendKeys("David Sweeney");

		driver.findElement(By.xpath("//label[text()='PACR']/following-sibling::div/input[@type='text']")).sendKeys("");

		driver.findElement(By.xpath("//button[text()='Create Case']")).click();

		Thread.sleep(4000);

		driver.navigate().refresh();

		Thread.sleep(4000);
	}

}
