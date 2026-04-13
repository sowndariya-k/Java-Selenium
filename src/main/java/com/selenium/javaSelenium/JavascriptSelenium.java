package com.selenium.javaSelenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class JavascriptSelenium {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByTagName('input')[0].value='Sowndariya'");
		String firstName = (String) js.executeScript("return document.getElementsByTagName('input')[0].value");
		System.out.println(firstName);
		
		js.executeScript("document.getElementsByTagName('input')[1].value='K'");
		String lastName=(String)js.executeScript("return document.getElementsByTagName('input')[1].value").toString();
		System.out.println(lastName);
		
		
		js.executeScript("document.getElementsByTagName('input')[2].value='sowndariyadeveloper@gmail.com'");
		String Email=(String)js.executeScript("return document.getElementsByTagName('input')[2].value").toString();
		System.out.println(Email);
		
		js.executeScript("document.getElementsByTagName('input')[3].value='Sow@911!'");
		String password=(String)js.executeScript("return document.getElementsByTagName('input')[3].value").toString();
		System.out.println(password);
		
		js.executeScript("document.getElementsByTagName('input')[4].value='Sow@911!'");
		String resetPassword=(String)js.executeScript("return document.getElementsByTagName('input')[4].value").toString();
		System.out.println(resetPassword);
		
		js.executeScript("document.getElementsByClassName('btn').click()");
		
		String domain=js.executeScript("return document.domain;").toString();
		System.out.println(domain);
		
		String URL=js.executeScript("return document.URL;").toString();
		System.out.println(URL);
		
		String title=js.executeScript("return document.title;").toString();
		System.out.println(title);
		
		String scroll=js.executeScript("return window.scrollBy(0,500);").toString();
		System.out.println(scroll);
		
		driver.quit();
	}

}
