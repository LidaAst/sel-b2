package com.github.LidaAst;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LitecartMainStickers extends TestBase {

    @Test
    public void stickers_test(){
        driver.navigate().to("http://localhost/litecart/");
        List<WebElement> products = driver.findElements(By.cssSelector("li.product"));
        for (WebElement product:products){

            Assert.assertEquals(1, product.findElements(By.cssSelector("div.sticker")).size());

        }
        System.out.println(products.size());
    }

}
