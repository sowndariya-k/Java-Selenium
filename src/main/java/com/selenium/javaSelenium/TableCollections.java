package com.selenium.javaSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableCollections {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://thinking-tester-contact-list.herokuapp.com/");
		
		driver.findElement(By.id("email"))
        .sendKeys("sowndariya@gmail.com");
		System.out.println("1. Email entered");
		
		
		driver.findElement(By.id("password"))
        .sendKeys("Sow@911!");
		System.out.println("2. Password entered");
		
		driver.findElement(By.id("submit")).click();
		System.out.println("3. Login clicked");
		Thread.sleep(1000);
		
		List<WebElement> contactNames=driver.findElements(By.xpath("//table[@id='myTable']//tr/td[2]"));
		System.out.println("Total contact count: "+contactNames.size());
		for(WebElement name: contactNames) {
		System.out.println(name.getText());
		}
		
		
		int i=1;
		String expectedName="Kavinkumar R";
		for(WebElement name: contactNames) {
			if(name.getText().equals(expectedName)) {
			     List<WebElement> actualRowData=driver.findElements(By.xpath("//table[@id='myTable']/tr[" +i+ "]"));
			     for(WebElement row: actualRowData) {
			    	 System.out.println(row.getText());
			     }
			}
			i++;
		}
		driver.quit();
	}

}
