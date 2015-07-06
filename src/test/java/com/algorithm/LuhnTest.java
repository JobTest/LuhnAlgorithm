package com.algorithm;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Lazarchuk Aleksandr
 * @version 1.0
 * @date 01/07/2015
 * ***********************************
 * Basic test case for Luhn Algorithm:
 */
public class LuhnTest {

    private Luhn luhnAlgorithm;

    private List<Integer> expected_digit_list_min;
    private List<Integer> expected_digit_list_normal_zero;
    private List<Integer> expected_digit_list_normal;
    private List<Integer> expected_digit_list_max_zero;
    private List<Integer> expected_digit_list_max;
    private List<Integer> actual_double_even_digits_0;
    private List<Integer> actual_double_even_digits_1;
    private List<Integer> actual_double_even_digits_5;
    private List<Integer> actual_double_even_digits_9;
    private List<Integer> expected_double_even_digits_0;
    private List<Integer> expected_double_even_digits_1;
    private List<Integer> expected_double_even_digits_5;
    private List<Integer> expected_double_even_digits_9;
    private List<Integer> actual_add_two_digits_for_res_0;
    private List<Integer> actual_add_two_digits_for_res_1;
    private List<Integer> actual_add_two_digits_for_res_5;
    private List<Integer> actual_add_two_digits_for_res_9;
    private List<Integer> expected_add_two_digits_for_res_0;
    private List<Integer> expected_add_two_digits_for_res_1;
    private List<Integer> expected_add_two_digits_for_res_5;
    private List<Integer> expected_add_two_digits_for_res_9;
    private List<Integer> actual_calculate_luhn_0;
    private List<Integer> actual_calculate_luhn_1;
    private List<Integer> actual_calculate_luhn_5;
    private List<Integer> actual_calculate_luhn_9;
    private List<Integer> actual_calculate_luhn_12;
    private List<Integer> actual_calculate_luhn_51;
    private List<Integer> actual_calculate_luhn_24;
    private List<Integer> actual_calculate_luhn_48;

    @Before
    public void setUp() {
        createAlgorithmObj();
        createMockData();
    }

    /**
     * The formula verifies a number against its included check-digit, which is usually appended to a partial.
     */
    @Test(timeout = 100, expected = IllegalStateException.class)
    @Category(Luhn.class)
    public void testLuhnAlgorithm_1(){
        assertFalse("Here is test get IllegalStateException '1':", luhnAlgorithm.checkLuhnAlgorithm(1));
    }
    @Test(timeout = 100, expected = IllegalArgumentException.class)
    @Category(Luhn.class)
    public void testLuhnAlgorithm_negative12(){
        assertFalse("Here is test get IllegalArgumentException '-12':", luhnAlgorithm.checkLuhnAlgorithm(-12));
    }
    @Test(timeout = 100, expected = IllegalStateException.class)
    @Category(Luhn.class)
    public void testLuhnAlgorithm_large(){
        assertFalse("Here is test get IllegalStateException '4992739871649927398716':", luhnAlgorithm.checkLuhnAlgorithm("4992739871649927398716"));
    }
    @Test(timeout = 100)
    @Category(Luhn.class)
    public void testLuhnAlgorithm(){
        assertFalse("Here is test get right Number 59:", luhnAlgorithm.checkLuhnAlgorithm(59));
        assertTrue("Here is test get right Number 12:", luhnAlgorithm.checkLuhnAlgorithm(12));
        assertFalse("Here is test get right Number zero:", luhnAlgorithm.checkLuhnAlgorithm("00"));
        assertFalse("Here is test get right Number 49927398716:", luhnAlgorithm.checkLuhnAlgorithm("00000000000"));
        assertFalse("Here is test get right Number 49927398716:", luhnAlgorithm.checkLuhnAlgorithm("49927398716"));
        assertFalse("Here is test get right Number 79927398713:", luhnAlgorithm.checkLuhnAlgorithm("79927398713"));
        assertTrue("Here is test get wrong Number 79927398710:", luhnAlgorithm.checkLuhnAlgorithm("79927398710"));
    }

