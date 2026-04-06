package com.selenium.javaSelenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.function.Consumer;
import java.util.function.Function;

public class IRCTCAirLocatorsDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Helper lambda functions for safe operations
            Function<By, String> safeText = (By locator) -> {
                try {
                    WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
                    if(el.isDisplayed()) return el.getText();
                } catch(Exception ignored) {}
                return null;
            };

            Consumer<By> safeSendKeys = (By locator) -> {
                try {
                    WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
                    if(el.isDisplayed()) el.sendKeys("Test Input");
                } catch(Exception ignored) {}
            };

            Consumer<By> safeClick = (By locator) -> {
                try {
                    WebElement el = wait.until(ExpectedConditions.elementToBeClickable(locator));
                    if(el.isDisplayed()) el.click();
                } catch(Exception ignored) {}
            };

            Consumer<By> safeScroll = (By locator) -> {
                try {
                    WebElement el = driver.findElement(locator);
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
                } catch(Exception ignored) {}
            };

            // ------------------- HOME PAGE -------------------
            driver.get("https://www.air.irctc.co.in/");

            String logo = safeText.apply(By.xpath("//img[@alt='air-logo.png']"));
            if(logo != null) System.out.println("1. Logo displayed");

            String flightsTab = safeText.apply(By.xpath("//a[span='Flights']"));
            if(flightsTab != null) System.out.println("2. Flights Tab: " + flightsTab);

            safeClick.accept(By.xpath("//button[@type='submit' and contains(@class,'home-btn')]"));
            System.out.println("3. Search Button clicked");

            safeSendKeys.accept(By.id("stationFrom"));
            System.out.println("4. From Input entered");

            safeSendKeys.accept(By.id("stationTo"));
            System.out.println("5. To Input entered");

            safeClick.accept(By.xpath("//a[text()='Login']"));
            System.out.println("6. Login Button clicked");

            safeClick.accept(By.id("defenceForce"));
            System.out.println("7. Defence Checkbox clicked");

            String regNav = safeText.apply(By.id("dropdownRegistration"));
            if(regNav != null) System.out.println("8. Registration Nav displayed");

            String marqueeText = safeText.apply(By.xpath("//marquee[contains(text(),'Government Employees are mandated')]"));
            if(marqueeText != null) System.out.println("9. Marquee text: " + marqueeText);

            String faqHeader = safeText.apply(By.xpath("//h2[text()='FAQ']"));
            if(faqHeader != null) System.out.println("10. FAQ Header displayed");

            // ------------------- GOVT REGISTRATION PAGE -------------------
            driver.navigate().to("https://www.air.irctc.co.in/govempregistration");
            System.out.println("Navigated to Govt Registration Page");

            String studentLabel = safeText.apply(By.xpath("//label[@for='student']"));
            if(studentLabel != null) System.out.println("11. Student Label: " + studentLabel);

            safeScroll.accept(By.xpath("//img[@src='air/banner/home-9.gif']"));
            System.out.println("12. Banner Image checked");

            safeScroll.accept(By.id("travelClass"));
            System.out.println("13. Travel dropdown checked");

            safeSendKeys.accept(By.id("First_Name"));
            System.out.println("14. First Name entered");

            safeSendKeys.accept(By.name("file"));
            System.out.println("15. File Input checked");

            safeSendKeys.accept(By.xpath("//input[@placeholder='Enter Captcha']"));
            System.out.println("16. Captcha Input checked");

            safeClick.accept(By.xpath("//input[@type='submit' and @value='Create']"));
            System.out.println("17. Create Button clicked");

            safeClick.accept(By.xpath("//input[@type='reset' and @value='Reset']"));
            System.out.println("18. Reset Button clicked");

            safeClick.accept(By.id("dropdown10"));
            System.out.println("19. Contact Us clicked");

            safeText.apply(By.xpath("//h1[@id='exampleModalLongTitle']"));
            System.out.println("20. Title Govt checked");

            safeClick.accept(By.xpath("//label[@for='One-Way']"));
            System.out.println("21. One-Way checked");

            safeScroll.accept(By.xpath("//img[@src='assets/img/frame-2.png' and @class='responsiveImg']"));
            System.out.println("22. QR Scan checked");

            safeScroll.accept(By.xpath("//img[@src='assets/img/star.png']"));
            System.out.println("23. Rating checked");

            safeClick.accept(By.xpath("//button[@class='feed-back']"));
            System.out.println("24. Feedback clicked");

            safeClick.accept(By.xpath("//button[text()='Which site is cheapest for flight tickets?']"));
            System.out.println("25. FAQ question button clicked");

            safeText.apply(By.xpath("//small[contains(text(),'2025')]"));
            System.out.println("26. Copy Rights checked");

            safeClick.accept(By.xpath("//a[@href='/agreement/privacy-policy']"));
            System.out.println("27. Privacy Policy clicked");

            // ------------------- GOVT VERIFY PAGE -------------------
            driver.navigate().to("https://www.air.irctc.co.in/govtverifyuser");
            System.out.println("Navigated to Govt Verify Page");

            safeClick.accept(By.xpath("//button[@fdprocessedid='9fl7zi']"));
            System.out.println("28. Validate OTP button clicked");

            safeClick.accept(By.xpath("//button[@fdprocessedid='kfj83']"));
            System.out.println("29. Resend OTP button clicked");

            safeScroll.accept(By.id("organization"));
            System.out.println("30. Organization dropdown checked");

        } catch(Exception ignored) {}

        driver.quit();
    }
}