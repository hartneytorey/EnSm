package Es1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

public class ElementTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
    	WebDriverManager.chromedriver().setup();
    	  driver = new ChromeDriver();
    	  driver.manage().window().maximize();
  
    }

    @Test
    public void addAndAssertNElements() {
        int n = 3;
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        for (int i = 0; i < n; i++) {
            driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        }

        List<WebElement> addedElements = driver.findElements(By.xpath("//button[text()='Delete']"));
        Assert.assertEquals(addedElements.size(), n);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