    /**
     * get exception 'IllegalArgumentException' on convert number to the list
     */
    @Test(timeout = 100, expected = IllegalArgumentException.class)
    @Category(Luhn.class)
    public void testToDigitListForType_stringNumberNull(){
        String actual_string_number_null = null;
        assertNull( "Here is test string_number_null:", luhnAlgorithm.toDigitList(actual_string_number_null) );
    }
    @Test(timeout = 100, expected = IllegalArgumentException.class)
    @Category(Luhn.class)
    public void testToDigitListForType_stringNumberStr(){
        String actual_string_number_str = "11111111ab";
        assertNull( "Here is test string_number_str:", luhnAlgorithm.toDigitList(actual_string_number_str) );
    }
    @Test(timeout = 100, expected = IllegalArgumentException.class)
    @Category(Luhn.class)
    public void testToDigitListForType_stringNumberNegative(){
        String actual_string_number_negative = "-1111111111";
        assertNull( "Here is test string_number_negative:", luhnAlgorithm.toDigitList(actual_string_number_negative) );
    }
    @Test(timeout = 100, expected = IllegalArgumentException.class)
    @Category(Luhn.class)
    public void testToDigitListForType_integerCardNumberNegative(){
        Integer actual_integer_card_number_negative = -1111111111;
        assertNull( "Here is test integer_card_number_negative:", luhnAlgorithm.toDigitList(actual_integer_card_number_negative) );
    }
    @Test(timeout = 100, expected = IllegalArgumentException.class)
    @Category(Luhn.class)
    public void testToDigitListForType_doubleCardNumberNegative(){
        Double actual_double_card_number_negative = -1111111111d;
        assertNull( "Here is test double_card_number_negative:", luhnAlgorithm.toDigitList(actual_double_card_number_negative) );
    }
    @Test(timeout = 100, expected = IllegalArgumentException.class)
    @Category(Luhn.class)
    public void testToDigitListForType_doubleCardNumberNegativeDot(){
        Double actual_double_card_number_negative_dot = -1111111111.01d;
        assertNull( "Here is test double_card_number_negative_dot:", luhnAlgorithm.toDigitList(actual_double_card_number_negative_dot) );
    }
    @Test(timeout = 100, expected = IllegalArgumentException.class)
    @Category(Luhn.class)
    public void testToDigitListForType_floatCardNumberNegative(){
        Float actual_float_card_number_negative = -1111111111f;
        assertNull( "Here is test float_card_number_negative:", luhnAlgorithm.toDigitList(actual_float_card_number_negative) );
    }
    @Test(timeout = 100, expected = IllegalArgumentException.class)
    @Category(Luhn.class)
    public void testToDigitListForType_floatCardNumberNegativeDot(){
        Float actual_float_card_number_negative_dot = -1111111111.011f;
        assertNull( "Here is test float_card_number_negative_dot:", luhnAlgorithm.toDigitList(actual_float_card_number_negative_dot) );
    }

