package com.selenium.javaSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        driver.get("https://omayo.blogspot.com/");
        WebElement blogsmenuElement=driver.findElement(By.id("blogsmenu"));
        Actions action=new Actions(driver);
        
        action.moveToElement(blogsmenuElement).perform();
        
        /*WebElement option2=driver.findElement(By.xpath("//span[normalize-space()='SeleniumByArun']"));
        action.moveToElement(option2).click().build().perform();
        System.out.println("Click Selenium By Arun");*/
        
        /*WebElement searchField=driver.findElement(By.xpath("//input[@name='q']"));
        action.contextClick(searchField).perform();
        System.out.println("click search field");*/
        
        WebElement doubleClickOption=driver.findElement(By.xpath("//button[@ondblclick='dblclickAlert()']"));
        action.doubleClick(doubleClickOption).perform();
        Thread.sleep(2000);
        System.out.println("double click button");
        
        driver.quit();
	}

}
