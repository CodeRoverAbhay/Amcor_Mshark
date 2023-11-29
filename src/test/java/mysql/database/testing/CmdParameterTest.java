package mysql.database.testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CmdParameterTest {
	@Test
	public void mavenParameterTest() {
		String url = System.getProperty("url");
		String email = System.getProperty("eid");
		String password = System.getProperty("pwd");
		System.out.println(url);
		System.out.println(email);
		System.out.println(password);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.name("hr_email")).sendKeys(email);
		driver.findElement(By.name("hr_password")).sendKeys(password);
		Select select = new Select(driver.findElement(By.id("hr_type")));
		select.selectByValue("HR Head");
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		String popupMsg = wait.until(ExpectedConditions.alertIsPresent()).getText();
		System.out.println(popupMsg);
		driver.switchTo().alert().accept();
		driver.manage().window().minimize();
		driver.quit();
	}
}