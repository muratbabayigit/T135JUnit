import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class M01_MavenIlkTest {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.babayigit.net/test");

        Thread.sleep(3000);
        driver.quit();

    }
}
