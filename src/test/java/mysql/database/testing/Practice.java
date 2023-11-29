package mysql.database.testing;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hrm.objectRepo.LoginPage;

public class Practice {
	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver/domain/HRM_System/");
		LoginPage lg = new LoginPage(driver);
		lg.hrHeadLogin("hrhead@gmail.com", "hrhead@123");
	}
}