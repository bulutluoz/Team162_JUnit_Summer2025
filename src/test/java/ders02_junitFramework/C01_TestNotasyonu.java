package ders02_junitFramework;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class C01_TestNotasyonu {

    /*
        Su ana kadar
        run edilebilir bir class olusturmak icin
        main method SARTTIR diyorduk

        main method olsa bile
        test method'larini calistirmak
        ancak main method icinde yapilacak method call ile mumkun olabiliyordu.

        Testing'de kontrolu daha fazla ele almamiz
        gerektiginde her bir test method'unu bagimsiz olarak calistirabilmemiz gerekir

     */

    @Test @Disabled("bu method 13.sprint sonuna kadar calistirilmamali")
    public void test03(){
        System.out.println("Test03 calisti");
    }

    @Test
    public void test02(){
        System.out.println("Test02 calisti");
    }

    @Test
    public void test01(){
        System.out.println("Test01 calisti");
    }

}
