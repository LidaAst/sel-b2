package com.github.LidaAst;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class First_test extends TestBase {

    @Test
    public void myFirstTest() {
        driver.navigate().to("https://www.edx.org/");


    }

}
