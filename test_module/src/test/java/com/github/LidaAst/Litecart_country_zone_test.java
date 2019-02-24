package com.github.LidaAst;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.fail;

public class Litecart_country_zone_test extends TestBase {

    @Test
    /*public void countryTest(){
        driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
        List<WebElement> countries = driver.findElements(By.cssSelector("tr.row a:not([title=Edit])"));
        String previousName = "";
        for (WebElement country:countries){
            String name = country.getText();
            if (name.compareTo(previousName)<0){
                fail("Countries are not in alphabetical order: "+previousName+" and "+name);
                break;
            }
            previousName=name;
        }

    }*/

    public void countryTest(){
        login();
        driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
        int numOfCountries = driver.findElements(By.cssSelector("tr.row a:not([title=Edit])")).size();
        String previousName = "";
        for (int rowNumber=2; rowNumber<numOfCountries+2; rowNumber++){
            WebElement row = driver.findElement(By.xpath("//tbody//tr["+rowNumber+"]"));
            WebElement country = row.findElement(By.cssSelector("a:not([title=Edit])"));
            String name = country.getText();
            if (name.compareTo(previousName)<0){
                fail("Countries are not in alphabetical order: "+previousName+" and "+name);
                break;
            }
            previousName=name;
            int zoneCount = Integer.parseInt(row.findElement(By.cssSelector("td:nth-child(6)")).getText());
            if (zoneCount>0){
                country.click();
                List<WebElement> zones = driver.findElements(By.cssSelector("input[name*=zones][name*=name]"));
                String previousZone = "";
                for (WebElement zone:zones){
                    String zoneName = zone.getText();
                    if (zoneName.compareTo(previousZone)<0){
                        fail("Zones are not in alphabetical order: "+previousZone+" and "+zoneName+" in "+name);
                        return;
                    }
                    previousZone=zoneName;
                }
                driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
            }
        }
    }

    @Test
    public void zoneTest(){
        driver.navigate().to("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        String countrySelector = "tr.row a:not([title=Edit])";
        int size = driver.findElements(By.cssSelector(countrySelector)).size();
        for (int countryNumber=0; countryNumber<size; countryNumber++){
            driver.findElements(By.cssSelector(countrySelector)).get(countryNumber).click();
            List<WebElement> zones = driver.findElements(By.cssSelector("select[name*=zone_code]"));
            String previosZoneName = "";
            for (WebElement zone:zones){
                String zoneName = zone.findElement(By.cssSelector("[selected=selected]")).getText();
                if (zoneName.compareTo(previosZoneName)<0){
                    fail("Zones are not in alphabetical order: "+previosZoneName+" and "+zoneName);
                    return;
                }
                previosZoneName=zoneName;
            }
            driver.navigate().to("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        }
    }
}
