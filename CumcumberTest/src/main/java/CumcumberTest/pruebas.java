package CumcumberTest;


import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;

public class pruebas {
private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.choucairtesting.com/empleos-testing/");
	}

	@Test
	public void testempleoPage() {
		
	    WebElement searchBox = driver.findElement(By.name("search_keywords"));
		searchBox.clear();
		searchBox.sendKeys("analista de pruebas");
		searchBox.submit();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		assertEquals("analista de pruebas",driver.getTitle());
	}
	@Test
	public void testempleoPage2() {
		
	    WebElement searchBox = driver.findElement(By.name("search_location"));
		searchBox.clear();
		searchBox.sendKeys("bogota");
		searchBox.submit();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		assertEquals("search_location",driver.getTitle());
	}
	@When
	public void button() {
		driver.findElement(By.name("Search_Jobs")).click();
	}
	
	@After
	public void tearDown() {
	driver.quit();
	}


}
