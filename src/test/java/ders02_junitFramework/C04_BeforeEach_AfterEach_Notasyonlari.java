package ders02_junitFramework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeEach_AfterEach_Notasyonlari {

    WebDriver driver;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Before Each Calisti");
    }

    @AfterEach
    public void teardown(){
        // sayfayi kapatin
        System.out.println("After Each Calisti");
        driver.quit();
    }

    @Test
    public void test01(){
        // youtube anasayfaya gidip
        driver.get("https://www.youtube.com");

        // url'in youtube icerdigini test edin

        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();


        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Youtube url testi PASSED");
        }else System.out.println("Youtube url testi FAILED");
    }

    @Test
    public void test02(){
        // wisequarter anasayfaya gidip
        driver.get("https://www.wisequarter.com");

        // url'in wise icerdigini test edin

        String expectedUrlIcerik = "wise";
        String actualUrl = driver.getCurrentUrl();


        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Wisequarter url testi PASSED");
        }else System.out.println("Wisequarter url testi FAILED");


        // sayfayi kapatin
    }

    @Test
    public void test03() throws InterruptedException {
        // arabam.com anasayfaya gidip
        driver.get("https://www.arabam.com");
        Thread.sleep(3000);
        // url'in araba icerdigini test edin

        String expectedUrlIcerik = "araba";
        String actualUrl = driver.getCurrentUrl();


        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Arabam url testi PASSED");
        }else System.out.println("Arabam url testi FAILED");

        // sayfayi kapatin
    }
}