    /**
     * get exception 'IllegalStateException' on convert number to the list
     */
    @Test(timeout = 100, expected = IllegalStateException.class)
    @Category(Luhn.class)
    public void testToDigitListForLength_stringNumberSingleZero(){
        String actual_string_number_single_zero = "0";
        assertNull( "Here is test string_number_single_zero:", luhnAlgorithm.toDigitList(actual_string_number_single_zero) );
    }
    @Test(timeout = 100, expected = IllegalStateException.class)
    @Category(Luhn.class)
    public void testToDigitListForLength_stringNumberSingle(){
        String actual_string_number_single = "1";
        assertNull( "Here is test string_number_single:", luhnAlgorithm.toDigitList(actual_string_number_single) );
    }
    @Test(timeout = 100, expected = IllegalStateException.class)
    @Category(Luhn.class)
    public void testToDigitListForLength_stringNumberLarge(){
        String actual_string_number_large = "11111111111111111";
        assertNull( "Here is test string_number_large:", luhnAlgorithm.toDigitList(actual_string_number_large) );
    }
    @Test(timeout = 100, expected = IllegalStateException.class)
    @Category(Luhn.class)
    public void testToDigitListForLength_integerCardNumber_zero(){
        Integer actual_integer_card_number_zero = 0;
        assertNull( "Here is test integer_card_number_zero:", luhnAlgorithm.toDigitList(actual_integer_card_number_zero) );
    }
    @Test(timeout = 100, expected = IllegalStateException.class)
    @Category(Luhn.class)
    public void testToDigitListForLength_integerCardNumberSingle(){
        Integer actual_integer_card_number_single = 1;
        assertNull( "Here is test integer_card_number_single:", luhnAlgorithm.toDigitList(actual_integer_card_number_single) );
    }
    @Test(timeout = 100, expected = IllegalStateException.class)
    @Category(Luhn.class)
    public void testToDigitListForLength_doubleCardNumberSingleZero(){
        Double actual_double_card_number_single_zero = 0d;
        assertNull( "Here is test double_card_number_single_zero:", luhnAlgorithm.toDigitList(actual_double_card_number_single_zero) );
    }
    @Test(timeout = 100, expected = IllegalStateException.class)
    @Category(Luhn.class)
    public void testToDigitListForLength_doubleCardNumberSingle(){
        Double actual_double_card_number_single = 1d;
        assertNull( "Here is test double_card_number_single:", luhnAlgorithm.toDigitList(actual_double_card_number_single) );
    }
    @Test(timeout = 100, expected = IllegalStateException.class)
    @Category(Luhn.class)
    public void testToDigitListForLength_doubleCardNumberZero(){
        Double actual_double_card_number_zero = 0.0d;
        assertNull( "Here is test double_card_number_zero:", luhnAlgorithm.toDigitList(actual_double_card_number_zero) );
    }
    @Test(timeout = 100, expected = IllegalStateException.class)
    @Category(Luhn.class)
    public void testToDigitListForLength_doubleCardNumberDot(){
        Double actual_double_card_number_dot = 1.01d;
        assertNull( "Here is test double_card_number_dot:", luhnAlgorithm.toDigitList(actual_double_card_number_dot) );
    }
    @Test(timeout = 100, expected = IllegalStateException.class)
    @Category(Luhn.class)
    public void testToDigitListForLength_floatCardNumberSingle_zero(){
        Float actual_float_card_number_single_zero = 0f;
        assertNull( "Here is test float_card_number_single_zero:", luhnAlgorithm.toDigitList(actual_float_card_number_single_zero) );
    }
    @Test(timeout = 100, expected = IllegalStateException.class)
    @Category(Luhn.class)
    public void testToDigitListForLength_floatCardNumberZero(){
        Float actual_float_card_number_zero = 0.0f;
        assertNull( "Here is test float_card_number_zero:", luhnAlgorithm.toDigitList(actual_float_card_number_zero) );
    }
    @Test(timeout = 100, expected = IllegalStateException.class)
    @Category(Luhn.class)
    public void testToDigitListForLength_floatCardNumberSingle(){
        Float actual_float_card_number_single = 1f;
        assertNull( "Here is test float_card_number_single:", luhnAlgorithm.toDigitList(actual_float_card_number_single) );
    }
    @Test(timeout = 100, expected = IllegalStateException.class)
    @Category(Luhn.class)
    public void testToDigitListForLength_floatCardNumberDot(){
        Float actual_float_card_number_dot = 1.011f;
        assertNull( "Here is test float_card_number_dot:", luhnAlgorithm.toDigitList(actual_float_card_number_dot) );
    }

