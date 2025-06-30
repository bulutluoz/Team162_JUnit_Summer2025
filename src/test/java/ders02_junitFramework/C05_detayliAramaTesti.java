package ders02_junitFramework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_detayliAramaTesti {

    // https://the-internet.herokuapp.com/checkboxes gidip
    // asagidaki gorevleri 3 farkli test method'u olarak olusturun
    // 1- url'in heroku icerdigini test edin
    // 2- checkbox1 check box'inin erisilebilir oldugunu test edin
    // 3- checkbox1'i tiklayip, checkbox1'in secili oldugunu test edin

    WebDriver driver;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void teardown(){
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
