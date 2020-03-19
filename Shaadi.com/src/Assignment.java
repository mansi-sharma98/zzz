
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment {
	static WebDriver driver;

	public static void clicking(WebDriver driver, By by) {

		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).click();

	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:/Users/mansi.sharma1/Downloads/chromedriver_win32/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// launching the sites
		driver.get("https://www.shaadi.com/");
		String parent = driver.getWindowHandle();
		System.out.println(" parent window handle :  " + parent);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		// login link click
		clicking(driver, By.linkText("Login"));

		// sign-up click
		clicking(driver, By.linkText("Sign Up Free"));

		// random generator for e-mail
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);

		// email details
		WebElement email = driver.findElement(By.xpath("//input[contains(@name,'email')]"));
		email.sendKeys("user01" + randomInt + "@gmail.com");
		System.out.println("email entered is " + " value--> " + email.getAttribute("value"));

		// password details
		WebElement create_pass = driver.findElement(By.xpath("//input[contains(@name,'password')]"));
		create_pass.sendKeys("987532fh");

		// profile for
		new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'postedby')]"))).click();
		List<WebElement> myList = new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"___gatsby\"]/div/div[6]/form/div[2]/div[3]/div/div[2]")));
		for (WebElement element : myList)
			if (element.getText().contains("Brother")) {
				element.click();
			}

		// submit button
		clicking(driver, By.xpath("//button[contains(text(),'Next')]"));
		System.out.println("Button next");

		WebDriverWait wait = new WebDriverWait(driver, 80);

		// first and last names
		WebElement fn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@name,'first_name')]")));
		fn.sendKeys("akaka");
		System.out.println("first name entered is " + " value--> " + fn.getAttribute("value"));

		WebElement ln = driver.findElement(By.xpath("//input[contains(@name,'last_name')]"));
		ln.sendKeys("verma");
		System.out.println("last name entered is " + " value--> " + ln.getAttribute("value"));

		ln.clear();

		// Date Selections (day, month,year)
		WebElement days= new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Day')]")));
		days.click();
		clicking(driver, By.xpath("//div[contains(text(),'7')]"));
		String dayval= days.getText();
		

		WebElement month = new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Month')]")));
		month.click();
		clicking(driver, By.xpath("//div[contains(text(),'Mar')]"));	
		String monthval= month.getText();
		
		WebElement year = new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Year')]")));
		year.click();
		clicking(driver, By.xpath("//div[contains(text(),'1993')]"));
		String yearval= year.getText();
		
		System.out.println("date entered dd-mm-yyyy is -->" +" " + dayval + " " + monthval+ " "+ yearval);
		

		// religion
		WebElement religion = driver.findElement(By.xpath("//*[@id=\"___gatsby\"]/div/div[6]/form/div[4]/div/div/div"));
		religion.click();
		driver.findElement(By.xpath("//*[@id=\"___gatsby\"]/div/div[6]/form/div[4]/div/div/div[2]/div[8]")).click();
		String rel = religion.getText();
		System.out.println("Religion is selected--> " + rel);

		// language
		WebElement lang = driver.findElement(By.xpath("//*[@id=\"___gatsby\"]/div/div[6]/form/div[5]/div/div/div[1]"));
		lang.click();
		driver.findElement(By.xpath("//*[@id=\"___gatsby\"]/div/div[6]/form/div[5]/div/div/div[2]/div[2]/div[18]"))
				.click();
		String lan = lang.getText();
		System.out.println("Language is selected --> " + lan);

		// country
		WebElement country = driver.findElement(By.xpath("//*[@id=\"___gatsby\"]/div/div[6]/form/div[6]/div/div/div"));
		country.click();
		driver.findElement(By.xpath("//*[@id=\"___gatsby\"]/div/div[6]/form/div[6]/div/div/div[2]/div[2]/div[91]"))
				.click();
		String cou = country.getText();
		System.out.println("country is selected --> " + cou);

		// sign-up button
		clicking(driver, By.xpath("//button[contains(text(),'Sign Up')]"));

		// <---------------------------- PAGE 02------------------------>

		// city he lives in
		WebElement city = driver.findElement(By.xpath("//input[@id='places']"));
		city.click();
		Thread.sleep(2000);
		city.sendKeys("Delhi, India");
		String liv = city.getAttribute("value");
		Thread.sleep(2000);
		city.sendKeys(Keys.CONTROL + "\t");
		Thread.sleep(2000);
		System.out.println("Lives in---> " + liv);

		// lives with family

		driver.findElement(By.xpath("//div[contains(text(), 'Yes')]")).click();

		// Martial status
		
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='maritalStatus']"))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Never Married')]"))).click();
	
		// vegetarian
		clicking(driver, By.xpath("//div[contains(text(),'Veg')]"));
		System.out.println("Vegetarian");

		//height
		
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='height']"))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'4ft 7in - 139cm')]"))).click();
		 
		/* 
		 //caste
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id,'caste']"))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Baniya')]"))).click();
		*/
	
		// continue
		clicking(driver, By.xpath("//span[contains(text(),'Continue')]"));
	
		// <-----------------------PAGE 03------------------>
		//education level
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='educationLevel']"))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Doctorate')]"))).click();
		 
		 //education field
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='educationField']"))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Commerce')]"))).click();
		 
		 //college
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='highestCollege']"))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Acharya')]"))).click();
		 
		 //works with
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='workingWith']"))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Private Company')]"))).click(); 
		 
		//working as
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='workingAs']"))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Banking Professional')]"))).click();
		 
		 //company name
		 WebElement company = driver.findElement(By.xpath("//input[@id='employer']"));
			company.click();
			Thread.sleep(2000);
			company.sendKeys("A  PJ  Project");
			Thread.sleep(2000);
			company.sendKeys(Keys.CONTROL + "\t");
			Thread.sleep(2000);
			
			//income slider
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Monthly')]"))).click();
			
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			//income selector
			 WebElement Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='income']")));
			 Element.click();

			 js.executeScript("arguments[0].scrollIntoView();", Element);
		     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'₹ 60 to 80K monthly')]"))).click();
				 
			 //continue button
			 clicking(driver, By.xpath("//span[contains(text(),'Continue')]"));
			
				// <-----------------------PAGE 04------------------>
             //about brother
			 Thread.sleep(2000);
			 WebElement textarea= driver.findElement(By.xpath("//textarea"));
			 Thread.sleep(2000);

			 textarea.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.");
			 textarea.sendKeys(Keys.CONTROL + "\t");
			 
			 //phone number
			 wait.until(ExpectedConditions.elementToBeClickable(By.id("mobileNumber"))).sendKeys("9911223344");
			 
			 //create profile
			 clicking(driver, By.xpath("//span[contains(text(),'Create Profile')]"));

			 
				// <-----------------------PAGE 05------------------>

			 /*//Close button
			 clicking(driver,By.xpath("//a[@id='campaignclosebutton']"));
			 
			 //header match
			 WebElement congrats = driver.findElement(By.xpath("//span[contains(text(),'Congrats!')]"));
			 String text = congrats.getText();
			 String exp = " Congrats! " + fn+ "'s Profile has been created.";
			 if(text==exp) {
				 System.out.println("Header matches");
			 }*/
			 
			 driver.quit();

        

	}

}
