package com.Maven_Zoho;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Zoho {
	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.zoho.com/login.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement sign = driver.findElement(By.xpath("//a[text()='Sign Up Now']"));
		sign.click();
		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		email.sendKeys("palani@gmail.com");
		WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
		pass.sendKeys("123456789");
		Thread.sleep(3000);
		WebElement checkbox = driver.findElement(By.xpath("//span[@id='signup-termservice']"));
		checkbox.click();
		Thread.sleep(3000);
		WebElement signup = driver.findElement(By.xpath("//input[@type='submit']"));
		signup.click();

		TakesScreenshot sc = (TakesScreenshot) driver;
		File s = sc.getScreenshotAs(OutputType.FILE);
		File f = new File("C:\\Users\\Manikandaprabu\\eclipse-workspace\\Maven_Zoho\\Report");
		FileUtils.copyFile(s, f);

	}
}
