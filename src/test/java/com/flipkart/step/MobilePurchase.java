package com.flipkart.step;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;

public class MobilePurchase {
     private static final String FileUtils = null;
	public static WebDriver driver;
	@BeforeClass
	public static void launchbrowser() throws InterruptedException {
		System.out.println("launch");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\junittasks\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/?s_kwcid=AL!739!3!582822043916!e!!g!!flipkart&gclsrc=aw.ds&&semcmpid=sem_8024046704_brand_exe_buyers_goog&gclid=EAIaIQobChMI_cCk4-Hb-AIVj5JmAh1ZlgSBEAAYASAAEgI2iPD_BwE");
		driver.manage().window().maximize();
	}
	@AfterClass
	public static void close() {
		System.out.println("close");
	}
	@Before
	public void beforeclass() {
		System.out.println("before");
	}
	@After
	public void afterclass() {
		System.out.println("after");
	}
	@Test
	public  void launchbrowser1()  {
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
	}
	@Test
	public void launchbrowser2() {
		System.out.println("mobiles");
		driver.findElement(By.name("q")).sendKeys("vivo mobiles");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@Test
	public void launchbrowser3() {
		System.out.println("click");
		List<String> a = new ArrayList<String>();
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		
			for (WebElement w : list) {
				String text = w.getText();
				  a.add(text);
			}
		
		
	}
	@Test
	public void launchbrowser4() {
		System.out.println("close");
		
		driver.findElement(By.xpath("//div[contains(text(),'vivo T1 44W (Ice Dawn, 128 GB)')][1]")).click();
		Set<String> window = driver.getWindowHandles();
		
		driver.findElement(By.xpath("//span[@class='B_NuCI']")).getText();
		List<String> listWindow = new ArrayList<String>();
	 	driver.switchTo().window(listWindow.get(1));
	}
	
	public void screenshot() {
		System.out.println("Specifications screenshot");
	 	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	 	JavascriptExecutor js =(JavascriptExecutor)driver;
	 	WebElement spec = driver.findElement(By.xpath("//div[text()='Specifications']"));
	 	js.executeScript("arguments[0].scrollIntoView(true)", spec);
	 	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		TakesScreenshot ts =(TakesScreenshot)driver;
		File src =ts.getScreenshotAs(OutputType.FILE);
		File trg= new File("C:\\Users\\DD\\workspace\\JunitTest\\target\\specification.png");
		FileUtils.copyFile(src, trg);
	}
}
