package com.github.LidaAst;

import org.junit.Test;
import org.openqa.selenium.By;

public class litecart_menu extends TestBase{

    @Test
    public void menuTest(){
        driver.navigate().to("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Appearence')]")).click();
        driver.findElement(By.id("doc-template")).click();
        driver.findElement(By.id("doc-logotype")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Catalog')]")).click();
        driver.findElement(By.id("doc-catalog")).click();
        driver.findElement(By.id("doc-product_groups")).click();
        driver.findElement(By.id("doc-option_groups")).click();
        driver.findElement(By.id("doc-manufacturers")).click();
        driver.findElement(By.id("doc-suppliers")).click();
        driver.findElement(By.id("doc-delivery_statuses")).click();
        driver.findElement(By.id("doc-sold_out_statuses")).click();
        driver.findElement(By.id("doc-quantity_units")).click();
        driver.findElement(By.id("doc-csv")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Countries')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Currencies')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Customers')]")).click();
        driver.findElement(By.id("doc-customers")).click();
        driver.findElement(By.id("doc-csv")).click();
        driver.findElement(By.id("doc-newsletter")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Geo Zones')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Languages')]")).click();
        driver.findElement(By.id("doc-languages")).click();
        driver.findElement(By.id("doc-storage_encoding")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Modules')]")).click();
        driver.findElement(By.id("doc-jobs")).click();
        driver.findElement(By.id("doc-customer")).click();
        driver.findElement(By.id("doc-shipping")).click();
        driver.findElement(By.id("doc-payment")).click();
        driver.findElement(By.id("doc-order_total")).click();
        driver.findElement(By.id("doc-order_success")).click();
        driver.findElement(By.id("doc-order_action")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Orders')]")).click();
        driver.findElement(By.id("doc-orders")).click();
        driver.findElement(By.id("doc-order_statuses")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Pages')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Reports')]")).click();
        driver.findElement(By.id("doc-monthly_sales")).click();
        driver.findElement(By.id("doc-most_sold_products")).click();
        driver.findElement(By.id("doc-most_shopping_customers")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Settings')]")).click();
        driver.findElement(By.id("doc-store_info")).click();
        driver.findElement(By.id("doc-defaults")).click();
        driver.findElement(By.id("doc-general")).click();
        driver.findElement(By.id("doc-listings")).click();
        driver.findElement(By.id("doc-images")).click();
        driver.findElement(By.id("doc-checkout")).click();
        driver.findElement(By.id("doc-advanced")).click();
        driver.findElement(By.id("doc-security")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Slides')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Tax')]")).click();
        driver.findElement(By.id("doc-tax_classes")).click();
        driver.findElement(By.id("doc-tax_rates")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Translations')]")).click();
        driver.findElement(By.id("doc-search")).click();
        driver.findElement(By.id("doc-scan")).click();
        driver.findElement(By.id("doc-csv")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Users')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'vQmods')]")).click();
        driver.findElement(By.id("doc-vqmods")).click();

    }
}
