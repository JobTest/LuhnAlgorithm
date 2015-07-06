package com;

import com.algorithm.Luhn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Lazarchuk Aleksandr
 * @version 1.0
 * @date 30/06/2015
 * ************************************************
 * The implementation CreditCard Number validation:
 */
public class CreditCardValidation extends Luhn {

    /* Allows format: 'XXXX XXXX XXXX XXXX' or 'XXXX-XXXX-XXXX-XXXX' and allows length */
    public static final String PATTERN_CARD_NUMBER = "^[0-9\\s-]*$";
    public static final int LENGTH_CARD_NUMBER = 16;

    /* Disable value: for '0' to '0000000000000000' */
    public static final String FILTER_PATTERN_CARD_NUMBER = "^[0]*$";

    /**
     * get filter number
     *
     * @param card_number
     * @return
     */
    private String filterNumberOnSeparation(String card_number) {
        return card_number.replace(" ", "").replace("-", "");
    }

    /**
     * get match Pattern
     *
     * @param card_number
     * @param pattern
     * @return
     */
    private boolean isMatchCardNumber(String card_number, String pattern){
        Pattern patternCardNumber = Pattern.compile(pattern);
        Matcher matchCardNumber = patternCardNumber.matcher(card_number);

        return matchCardNumber.matches();
    }

    /**
     * The formula verifies a number against its included check-digit, which is usually appended to a partial.
     *
     * Required to support the entry of credit card numbers both with spaces and without spaces and to validate each of these appropriately.
     * @param card_number ('XXXXXXXXXXXXXXXX' or 'XXXX XXXX XXXX XXXX' or 'XXXX-XXXX-XXXX-XXXX')
     * @return <boolean>
     */
    @Override
    public <T> boolean checkLuhnAlgorithm(T card_number) throws IllegalArgumentException, IllegalStateException {
        if(card_number != null){
            if( isMatchCardNumber((String)card_number, PATTERN_CARD_NUMBER) ){
                String prepare_card_number = filterNumberOnSeparation((String)card_number);
                if (prepare_card_number.length() == LENGTH_CARD_NUMBER) {
                    if( !isMatchCardNumber(prepare_card_number,FILTER_PATTERN_CARD_NUMBER) ){
                        return super.checkLuhnAlgorithm(prepare_card_number);
                    } else {
                        throw new IllegalArgumentException("Incorrect type of number");
                    }
                } else {
                    throw new IllegalStateException("Incorrect the digits number");
                }
            } else {
                throw new IllegalArgumentException("Incorrect type of number");
            }
        } else {
            throw new IllegalArgumentException("The number is null");
        }
    }

}
