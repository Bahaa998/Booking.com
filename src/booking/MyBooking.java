package booking;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyBooking {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webDriver.chrome.driver",
				"‪C:\\Users\\ECC\\OneDrive\\Desktop\\selenium_dev\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.get("https://www.booking.com/");

		//Click on where you going
		driver.findElement(By.xpath("//*[@id=\"ss\"]")).click();
		
		//Send text Amman
		driver.findElement(By.xpath("//*[@id=\"ss\"]")).sendKeys("Amman");
		Thread.sleep(3000);
		
		// Arrow down to first choice
		driver.findElement(By.xpath("//*[@id=\"ss\"]")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(3000);
		
		//Click on first choice
		driver.findElement(By.xpath("//*[@id=\"ss\"]")).sendKeys(Keys.ENTER);
		
		//Check in from 26 dec to 31 dec
		driver.findElement(
				By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[1]/table/tbody/tr[5]/td[2]"))
				.click();
		driver.findElement(
				By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[1]/table/tbody/tr[5]/td[7]"))
				.click();
		Thread.sleep(2000);
		
		//Click on search button
		driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[4]/div[2]/button")).click();
		
		
		// get list of hotel
		List <WebElement> myHotel = driver.findElements(By.className("a23c043802")); //25
		int Allitem = myHotel.size();
		System.out.println("Size of List : " + Allitem);
		
		//print name of tenth item
		String nameOfTenth=myHotel.get(10).getText();
		System.out.println(nameOfTenth);
	}

}
