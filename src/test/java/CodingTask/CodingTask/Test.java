package CodingTask.CodingTask;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://e.ggtimer.com/");
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement searchButton = driver.findElement(By.id("EggTimer-start-time-input-text"));
		wait.until(ExpectedConditions.elementToBeClickable(searchButton));
		driver.findElement(By.id("EggTimer-start-time-input-text")).clear();
		driver.findElement(By.id("EggTimer-start-time-input-text")).sendKeys("10");
		driver.findElement(By.cssSelector("[class='EggTimer-start-time-input']>button")).click();
		WebElement countTimer = driver.findElement(By.cssSelector("[class='ClassicTimer-inner']>p>span"));
		try {
			for (int a = 10; a <= 20; a--) {
				if (a != 0 && a != 1) {
					Assert.assertEquals(a + " seconds", countTimer.getText());
				} else if (a == 1) {
					Assert.assertEquals(a + " second", countTimer.getText());
				} else if (a == 0) {
					Assert.assertEquals(a + " second", countTimer.getText());
					break;
				}
			}
		} finally {
			wait.until(ExpectedConditions.alertIsPresent());
			String alert = driver.switchTo().alert().getText();
			Assert.assertEquals(alert, "Time Expired!");
			driver.switchTo().alert().accept();
			String expired = driver.findElement(By.cssSelector("[class='ClassicTimer-inner']>p>span")).getText();
			Assert.assertEquals(expired, "Time Expired!");
			driver.close();
		}

	}

}
