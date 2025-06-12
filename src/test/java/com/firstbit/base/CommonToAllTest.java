package com.firstbit.base;

import com.firstbit.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.sql.Driver;

public class CommonToAllTest {
    // To call the Start the Webdriver
    // Down the WebDriver
    // Start Webdirver start

    @BeforeMethod
    public void setup(){
        DriverManager.init();
    }
    @AfterMethod
    public void tearDown(){
        DriverManager.down();
    }
}
