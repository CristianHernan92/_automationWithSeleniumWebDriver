package SauceDemo.SauceDemo;

import org.junit.jupiter.api.Test;

//selenium
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_BonusTrack1 {
	void _closeAllNavigators(WebDriver driver) throws InterruptedException{
		//Esperamos 3 segundos
        Thread.sleep(3000);
        //cerramos las ventanas
        driver.quit();
	}
	
	//TESTS

    @Test
    void shouldAnswerWithTrue() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        
        driver.navigate().to("https://www.saucedemo.com/");
        
        //Maximisamos el navegador
        driver.manage().window().maximize();
        
        //Limpiamos las cookies
        driver.manage().deleteAllCookies();
        
        //agarramos el campo username por medio de su ID
        WebElement username = driver.findElement(By.id("user-name"));
        
        //agarramos el campo password por medio de su ID
        WebElement password = driver.findElement(By.id("password"));
        
        //agarramos el campo botón por medio de su ID
        WebElement loginButton = driver.findElement(By.id("login-button"));
        
        //ingresar dato en el campo de username y password y hacer click en el botón de login
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();
        
      
        //finalizamos
        _closeAllNavigators(driver);
    }
}
