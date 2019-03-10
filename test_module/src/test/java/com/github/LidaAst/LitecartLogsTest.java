package com.github.LidaAst;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;

import java.util.List;
import java.util.NoSuchElementException;

public class LitecartLogsTest extends TestBase {

    @Test
    public void logsTest(){
        login();
        driver.navigate().to("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");

        do {
            List<WebElement> folders = driver.findElements(By.xpath("//i[@class='fa fa-folder']/parent::td//a"));
            if (folders.size()==0){
                break;
            }
            folders.get(0).click();

        } while (true);

        int size = driver.findElements(By.xpath("//tr[@class='row']//img/parent::td//a")).size();

        for (int i=0; i<size; i++){
            driver.findElements(By.xpath("//tr[@class='row']//img/parent::td//a")).get(i).click();
            for (LogEntry l : driver.manage().logs().get("browser").getAll()){
                System.out.println(l);
            }
            driver.findElement(By.name("cancel")).click();
        }
    }
}
