import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class M09_dropDown {

    // https://the-internet.herokuapp.com/dropdown adresine gidin.
    // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    // 4.Tüm dropdown değerleri(value) yazdırın
    // 5.Dropdown'un boyutunun 3 olduğunu test edin
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
    public void dropDown(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement dropDownMenu=driver.findElement(By.xpath("//*[@id='dropdown']"));

        Select select=new Select(dropDownMenu);
        select.selectByIndex(1);

        System.out.println(select.getFirstSelectedOption().getText());

        // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        // 4.Tüm dropdown değerleri(value) yazdırın

        List<WebElement> optionList=select.getOptions();


        for (WebElement eachElement:optionList ) {
            System.out.println(eachElement.getText());
        }

        // 5.Dropdown'un boyutunun 3 olduğunu test edin

        int actualSize=optionList.size();
        int expectedSize=3;
        Assert.assertEquals(expectedSize,actualSize);

    }

}
