package OpenHRM.OpenHRM;

import org.junit.jupiter.api.Test;

//selenium
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

//para el uso de espera hasta encontrar el elemento
import java.time.Duration;

public class Test_BonusTrack1b {
	
	//UTIL FUNCTIONS
	
	//cierra todos los nevagadores abiertos por el driver
	void _closeAllNavigatorsOfDriver(WebDriver driver, int seconds) throws InterruptedException{
		var _seconds = seconds * 1000;
		//esperamos tales segundos
        Thread.sleep(_seconds);
        //cerramos las ventanas
        driver.quit();
	}
	
	//setear una espera global para todos los elementos del driver (se le llama espera implícita) antes de rendirse
	void _setMaxWaitForFindAllElements(WebDriver driver, int secondsToWait) {
		var _seconds = Duration.ofSeconds(secondsToWait);
		driver.manage().timeouts().implicitlyWait(_seconds); 
	}
	
	//setear una espera para un elemento específico del driver (se le llama espera explícita) antes de rendirse
	void _setMaxWaitForASpecificElement(WebDriver driver, int secondsToWait, ExpectedCondition<?> condition) {
	    Duration _seconds = Duration.ofSeconds(secondsToWait);
	    new WebDriverWait(driver, _seconds).until(condition);
	}
	
	//TESTS

    @Test
    void shouldAnswerWithTrue() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        //_setMaxWaitForFindAllElements(driver,3);
        
        driver.navigate().to("https://orangehrmlive.com/book-a-free-demo");
        
        //Maximisamos el navegador
        driver.manage().window().maximize();
        
        //Limpiamos las cookies
        driver.manage().deleteAllCookies();
        
        //agarramos el campo username por medio de su ID
        _setMaxWaitForASpecificElement(driver,10,ExpectedConditions.elementToBeClickable(By.id("Form_getForm_FullName")));
        WebElement username = driver.findElement(By.id("Form_getForm_FullName"));
        username.sendKeys("Cristian");
        
        //agarramos el campo email por medio de su ID
        WebElement email = driver.findElement(By.id("Form_getForm_Email"));
        email.sendKeys("cristian@gmail.com");
        
        //agarramos el campo phone number por medio de su ID
        WebElement phoneNumber = driver.findElement(By.id("Form_getForm_Contact"));
        phoneNumber.sendKeys("123456789");
        
        //agarramos el campo company name por medio de su ID
        WebElement companyName = driver.findElement(By.id("Form_getForm_CompanyName"));
        companyName.sendKeys("Nubimetrics");
        
        //agarramos el campo de seleccion de país por medio de su ID
        WebElement campoCountry = driver.findElement(By.id("Form_getForm_Country"));
        Select selectCompany = new Select(campoCountry);
        selectCompany.selectByIndex(1);
        
        //agarramos el campo de título de trabajador por medio de su ID
        WebElement jobTitle = driver.findElement(By.id("Form_getForm_JobTitle"));
        jobTitle.sendKeys("Developer");
        
        //agarramos el campo de seleccion de número de empleados por medio de su ID
        WebElement numberOfEmployees = driver.findElement(By.id("Form_getForm_NoOfEmployees"));
        Select selectNumberOfEmployees = new Select(numberOfEmployees);
        selectNumberOfEmployees.selectByIndex(1);
        
        //agarramos el botón para enviar
        WebElement getAFreeDemoButton = driver.findElement(By.id("Form_getForm_action_submitForm"));
        getAFreeDemoButton.submit();
        
        //
      
        //finalizamos
        _closeAllNavigatorsOfDriver(driver,3);
    }
}

