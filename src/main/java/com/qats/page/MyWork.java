package com.qats.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyWork {
	
	WebDriver driver;
	
	public MyWork(WebDriver driver){
		
		this.driver=driver;
		
		
	}
	
	public void selectuploadvitalrecordsreviewcase() throws InterruptedException{
		if (driver.getTitle().equals("QA Manager")) {
			driver.switchTo().frame(1);
		}

		driver.findElement(By.xpath("//div[text()='Assignment Task']/following::a[@id='pui_filter']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[contains(text(),'Rating Com')]/following::input[@type='checkbox']"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		Thread.sleep(3000);
		driver.findElements(By.xpath("//h1[text()='My Work']/following::td[@data-attribute-name='QRS ID']/div/span/a"))
				.get(0).click();
		Thread.sleep(6000);
	}

}
