import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class M10_dropDown {
    //https://www.amazon.com/customer-preferences/country?ref_=icp_lop_mop_chg_ais&preferencesReturnUrl=/ adresine gidin
    //Ülke menüsünü locate edin
    //Türkiye Seçeneğini seçin
    //Go to website butonuna tıklayın

    static WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void countryMenu(){
        driver.get("https://www.amazon.com/customer-preferences/country?ref_=icp_lop_mop_chg_ais&preferencesReturnUrl=/");
        WebElement country= driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']"));
        country.click();
        WebElement turkey=driver.findElement(By.xpath("//*[@id='icp-dropdown_18']"));
        turkey.click();
        driver.findElement(By.xpath("//*[@id='nav-search-submit-button']")).click();

        String expectedIcerik="com.tr";
        String actualUrl= driver.getCurrentUrl();

        //Assert.assertTrue(actualUrl.contains(expectedIcerik));

    }
}
