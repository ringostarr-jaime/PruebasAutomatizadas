package steps;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepCar1 {
	WebDriver driver;
	/*---Elementos del navegador yo lo uso para realizar una accion
	determinada al realizar busquedas con xpath*/
	WebElement element;		
	// --Declarado a nivel de clase porque falla al realizar de manera global
	// ---Utilizado para ejecutar javaScript
	// JavascriptExecutor JavascriptExecutor = ((JavascriptExecutor)driver);
	// --Ejemplo de una alerta
	// JavascriptExecutor.executeScript("alert('Termino la prueba');");
	@Given("the user is in the index page")
	public void index() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		// --Esto es una espera implicita esperamos x tiempo
		// a que los elementos web esten esten presentes en el web driver
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://automationpractice.com/index.php");
		// Maximizar
		driver.manage().window().maximize();
		// --Esperamos en lo que carga la web
		Thread.sleep(5000);
	}

	@Then("I want to add short clothes")
	public void addShort() {
		try {
			for (int i = 0; i < 20; i++) {
				// ---Simulamos la accion de desplazarnos hacia abajo con la tecla DOWN del
				// teclado
				driver.findElement(By.cssSelector("body")).sendKeys(Keys.DOWN);
				/*
				 * Robot robot = new Robot(); // MIDDLE WHEEL CLICK
				 * robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
				 * robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK); // SCROLL THE MOUSE WHEEL
				 * robot.mouseWheel(-100);
				 */
			}
			// ---Para acciones con el Mouse se usa el robot
			/*
			 * Robot robot = new Robot(); // SET THE MOUSE X Y POSITION robot.mouseMove(300,
			 * 550);
			 */

			// ---Encadenando acciones movernos hacia el elemento que revela los otros para
			// poder selecionar
			Actions action = new Actions(driver);
			element= driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[1]/div/div[1]/div/a[1]/img"));
			Thread.sleep(2000);
			action.moveToElement(element).moveToElement(driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]/span")))
					.click().build().perform();
			Thread.sleep(2000);
			
			//element = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]/span"));			
		} catch (Exception e) {
			System.out.println("==addShort() " + e);
		} finally {
			// --Ejemplo de una alerta
			// JavascriptExecutor.executeScript("alert('Termino la prueba');");
		}
	}

	@Then("continue shop")
	public void continueShop() {
		// --Declarado a nivel de clase porque falla al realizar de manera global
		// ---Utilizado para ejecutar javaScript
		// JavascriptExecutor JavascriptExecutor = ((JavascriptExecutor)driver);
		try {			
			element = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span"));
			element.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("===continueShop() " + e);
		} finally {
			// JavascriptExecutor.executeScript("alert('Termino la prueba');");
		}
	}

	@And("down the page")
	public void downPage() {
		for (int i = 0; i < 14; i++) {
			// ---Simulamos la accion de desplazarnos hacia abajo con la tecla DOWN del
			// teclado
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.DOWN);
		}
		
	}

	@Then("add two different summer dress")
	public void addSumerDress() {
		//JavascriptExecutor JavascriptExecutor = ((JavascriptExecutor)driver);
		try {	
			//Thread.sleep(1000);	
			Actions action = new Actions(driver);
			//--Comprar
			element= driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[5]/div/div[1]/div/a[1]/img"));
			action.moveToElement(element).moveToElement(driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[5]/div/div[2]/div[2]/a[1]/span")))
					.click().build().perform();		
			Thread.sleep(2000);		
			//--salir			
			element = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span"));
			element.click();
			Thread.sleep(2000);	
			//---comprar
			element= driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[6]/div/div[1]/div/a[1]/img"));
			action.moveToElement(element).moveToElement(driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[6]/div/div[2]/div[2]/a[1]/span")))
					.click().build().perform();
			Thread.sleep(2000);		
			element = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span"));
			element.click();
			Thread.sleep(2000);	
		} catch (Exception e) {
			System.out.println("===addSumerDress() " + e);
		}finally {
			 //JavascriptExecutor.executeScript("alert('Termino la prueba');");
		}

	}
     
     @And("click a chiffon dress, click in more") 
     public void clickMore() {
    	 try {
    		 Actions action = new Actions(driver);
 			//--ver mas
 			element= driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[7]/div/div[1]/div/a[1]/img"));
 			action.moveToElement(element).moveToElement(driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[7]/div/div[2]/div[2]/a[2]/span")))
 					.click().build().perform();		
 			Thread.sleep(3000);
 			
		}catch(Exception e)
    	 {
			System.out.println("===clickMore() " + e);
    	 }
    	 finally {
			// TODO: handle finally clause
		}
     }
     @Then("see the dress") 
     public void seeDress() {
	     try {
	    	 Actions action = new Actions(driver);
	    	 for (int i = 0; i < 12; i++) {
	 			// ---Simulamos la accion de desplazarnos hacia abajo con la tecla DOWN del
	 			// teclado
	 			driver.findElement(By.cssSelector("body")).sendKeys(Keys.DOWN);
	 		}
	    	 Thread.sleep(1000);
	    	 	//--ver
				//element= driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[2]/div[2]/div/ul/li[2]/a/img"));
	    	 	
	    	 	element= driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[2]/div[2]/div/ul/li[2]/a/img"));
				action.moveToElement(element).perform();
	    	 	
				Thread.sleep(2000);	
				//--ver
				element= driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[2]/div[2]/div/ul/li[3]/a/img"));
				action.moveToElement(element).perform();
				
				//element= driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[2]/div[2]/div/ul/li[3]/a/img"));
				Thread.sleep(2000);
				element= driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[2]/div[2]/div/ul/li[4]/a/img"));
		} catch (Exception e) {
			System.out.println("===seeDress() " + e);
		}
     }
     
     @And("add to the car") 
     public void addToCar() {
    	 try {
    		//--comprar
 			element = driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span"));
 			element.click(); 			
 			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("===addToCar() " + e);
		}    	 	
     }
     
     
     @Then("proceed to checkout") 
     public void proceedCheckout() {
    	 try {
    		//--comprar
  			element = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"));
  			element.click(); 			
  			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println("===proceedCheckout() " + e);
		}
     }
     
     @And("move to the total") 
     public void moveTotal() {
    	 try {
    		 Thread.sleep(1050);
    		 for (int i = 0; i < 20; i++) {
    	 			// ---Simulamos la accion de desplazarnos hacia abajo con la tecla DOWN del
    	 			// teclado
    	 			driver.findElement(By.cssSelector("body")).sendKeys(Keys.DOWN);
    	 		}	
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
     }
     

}
