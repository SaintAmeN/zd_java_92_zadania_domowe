package com.sda.z92.week1.zad1;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(JUnit4.class)
public class MainTest {
    private static List<String> TEST_STRING_LIST;

    @Before
    public void przedKazdymTestem(){
        TEST_STRING_LIST = new ArrayList<>(
                Arrays.asList("1", "2", "3")
        );
    }

    @Test
    public void test_sprawdzCzyZawieraElement_true() {
        Assert.assertEquals(true, Main.sprawdzCzyZawieraElement(TEST_STRING_LIST, "3"));
    }

    @Test
    public void test_sprawdzCzyZawieraElement_false() {
        Assert.assertEquals(false, Main.sprawdzCzyZawieraElement(TEST_STRING_LIST, "5"));
    }

    @Test
    public void test_sprawdzCzyZawieraElement_false_with_null() {
        Assert.assertEquals(false, Main.sprawdzCzyZawieraElement(TEST_STRING_LIST, null));
    }

    @Test
    public void test_usuwanieElementu() {
        Assert.assertEquals(3, TEST_STRING_LIST.size());
        TEST_STRING_LIST.remove("1");
        Assert.assertEquals(2, TEST_STRING_LIST.size());
        TEST_STRING_LIST.clear();
        Assert.assertEquals(0, TEST_STRING_LIST.size());
    }

}