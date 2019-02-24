package com.github.LidaAst;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class LitecartAddProductTest extends TestBase {

    @Test
    public void addProductTest(){
        login();
        driver.findElement(By.xpath("//span[contains(text(),'Catalog')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Add New Product')]")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Enabled')]//input[@value='1']")).click();
        String productName = randomString(5);
        driver.findElement(By.name("name[en]")).sendKeys(productName);
        driver.findElement(By.name("code")).sendKeys(randomNumber(999).toString());
        WebElement rootCheckbox = driver.findElement(By.xpath("//div[@class='input-wrapper']//input[@value='0']"));
        if (!rootCheckbox.isSelected()){
            rootCheckbox.click();
        }
        Select root = new Select(driver.findElement(By.name("default_category_id")));
        root.selectByValue("0");
        driver.findElement(By.xpath("//input[@value='1-3']")).click();
        driver.findElement(By.name("quantity")).sendKeys("100");
        String userDir = System.getProperty("user.dir");
        String absPath = userDir+"/src/test/java/com/github/LidaAst/tricotazh.jpg";
        driver.findElement(By.name("new_images[]")).sendKeys(absPath);
        driver.findElement(By.name("date_valid_from")).sendKeys("01012019");
        driver.findElement(By.name("date_valid_to")).sendKeys("01012020");

        driver.findElement(By.xpath("//a[contains(text(),'Information')]")).click();
        Select manufacturer = new Select(driver.findElement(By.name("manufacturer_id")));
        manufacturer.selectByValue("1");
        driver.findElement(By.name("keywords")).sendKeys("cats");
        driver.findElement(By.name("short_description[en]")).sendKeys("Three cats");
        driver.findElement(By.name("description[en]")).sendKeys("Three perfect cats");
        driver.findElement(By.name("head_title[en]")).sendKeys("Tricotazh");
        driver.findElement(By.name("meta_description[en]")).sendKeys("some metta");

        driver.findElement(By.xpath("//a[contains(text(),'Prices')]")).click();
        driver.findElement(By.name("purchase_price")).sendKeys("1");
        Select currency = new Select(driver.findElement(By.name("purchase_price_currency_code")));
        currency.selectByValue("USD");
        Select taxId = new Select(driver.findElement(By.name("tax_class_id")));
        taxId.selectByValue("1");
        driver.findElement(By.name("gross_prices[USD]")).sendKeys("1");
        driver.findElement(By.name("save")).click();


        List<WebElement> products = driver.findElements(By.cssSelector("tr.row a:not([title=Edit])"));
        for (WebElement product:products){
            if (product.getText().equals(productName)){
                return;
            }
        }
        Assert.fail();
    }
}
