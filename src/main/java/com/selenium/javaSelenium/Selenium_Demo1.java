package com.selenium.javaSelenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
public class Selenium_Demo1 {
	
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/"); 
		System.out.println("Page title is: "+driver.getTitle());
		System.out.println("Page title length is: "+driver.getTitle().length());
		String CurrentUrl=driver.getCurrentUrl();
		if(CurrentUrl.equals("https://www.flipkart.com/")) {
		System.out.println(driver.getCurrentUrl());
		}else {
			System.out.println("Invalid page");
		}
		System.out.println(driver.getPageSource());
		System.out.println(driver.getPageSource().length());
		
		driver.close();
		
		
	}
}

/*
 * get page title, get title length
 * print title and also length in eclipse console, 
 * get page url verify the correct page opens, 
 * 
*/
