package toolsqa;


import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Form {
	 static WebDriver driver;
	public static void main(String[] args) {
	       System.setProperty("webdriver.chrome.driver","C:/Users/mansi.sharma1/Downloads/chromedriver_win32/chromedriver.exe");
	       System.setProperty("webdriver.chrome.silentOutput", "true");
	       driver = new ChromeDriver();
	        driver.manage().window().maximize();

	       driver.get("https://www.toolsqa.com/automation-practice-form/");
	       String parent = driver.getWindowHandle();
	       System.out.println(" parent window handle :  "+ parent);
	       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
	     
	       //WebDriverWait wait=new WebDriverWait(driver,40);
	       driver.findElement(By.xpath("//*[@id=\"cookie_action_close_header\"]")).click();
	       System.out.println("Cookie accepted");
	  
	      WebElement nextlink= driver.findElement(By.linkText("Link Test"));
	      nextlink.click();
	  
	       driver.navigate().to("https://www.toolsqa.com/automation-practice-form/");
	       
	       WebElement fn = driver.findElement(By.name("firstname")); //first name
	       fn.sendKeys("Mansi");
	       System.out.println("first name is "+" value--> "+fn.getAttribute("value"));
           WebElement ln = driver.findElement(By.id("lastname"));//ln
           ln.sendKeys("Sharma");
           System.out.println("last name is "+" value--> "+ln.getAttribute("value"));	    
           
           //genders male and female
           WebElement female_radio1 = driver.findElement(By.id("sex-1"));
        		   //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sex-1")));
           female_radio1.click();
           System.out.println("gender clicked -->  "+female_radio1.isSelected()+" value-->  "+female_radio1.getAttribute("value"));
           
           //experience
           WebElement exp0= driver.findElement(By.id("exp-0"));
           exp0.click();
           System.out.println("experience clicked --> "+exp0.isSelected()+" value is---> "+exp0.getAttribute("value"));
           
	       
	       // date 
	       WebElement datepicker= driver.findElement(By.id("datepicker")); 
	       datepicker.sendKeys("13 feb 2020");
           System.out.println("date entered is "+" value--> "+datepicker.getAttribute("value"));

	       
	       //profession check-box
	       WebElement profession1= driver.findElement(By.id("profession-1"));
	       profession1.click();
           System.out.println("profession choosen -->  "+profession1.isSelected()+" value-->  "+profession1.getAttribute("value"));

	       
	       //file upload
	       WebElement upload= driver.findElement(By.id("photo"));
	       upload.sendKeys("C:/Users/mansi.sharma1/Desktop/Capture.png");
	       
	           
	       //link downloads file
	       WebElement linktext = driver.findElement(By.linkText("Selenium Automation Hybrid Framework"));
           linktext.click();
	       
	       // tool selection check-box
	        driver.findElement(By.id("tool-1")).click();  
	        
	        //list selection continents
	        Select dropdown = new Select(driver.findElement(By.id("continents")));
	        dropdown.selectByVisibleText("Europe");
	        WebElement sel= dropdown.getFirstSelectedOption();
	        String selected= sel.getText();
	        System.out.println("continent(1) -->  "+selected);
	        
	        //multiple choice selection 
	        Select dropdownMultiple = new Select(driver.findElement(By.id("continentsmultiple")));
	        dropdownMultiple.selectByVisibleText("Asia");
	        dropdownMultiple.selectByIndex(2);
	        List <WebElement> elementCount = dropdownMultiple.getOptions();
	        int n = elementCount.size();
	        for(int i =0; i<n ; i++){
	        String value = elementCount.get(i).getText();
	        System.out.println("value "+i+ "= " +value);
	        }
	   
	        	        
	        List <WebElement> sel1= dropdownMultiple.getAllSelectedOptions();
             for(WebElement t : sel1)
             {
            	 String txt = t.getText();
 		        System.out.println("continent(many) value -->  "+txt);

             }

	       
	        
	        //commands selection
	        Select seleniumcmds = new Select(driver.findElement(By.id("selenium_commands")));
	        seleniumcmds.selectByVisibleText("Navigation Commands");
	        seleniumcmds.selectByIndex(2);
	        

	        //social contact
	        String Actual_url= "https://www.facebook.com/sharer.php?u=https%3A%2F%2Fwww.toolsqa.com%2Fautomation-practice-form%2F&t=Automation+Practice+Form";
	        String expected_url= "https://www.facebook.com/sharer.php?u=https%3A%2F%2Fwww.toolsqa.com%2Fautomation-practice-form%2F&t=Automation+Practice+Form";

	        WebElement social= driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/a[1]"));
	        social.click();
	      
	 //       Assert.assertEquals(Actual_url,expected_url,"link not true");	        
	        System.out.println("URL matching --> Part executed");
	        String child = driver.getWindowHandle();
	        System.out.println("Child window -->  "+child);
	        if(child != parent) {
	        	driver.switchTo().window(parent);
	        }
	 }

}
