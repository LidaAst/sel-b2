package com.github.LidaAst;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;


@SuppressWarnings("ALL")
    public class TestBase {

        public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
        public WebDriver driver;
        public WebDriverWait wait;

        @Before
        public void start() {
            if (tlDriver.get() != null) {
                driver = tlDriver.get();
                wait = new WebDriverWait(driver, 10);
                return;
            }

            //driver = new FirefoxDriver();
            driver = new ChromeDriver();
            //driver = new InternetExplorerDriver();
            //FirefoxOptions caps = new FirefoxOptions();
            //caps.setBinary("C:\\Program Files\\Firefox Nightly\\firefox.exe");
            //caps.setProfile(new FirefoxProfile());
            //caps.setCapability(FirefoxDriver.MARIONETTE, false);
            //driver = new FirefoxDriver(caps);
            tlDriver.set(driver);
            System.out.println(((HasCapabilities) driver).getCapabilities());
            wait = new WebDriverWait(driver, 10);

            Runtime.getRuntime().addShutdownHook(
                    new Thread(() -> { driver.quit(); driver = null; }));

        }
        @After
        public void stop() {
            //driver.quit();
            //driver = null;
    }

        public void login(){
            driver.navigate().to("http://localhost/litecart/admin/login.php");
            driver.findElement(By.name("username")).sendKeys("admin");
            driver.findElement(By.name("password")).sendKeys("admin");
            driver.findElement(By.name("login")).click();
        }

        public String randomString(int n){
            String alphaNumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"0123456789"+"abcdefghijklmnopqrstuvxyz";
            StringBuilder sb = new StringBuilder(n);
            for (int i = 0; i < n; i++){
                int index = (int)(alphaNumeric.length()*Math.random());
                sb.append(alphaNumeric.charAt(index));
            }
            return sb.toString();
        }

        public Integer randomNumber(double max){
            double min = 0.00;
            double x = (Math.random()*((max-min)+1))+min;
                return (int)x;
        }
}
