package com.selenium.javaSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NOWaitImplemented {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");
        driver.findElement(By.className("dropbtn")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Facebook")).click();
	}

}
