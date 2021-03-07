import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class hipTripValidation {
    WebDriver driver;

    @BeforeMethod
    public void initTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://lowcoststrip.com/search");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void searchTripPosetiveTest() throws InterruptedException {
        WebElement from = driver.findElement(By.id("mat-input-0"));
        from.click();
        from.sendKeys("Tel-Aviv");
        Thread.sleep(2000);
        WebElement dropFrom = driver.findElement(By.className("mat-option-text"));
        dropFrom.click();
        Thread.sleep(2000);
        WebElement to = driver.findElement(By.id("mat-input-1"));
        to.click();
        to.sendKeys("Prague");
        Thread.sleep(2000);
        WebElement dropTo = driver.findElement(By.className("mat-option-text"));
        dropTo.click();
        Thread.sleep(2000);
        WebElement goButton = driver.findElement(By.cssSelector("button.mat-primary"));
        goButton.click();
        Thread.sleep(2000);
        WebElement ansver = driver.findElement(By.className("aside"));
        if(ansver.isEnabled()){
            System.out.println("Pass");
        }else System.out.println("not Pass");
    }

}
