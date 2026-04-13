package com.selenium.javaSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        driver.get("https://demoqa.com/frames");
        
        WebElement iframeElement=driver.findElement(By.id("frame1"));
        driver.switchTo().frame(iframeElement);
        String Frame_1=driver.findElement(By.id("sampleHeading")).getText();
        System.out.println("Switch by loactor: "+Frame_1);
        
        driver.switchTo().defaultContent();
        String mainPage=driver.findElement(By.xpath("//*[@id='frame1Wrapper']")).getText();
        System.out.println("Back to main page: "+mainPage);
        
        driver.switchTo().frame(1);
        String Frame_2=driver.findElement(By.id("sampleHeading")).getText();
        System.out.println("Switch by loactor: "+Frame_2);
        
        
        driver.quit();
        

	}

}
