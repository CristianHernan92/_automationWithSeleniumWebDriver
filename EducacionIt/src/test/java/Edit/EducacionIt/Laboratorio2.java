package Edit.EducacionIt;

import java.time.Duration;

import org.junit.*;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class Laboratorio2 {

	WebDriver driver;

	@Test
	void lab1_test() {
		System.out.print("¡Hola Mundo de Automatización!");
	}
	
	@Test
	void lab1_E1() {
		driver = new ChromeDriver();
		driver.navigate().to("https://automationexercise.com/products");
		driver.close();
	}
	
	@Test
	void lab1_E2() {
		driver = new FirefoxDriver();
		driver.navigate().to("https://automationexercise.com/products");
		driver.manage().window().maximize();
		driver.close();
	}
	
	@Test
	void lab1_E3() {
		driver = new ChromeDriver();
		driver.navigate().to("https://automationexercise.com/products");
		WebElement findField = driver.findElement(By.id("search_product"));
		findField.sendKeys("Blue Top");
		WebElement submitButton = driver.findElement(By.id("submit_search"));
		submitButton.click();
		driver.close();
	}
	
	//
	
	@Test
	void lab2_E1() {
		String url = "https://automationexercise.com/signup";
		driver = new ChromeDriver();
		driver.navigate().to(url);
		
		//
		//first elements before entering the form of signup
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")).sendKeys("Cristian");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")).sendKeys("othertwo@gmail.com");
		new WebDriverWait(driver,Duration.ofSeconds(4)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"))).click();
		//
		
		/*
		
		//espera explícita sobre el elemento Email
		new WebDriverWait(driver,Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#email")));
		WebElement email = driver.findElement(By.cssSelector("#email"));
		email.sendKeys("cristianhernandelrio@gmail.com");
		
		//espera explícita sobre el elemento Name
		new WebDriverWait(driver,Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("Cristian");
		
		*/
		
		//espera explícita sobre el elemento Password
		new WebDriverWait(driver,Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("12345678");
		
		//espera explícita sobre el elemento dropdown de Birth Day
		new WebDriverWait(driver,Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOfElementLocated(By.id("days")));
		Select dayOfBirth = new Select(driver.findElement(By.id("days")));		
		dayOfBirth.selectByIndex(1);
		//espera explícita sobre el elemento dropdown de Birth Month
		new WebDriverWait(driver,Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOfElementLocated(By.id("months")));
		Select monthOfBirth = new Select(driver.findElement(By.id("months")));		
		monthOfBirth.selectByVisibleText("April");
		//espera explícita sobre el elemento dropdown de Birth Year
		new WebDriverWait(driver,Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOfElementLocated(By.id("years")));
		Select yearOfBirth = new Select(driver.findElement(By.id("years")));		
		yearOfBirth.selectByIndex(1);
		
		//espera explícita sobre el elemento radio Title
		new WebDriverWait(driver,Duration.ofSeconds(4)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@value,'Mr')]")));
		WebElement radioTitle = driver.findElement(By.xpath("//input[contains(@value,'Mr')]"));
		radioTitle.click();
		
		
		//others element
		driver.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys("Cristian");
		driver.findElement(By.xpath("//*[@id=\"last_name\"]")).sendKeys("Del Río");
		driver.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys("Saavedra");
		driver.findElement(By.xpath("//*[@id=\"state\"]")).sendKeys("Buenos Aires");
		driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("Ensenada");
		driver.findElement(By.xpath("//*[@id=\"zipcode\"]")).sendKeys("1925");
		driver.findElement(By.xpath("//*[@id=\"mobile_number\"]")).sendKeys("+123456789");
		
		//espera implícita sobre el elemento Button
		new WebDriverWait(driver,Duration.ofSeconds(4)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button")));
		WebElement button = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button"));
		button.click();
		
		driver.close();
	}
	
}
