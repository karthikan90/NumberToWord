package com.numbertoword;

import static com.numbertoword.ApplicationConstants.NUMBERNAMES;
import static com.numbertoword.ApplicationConstants.TENSNAMES;
import static com.numbertoword.ApplicationConstants.SPECIALNAMES;
import static com.numbertoword.ApplicationConstants.HUNDRED;

/**
 * This class helps to convert a given number to word
 */
public class NumberToWord {

    /**
     * This method uses to convert given number to less than thousand
     * @param number
     * @return
     */
    private String convertLessThanOneThousand(int number) {
        String current;

        if (number % 100 < 20) {
            current = NUMBERNAMES[number % 100];
            number /= 100;
        } else {
            current = NUMBERNAMES[number % 10];
            number /= 10;

            current = TENSNAMES[number % 10] + current;
            number /= 10;
        }
        if (number == 0)
            return current;
        return NUMBERNAMES[number] + HUNDRED + current;
    }

    /***
     * This method calls first to receive the input and convert from number to word
     * @param number
     * @return
     */
    public String convert(int number) {

        //If given number is 0 then simply return word as zero
        if (number == 0) {
            return "zero";
        }

        String prefix = "";

        //If given number is less than 0 then simply append "-" to prefix
        if (number < 0) {
            number = -number;
            prefix = "-";
        }

        String current = "";
        int place = 0;

        do {
            int n = number % 1000;
            if (n != 0) {
                String s = convertLessThanOneThousand(n);
                current = s + SPECIALNAMES[place] + current;
            }
            place++;
            number /= 1000;
        } while (number > 0);

        return (prefix + current).trim();
    }

    /**
     * The program begins from here.
     * @param args
     */
    public static void main(String[] args) {
        int number = 878945615;
        NumberToWord numberToWord = new NumberToWord();
        System.out.println("Given Number :: " +number);
        System.out.println("============================");
        String word = numberToWord.convert(number);
        System.out.println(number + " ==> " +word);
    }
}
