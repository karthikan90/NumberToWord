package com.numbertoword;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This class helps to test the all cases
 */
public class NumberToWordTest {

    private NumberToWord numberToWord = null;

    /**
     * This method executes before every test case.
     */
    @Before
    public void setUp(){
        numberToWord = new NumberToWord();
    }

    /***
     * This method tests with hundreds
     */
    @Test
    public void convertNumberTestWithHundreds(){
        String word = numberToWord.convert(456);
        Assert.assertEquals("When number is equivalent with word","four hundred fifty six", word);
    }

    /***
     * This method tests with thousands
     */
    @Test
    public void convertNumberTestWithThousands(){
        String word = numberToWord.convert(1456);
        Assert.assertEquals("When number is equivalent with word","one thousand four hundred fifty six", word);
    }

    /***
     * This method tests with Millions
     */
    @Test
    public void convertNumberTestWithMillions(){
        String word = numberToWord.convert(7812456);
        Assert.assertEquals("When number is equivalent with word","seven million eight hundred twelve thousand four hundred fifty six", word);
    }

}
