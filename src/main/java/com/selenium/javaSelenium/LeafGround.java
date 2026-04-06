package com.selenium.javaSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LeafGround {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/waits.xhtml");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //1. wait for visibile
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='j_idt87:j_idt89']//span[@class='ui-button-text ui-c'][normalize-space()='Click']")
        )).click();

        WebElement visibleText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='I am here']")
                )
        );
        System.out.println("Visible Text: " + visibleText.getText());


        //wait for invisible
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='j_idt87:j_idt92']//span[@class='ui-button-text ui-c'][normalize-space()='Click']")
        )).click();

        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(
                        By.xpath("//div[contains(@class,'ui-progressbar')]")
                )
        );
        System.out.println("Loader disappeared");

        
        // 3. Wait for clickabla
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Click First Button')]")
        )).click();

        WebElement secondButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[contains(text(),'Click Second')]")
                )
        );
        secondButton.click();
        System.out.println("Second button clicked");

        // 4. Wait for Text Change
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='j_idt87:j_idt98']//span[@class='ui-button-text ui-c'][normalize-space()='Click']")
        )).click();

        WebElement textChange = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[contains(text(),'Did you notice?')]")
                )
        );
        System.out.println("Text changed: " + textChange.getText());


        driver.quit();
    }
}