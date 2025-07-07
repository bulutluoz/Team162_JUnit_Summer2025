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
        //   tum baslik elementlerini bir liste olarak kaydedelim
        List<WebElement> baslikElementleriList = driver.findElements(By.xpath("//thead/tr/th"));

        System.out.println("Tablodaki basliklar : " + ReusableMethods.stringListeDondur(baslikElementleriList));

        // liste yapmak yerine, baslik satirini tek bir webelement olarak kaydedip yazdirsak ?

        WebElement baslikSatiriElementi = driver.findElement(By.xpath("//thead/tr"));
        System.out.println("Baslik satiri : " + baslikSatiriElementi.getText());
        // bu yontemde basliklari yazdirabiliriz ama birbirinden ayirmak mumkun degil


        //9. Satir ve sutunu parametre olarak alip,
        //   hucredeki bilgiyi döndüren bir method olusturun

        System.out.println(getCellData(1, 2)); // Electronics
        System.out.println(getCellData(3, 3)); // $99.00

        //10. 4.satirdaki category degerinin "Furniture" oldugunu test edin


        String expectedDeger = "Furniture";
        String actualDeger = getCellData(4,2);

        Assertions.assertEquals(expectedDeger,actualDeger);

        ReusableMethods.bekle(3);

    }

    public String getCellData(int satirNo, int sutunNo){

        //     spesifik bir hucrenin xpath'i   : //tbody/tr[3]/td[2]
        //     bu xpath 3.satirdaki 2.dataya aittir
        //     bu xpath'i dinamik yapmak icin
        //     3 yazan yere satirNo, 2 yazan yere sutunNo gelmelidir


        String dinamikXpath = "//tbody/tr[" + satirNo + "]/td[" + sutunNo + "]";

        WebElement istenenHucreElementi = driver.findElement(By.xpath(dinamikXpath));

        return istenenHucreElementi.getText();

    }
}
