package PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import StepDefinitions.Hook;

public class TimeCounterPage {

	public static WebDriverWait wait;
	public static WebDriver driver;

	public TimeCounterPage() {
		TimeCounterPage.driver = Hook.getDriver();
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 60);
	}

	@FindBy(id = "EggTimer-start-time-input-text")
	WebElement searchInputField;
	@FindBy(css = "[class='EggTimer-start-time-input']>button")
	WebElement searchButton;
	@FindBy(css = "[class='ClassicTimer-inner']>p>span")
	WebElement timerText;

	public void launchApplication() {
		driver.get("https://e.ggtimer.com/");
	}

	public void enterTime() {
		wait.until(ExpectedConditions.elementToBeClickable(searchInputField));
		searchInputField.clear();
		searchInputField.sendKeys("10");
		searchButton.click();
	}

	public void validateTimeCounter() {
		try {
			for (int a = 10; a <= 20; a--) {
				if (a != 0 && a != 1) {
					Assert.assertEquals(a + " seconds", timerText.getText());
				} else if (a == 1) {
					Assert.assertEquals(a + " second", timerText.getText());
				} else if (a == 0) {
					Assert.assertEquals(a + " second", timerText.getText());
					break;
				}
			}
		} finally {
			wait.until(ExpectedConditions.alertIsPresent());
			String alert = driver.switchTo().alert().getText();
			Assert.assertEquals(alert, "Time Expired!");
			driver.switchTo().alert().accept();
			Assert.assertEquals(timerText.getText(), "Time Expired!");
		}
	}
}
