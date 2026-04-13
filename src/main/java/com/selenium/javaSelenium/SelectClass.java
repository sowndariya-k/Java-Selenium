package com.selenium.javaSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClass {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        driver.get("https://omayo.blogspot.com/");
        
        Select objSelect=new Select(driver.findElement(By.xpath("//input[@name='q']")));
        objSelect.selectByVisibleText("Automation");
        
        List <WebElement> elementCount=objSelect.getOptions();
        System.out.println(elementCount.size());
        
        driver.quit();

	}

}
