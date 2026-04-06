package com.selenium.javaSelenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TimerExplicit {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://omayo.blogspot.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement timerButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("timerButton")));
        timerButton.click();

        System.out.println("Timer button clicked successfully");
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert text: " + alert.getText());
        Thread.sleep(3000);
        alert.accept();

        System.out.println("Alert handled");

        //in visible 
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("delayedText")));

        WebElement alertBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("alert2"))
        );
        
        alertBtn.click();
        System.out.println("Clicked alert2 button");
        Alert alert2 = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert text: " + alert2.getText());
        Thread.sleep(3000);
        alert2.accept();
        System.out.println("Alert handled");

    }
}