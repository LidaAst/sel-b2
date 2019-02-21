package com.github.LidaAst;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Litecart_product_test extends TestBase{

    @Test
    public void productTest(){
        driver.navigate().to("http://localhost/litecart/en/");
        WebElement product = driver.findElement(By.cssSelector("div#box-campaigns li.product"));
        String name = product.findElement(By.className("name")).getText();
        WebElement regularPrice = product.findElement(By.className("regular-price"));
        String regPriceColor = regularPrice.getCssValue("color");
        String regPriceStyle = regularPrice.getCssValue("text-decoration-line");
        WebElement salePrice = product.findElement(By.className("campaign-price"));
        String salePriceColor = salePrice.getCssValue("color");
        String salePriceStyle = salePrice.getCssValue("font-weight");

    }

}
