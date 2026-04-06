package com.selenium.javaSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorsDemo {

	 public static void main(String[] args) throws InterruptedException {
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");

	        Thread.sleep(2000);

	        // First Name input below its label
	        WebElement firstName = driver.findElement(
	            RelativeLocator.with(By.tagName("input"))
	                .below(driver.findElement(By.xpath("//label[text()='First Name ']")))
	        );
	        firstName.sendKeys("John");

	        // Last Name input below its label
	        WebElement lastName = driver.findElement(
	            RelativeLocator.with(By.tagName("input"))
	                .below(driver.findElement(By.xpath("//label[text()='Last Name']")))
	        );
	        lastName.sendKeys("Doe");

	        // Email input below its label
	        WebElement email = driver.findElement(
	            RelativeLocator.with(By.tagName("input"))
	                .below(driver.findElement(By.xpath("//label[text()='Email']")))
	        );
	        email.sendKeys("john@example.com");

	        // Phone label to the left of phone input
	        WebElement password = driver.findElement(By.xpath("//label[text()='Password']"));
	        WebElement passwordLabel = driver.findElement(RelativeLocator.with(By.tagName("label")).toLeftOf(password));
	        System.out.println("Phone label text: " + passwordLabel.getText());

	        driver.quit();
	    }
}