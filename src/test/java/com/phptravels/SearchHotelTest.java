package com.phptravels;


import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SearchHotelTest {

    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception{
        baseUrl = "http://www.phptravels.net";
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
    }

//    @Test
    public void testChrome() throws Exception {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl+"/login");
        Thread.sleep(2000);
        driver.findElement(By.name("username")).sendKeys("user@phptravels.com");
        driver.findElement(By.name("password")).sendKeys("demouser");
        driver.findElement(By.xpath(".//*[@id='loginfrm']/div[4]/button")).click();

        Thread.sleep(2000);
        String welcomeMessage = driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div[1]/h3")).getText();

        System.out.println(welcomeMessage);
    }

//    @Test
    public void testFirefox() throws Exception {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl+"/login");
        Thread.sleep(2000);
        driver.findElement(By.name("username")).sendKeys("user@phptravels.com");
        driver.findElement(By.name("password")).sendKeys("demouser");
        driver.findElement(By.xpath(".//*[@id='loginfrm']/div[4]/button")).click();

        Thread.sleep(2000);
        String welcomeMessage = driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div[1]/h3")).getText();

        System.out.println(welcomeMessage);
    }

    @Test
    public void searchHotel() throws Exception {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
//        driver.findElement(By.xpath(".//*[@id='citiesInput']")).sendKeys("Portland");
        driver.findElement(By.xpath(".//*[@id='dpean1']/div/input")).sendKeys("07/17/2017");
        driver.findElement(By.xpath(".//*[@id='dpd2']/div/input")).sendKeys("07/18/2017");
//        driver.findElement(By.xpath(".//*[@id='EXPEDIA']/div/form/div[6]/div/button")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
