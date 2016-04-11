package com.example.estitweg.assignment3;

/**
 * Created by estitweg on 16-03-16.
 */
public class NumberConverter {

    //function to change an array of integers (where each digit is its own element)
    //to a number
    public int intArrayToInt(int[]numbers, int numOfDigits){
        int number = 0;
        int place = 1;
        //run through the array from the last element to the first
        //add together the digits nultiplied by its corrisponding place (10's, 100's...)
        for (int i = numOfDigits - 1 ; i >= 0 ; i--){
            number += numbers[i] * place;
            place *= 10;
        }
        return number;
    }


    //function to convert a decimal number to a ternary number
    public int decimalToTernary(int num, int numOfDigits){
        //initialize variables
        int counter = 0;
        int number = num;
        int remainder = 0;
        int result = 4;
        //go through the calculation process to count how many digits this ternary number will have
        while (result != 0){
            result = num/3;
            remainder = num%3;
            num /= 3;
            counter++;
        }
        //using the just calculated number, make an array of that size
        int[] intArray = new int[counter];
        //repete the process to convert to a ternary number and fill the array with the calculated digits
        int i = intArray.length-1;
        remainder = 0;
        result = 4;
        while (result != 0){
            result = number/3;
            remainder = number%3;
            number /= 3;
            intArray[i] = remainder;
            i--;
        }
        //convert the array to an integer and return the ternary number
        return intArrayToInt(intArray, intArray.length);
    }

    //function to convert a decimal number to a Octal number
    public int decimalToOctal(int num, int numOfDigits){
        //initialize variables
        int counter = 0;
        int number = num;
        int remainder = 0;
        int result = 4;
        //go through the calculation process to count how many digits this ternary number will have
        while (result != 0){
            result = num/8;
            remainder = num%8;
            num /= 8;
            counter++;
        }
        //using the just calculated number, make an array of that size
        int[] intArray = new int[counter];
        //repete the process to convert to an octal number and fill the array with the calculated digits
        int i = intArray.length-1;
        remainder = 0;
        result = 4;
        while (result != 0){
            result = number/8;
            remainder = number%8;
            number /= 8;
            intArray[i] = remainder;
            i--;
        }
        //convert the array to an integer and return the Octal number
        return intArrayToInt(intArray, intArray.length);
    }


    //function to convert an octal number to a decimal number
    public int octalToDecimal(int num){
        //return the octal number converted to decimal
        //change int to string
        String stringNum = Integer.toString(num);
        int number = 0;
        //run through all inputed charecters
        for(int i = 0; i < stringNum.length(); i++) {
            char digit = stringNum.charAt(i);
            // change to number (integer)
            digit -= '0';
            // shift to left what I already ahve
            number *= 8;
            // add new number
            number += digit;
        }
        return number;
    }

    //function to convert a ternary number to a decimal number
    public int ternaryToDecimal(int num){
        //return the ternary number converted to decimal
        //change int to string
        String stringNum = Integer.toString(num);
        int number = 0;
        //run through all inputed charecters
        for(int i = 0; i < stringNum.length(); i++) {
            char digit = stringNum.charAt(i);
            // change to number (integer)
            digit -= '0';
            number *= 3;
            // add new number
            number += digit;
        }
        return number;
    }





}
