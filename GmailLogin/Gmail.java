package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class A {
    static WebDriver driver;
  public static void main(String[] args) {
       System.setProperty("webdriver.chrome.driver","C:/Users/mansi.sharma1/Downloads/chromedriver_win32/chromedriver.exe");
       System.setProperty("webdriver.chrome.silentOutput", "true");
       driver = new ChromeDriver();
       driver.get("https://accounts.google.com/signin");
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
     WebElement email= driver.findElement(By.xpath("//input[@id='identifierId']"));
      email.sendKeys("mansi261198");
       driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span")).click();
      WebElement password= driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
      password.sendKeys("abc12345");
       //driver.findElement(By.xpath("//[@id=\'password\']/div[1]/div/span/div/span/span/span[1]/svg")).click();
       driver.findElement(By.xpath("//input[@id='identifierId']")).click();
       driver.findElement(By.xpath("//input[@type='password']")).click();
       

}
}
