package com.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lazarchuk Aleksandr
 * @version 1.0
 * @date 30/06/2015
 * {@link https://bitbucket.org/OpsIT/luhn-validation/commits/49927398716}
 * ***********************************************************************
 * The Luhn Algorithm:
 */
public class Luhn implements ILuhn {

    /* Allows length */
    public static final int LENGTH_CARD_NUMBER_MIN = 2;
    public static final int LENGTH_STRING_CARD_NUMBER_MAX = 16;

    @Override
    public <T> boolean checkLuhnAlgorithm(T card_number) throws IllegalArgumentException, IllegalStateException {
        /* Convert number to the list */
        List lDigit = toDigitList( card_number );

        /* (Behavior #1) Double every second digit, from the rightmost digit                                         */
        /* (Behavior #2) If in the process of doubling the value is greater than 9, add the two digits of the result */
        /* (Behavior #3) Sum all digits                                                                              */
        /* (Behavior #4) Take the sum module 10                                                                      */
        return isLuhnValid( calculateLuhn( addTwoDigitsForRes( doubleEvenDigits(lDigit)) ) );
    }

    private  <T> String toConvertString(T number){
        if( String.valueOf(number).indexOf(".") < 0 ) {
            return String.valueOf(number);
        } else {
            return String.valueOf(number).substring(0, String.valueOf(number).indexOf("."));
        }
    }

    /**
     * Convert number (String/Integer/Double/Float/int/long) to ArrayList <Integer>
     *
     * @param number
     * @param <T>
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalStateException
     */
    protected final <T> List<Integer> toDigitList(T number) throws IllegalArgumentException, IllegalStateException {
        if (number != null) {
            List<Integer> returnDigitArray = new ArrayList<>();
            for (Character ch : toConvertString(number).toCharArray()) {
                if (Character.isDigit(ch)) {
                    returnDigitArray.add(Integer.valueOf(ch.toString()));
                } else {
                    throw new IllegalArgumentException("incorrect type of number");
                }
            }
            if (LENGTH_CARD_NUMBER_MIN <= returnDigitArray.size() && returnDigitArray.size() <= LENGTH_STRING_CARD_NUMBER_MAX) {
                return returnDigitArray;
            } else {
                throw new IllegalStateException("Incorrect the digits number");
            }
        } else {
            throw new IllegalArgumentException("The number is null");
        }
    }

    /**
     * (Behavior #1) Double every second digit, from the rightmost digit
     *
     * @param number
     * @return
     * @throws IllegalStateException
     */
    protected final List<Integer> doubleEvenDigits(List<Integer> number) {
            int count = 1;
            for (int i = (number.size() - 1); 0 <= i; i--)
                if ((count++ % 2) == 0)
                    number.set(i, (number.get(i) * 2));

        return number;
    }

    /**
     * (Behavior #2) If in the process of doubling the value is greater than 9, add the two digits of the result
     *
     * @param number
     * @return
     */
    protected final List<Integer> addTwoDigitsForRes(List<Integer> number) {
        for (int i = 0; i < number.size(); i++) {
            if (9 < number.get(i) ) {
                String digitsToStr = String.valueOf(number.get(i)).toString();
                number.set(i, (Integer.parseInt(digitsToStr.substring(0, 1)) + Integer.parseInt(digitsToStr.substring(1, 2))));
            }
        }

        return number;
    }

    /**
     * (Behavior #3) Sum all digits
     *
     * @param number
     * @return
     */
    protected final Integer calculateLuhn(List<Integer> number) {
        int sum = 0;
        for (int num : number)
            sum += num;

        return sum;
    }

    /**
     * (Behavior #4) Take the sum modulo 10
     *
     * @param sumLuhn
     * @return
     */
    protected final boolean isLuhnValid(Integer sumLuhn) {
        if ((sumLuhn%10) == 0)
            return false;
        else
            return true;
    }

}
