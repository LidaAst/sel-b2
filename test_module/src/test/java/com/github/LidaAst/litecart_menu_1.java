package com.github.LidaAst;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class litecart_menu_1 extends TestBase {

    @Test
    public void litecartMenuTest(){
        driver.navigate().to("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        int size = driver.findElements(By.id("app-")).size();
        for (int itemNumber=1; itemNumber<=size; itemNumber++){
            String locator = "ul#box-apps-menu li#app-:nth-child("+itemNumber+")";
            driver.findElement(By.cssSelector(locator)).click();
            int subSize = driver.findElement(By.cssSelector(locator)).findElements(By.cssSelector("ul.docs li")).size();
            for (int subItemNumber=1; subItemNumber<=subSize; subItemNumber++){
                driver.findElement(By.cssSelector(locator)).findElement(By.cssSelector("ul.docs li:nth-child("
                        +subItemNumber+")")).click();
            }

        }
    }
}
