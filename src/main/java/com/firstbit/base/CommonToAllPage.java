package com.firstbit.base;

import com.firstbit.driver.DriverManager;
import com.firstbit.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.security.Key;
import java.time.Duration;

import static com.firstbit.driver.DriverManager.getDriver;

public class CommonToAllPage {
    // If you want to call something before every Page Object Class call, Put your Code here")
//
// Open File, Open Data Base Connection You can write code here

    public CommonToAllPage() {
    }

    public void openVWOLoginURL(String url) {
        //driver.get
      //  getDriver().get("https://app.vwo.com");
        try {
            switch (url) {
                case "qa":
                    getDriver().get(PropertyReader.readKey("qa_url"));
                    break;
                case "preprod":
                    getDriver().get(PropertyReader.readKey("uat_url"));
                    break;
                default:
                    getDriver().get(PropertyReader.readKey("url"));
                    break;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickElement(By by) {
        getDriver().findElement(by).click();
    }

    public void clickElement(WebElement by) {
        by.click();

    }
    public void enterInput(By by, String key){
        getDriver().findElement(by).sendKeys(key);
    }
    public void enterInput(WebElement element, String Key) {
    element.sendKeys(Key);
    }
    // Waits

    public WebElement presenceOfElement(By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public WebElement visibilityOfElement(By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }

    public WebElement getElement(By key) {
        return getDriver().findElement(key);
    }

    public WebElement getElement(WebElement element) {
        return element;
    }


}


