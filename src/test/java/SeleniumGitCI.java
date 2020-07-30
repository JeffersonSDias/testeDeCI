
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumGitCI {
	private static WebDriver driver;

	@BeforeAll
	public static void setUp() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.navigate().to("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.MILLISECONDS);
	}

	@Test
	public void userLogin() {
		WebElement searchTxt = driver.findElement(By.name("q"));
		searchTxt.sendKeys("automation");
		WebElement submitBtn = driver.findElement(By.name("btnK"));
		submitBtn.click();
		
		System.out.println("Current Title is:" + driver.getTitle());
	}

	@AfterAll
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}