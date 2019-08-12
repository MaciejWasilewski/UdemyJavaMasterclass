package com.mw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

    @Test
    void everyNthChar() {
       assertArrayEquals(new char[]{'e','l'}, Utilities.everyNthChar(new char[]{'h','e','l','l','o'},2));
        assertArrayEquals(new char[]{'h','e','l','l','o'}, Utilities.everyNthChar(new char[]{'h','e','l','l','o'},6));
    }

    @Test
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

    }

    @Test
    void testNullIfOddLength() {
        assertNull(Utilities.nullIfOddLength("a"));
        assertNull(Utilities.nullIfOddLength("abc"));
        assertNotNull(Utilities.nullIfOddLength(""));
        assertNotNull(Utilities.nullIfOddLength("aa"));
    }
}