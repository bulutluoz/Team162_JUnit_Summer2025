package ders03_webTables;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class C01_KlasikHtmlKodlariylaWebTable extends TestBase_Each {

    @Test
    public void klasikWebTableTesti()  {

        //1."https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");

        //2.Web table tum body’sini yazdirin
        WebElement bodyElementi = driver.findElement(By.tagName("tbody"));

        System.out.println("Tum Body : \n" + bodyElementi.getText() +"\n====================" );

        //3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin

        String expectedBodyIcerik = "Comfortable Gaming Chair";
        String actualTableBody = bodyElementi.getText();

        Assertions.assertTrue(actualTableBody.contains(expectedBodyIcerik));

        //4. Web table’daki satir sayisinin 5 oldugunu test edin

        List<WebElement> satirElementleriList = driver.findElements(By.xpath("//tbody/tr"));

        int expectedSatirSayisi = 5 ;
        int actualSatirSayisi = satirElementleriList.size();

        Assertions.assertEquals(expectedSatirSayisi,actualSatirSayisi);

        //5. Tum satirlari yazdirin

        System.out.println(satirElementleriList);

        // liste webelementlerden olusuyor ve webelementler direkt yazdirilamaz
        // satirlari yazdirmak icin 2 yolumuz var

        // 1.yontem - bir loop ile her bir webelemnti ele alip getText() ile yazisini yazdirabilirsiniz

        for (int i = 0; i <satirElementleriList.size() ; i++) {

            System.out.println( i+1 + ".satir   :    \n" + satirElementleriList.get(i).getText());
        }



        // 2.yontem - Reusable Methods'daki hazir method'u kullanma

        // elimizde weblementler'den olusan satirElementleriList var

        System.out.println("Tablodaki satirlar listesi : \n" + ReusableMethods.stringListeDondur(satirElementleriList));


        //6. Web table’daki sutun sayisinin 4 olduğunu test edin

        //   Web tablosunda sutun yapisi kod olarak yoktur
        //   Sutun ile ilgili islemlerde her satirdaki datalara bakabiliriz
        //   ornegin kac sutun var sorusu yerine
        //   herhangi bir satirda kac data var diye sorabiliriz
        //   biz 3.satira bakalim

        List<WebElement> ucuncuSatirElementleriList = driver.findElements(By.xpath("//tbody/tr[3]/td"));

        int expectedSutunSayisi = 4;
        int actualSutunSayisi = ucuncuSatirElementleriList.size();

        Assertions.assertEquals(expectedSutunSayisi,actualSutunSayisi);


        //7. 3.sutunu yazdirin
        //   sutun yapisi olmadigindan
        //   "her satirdaki ilgili kayit" olarak dusunebilirz

        List <WebElement> ucuncuSutunElementleriList = driver.findElements(By.xpath("//tbody/tr[*]/td[3]"));

        // hazir method'u kullanalim

        System.out.println("3.sutun : " + ReusableMethods.stringListeDondur(ucuncuSutunElementleriList));



        //8. Tablodaki basliklari yazdirin


        //9. Satir ve sutunu parametre olarak alip,
        //   hucredeki bilgiyi döndüren bir method olusturun



        //10. 4.satirdaki category degerinin "Furniture" oldugunu test edin

        ReusableMethods.bekle(3);

    }
}
