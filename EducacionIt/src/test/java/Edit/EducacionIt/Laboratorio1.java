package Edit.EducacionIt;

import java.time.Duration;

import org.junit.*;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Laboratorio1 {
	
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
	
	
}
