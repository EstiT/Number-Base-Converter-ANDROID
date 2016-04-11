package com.example.estitweg.assignment3;


import android.test.InstrumentationTestCase;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Assert;


/**
 * Created by estitweg on 16-03-16.
 */


public class NumberConverterTestCase {

    //@Test
    //public void nameOfMethod() throws Exception{
    //mkae new instance NumberConverter aNumberConvverter = new NumberConverter();
    //assertEquals(101, aNumberConverter.method(101));


    //global instance of a number converter
    NumberConverter aNumberConverter = new NumberConverter();

    //method to test the intArrayToInt method
    @Test
    public void intArrayToIntTest() throws Exception{
        int number = 1234;
        int[] numberArray = {1,2,3,4};
        assertEquals(number, aNumberConverter.intArrayToInt(numberArray, 4));
        number = 0;
        int [] numberArray2 = {0};
        assertEquals(number, aNumberConverter.intArrayToInt(numberArray2, 1));
    }

    //method to test the decimalToTernary method
    @Test
    public void decimalToTernaryTest() throws Exception{
        assertEquals(10000, aNumberConverter.decimalToTernary(81, 2));
        assertEquals(11111, aNumberConverter.decimalToTernary(121, 3));
    }

    //method to test the decimalToOctal method
    @Test
    public void decimalToOctalTest()throws Exception{
        assertEquals(121, aNumberConverter.decimalToOctal(81, 2));
        assertEquals(171, aNumberConverter.decimalToOctal(121, 3));
    }

    //method to test the OctalToDecimal method
    @Test
    public void octalToDecimalTest() throws Exception{
        assertEquals(81, aNumberConverter.octalToDecimal(121));
        assertEquals(121, aNumberConverter.octalToDecimal(171));
    }

    //method to test the ternaryToDecimal method
    @Test
    public void ternaryToDecimalTest() throws Exception{
        assertEquals(81,aNumberConverter.ternaryToDecimal(10000));
        assertEquals(121,aNumberConverter.ternaryToDecimal(11111));
    }

}
