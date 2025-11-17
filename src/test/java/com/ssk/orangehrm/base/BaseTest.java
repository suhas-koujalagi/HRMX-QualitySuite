package com.ssk.orangehrm.base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.ssk.orangehrm.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    public WebDriver driver;

    public void initializeBrowser() {
        String browser = ConfigReader.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Invalid browser in config.properties");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void launchUrl(String url) {
        driver.get(url);
    }
}
