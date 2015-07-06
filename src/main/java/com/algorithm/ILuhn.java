package com.algorithm;

import java.util.List;

/**
 * @author Lazarchuk Aleksandr
 * @version 1.1
 * @date 05/07/2015
 * {@link https://bitbucket.org/OpsIT/luhn-validation/commits/49927398716}
 * ***********************************************************************
 * The interface 'Luhn Algorithm'
 */

public interface ILuhn {

    /**
     * Double every second digit, from the rightmost digit
     *
     * @param numbers
     * @return
     * @throws NullPointerException
     */
    List<Integer> doubleEvenDigits(List<Integer> numbers) throws NullPointerException;

    /**
     * If in the process of doubling the value is greater than 9, add the two digits of the result
     *
     * @param numbers
     * @return
     */
    Integer calculateDigits(List<Integer> numbers);

    /**
     * Sum all digits
     *
     * @param card_number
     * @return
     * @throws NumberFormatException
     * @throws IllegalArgumentException
     */
    boolean checkAlgorithm(String card_number) throws NumberFormatException, IllegalArgumentException;

}
