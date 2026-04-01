package com.selenium.javaSelenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
public class Selenium_Demo1 {
	
	public static void main(String[] args) {
		
		 System.setProperty("webdriver.edge.driver", "C:\\Users\\Sowndariya\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.flipkart.com/");

	        System.out.println("Running in Jenkins without browser");
	        System.out.println("Page title: " + driver.getTitle());
	        System.out.println("Title length: " + driver.getTitle().length());

	        if (driver.getCurrentUrl().equals("https://www.flipkart.com/")) {
	            System.out.println("Correct page opened: " +driver.getCurrentUrl() );
	        } else {
	            System.out.println("Invalid page");
	        }

	        System.out.println("Page source length: " + driver.getPageSource().length());
	        System.out.println("Execution completed successfully");
		
		driver.close();
		
		
	}
}

/*
 * get page title, get title length
 * print title and also length in eclipse console, 
 * get page url verify the correct page opens, 
 * 
*/
