package google;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Check {

	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/mansi.sharma1/Downloads/chromedriver_win32/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		driver.get("http://www.google.co.in/");
		driver.get("http://google.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("popcorn");
		driver.findElement(By.name("btnK")).submit();

		List<WebElement> links = driver.findElements(By.tagName("a"));

		// printing total available links
		System.out.println("Total links are " + links.size());
		Iterator<WebElement> iterate = links.iterator();

		// iterating them
		while (iterate.hasNext()) {

			String url = iterate.next().getAttribute("href");
			if (url == null || url.isEmpty()) {
				System.out.println("This url is empty");
			} else {
				verifyLinkActive(url);
			}

		}

	}

	public static void verifyLinkActive(String linkUrl) {
		try {
			URL url = new URL(linkUrl);

			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();

			httpURLConnect.setConnectTimeout(3000);

			httpURLConnect.connect();

			if (httpURLConnect.getResponseCode() == 200) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());

			}
			if (httpURLConnect.getResponseCode() >= 400) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
			}

		} catch (Exception e) {

		}

	}

}
