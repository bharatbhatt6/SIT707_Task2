package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import java.io.*;
import org.openqa.selenium.*;

//import java.io.File;
//import java.io.IOException;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;



/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

    public static void sleep(int sec) {
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    
    public static void officeworks_registration_page(String url) {
        // Step 1: Locate chrome driver folder in the local drive.
        System.setProperty("webdriver.chrome.driver", "/Users/bharatbhatt/Downloads/chromedriver-mac-arm64/chromedriver");
        
        // Step 2: Use above chrome driver to open up a chromium browser.
        System.out.println("Fire up chrome browser.");
        WebDriver driver = new ChromeDriver();
        
        System.out.println("Driver info: " + driver);
        
        sleep(2);
    
        // Load a webpage in chromium browser.
        driver.get(url);
        
        /*
         * How to identify a HTML input field -
         * Step 1: Inspect the webpage, 
         * Step 2: locate the input field, 
         * Step 3: Find out how to identify it, by id/name/...
         */
        
        // Find first input field which is firstname
        WebElement firstNameElement = driver.findElement(By.id("firstname"));
        System.out.println("Found element: " + firstNameElement);
        // Send first name
        firstNameElement.sendKeys("Ahsan");
        
        /*
         * Find following input fields and populate with values
         */
        WebElement lastNameElement = driver.findElement(By.id("lastname"));
        lastNameElement.sendKeys("Habib");
        
        WebElement emailElement = driver.findElement(By.id("email"));
        emailElement.sendKeys("ahsan@example.com");
        
        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys("password123");
        
        WebElement confirmpasswordElement = driver.findElement(By.id("confirmPassword"));
        confirmpasswordElement.sendKeys("password123");
        
        
        
        // Add more fields as needed
        
        /*
         * Identify button 'Create account' and click to submit using Selenium API.
         */
        WebElement createAccountButton = driver.findElement(By.className("ActionButton__StyledButton-r7njn9-0"));
        createAccountButton.click();
        
        /*
         * Take screenshot using selenium API.
         */
        try {
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("/Users/bharatbhatt/Desktop/Screenshot/screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        // Sleep a while
        sleep(2);
        
        // close chrome driver
        driver.close();    
    }
    
    public static void bws_registration_page(String url) {
        // Set the path to your ChromeDriver
        System.setProperty("webdriver.chrome.driver", "/Users/bharatbhatt/Downloads/chromedriver-mac-arm64/chromedriver");

        WebDriver driver = new ChromeDriver();

        try {
            driver.get(url);
            
            WebElement firstNameElement = driver.findElement(By.id("signupForm-firstName"));
            firstNameElement.sendKeys("Ahsan");
       
            WebElement lastNameElement = driver.findElement(By.id("signupForm-lastName"));
            lastNameElement.sendKeys("Habib");
            
            WebElement dateofbirth = driver.findElement(By.id("signupForm-DOB"));
            dateofbirth.sendKeys("01/05/1997");
            
            WebElement postcode = driver.findElement(By.id("signup-locator-search"));
            postcode.sendKeys("3125");
            
            WebElement mobnum = driver.findElement(By.id("signupForm-MobileNo"));
            mobnum.sendKeys("0488173456");
            
            WebElement emailElement = driver.findElement(By.id("signupForm-email"));
            emailElement.sendKeys("ahsan@example.com");
           
            WebElement password = driver.findElement(By.id("signupForm-password"));
            password.sendKeys("yourpassword"); 

            WebElement createAccountButton = driver.findElement(By.cssSelector(".btn.btn-primary.btn--has-icon.btn--singup-submit"));
            createAccountButton.click();


            // Sleep for a short time to allow any messages or navigation to occur
            Thread.sleep(2000); // This is to wait for 2 seconds

            // Take a screenshot of the filled form
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("/Users/bharatbhatt/Desktop/Screenshot/bigw_signup.png"));

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the browser window
            driver.quit();
        }
    }

    
}




