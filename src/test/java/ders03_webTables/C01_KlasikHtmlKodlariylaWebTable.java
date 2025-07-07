package ders03_webTables;

import org.junit.jupiter.api.Test;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C01_KlasikHtmlKodlariylaWebTable extends TestBase_Each {

    @Test
    public void klasikWebTableTesti()  {

        //1."https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");
        //2.Web table tum body’sini yazdirin
        //3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
        //4. Web table’daki satir sayisinin 5 oldugunu test edin
        //5. Tum satirlari yazdirin
        //6. Web table’daki sutun sayisinin 4 olduğunu test edin
        //7. 3.sutunu yazdirin
        //8. Tablodaki basliklari yazdirin
        //9. Satir ve sutunu parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
        //10. 4.satirdaki category degerinin "Furniture" oldugunu test edin

        ReusableMethods.bekle(3);

    }
}
