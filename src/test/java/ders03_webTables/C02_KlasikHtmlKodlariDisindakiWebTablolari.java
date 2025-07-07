package ders03_webTables;

import org.junit.jupiter.api.Test;

public class C02_KlasikHtmlKodlariDisindakiWebTablolari {

    @Test
    public void test01(){

        /*

            Klasik HTML kodlari ile olusturulan tabloda
            bir cell'deki datanin locate'i SADECE taglarla alinabilir
            //tbody/tr[3]/td[2]

            Klasik HTML tablosu disinda yontemlerle bir webtable olusturulmussa
            locate icin tag'lar yetmez
            developer'in hangi mantikla satir ve datalari olusturdugunu bulmali
            ve xpath'ler ile locate alinmalidir

            //*[@role = 'trow'][3] // *[@role = 'tdata'][2]
         */

        //  1. “https://testotomasyonu.com/webtables2” sayfasina gidin
        //  2. Headers da bulunan basliklari yazdirin
        //  3. 3.sutunun basligini yazdirin
        //  4. Tablodaki tum datalari yazdirin
        //  5. Tabloda kac tane cell (data) oldugunu yazdirin
        //  6. Tablodaki satir sayisini yazdirin
        //  7. Tablodaki sutun sayisini yazdirin
        //  8. Tablodaki 3.kolonu yazdirin
        //  9. Bir method olusturun, Test sayfasindan satir ve sutun verildiginde datayi yazdirsin
        //  10. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin
    }
}
