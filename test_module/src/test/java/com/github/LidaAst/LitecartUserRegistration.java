package com.github.LidaAst;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class LitecartUserRegistration extends TestBase {


    private void logout(){
        driver.findElement(By.xpath("//div[@class='content']//a[contains(text(),'Logout')]")).click();
    }

    @Test
    public void userRegistrationTest(){
        driver.navigate().to("http://localhost/litecart/en/");
        driver.findElement(By.xpath("//a[contains(text(),'New customers click here')]")).click();
        driver.findElement(By.name("firstname")).sendKeys(randomString(5));
        driver.findElement(By.name("lastname")).sendKeys(randomString(5));
        driver.findElement(By.name("address1")).sendKeys(randomString(5));
        driver.findElement(By.name("postcode")).sendKeys("98021");
        driver.findElement(By.name("city")).sendKeys("Seattle");
        Select country = new Select(driver.findElement(By.name("country_code")));
        country.selectByValue("US");
        Select state = new Select(driver.findElement(By.name("zone_code")));
        state.selectByValue("WA");
        String email = randomString(5)+"@gmail.com";
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("phone")).sendKeys("+14251111111");
        String password = randomString(7);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("confirmed_password")).sendKeys(password);
        driver.findElement(By.name("create_account")).click();

        logout();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();
        logout();
    }
}
