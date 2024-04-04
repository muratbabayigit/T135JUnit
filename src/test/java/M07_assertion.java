import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.*;


public class M07_assertion {
//https://www.bestbuy.com/ Adresine gidin
//  farkli test method'lari olusturarak asagidaki testleri yapin
//  ○ Sayfa URL'inin https://www.bestbuy.com/ 'a esit oldugunu test edin
//  ○ titleTest => Sayfa başlığının "Rest" içermediğini(contains) test edin
//  ○ logoTest => BestBuy logosunun görüntülendigini test edin
//  ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    static WebDriver driver;

    @BeforeClass
    public static void setUP(){
        //WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void urlTest(){
        //  ○ Sayfa URL'inin https://www.bestbuy.com/ 'a esit oldugunu test edin
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl=driver.getCurrentUrl();

      assertEquals(expectedUrl,actualUrl);
      // assertEquals("https://www.bestbuy.com/",driver.getCurrentUrl());

    }
    @Test
    public void titleTest(){
        //  ○ titleTest => Sayfa başlığının "Rest" içermediğini(contains) test edin
        String unexpectedTitle="Rest";
        String actualTitle=driver.getTitle();
        assertFalse(actualTitle.contains("Rest"));
    }

    @Test
    public void logoTest(){
        WebElement logo=driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        assertTrue(logo.isDisplayed());
    }

}
