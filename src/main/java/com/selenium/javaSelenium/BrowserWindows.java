package com.selenium.javaSelenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindows {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("https://demoqa.com/browser-windows");
        String parentWindow=driver.getWindowHandle();
        System.out.println(parentWindow);
        
        Set<String> allWindowHandles=driver.getWindowHandles();
        System.out.println("Count of window: "+allWindowHandles.size());
        //open a child window
        driver.findElement(By.id("windowButton")).click();
        
        //count of windows, changed from 1 to 2
        
        Set<String> newAllWindowsHandles=driver.getWindowHandles();
        System.out.println("New count of window: "+newAllWindowsHandles.size());
        
        String parentHandle=driver.getWindowHandle();
        System.out.println(parentHandle);
        
        Iterator<String> iterator=newAllWindowsHandles.iterator();
        String MainWindow=iterator.next();
        String childWindow=iterator.next();
        System.out.print("Main window: "+MainWindow);
        System.out.print("child window: "+childWindow);
        
        
        //switch control to child window
        driver.switchTo().window(childWindow);
        WebElement text=driver.findElement(By.id("sampleHeading"));
        System.out.println("Child_Title: "+text.getText());
        
        driver.close();
        
        driver.switchTo().window(parentHandle);
        System.out.println("Parent_Title: "+driver.getTitle());
        
        driver.quit(); 

	}

}
