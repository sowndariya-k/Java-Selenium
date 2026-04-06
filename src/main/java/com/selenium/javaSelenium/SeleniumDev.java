package com.selenium.javaSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SeleniumDev {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");

        // Click Add button
        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("adder")));
        addBtn.click();
        System.out.println("Clicked Add a box!");

        // Verify box
        WebElement box = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("redbox")));
        System.out.println("Box displayed: " + box.isDisplayed());

        // Click Reveal button
        WebElement revealBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("reveal")));
        revealBtn.click();
        System.out.println("Clicked Reveal button");

        // Enter text
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("revealed")));
        input.sendKeys("Selenium Test");
        System.out.println("Entered text");


        System.out.println("Button Text: " + addBtn.getText());
        System.out.println("Box Visible: " + box.isDisplayed());
        System.out.println("Input Value: " + input.getAttribute("value"));

        driver.quit();
    }
}