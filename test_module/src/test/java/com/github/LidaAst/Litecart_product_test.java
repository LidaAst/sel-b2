package com.github.LidaAst;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Litecart_product_test extends TestBase{

    private int[] colorFinder(String rgb){
        int bracket = rgb.indexOf('(');
        int firstComma = rgb.indexOf(',');
        int secondComma = rgb.indexOf(',', firstComma+1);
        int thirdComma = rgb.indexOf(',', secondComma+1);
        if (thirdComma == -1){
            thirdComma = rgb.indexOf(')');
        }
        int[] ans = new int[3];
        ans[0] = Integer.parseInt(rgb.substring(bracket+1, firstComma));
        ans[1] = Integer.parseInt(rgb.substring(firstComma+1, secondComma).trim());
        ans[2] = Integer.parseInt(rgb.substring(secondComma+1, thirdComma).trim());

        return ans;
    }
    private float sizeFinder(String size){
        int p = size.indexOf('p');
        return Float.parseFloat(size.substring(0, p));
    }



    @Test
    public void productTest(){
        driver.navigate().to("http://localhost/litecart/en/");
        WebElement product = driver.findElement(By.cssSelector("div#box-campaigns li.product"));
        String name = product.findElement(By.className("name")).getText();
        WebElement regularPrice = product.findElement(By.className("regular-price"));
        String regPriceValue = regularPrice.getText();
        String regPriceColor = regularPrice.getCssValue("color");
        String regPriceStyle = regularPrice.getCssValue("text-decoration");
        String regPriceWeight = regularPrice.getCssValue("font-weight");
        String regPriceSize = regularPrice.getCssValue("font-size");
        WebElement salePrice = product.findElement(By.className("campaign-price"));
        String salePriceValue = salePrice.getText();
        String salePriceColor = salePrice.getCssValue("color");
        String salePriceWeight = salePrice.getCssValue("font-weight");
        String salePriceSize = salePrice.getCssValue("font-size");

        product.click();
        String name2 = driver.findElement(By.cssSelector("h1.title")).getText();
        WebElement regPrice2 = driver.findElement(By.className("regular-price"));
        String regPrice2Value = regPrice2.getText();
        String regPrice2Color = regPrice2.getCssValue("color");
        String regPrice2Style = regPrice2.getCssValue("text-decoration");
        String regPrice2Weight = regPrice2.getCssValue("font-weight");
        String regPrice2Size = regPrice2.getCssValue("font-size");
        WebElement salePrice2 = driver.findElement(By.className("campaign-price"));
        String salePrice2Value = salePrice2.getText();
        String salePrice2Color = salePrice2.getCssValue("color");
        String salePrice2Weight = salePrice2.getCssValue("font-weight");
        String salePrice2Size = salePrice2.getCssValue("font-size");

        Assert.assertEquals(name, name2);
        Assert.assertEquals(regPriceValue, regPrice2Value);
        Assert.assertEquals(salePriceValue, salePrice2Value);

        int[] temp = colorFinder(regPriceColor);
        Assert.assertEquals(temp[0], temp[1]);
        Assert.assertEquals(temp[1], temp[2]);

        temp = colorFinder(salePriceColor);
        Assert.assertEquals(0, temp[1]);
        Assert.assertEquals(0, temp[2]);

        temp = colorFinder(regPrice2Color);
        Assert.assertEquals(temp[0], temp[1]);
        Assert.assertEquals(temp[1], temp[2]);

        temp = colorFinder(salePrice2Color);
        Assert.assertEquals(0, temp[1]);
        Assert.assertEquals(0, temp[2]);

        Assert.assertNotEquals(-1, regPriceStyle.indexOf("line-through"));
        Assert.assertNotEquals(-1, regPrice2Style.indexOf("line-through"));

        Assert.assertTrue(Integer.parseInt(salePriceWeight) > Integer.parseInt(regPriceWeight));
        Assert.assertTrue(Integer.parseInt(salePrice2Weight) > Integer.parseInt(regPrice2Weight));

        Assert.assertTrue(sizeFinder(salePriceSize)>sizeFinder(regPriceSize));
        Assert.assertTrue(sizeFinder(salePrice2Size)>sizeFinder(regPrice2Size));


        /*System.out.println("color: " +regPriceColor);
        System.out.println("color style: "+regPriceStyle);
        System.out.println("color size: "+regPriceSize);
        System.out.println("price weight: "+regPriceWeight);
        System.out.println("color2: "+regPrice2Color);
        System.out.println("price2 style: "+regPrice2Style);
        System.out.println("price2 size: "+regPrice2Size);
        System.out.println("price2 weight: "+rerPrice2Weight);
        System.out.println("");
        System.out.println("sale price color: "+salePriceColor);
        System.out.println("sale price weight: "+salePriceStyle);
        System.out.println("sale price size: "+salePriceSize);
        System.out.println("sale price2 color: "+salePrice2Color);
        System.out.println("sale price2 style: "+salePrice2Style);
        System.out.println("sale price2 size: "+salePrice2Size);
        */
    }

}
