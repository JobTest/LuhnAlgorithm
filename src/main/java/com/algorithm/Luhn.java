package com.algorithm;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Lazarchuk Aleksandr
 * @version 1.1
 * @date 05/07/2015
 * *******************************
 * The implements 'Luhn Algorithm'
 */
public class Luhn implements ILuhn {

    @Override
    public List<Integer> doubleEvenDigits(List<Integer> numbers) {
        for (int number=(numbers.size()-2); 0<=number; number-=2)
            numbers.set( number, sum(toDigitList(String.valueOf(numbers.get(number)*2))) );
        return numbers;
    }

    @Override
    public Integer calculateDigits(List<Integer> numbers) {
        return sum(numbers);
    }

    @Override
    public boolean checkAlgorithm(String card_number) throws NumberFormatException, IllegalArgumentException {
        if(!StringUtils.isEmpty(card_number) && !StringUtils.isBlank(card_number))
            return calculateDigits(doubleEvenDigits(toDigitList(card_number))) % 10 == 0 ? false : true;
        else
            throw new IllegalArgumentException("Illegal Argument");
    }

    private List<Integer> toDigitList(String number){
        return Arrays.asList(number.split(""))
                .stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private Integer sum(List<Integer> numbers) {
        return numbers
                .stream()
                .mapToInt(number -> number++)
                .sum();
    }
}
