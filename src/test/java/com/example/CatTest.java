package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    private Cat cat;

    @Mock
    Feline feline;

    @Before
    public void setUp() throws Exception {
        cat = new Cat(feline);
    }
    //ReturnCorrectValue
    @Test
    public void getSoundTest() {
        String expected = cat.getSound();
        String actual = "Мяу";
        assertEquals(expected, actual);
    }
    //ReturnCorrectValue
    @Test
    public void getFoodTest() throws Exception {
        // Чем каждый раз создавать список, лучше сделать сразу переменную с ним.
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expected);
        List<String> actual = cat.getFood();
        assertEquals(expected, actual);
    }
}
