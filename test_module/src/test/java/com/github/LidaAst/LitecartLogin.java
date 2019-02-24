package com.github.LidaAst;

import org.junit.Test;
import org.openqa.selenium.By;

public class LitecartLogin extends TestBase{

    @Test
    public void loginTest(){
        login();
        //driver.navigate().to("http://localhost/litecart/admin/login.php");
        //driver.findElement(By.name("username")).sendKeys("admin");
        //driver.findElement(By.name("password")).sendKeys("admin");
        //driver.findElement(By.name("login")).click();

    }
}
