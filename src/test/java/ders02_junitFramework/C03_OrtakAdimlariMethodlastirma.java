package ders02_junitFramework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_OrtakAdimlariMethodlastirma {

    /*
        setup ve teardown islemlerini ayri bir method olarak olusturmanin
        2 temel faydasi var

        1- ayni adimlari tekrar tekrar yazmak zorunda kalmiyoruz
        2- @Test method'lari ayarlarla ugrasmak yerine
           SADECE kendilerinden istenen TEST islemini yapmaya odaklanabilirler
     */

    WebDriver driver;

    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void teardown(){
        // sayfayi kapatin
        driver.quit();
    }

    @Test
    public void test01(){
        setup();
        // youtube anasayfaya gidip
        driver.get("https://www.youtube.com");

        // url'in youtube icerdigini test edin

        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();


        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Youtube url testi PASSED");
        }else System.out.println("Youtube url testi FAILED");
        teardown();
    }

    @Test
    public void test02(){
        setup();

        // wisequarter anasayfaya gidip
        driver.get("https://www.wisequarter.com");

        // url'in wise icerdigini test edin

        String expectedUrlIcerik = "wise";
        String actualUrl = driver.getCurrentUrl();


        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Wisequarter url testi PASSED");
        }else System.out.println("Wisequarter url testi FAILED");


        // sayfayi kapatin
        teardown();
    }

    @Test
    public void test03(){
        setup();

        // arabam.com anasayfaya gidip
        driver.get("https://www.arabam.com");

        // url'in araba icerdigini test edin

        String expectedUrlIcerik = "araba";
        String actualUrl = driver.getCurrentUrl();


        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Arabam url testi PASSED");
        }else System.out.println("Arabam url testi FAILED");


        // sayfayi kapatin
        teardown();
    }
}
