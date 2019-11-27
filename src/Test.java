import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;

import javafx.scene.control.Alert;

import org.openqa.selenium.chrome.ChromeDriver;
public class Test {

	public static void main(String[] args) {
		//Initiate driver
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		  // 1. Maximize the browser
		 
		driver.manage().window().maximize();

        // 2.Navigate to home page
        driver.get("https://raamatukogu.herokuapp.com:");

        //3. Click on create book link
        driver.findElement(By.linkText("Create new book")).click();
       
        //4. filling out the title 

        WebElement title = driver.findElement(By.xpath("//input[@id='title']"));
        JavascriptExecutor titleExe = (JavascriptExecutor)driver;
        titleExe.executeScript("arguments[0].value='Test Assignment';", title);
      
        //5. select the author
        Select dropdown = new Select(driver.findElement(By.id("author")));
        dropdown.selectByVisibleText("Carroll, Lewis");

        //6. Fill the summary text
       
        WebElement Summary =   driver.findElement(By.id("summary"));
        JavascriptExecutor SummaryExe = (JavascriptExecutor)driver;
        SummaryExe.executeScript("arguments[0].value='Testing program';", Summary);


        //7. Enter ISBN
    
        WebElement Isbn =  driver.findElement(By.id("isbn"));
        JavascriptExecutor IsbnExe = (JavascriptExecutor)driver;
        IsbnExe.executeScript("arguments[0].value='Test1234';", Isbn);

        //8. select fiction icon
         
         WebElement Genre =    driver.findElement(By.id("5b6714c93809970014e31c9a"));
         JavascriptExecutor GenreExe = (JavascriptExecutor)driver;
         GenreExe.executeScript("arguments[0].click();", Genre);

        
       
        //9. Submit form
      
        WebElement Submit =     driver.findElement(By.xpath("//button[@type='submit']"));
        JavascriptExecutor submitExe = (JavascriptExecutor)driver;
        submitExe.executeScript("arguments[0].click();", Submit);
        
        //Navigate to verify book
        driver.navigate().to("https://raamatukogu.herokuapp.com/catalog/books");
        
        //Verifcation of book
        driver.findElement(By.linkText("Test Assignment")).click();
        
        
	}

}






