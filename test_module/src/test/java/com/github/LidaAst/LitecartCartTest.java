package com.github.LidaAst;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class LitecartCartTest extends TestBase {

    private void waitForCartUpdate(String quantity){
        wait.until(d->d.findElement(By.cssSelector("span.quantity")).getText().equals(quantity));
    }

    @Test
    public void cartTest(){
        for (int i=1; i<4; i++){
            driver.navigate().to("http://litecart.stqa.ru/en/");
            driver.findElement(By.cssSelector("li.product")).click();
            try {
                Select size = new Select(driver.findElement(By.name("options[Size]")));
                size.selectByValue("Small");
            } catch (Exception e){}
            driver.findElement(By.name("add_cart_product")).click();
            waitForCartUpdate(String.valueOf(i));
        }

        driver.findElement(By.xpath("//a[contains(text(),'Checkout »')]")).click();
        List<WebElement> itemsInCart = driver.findElements(By.cssSelector("tr td.item"));
        for (int i = 0; i<itemsInCart.size(); i++){
            driver.findElement(By.name("remove_cart_item")).click();
            wait.until(ExpectedConditions.stalenessOf(itemsInCart.get(0)));
        }
    }
}
