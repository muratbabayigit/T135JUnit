import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class M06 {
    static WebDriver driver;

/*
1-https://babayigit.net/test/ adresine gidin
2-Login butonuna tıklayın
3-Username kısmına “babayigit” yazdırın
4-Password kısmına baba123 yazdırın
5-Login butonuna tıklayın
6-Başarılı giriş yapılamadığını doğrulayın
7-Pasword kısmına “Mb3471&” yazdırın.
8-Login butonuna tıklayın
9-Başarılı giriş yapıldığını doğrulayın
10-Sayfayı kaptın
*/

    @BeforeClass
    public static void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public void tearDown(){driver.quit();}

    @Before
    public void before(){
        driver.get("https://www.babayigit.net/test/");
    }


}
