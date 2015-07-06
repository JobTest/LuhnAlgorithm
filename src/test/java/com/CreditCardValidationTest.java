package com;

import com.algorithm.ILuhn;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
* @author Lazarchuk Aleksandr
* @version 1.0
* @date 01/07/2015
* *******************************************************************************
* The test case for ILuhn interface, implementation CreditCard Number validation:
*/
public class CreditCardValidationTest {

    ILuhn creditCardValidation;

    @Before
    public void setUp() {
        creditCardValidation = new CreditCardValidation();
    }

    /**
     * Required to support the entry of credit card numbers both with spaces and without spaces and to validate each of these appropriately.
     *
     * Format Card Nnumber: 'XXXXXXXXXXXXXXXX' or 'XXXX XXXX XXXX XXXX' or 'XXXX-XXXX-XXXX-XXXX'
     */
    @Test(timeout = 100, expected = IllegalArgumentException.class)
    @Category(ILuhn.class)
    public void testLuhnAlgorithmOnZero(){
        assertFalse("Here is test get IllegalArgumentException on zero:", creditCardValidation.checkLuhnAlgorithm("0000000000000000"));
    }
    @Test(timeout = 100, expected = IllegalArgumentException.class)
    @Category(ILuhn.class)
    public void testLuhnAlgorithmWithDot(){
        assertTrue("Here is test get wrong Number IllegalArgumentException separation dot:", creditCardValidation.checkLuhnAlgorithm("7992.7398.7107.9927"));
    }
    @Test(timeout = 100, expected = IllegalArgumentException.class)
    @Category(ILuhn.class)
    public void testLuhnAlgorithmWithUnderline(){
        assertTrue("Here is test get wrong Number IllegalArgumentException separation underline:", creditCardValidation.checkLuhnAlgorithm("7992_7398_7107_9927"));
    }

    @Test(timeout = 100)
    @Category(ILuhn.class)
    public void testLuhnAlgorithmOnFalse(){
        assertFalse("Here is test get wrong Number on check-false:", creditCardValidation.checkLuhnAlgorithm("4492739871649927"));
    }

    @Test(timeout = 100)
    @Category(ILuhn.class)
    public void testLuhnAlgorithmOnTrue(){
        assertTrue("Here is test get right Number on check-true:", creditCardValidation.checkLuhnAlgorithm("7992739871079927"));
    }
    @Test(timeout = 100)
    @Category(ILuhn.class)
    public void testLuhnAlgorithmWithSpace(){
        assertTrue("Here is test get right Number separation space:", creditCardValidation.checkLuhnAlgorithm("7992 7398 7107 9927"));
    }
    @Test(timeout = 100)
    @Category(ILuhn.class)
    public void testLuhnAlgorithmWithHyphen(){
        assertTrue("Here is test get right Number separation hyphen:", creditCardValidation.checkLuhnAlgorithm("7992-7398-7107-9927"));
    }
    @Test(timeout = 100)
    @Category(ILuhn.class)
    public void testLuhnAlgorithmWithSpaceHyphen(){
        assertTrue("Here is test get right Number separation with space and with hyphen:", creditCardValidation.checkLuhnAlgorithm("7992 - 7398 - 7107 - 9927"));
    }

}
