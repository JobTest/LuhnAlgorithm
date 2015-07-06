package com.algorithm;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Lazarchuk Aleksandr
 * @version 1.1
 * @date 05/07/2015
 * **********************************
 * The test case for 'Luhn Algorithm'
 */
public class LuhnTest {

    private ILuhn luhn;

    @Before
    public void setUp() {
        luhn = new Luhn();
    }

    /**
     * Double every second digit, from the rightmost digit
     */
    @Test (expected = NullPointerException.class)
    public void testDoubleEvenDigitsNull(){
        assertNull("Here is test NULL:", luhn.doubleEvenDigits(null));
    }
    @Test
    public void testDoubleEvenDigits(){
        List<Integer> actual_double_even_digits_single = Arrays.asList(1);
        List<Integer> actual_double_even_digits_min = Arrays.asList(2,2);
        List<Integer> actual_double_even_digits_max = Arrays.asList(9,9,9,9,9,9,9);
        List<Integer> actual_double_even_digits_zero = Arrays.asList(0,0,0,0,0,0,0);
        List<Integer> actual_double_even_digits = Arrays.asList(2,2,2,2,2,2,2);
        List<Integer> actual_double_even_digits_real = Arrays.asList(4,9,9,2,7,3,9,8,7,1,6);
        List<Integer> expected_double_even_digits_single = Arrays.asList(1);
        List<Integer> expected_double_even_digits_min = Arrays.asList(4,2);
        List<Integer> expected_double_even_digits_max = Arrays.asList(9,9,9,9,9,9,9);
        List<Integer> expected_double_even_digits_zero = Arrays.asList(0,0,0,0,0,0,0);
        List<Integer> expected_double_even_digits = Arrays.asList(2,4,2,4,2,4,2);
        List<Integer> expected_double_even_digits_real = Arrays.asList(4,9,9,4,7,6,9,7,7,2,6);

        assertEquals("Here is test double_even_digits_single:", expected_double_even_digits_single, luhn.doubleEvenDigits(actual_double_even_digits_single));
        assertEquals("Here is test double_even_digits_min:", expected_double_even_digits_min, luhn.doubleEvenDigits(actual_double_even_digits_min));
        assertEquals("Here is test double_even_digits_max:", expected_double_even_digits_max, luhn.doubleEvenDigits(actual_double_even_digits_max));
        assertEquals("Here is test double_even_digits_zero:", expected_double_even_digits_zero, luhn.doubleEvenDigits(actual_double_even_digits_zero));
        assertEquals("Here is test double_even_digits:", expected_double_even_digits, luhn.doubleEvenDigits(actual_double_even_digits));
        assertEquals("Here is test double_even_digits_real:", expected_double_even_digits_real, luhn.doubleEvenDigits(actual_double_even_digits_real));
    }

    /**
     * Sum all digits
     */
    @Test
    public void testCalculateDigits(){
        List<Integer> actual_double_even_digits_single = Arrays.asList(1);
        List<Integer> actual_double_even_digits_min = Arrays.asList(2,2);
        List<Integer> actual_double_even_digits_zero = Arrays.asList(0,0,0,0,0,0,0);
        List<Integer> actual_calculate_digits = Arrays.asList(4,9,9,4,7,6,9,7,7,2,6);
        Integer expected_calculate_digits_single = 1;
        Integer expected_calculate_digits_min = 4;
        Integer expected_calculate_digits_zero = 0;
        Integer expected_calculate_digits = 70;

        assertEquals("Here is test double_even_digits_single:", expected_calculate_digits_single, luhn.calculateDigits(actual_double_even_digits_single));
        assertEquals("Here is test double_even_digits_min:", expected_calculate_digits_min, luhn.calculateDigits(actual_double_even_digits_min));
        assertEquals("Here is test double_even_digits_zero:", expected_calculate_digits_zero, luhn.calculateDigits(actual_double_even_digits_zero));
        assertEquals("Here is test calculate_digits:", expected_calculate_digits, luhn.calculateDigits(actual_calculate_digits));
    }

    /**
     * Take the sum modulo 10
     */
    @Test (expected = NullPointerException.class)
    public void testCheckAlgorithmNull(){
        assertFalse("Here is test NullPointerException:", luhn.checkAlgorithm(null));
    }
    @Test (expected = NumberFormatException.class)
    public void testCheckAlgorithmInvalid(){
        String actual_check_algorithm = "a23456d";
        assertFalse("Here is test NumberFormatException:", luhn.checkAlgorithm(actual_check_algorithm));
    }
    @Test
    public void testCheckAlgorithm(){
        String actual_check_algorithm_zero = "0";
        String actual_check_algorithm_min = "1";
        String actual_check_algorithm = "49927398716";

        assertFalse("Here is test check_algorithm zero:", luhn.checkAlgorithm(actual_check_algorithm_zero));
        assertTrue("Here is test check_algorithm min:", luhn.checkAlgorithm(actual_check_algorithm_min));
        assertFalse("Here is test check_algorithm:", luhn.checkAlgorithm(actual_check_algorithm));
    }
}
