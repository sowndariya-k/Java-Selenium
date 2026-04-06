package com.selenium.javaSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class LinkedInLoginDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {

            driver.get("https://www.linkedin.com/login");
            System.out.println("1. Opened LinkedIn");

            driver.findElement(By.cssSelector("#username"))
                  .sendKeys("sowndariyadeveloper@gmail.com");
            System.out.println("2. Email entered");

            driver.findElement(By.cssSelector("#password"))
                  .sendKeys("Sow@911!");
            System.out.println("3. Password entered");

            driver.findElement(By.cssSelector("button[type='submit']")).click();
            System.out.println("4. Login clicked");

            String currentUrl = driver.getCurrentUrl();
            String title = driver.getTitle();

            System.out.println("URL: " + currentUrl);
            System.out.println("Title: " + title);

            if (currentUrl.contains("feed")) {
                System.out.println("5. Login Successful");
            } 
            else if (currentUrl.contains("checkpoint")) {
                System.out.println("5. Blocked by LinkedIn CAPTCHA");
            } 
            else {
                try {
                    WebElement errorMsg = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector("#error-for-username")
                        )
                    );
                    System.out.println("5. Invalid Login: " + errorMsg.getText());
                } catch (Exception e) {
                    System.out.println("5. Login failed (unexpected flow)");
                }
            }

        } catch (Exception e) {
            System.out.println("Login failed (CAPTCHA/OTP/blocked)");
        }

        driver.quit();
    }
}