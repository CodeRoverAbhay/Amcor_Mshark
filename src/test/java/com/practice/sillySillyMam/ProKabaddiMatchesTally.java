package com.practice.sillySillyMam;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

// Get all the matches tally of the passed team  name.
public class ProKabaddiMatchesTally {
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.prokabaddi.com/standings");
		String teamName = "Bengaluru Bulls";
		List<WebElement> allTeamName = driver.findElements(By.xpath("//p[text()='" + teamName + "']"));
		boolean flag = false;
		for (WebElement ele : allTeamName) {
			if (ele.getText().equals(teamName)) {
				String play = driver.findElement(By.xpath("//p[text()='" + teamName	+ "']/ancestor::div[@class='row-head']/descendant::div[@class='table-data matches-play']")).getText();
				String won = driver.findElement(By.xpath("//p[text()='" + teamName	+ "']/ancestor::div[@class='row-head']/descendant::div[@class='table-data matches-won']")).getText();
				String lost = driver.findElement(By.xpath("//p[text()='" + teamName	+ "']/ancestor::div[@class='row-head']/descendant::div[@class='table-data matches-lost']")).getText();
				String tie = driver.findElement(By.xpath("//p[text()='" + teamName + "']/ancestor::div[@class='row-head']/descendant::div[@class='table-data matches-draw']")).getText();
				String scoreDiff = driver.findElement(By.xpath("//p[text()='" + teamName + "']/ancestor::div[@class='row-head']/descendant::div[@class='table-data score-diff']")).getText();
				String form = driver.findElement(By.xpath("//p[text()='" + teamName	+ "']/ancestor::div[@class='row-head']/descendant::div[@class='table-data form']")).getText();
				String points = driver.findElement(By.xpath("//p[text()='" + teamName + "']/ancestor::div[@class='row-head']/descendant::div[@class='table-data points']")).getText();
				System.out.println("Team Name is : " + teamName);
				System.out.println(teamName + " had played a total of " + play + " matches in the league.");
				System.out.println(teamName + " had won a total of " + won + " matches in the league.");
				System.out.println(teamName + " had lost a total of " + lost + " matches in the league.");
				System.out.println(teamName + " had a total of " + tie + " matches in the league which got draw.");
				System.out.println(teamName + " had a total of " + scoreDiff + " score difference in the league.");
				System.out.println(teamName + " last five matches status is as below");
				System.out.println(form);
				System.out.println("Currently " + teamName + " had a total of " + points + " in the league.");
			}
		}
		if (!flag) {
			System.out.println(teamName + " is not a part of this league.");
		}
		driver.manage().window().minimize();
		driver.quit();
	}
}