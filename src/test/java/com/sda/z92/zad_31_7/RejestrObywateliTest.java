package com.sda.z92.zad_31_7;

import junit.framework.TestCase;
import org.junit.Test;

public class RejestrObywateliTest {

    @Test
    public void test_dodaj(){
        RejestrObywateli rejestrObywateli = new RejestrObywateli();
        rejestrObywateli.dodajObywatela("pawel", "gawel", "123");
        assert rejestrObywateli.znajdźObywatelaPoPeselu("123").isPresent();
    }

}