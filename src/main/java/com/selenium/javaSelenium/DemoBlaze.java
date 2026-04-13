package com.selenium.javaSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoBlaze {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.demoblaze.com/index.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.id("login2")));
        
        login.click();
        
        System.out.println("login button clicked successfully");
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys("sowndariya");
        
        driver.findElement(By.id("loginpassword")).sendKeys("Sow@911!");
        
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        
        WebElement welcome =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
        String actual="Welcome sowndariya";
        if(actual.matches(welcome.getText())) {
        	System.out.println("Same text");
        }else {
        	System.out.println("Not as Expected");
        }
        System.out.println("Login successful: " + welcome.getText());
        
        WebElement logout= wait.until(ExpectedConditions.elementToBeClickable(By.id("logout2")));
        logout.click();
        
        System.out.println("Logout Successful");
        driver.quit();
	}

}