    /**
     * Convert number to the list
     */
    @Test(timeout = 100)
     @Category(Luhn.class)
     public void testToDigitList(){
        String actual_string_number_min = "11";
        Integer actual_integer_card_number_min = 11;
        Double actual_double_card_number_min = 11d;
        Float actual_float_card_number_min = 11f;
        Double actual_double_card_number_min_dot = 11.01d;
        Float actual_float_card_number_min_dot = 11.011f;
        String actual_string_number_normal_zero = "0000000";
        String actual_string_number_normal = "1111111";
        int actual_int_card_number_normal = 1111111;
        Integer actual_integer_card_number_normal = 1111111;
        long actual_long_card_number_normal = 1111111;
        Double actual_double_card_number_normal = 1111111d;
        Float actual_float_card_number_normal = 1111111f;
        Double actual_double_card_number_normal_dot = 1111111.01d;
        Float actual_float_card_number_normal_dot = 1111111.011f;
        String actual_string_number_max_zero = "0000000000000000";
        String actual_string_number_max = "1111111111111111";

        assertEquals( "Here is test string_number_min:", expected_digit_list_min, luhnAlgorithm.toDigitList(actual_string_number_min) );
        assertEquals( "Here is test integer_card_number_min:", expected_digit_list_min, luhnAlgorithm.toDigitList(actual_integer_card_number_min) );
        assertEquals( "Here is test double_card_number_min:", expected_digit_list_min, luhnAlgorithm.toDigitList(actual_double_card_number_min) );
        assertEquals( "Here is test float_card_number_min:", expected_digit_list_min, luhnAlgorithm.toDigitList(actual_float_card_number_min) );
        assertEquals( "Here is test double_card_number_min_dot:", expected_digit_list_min, luhnAlgorithm.toDigitList(actual_double_card_number_min_dot) );
        assertEquals( "Here is test float_card_number_min_dot:", expected_digit_list_min, luhnAlgorithm.toDigitList(actual_float_card_number_min_dot) );
        assertEquals( "Here is test string_number_normal_zero:", expected_digit_list_normal_zero, luhnAlgorithm.toDigitList(actual_string_number_normal_zero) );
        assertEquals( "Here is test string_number_normal:", expected_digit_list_normal, luhnAlgorithm.toDigitList(actual_string_number_normal) );
        assertEquals( "Here is test int_card_number_normal:", expected_digit_list_normal, luhnAlgorithm.toDigitList(actual_int_card_number_normal) );
        assertEquals( "Here is test integer_card_number_normal:", expected_digit_list_normal, luhnAlgorithm.toDigitList(actual_integer_card_number_normal) );
        assertEquals( "Here is test long_card_number_normal:", expected_digit_list_normal, luhnAlgorithm.toDigitList(actual_long_card_number_normal) );
        assertEquals( "Here is test double_card_number_normal:", expected_digit_list_normal, luhnAlgorithm.toDigitList(actual_double_card_number_normal) );
        assertEquals( "Here is test afloat_card_number_normal:", expected_digit_list_normal, luhnAlgorithm.toDigitList(actual_float_card_number_normal) );
        assertEquals( "Here is test double_card_number_normal_dot:", expected_digit_list_normal, luhnAlgorithm.toDigitList(actual_double_card_number_normal_dot) );
        assertEquals( "Here is test float_card_number_normal_dot:", expected_digit_list_normal, luhnAlgorithm.toDigitList(actual_float_card_number_normal_dot) );
        assertEquals( "Here is test string_number_max_zero:", expected_digit_list_max_zero, luhnAlgorithm.toDigitList(actual_string_number_max_zero) );
        assertEquals( "Here is test string_number_max:", expected_digit_list_max, luhnAlgorithm.toDigitList(actual_string_number_max) );
    }

    /**
     * (Behavior #1) Double every second digit, from the rightmost digit
     */
    @Test(timeout = 100)
    @Category(Luhn.class)
    public void testDoubleEvenDigits(){
        assertEquals("Here is test double_even_digits:", expected_double_even_digits_0, luhnAlgorithm.doubleEvenDigits(actual_double_even_digits_0));
        assertEquals("Here is test double_even_digits:", expected_double_even_digits_1, luhnAlgorithm.doubleEvenDigits(actual_double_even_digits_1));
        assertEquals("Here is test double_even_digits:", expected_double_even_digits_5, luhnAlgorithm.doubleEvenDigits(actual_double_even_digits_5));
        assertEquals("Here is test double_even_digits:", expected_double_even_digits_9, luhnAlgorithm.doubleEvenDigits(actual_double_even_digits_9));
    }

