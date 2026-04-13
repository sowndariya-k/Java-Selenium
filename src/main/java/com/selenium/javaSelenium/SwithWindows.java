package com.selenium.javaSelenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwithWindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        driver.get("https://www.leafground.com/window.xhtml");
        String parentWindow=driver.getWindowHandle();
        System.out.println(parentWindow);
       //size of parent window
        Set<String> allWindowHandles=driver.getWindowHandles();
        System.out.println("Count of window: "+allWindowHandles.size());
        
        //redirect to next tab
        driver.findElement(By.id("j_idt88:new")).click();
        Thread.sleep(2000);
        //parent +new tab
        Set<String> newAllWindowsHandles=driver.getWindowHandles();
        System.out.println("New count of window: "+newAllWindowsHandles.size());
        
        //switch to parent
        driver.switchTo().window(parentWindow);
        driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
        Thread.sleep(2000);
        Set<String> newAllWindowsHandles1=driver.getWindowHandles();
        System.out.println("New count of window switch and close: "+newAllWindowsHandles1.size());
        
        

	}

}
