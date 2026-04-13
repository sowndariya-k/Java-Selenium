package com.selenium.javaSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        
        driver.get("https://www.leafground.com/select.xhtml");
        WebElement UIAutomation=driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select dropdown=new Select(UIAutomation);
        List <WebElement> list1=dropdown.getOptions();
        System.out.println("The drop down option size: "+list1.size());
        for(WebElement is: list1) {
        	System.out.println("The drop down option are: "+is.getText());
        }
        Boolean multiple=dropdown.isMultiple();
        System.out.println("The multiple options available: "+multiple);
        dropdown.selectByIndex(1);
        Thread.sleep(1000);
        dropdown.selectByVisibleText("Puppeteer");
        System.out.println("Puppeteer select");
        
	}

}
