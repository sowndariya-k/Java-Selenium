package com.selenium.javaSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.com");
		System.out.println("web page: google");
		Thread.sleep(5000);
		driver.navigate().to("https://www.smartcliff.in");
		System.out.println("web page: smartcliff");
		Thread.sleep(5000);
		driver.navigate().back();
		System.out.println("web page: google");
		Thread.sleep(5000);
		driver.navigate().forward();
		System.out.println("web page: smartcliff");
		Thread.sleep(5000);
		driver.navigate().refresh();
		System.out.println("web page: smartcliff");
		Thread.sleep(5000);
		driver.close();
	}

}
