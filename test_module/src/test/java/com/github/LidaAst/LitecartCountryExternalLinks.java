package com.github.LidaAst;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Set;

public class LitecartCountryExternalLinks extends TestBase {

    private String getNewWindow(String mainWindow){
        Set<String> windows = driver.getWindowHandles();
        windows.remove(mainWindow);
        for (String w:windows){
            return w;
            }
        return null;
    }

    @Test
    public void countryExtLinksTest(){
        login();
        driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.cssSelector("a[title=Edit]")).click();
        List<WebElement> links = driver.findElements(By.cssSelector("i.fa-external-link"));
        String mainWindow = driver.getWindowHandle();
        for (WebElement link:links){
            link.click();
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            String newWindow = getNewWindow(mainWindow);
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(mainWindow);
        }
    }
}
