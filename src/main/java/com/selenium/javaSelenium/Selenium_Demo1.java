package com.selenium.javaSelenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Selenium_Demo1 {

		public static void main(String[] args) {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.flipkart.com/");
			String page=driver.getTitle();
			int titleLength= driver.getTitle().length();
			System.out.println("The Page title is:"+page);
			System.out.println("The page Title Length:"+titleLength);
			System.out.println(driver.getCurrentUrl());
			String pageSource=driver.getPageSource();
			int lengthSource=driver.getPageSource().length();
			System.out.println("The page Source:"+pageSource);
			System.out.println("The Page Source length:"+lengthSource);
			driver.close();
		}
}

/*
 * get page title, get title length
 * print title and also length in eclipse console, 
 * get page url verify the correct page opens, 
 * 
*/
