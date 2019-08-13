package com.mw;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {


    @Test
    void everyNthChar() {
       assertArrayEquals(new char[]{'e','l'}, Utilities.everyNthChar(new char[]{'h','e','l','l','o'},2));
        assertArrayEquals(new char[]{'h','e','l','l','o'}, Utilities.everyNthChar(new char[]{'h','e','l','l','o'},6));

    }



    @ParameterizedTest
    @CsvFileSource(resources = "dataForTest.txt", numLinesToSkip = 1)
    void testRemovePairs(String input, String output)
    {
        assertEquals(output,Utilities.removePairs(input));
    }

    void removePairs() {
        Random random=new Random();
        assertEquals("abcde",Utilities.removePairs("aabccdee"));
        assertEquals("abBcde",Utilities.removePairs("aabBccdee"));
        assertEquals("abcdee",Utilities.removePairs("aabccdeee"));
        assertEquals("1BbCcC",Utilities.removePairs("11BBbbCcCC"));
        assertEquals("",Utilities.removePairs(""));
    }

    @Test
    void testConverter() {
        assertEquals(300,Utilities.converter(10,5));
        assertThrows(ArithmeticException.class,()->Utilities.converter(10,0));
    }

    @Test
    void testNullIfOddLength() {
        assertNull(Utilities.nullIfOddLength("a"));
        assertNull(Utilities.nullIfOddLength("abc"));
        assertNotNull(Utilities.nullIfOddLength(""));
        assertNotNull(Utilities.nullIfOddLength("aa"));
    }
}