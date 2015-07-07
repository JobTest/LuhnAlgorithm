The Luhn Algorithm
==================

###The brief

You are required to produce a solution to perform credit card validation according to the Luhn
algorithm below. This will be used for web-based validations and therefore should be tolerant of
edge conditions and invalid data scenarios which can be exhibited on a website. In addition, it is
required to support the entry of credit card numbers both with spaces and without spaces and to
validate each of these appropriately.

You should prove its operation through JUnit test cases.


###The Luhn Algorithm

The formula verifies a number against its included check-digit, which is usually appended to a partial 
account number to generate the full account number. This account number must pass the following
test:

1. Counting from the check digit, which is the rightmost, and moving left, double the value of every 
second digit.
2. Sum the digits of the products together with the un-doubled digits from the original number.
3. If the total ends in 0 (put another way, if the total modulo 10 is congruent to 0), then the number is
valid according to the Luhn formula; else it is not valid.


###Example

As an illustration, if the account number is [49927398716](https://en.wikipedia.org/wiki/Luhn_algorithm), it will be validated as follows:

1. Double every second digit, from the rightmost digit:
(1*2) = 2, (8*2) = 16, (3*2) = 6, (2*2) = 4, (9*2) = 18
2. Sum all digits (digits in parentheses are the products from Step 1):
6 + (2) + 7 + (1 + 6) + 9 + (6) + 7 + (4) + 9 + (1 + 8) + 4 = 70
3. Take the sum modulo 10: 70 mod 10 = 0; the account number is valid.


###luhn алгоритм java

* `Алгоритм Луна (Luhn Algorithm)` [http://crypto.pp.ua/2011/03/algoritm-luna-luhn-algorithm/](http://crypto.pp.ua/2011/03/algoritm-luna-luhn-algorithm/)
* `Luhn algorithm in Java` [http://www.xinotes.net/notes/note/595/](http://www.xinotes.net/notes/note/595/)
* [http://snipplr.com/view/7823/](http://snipplr.com/view/7823/)
* `Luhn test of credit card numbers` [http://rosettacode.org/wiki/Luhn_test_of_credit_card_numbers](http://rosettacode.org/wiki/Luhn_test_of_credit_card_numbers)
* `Check Credit Card Validity using Luhn Algorithm` [Check Credit Card Validity using Luhn Algorithm](http://stackoverflow.com/questions/20740444/check-credit-card-validity-using-luhn-algorithm)
* `Luhn algorithm java` [Luhn algorithm java](http://stackoverflow.com/questions/26383926/luhn-algorithm-java)
* `Luhn algorithm` [Luhn algorithm](https://en.wikipedia.org/wiki/Luhn_algorithm)
