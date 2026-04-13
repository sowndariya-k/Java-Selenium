package com.selenium.javaSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        driver.get("https://www.leafground.com/drag.xhtml");
        WebElement DragtoElement=driver.findElement(By.xpath("//p[normalize-space()='Drag to target']"));
        Actions action=new Actions(driver);
        WebElement DroptargetElement=driver.findElement(By.xpath(" //p[@class='ui-widget-header']"));
        action.dragAndDrop(DragtoElement, DroptargetElement).perform();
        System.out.println("Drag and drop ");
        
        
        WebElement DragOffSet=driver.findElement(By.xpath("//div[@id='form:conpnl_content']"));
        
        action.dragAndDropBy(DragOffSet, 0, 0);
        driver.quit();
	}

}
