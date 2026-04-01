package com.selenium.javaSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium_Demo1 {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();

        EdgeOptions options = new EdgeOptions();

        String headless = System.getProperty("headless", "true");

        if (headless.equalsIgnoreCase("true")) {
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
            System.out.println("Running in HEADLESS mode (Jenkins)");
        } else {
            System.out.println("Running in NORMAL mode (Local)");
        }

        WebDriver driver = new EdgeDriver(options);

        try {
            System.out.println("Launching browser...");

            driver.manage().window().maximize();
            driver.get("https://www.flipkart.com/");

            String title = driver.getTitle();
            System.out.println("Page title: " + title);
            System.out.println("Title length: " + title.length());

            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("flipkart")) {
                System.out.println("Correct page opened: " + currentUrl);
            } else {
                System.out.println("Invalid page");
            }

            System.out.println("Page source length: " + driver.getPageSource().length());

            System.out.println("Execution completed successfully");

        } catch (Exception e) {
            System.out.println("Execution failed");
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}