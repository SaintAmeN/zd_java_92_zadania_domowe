package com.sda.z92.zad_31_7;

import com.sda.z92.zad_31_7.rejestrob.RejestrObywateli;
import org.junit.Test;

public class RejestrObywateliTest {

    @Test
    public void test_dodaj(){
        RejestrObywateli rejestrObywateli = new RejestrObywateli();
        rejestrObywateli.dodajObywatela("pawel", "gawel", "123");
        assert rejestrObywateli.znajd┼║ObywatelaPoPeselu("123").isPresent();
    }

}