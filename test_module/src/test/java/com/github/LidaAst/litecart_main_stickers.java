package com.github.LidaAst;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class litecart_main_stickers extends TestBase {

    @Test
    public void stickers_test(){
        driver.navigate().to("http://localhost/litecart/");
        List<WebElement> products = driver.findElements(By.cssSelector("div.image-wrapper"));
        for (WebElement product:products){
            Assert.assertEquals(1, product.findElements(By.cssSelector("div.sticker")).size());

        }
        System.out.println(products.size());
    }

}