    /**
     * (Behavior #2) If in the process of doubling the value is greater than 9, add the two digits of the result
     */
    @Test(timeout = 100)
    @Category(Luhn.class)
    public void testAddTwoDigitsForRes(){
        assertEquals("Here is test add_two_digits_for_res:", expected_add_two_digits_for_res_0, luhnAlgorithm.addTwoDigitsForRes(actual_add_two_digits_for_res_0));
        assertEquals("Here is test add_two_digits_for_res:", expected_add_two_digits_for_res_1, luhnAlgorithm.addTwoDigitsForRes(actual_add_two_digits_for_res_1));
        assertEquals("Here is test add_two_digits_for_res:", expected_add_two_digits_for_res_5, luhnAlgorithm.addTwoDigitsForRes(actual_add_two_digits_for_res_5));
        assertEquals("Here is test add_two_digits_for_res:", expected_add_two_digits_for_res_9, luhnAlgorithm.addTwoDigitsForRes(actual_add_two_digits_for_res_9));
    }

    /**
     * (Behavior #3) Sum all digits
     */
    @Test(timeout = 100)
    @Category(Luhn.class)
    public void testCalculateLuhn(){
        Integer expected_calculate_luhn_0 = 0;
        Integer expected_calculate_luhn_1 = 7;
        Integer expected_calculate_luhn_5 = 35;
        Integer expected_calculate_luhn_9 = 63;
        Integer expected_calculate_luhn_12 = 10;
        Integer expected_calculate_luhn_51 = 23;
        Integer expected_calculate_luhn_24 = 20;
        Integer expected_calculate_luhn_48 = 40;

        assertEquals("Here is test calculate_luhn:", expected_calculate_luhn_0, luhnAlgorithm.calculateLuhn(actual_calculate_luhn_0));
        assertEquals("Here is test calculate_luhn:", expected_calculate_luhn_1, luhnAlgorithm.calculateLuhn(actual_calculate_luhn_1));
        assertEquals("Here is test calculate_luhn:", expected_calculate_luhn_5, luhnAlgorithm.calculateLuhn(actual_calculate_luhn_5));
        assertEquals("Here is test calculate_luhn:", expected_calculate_luhn_9, luhnAlgorithm.calculateLuhn(actual_calculate_luhn_9));
        assertEquals("Here is test calculate_luhn:", expected_calculate_luhn_12, luhnAlgorithm.calculateLuhn(actual_calculate_luhn_12));
        assertEquals("Here is test calculate_luhn:", expected_calculate_luhn_51, luhnAlgorithm.calculateLuhn(actual_calculate_luhn_51));
        assertEquals("Here is test calculate_luhn:", expected_calculate_luhn_24, luhnAlgorithm.calculateLuhn(actual_calculate_luhn_24));
        assertEquals("Here is test calculate_luhn:", expected_calculate_luhn_48, luhnAlgorithm.calculateLuhn(actual_calculate_luhn_48));
    }

    /**
     * (Behavior #4) Take the sum modulo 10
     */
    @Test(timeout = 100)
    @Category(Luhn.class)
    public void testIsLuhnValid(){
        Integer actual_is_luhn_valid_0 = 0;
        Integer actual_is_luhn_valid_1 = 7;
        Integer actual_is_luhn_valid_5 = 35;
        Integer actual_is_luhn_valid_9 = 63;
        Integer actual_is_luhn_valid_12 = 10;
        Integer actual_is_luhn_valid_51 = 23;
        Integer actual_is_luhn_valid_24 = 20;
        Integer actual_is_luhn_valid_48 = 40;

        assertFalse("Here is test is_luhn_valid:", luhnAlgorithm.isLuhnValid(actual_is_luhn_valid_0));
        assertTrue("Here is test is_luhn_valid:", luhnAlgorithm.isLuhnValid(actual_is_luhn_valid_1));
        assertTrue("Here is test is_luhn_valid:", luhnAlgorithm.isLuhnValid(actual_is_luhn_valid_5));
        assertTrue("Here is test is_luhn_valid:", luhnAlgorithm.isLuhnValid(actual_is_luhn_valid_9));
        assertFalse("Here is test is_luhn_valid:", luhnAlgorithm.isLuhnValid(actual_is_luhn_valid_12));
        assertTrue("Here is test is_luhn_valid:", luhnAlgorithm.isLuhnValid(actual_is_luhn_valid_51));
        assertFalse("Here is test is_luhn_valid:", luhnAlgorithm.isLuhnValid(actual_is_luhn_valid_24));
        assertFalse("Here is test is_luhn_valid:", luhnAlgorithm.isLuhnValid(actual_is_luhn_valid_48));
    }


