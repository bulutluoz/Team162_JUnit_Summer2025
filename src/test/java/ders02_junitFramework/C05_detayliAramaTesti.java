package ders02_junitFramework;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_detayliAramaTesti {
    /*
        EGER birbiri ile ilintili olan test methodlarini calistirmak istersek

        *** oncelikle calisma sirasinin dogru oldugunu kontrol etmeliyiz
            JUnit calistirma sirasini kafasina gore belirler
            Test method'larina verdigimiz isimler sebebiyle,
            Test method'lari istenen sirada calismayabilir.
            eger istenen sira ile calismiyorsa
            isimler test01, test02, test03 gibi ardisik sekilde verilirse
            bu siralamaya uygun sekilde calisirlar

        *** eger test method'lari birbiri ile ilintili ise
            bir test method'unun calismasi icin onceki test method'larinin calismasi gerekiyorsa
            @BeforeEach ve @AfterEach yerine
              @BeforeAll ve @AfterAll kullanilabilir

            Bu durumda hic bir test method'u calismadan once @BeforeEach calisir
            tum method'larin calisip bitmesinden sonra
            en son olarak teardown'in tek bir sefer calismasi icin
            @AfterAll kullanilabilir

            Ancak bu notasyon kullanildiginda
            method'un static olarak israetlenmesi ZORUNLUDUR

     */

    // https://the-internet.herokuapp.com/checkboxes gidip
    // asagidaki gorevleri 3 farkli test method'u olarak olusturun
    // 1- url'in heroku icerdigini test edin
    // 2- checkbox1 check box'inin erisilebilir oldugunu test edin
    // 3- checkbox1'i tiklayip, checkbox1'in secili oldugunu test edin

    static WebDriver driver;

    @BeforeAll
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    public static void teardown(){
        driver.quit();

    }


    @Test
    public void urlTesti(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        // 1- url'in heroku icerdigini test edin

        String expectedUrlIcerik = "heroku";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Url testi PASSED");
        } else System.out.println("Url testi FAILED");
    }

    @Test
    public void erisilebilirlikTesti(){
        // 2- checkbox1 check box'inin erisilebilir oldugunu test edin

        WebElement checkbox1Kutusu  = driver.findElement(By.xpath("(//input[@type ='checkbox'])[1]"));

        if (checkbox1Kutusu.isEnabled()){
            System.out.println("erisilebilirlik testi PASSED");
        } else System.out.println("erisilebilirlik testi FAILED");
    }


    @Test
    public void isaretlemeTesti() throws InterruptedException {
        // 3- checkbox1'i tiklayip, checkbox1'in secili oldugunu test edin

        WebElement checkbox1Kutusu  = driver.findElement(By.xpath("(//input[@type ='checkbox'])[1]"));

        checkbox1Kutusu.click();

        Thread.sleep(3000);

        if (checkbox1Kutusu.isSelected()){
            System.out.println("Checkbox1 testi PASSED");
        } else  System.out.println("Checkbox1 testi FAILED");
    }
}