    private void createMockData(){
        expected_digit_list_min = new ArrayList<>();
        expected_digit_list_min.add(1);
        expected_digit_list_min.add(1);
        expected_digit_list_normal_zero = new ArrayList<>();
        expected_digit_list_normal_zero.add(0);
        expected_digit_list_normal_zero.add(0);
        expected_digit_list_normal_zero.add(0);
        expected_digit_list_normal_zero.add(0);
        expected_digit_list_normal_zero.add(0);
        expected_digit_list_normal_zero.add(0);
        expected_digit_list_normal_zero.add(0);
        expected_digit_list_normal = new ArrayList<>();
        expected_digit_list_normal.add(1);
        expected_digit_list_normal.add(1);
        expected_digit_list_normal.add(1);
        expected_digit_list_normal.add(1);
        expected_digit_list_normal.add(1);
        expected_digit_list_normal.add(1);
        expected_digit_list_normal.add(1);
        expected_digit_list_max_zero = new ArrayList<>();
        expected_digit_list_max_zero.add(0);
        expected_digit_list_max_zero.add(0);
        expected_digit_list_max_zero.add(0);
        expected_digit_list_max_zero.add(0);
        expected_digit_list_max_zero.add(0);
        expected_digit_list_max_zero.add(0);
        expected_digit_list_max_zero.add(0);
        expected_digit_list_max_zero.add(0);
        expected_digit_list_max_zero.add(0);
        expected_digit_list_max_zero.add(0);
        expected_digit_list_max_zero.add(0);
        expected_digit_list_max_zero.add(0);
        expected_digit_list_max_zero.add(0);
        expected_digit_list_max_zero.add(0);
        expected_digit_list_max_zero.add(0);
        expected_digit_list_max_zero.add(0);
        expected_digit_list_max = new ArrayList<>();
        expected_digit_list_max.add(1);
        expected_digit_list_max.add(1);
        expected_digit_list_max.add(1);
        expected_digit_list_max.add(1);
        expected_digit_list_max.add(1);
        expected_digit_list_max.add(1);
        expected_digit_list_max.add(1);
        expected_digit_list_max.add(1);
        expected_digit_list_max.add(1);
        expected_digit_list_max.add(1);
        expected_digit_list_max.add(1);
        expected_digit_list_max.add(1);
        expected_digit_list_max.add(1);
        expected_digit_list_max.add(1);
        expected_digit_list_max.add(1);
        expected_digit_list_max.add(1);

        actual_double_even_digits_0 = new ArrayList<>();
        actual_double_even_digits_0.add(0);
        actual_double_even_digits_0.add(0);
        actual_double_even_digits_0.add(0);
        actual_double_even_digits_0.add(0);
        actual_double_even_digits_0.add(0);
        actual_double_even_digits_0.add(0);
        actual_double_even_digits_0.add(0);
        actual_double_even_digits_1 = new ArrayList<>();
        actual_double_even_digits_1.add(1);
        actual_double_even_digits_1.add(1);
        actual_double_even_digits_1.add(1);
        actual_double_even_digits_1.add(1);
        actual_double_even_digits_1.add(1);
        actual_double_even_digits_1.add(1);
        actual_double_even_digits_1.add(1);
        actual_double_even_digits_5 = new ArrayList<>();
        actual_double_even_digits_5.add(5);
        actual_double_even_digits_5.add(5);
        actual_double_even_digits_5.add(5);
        actual_double_even_digits_5.add(5);
        actual_double_even_digits_5.add(5);
        actual_double_even_digits_5.add(5);
        actual_double_even_digits_5.add(5);
        actual_double_even_digits_9 = new ArrayList<>();
        actual_double_even_digits_9.add(9);
        actual_double_even_digits_9.add(9);
        actual_double_even_digits_9.add(9);
        actual_double_even_digits_9.add(9);
        actual_double_even_digits_9.add(9);
        actual_double_even_digits_9.add(9);
        actual_double_even_digits_9.add(9);
        expected_double_even_digits_0 = new ArrayList<>();
        expected_double_even_digits_0.add(0);
        expected_double_even_digits_0.add(0);
        expected_double_even_digits_0.add(0);
        expected_double_even_digits_0.add(0);
        expected_double_even_digits_0.add(0);
        expected_double_even_digits_0.add(0);
        expected_double_even_digits_0.add(0);
        expected_double_even_digits_1 = new ArrayList<>();
        expected_double_even_digits_1.add(1);
        expected_double_even_digits_1.add(2);
        expected_double_even_digits_1.add(1);
        expected_double_even_digits_1.add(2);
        expected_double_even_digits_1.add(1);
        expected_double_even_digits_1.add(2);
        expected_double_even_digits_1.add(1);
        expected_double_even_digits_5 = new ArrayList<>();
        expected_double_even_digits_5.add(5);
        expected_double_even_digits_5.add(10);
        expected_double_even_digits_5.add(5);
        expected_double_even_digits_5.add(10);
        expected_double_even_digits_5.add(5);
        expected_double_even_digits_5.add(10);
        expected_double_even_digits_5.add(5);
        expected_double_even_digits_9 = new ArrayList<>();
        expected_double_even_digits_9.add(9);
        expected_double_even_digits_9.add(18);
        expected_double_even_digits_9.add(9);
        expected_double_even_digits_9.add(18);
        expected_double_even_digits_9.add(9);
        expected_double_even_digits_9.add(18);
        expected_double_even_digits_9.add(9);

        actual_add_two_digits_for_res_0 = new ArrayList<>();
        actual_add_two_digits_for_res_0.add(0);
        actual_add_two_digits_for_res_0.add(0);
        actual_add_two_digits_for_res_0.add(0);
        actual_add_two_digits_for_res_0.add(0);
        actual_add_two_digits_for_res_0.add(0);
        actual_add_two_digits_for_res_0.add(0);
        actual_add_two_digits_for_res_0.add(0);
        actual_add_two_digits_for_res_1 = new ArrayList<>();
        actual_add_two_digits_for_res_1.add(1);
        actual_add_two_digits_for_res_1.add(2);
        actual_add_two_digits_for_res_1.add(1);
        actual_add_two_digits_for_res_1.add(2);
        actual_add_two_digits_for_res_1.add(1);
        actual_add_two_digits_for_res_1.add(2);
        actual_add_two_digits_for_res_1.add(1);
        actual_add_two_digits_for_res_5 = new ArrayList<>();
        actual_add_two_digits_for_res_5.add(5);
        actual_add_two_digits_for_res_5.add(10);
        actual_add_two_digits_for_res_5.add(5);
        actual_add_two_digits_for_res_5.add(10);
        actual_add_two_digits_for_res_5.add(5);
        actual_add_two_digits_for_res_5.add(10);
        actual_add_two_digits_for_res_5.add(5);
        actual_add_two_digits_for_res_9 = new ArrayList<>();
        actual_add_two_digits_for_res_9.add(9);
        actual_add_two_digits_for_res_9.add(18);
        actual_add_two_digits_for_res_9.add(9);
        actual_add_two_digits_for_res_9.add(18);
        actual_add_two_digits_for_res_9.add(9);
        actual_add_two_digits_for_res_9.add(18);
        actual_add_two_digits_for_res_9.add(9);
        expected_add_two_digits_for_res_0 = new ArrayList<>();
        expected_add_two_digits_for_res_0.add(0);
        expected_add_two_digits_for_res_0.add(0);
        expected_add_two_digits_for_res_0.add(0);
        expected_add_two_digits_for_res_0.add(0);
        expected_add_two_digits_for_res_0.add(0);
        expected_add_two_digits_for_res_0.add(0);
        expected_add_two_digits_for_res_0.add(0);
        expected_add_two_digits_for_res_1 = new ArrayList<>();
        expected_add_two_digits_for_res_1.add(1);
        expected_add_two_digits_for_res_1.add(2);
        expected_add_two_digits_for_res_1.add(1);
        expected_add_two_digits_for_res_1.add(2);
        expected_add_two_digits_for_res_1.add(1);
        expected_add_two_digits_for_res_1.add(2);
        expected_add_two_digits_for_res_1.add(1);
        expected_add_two_digits_for_res_5 = new ArrayList<>();
        expected_add_two_digits_for_res_5.add(5);
        expected_add_two_digits_for_res_5.add(1);
        expected_add_two_digits_for_res_5.add(5);
        expected_add_two_digits_for_res_5.add(1);
        expected_add_two_digits_for_res_5.add(5);
        expected_add_two_digits_for_res_5.add(1);
        expected_add_two_digits_for_res_5.add(5);
        expected_add_two_digits_for_res_9 = new ArrayList<>();
        expected_add_two_digits_for_res_9.add(9);
        expected_add_two_digits_for_res_9.add(9);
        expected_add_two_digits_for_res_9.add(9);
        expected_add_two_digits_for_res_9.add(9);
        expected_add_two_digits_for_res_9.add(9);
        expected_add_two_digits_for_res_9.add(9);
        expected_add_two_digits_for_res_9.add(9);

        actual_calculate_luhn_0 = new ArrayList<>();
        actual_calculate_luhn_0.add(0);
        actual_calculate_luhn_0.add(0);
        actual_calculate_luhn_0.add(0);
        actual_calculate_luhn_0.add(0);
        actual_calculate_luhn_0.add(0);
        actual_calculate_luhn_0.add(0);
        actual_calculate_luhn_0.add(0);
        actual_calculate_luhn_1 = new ArrayList<>();
        actual_calculate_luhn_1.add(1);
        actual_calculate_luhn_1.add(1);
        actual_calculate_luhn_1.add(1);
        actual_calculate_luhn_1.add(1);
        actual_calculate_luhn_1.add(1);
        actual_calculate_luhn_1.add(1);
        actual_calculate_luhn_1.add(1);
        actual_calculate_luhn_5 = new ArrayList<>();
        actual_calculate_luhn_5.add(5);
        actual_calculate_luhn_5.add(5);
        actual_calculate_luhn_5.add(5);
        actual_calculate_luhn_5.add(5);
        actual_calculate_luhn_5.add(5);
        actual_calculate_luhn_5.add(5);
        actual_calculate_luhn_5.add(5);
        actual_calculate_luhn_9 = new ArrayList<>();
        actual_calculate_luhn_9.add(9);
        actual_calculate_luhn_9.add(9);
        actual_calculate_luhn_9.add(9);
        actual_calculate_luhn_9.add(9);
        actual_calculate_luhn_9.add(9);
        actual_calculate_luhn_9.add(9);
        actual_calculate_luhn_9.add(9);
        actual_calculate_luhn_12 = new ArrayList<>();
        actual_calculate_luhn_12.add(1);
        actual_calculate_luhn_12.add(2);
        actual_calculate_luhn_12.add(1);
        actual_calculate_luhn_12.add(2);
        actual_calculate_luhn_12.add(1);
        actual_calculate_luhn_12.add(2);
        actual_calculate_luhn_12.add(1);
        actual_calculate_luhn_51 = new ArrayList<>();
        actual_calculate_luhn_51.add(5);
        actual_calculate_luhn_51.add(1);
        actual_calculate_luhn_51.add(5);
        actual_calculate_luhn_51.add(1);
        actual_calculate_luhn_51.add(5);
        actual_calculate_luhn_51.add(1);
        actual_calculate_luhn_51.add(5);
        actual_calculate_luhn_24 = new ArrayList<>();
        actual_calculate_luhn_24.add(2);
        actual_calculate_luhn_24.add(4);
        actual_calculate_luhn_24.add(2);
        actual_calculate_luhn_24.add(4);
        actual_calculate_luhn_24.add(2);
        actual_calculate_luhn_24.add(4);
        actual_calculate_luhn_24.add(2);
        actual_calculate_luhn_48 = new ArrayList<>();
        actual_calculate_luhn_48.add(4);
        actual_calculate_luhn_48.add(8);
        actual_calculate_luhn_48.add(4);
        actual_calculate_luhn_48.add(8);
        actual_calculate_luhn_48.add(4);
        actual_calculate_luhn_48.add(8);
        actual_calculate_luhn_48.add(4);
    }
    private void createAlgorithmObj(){
        luhnAlgorithm = new Luhn();
    }

}
