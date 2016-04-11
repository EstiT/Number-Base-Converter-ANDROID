package com.example.estitweg.assignment3;

import android.content.SyncAdapterType;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    NumberConverter change = new NumberConverter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //make buttons and edit text variables
        final Button decimalButton = (Button) findViewById(R.id.decimal);
        final Button ternaryButton = (Button) findViewById(R.id.ternary);
        final Button octalButton = (Button) findViewById(R.id.octal);
        final EditText text = (EditText) findViewById(R.id.editText);

        //DECIMAL BUTTON
        decimalButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //if the decimal button is clicked
                //change the other buttons to red and the decimal button to green
                ternaryButton.setBackgroundResource(R.drawable.red_drawable);
                octalButton.setBackgroundResource(R.drawable.red_drawable);
                decimalButton.setBackgroundResource(R.drawable.green_drawable);
                //get the text string that the user inputed
                String input =  text.getText().toString();
                boolean runMe = true;
                //if there is nothing in the text field then display error messege
                if (input.equals("")){
                    text.setText("ERROR");
                    text.setBackgroundResource(R.color.Red);
                }
                //if the user did not enter the right number of charecters (there needs to be it least 3)
                //then display the error messege
                if(text.length()<3) {
                    text.setText("ERROR");
                    text.setBackgroundResource(R.color.Red);
                }
                //there are at least three characters inputed
                else{
                    //make an array from the input
                    //each character inputed is its own element in the array
                    CharSequence textArray = text.getText();
                    //get the first second charecters from the array
                    char firstCharValue = textArray.charAt(0);
                    char secondCharValue = textArray.charAt(1);
                    //if the first charecter is not either o or d or t or the second charecter is not : then display the error messege
                    if (!((firstCharValue == 'd' || firstCharValue == 'o' || firstCharValue == 't' ) && (secondCharValue  == ':'))){
                        text.setText("ERROR");
                        text.setBackgroundResource(R.color.Red);
                    }
                    //check if all the character  are numbers and not a letter or symbol
                    //change each charecter to its ascii value and make sure its within the correct range
                    else{
                        for (int i = 0; i<textArray.length() ; i++){
                            if ((int)textArray.charAt(i)<48 || (int)textArray.charAt(i)>57){
                                runMe = false;
                            }
                        }
                    }
                    if ((firstCharValue == 'd' || firstCharValue == 'o' || firstCharValue == 't' ) && (secondCharValue  == ':') && !runMe){
                        //get the number of charecters inputed
                        //from that, calculate the number of digits in the inputed number
                        int numOfChars = textArray.length();
                        int numOfDigits = numOfChars-2;
                        //make an array of the inputed numbers
                        int[] numbers = new int [numOfDigits];
                        //fill the array in with the numbers from the input
                        for (int i = 0; i < numOfDigits ; i++){
                            numbers[i] = Integer.parseInt(String.valueOf(textArray.charAt(i+2)));
                        }
                        //change the array of integers into the actual entered number
                        int number = change.intArrayToInt(numbers, numOfDigits);
                        // if user entered a decimal number and wants a decimal number
                        if(firstCharValue == 'd'){
                            //then output the same number that they entered
                            text.setText("d:"+Integer.toString(number));
                        }
                        //if the user entered an octal number to be converted to decimal
                        else if(firstCharValue == 'o'){
                            //convert the octal number to a decimal integer and then to a string
                            //output the string
                            text.setText("d:"+Integer.toString(change.octalToDecimal(number)));
                        }
                        //the user entered a ternary number to be converted to decimal
                        else if (firstCharValue == 't'){
                            //convert the ternary number to a decimal integer and then to a string
                            //output the string
                            text.setText("d:"+Integer.toString(change.ternaryToDecimal(number)));
                        }
                        //set the text feild back to white (if it had changed to red)
                        text.setBackgroundResource(R.color.White);
                    }
                }
                //if it was none of those senarios then its invalid input and display the error messege
                if (runMe){
                    text.setText("ERROR");
                    text.setBackgroundResource(R.color.Red);
                }

            }});


      //TERNARY BUTTON
        ternaryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //if the Ternary button is clicked
                //change the ternary button to green and the other buttons to red
                    decimalButton.setBackgroundResource(R.drawable.red_drawable);
                    octalButton.setBackgroundResource(R.drawable.red_drawable);
                ternaryButton.setBackgroundResource(R.drawable.green_drawable);
                //get the text string that the user inputed
                String input =  text.getText().toString();
                boolean runMe = true;
                //if there is nothing in the text field then display error messege
                if (input.equals("")){
                    text.setText("ERROR");
                    text.setBackgroundResource(R.color.Red);
                }
                //if the user did not enter the right number of characters (there needs to be it least 3)
                //then display the error messege
                if(text.length()<3) {
                    text.setText("ERROR");
                    text.setBackgroundResource(R.color.Red);
                }
                //there are at least three characters inputed
                else{
                    //make an array from the input
                    //each character inputed is its own element in the array
                    CharSequence textArray = text.getText();
                    //get the first second characters from the array
                    char firstCharValue = textArray.charAt(0);
                    char secondCharValue = textArray.charAt(1);
                    //if the first charecter is not either o or d or t or the second charecter is not : then display the error messege
                    if (!((firstCharValue == 'd' || firstCharValue == 'o' || firstCharValue == 't' ) && (secondCharValue  == ':'))){
                        text.setText("ERROR");
                        text.setBackgroundResource(R.color.Red);
                    }
                    //check if all the character  are numbers and not a letter or symbol
                    //change each charecter to its ascii value and make sure its within the correct range
                    else{
                        for (int i = 0; i<textArray.length() ; i++){
                            if ((int)textArray.charAt(i)<48 || (int)textArray.charAt(i)>57){
                                runMe = false;
                            }
                        }
                    }
                    if ((firstCharValue == 'd' || firstCharValue == 'o' || firstCharValue == 't' ) && (secondCharValue  == ':') && !runMe){
                        //get the number of charecters inputed
                        //from that, caluclate the number of digits in the inputed number
                        int numOfChars = textArray.length();
                        int numOfDigits = numOfChars-2;
                        //make an array of the inputed numbers
                        int[] numbers = new int [numOfDigits];
                        //fill the array in with the numbers from the input
                        for (int i = 0; i < numOfDigits ; i++){
                            numbers[i] = Integer.parseInt(String.valueOf(textArray.charAt(i+2)));
                        }
                        //change the array of integers into the actual entered number
                        int number = change.intArrayToInt(numbers, numOfDigits);
                        // if user entered a decimal number and wants a decimal number
                        if(firstCharValue == 'd'){
                            //convert the decimal number to ternary and output that
                            text.setText("t:"+Integer.toString(change.decimalToTernary(number, numOfDigits)));
                        }
                        //if the user entered an octal number to be converted to ternary
                        else if(firstCharValue == 'o'){
                            //convert the octal number to decimal
                            int decimalNum = change.octalToDecimal(number);
                            //then make an array of the decimal number digits
                            int [] decimalArray = new int [String.valueOf(decimalNum).length()];
                            for (int i=0; i<String.valueOf(decimalNum).length(); i++){
                                decimalArray[i] = (int)String.valueOf(decimalNum).charAt(i);
                            }
                            //convert the decimal number to ternary then to a string and output that
                            text.setText("t:"+Integer.toString(change.decimalToTernary(decimalNum, decimalArray.length)));
                        }
                        //the user endered a ternary number and wants a ternary number
                        else if (firstCharValue == 't'){
                            //convert the ternary number to a decimal integer and then to a string
                            //output the string
                            text.setText("t:"+String.valueOf(number));

                        }
                        //set the text feild back to white (if it had changed to red)
                        text.setBackgroundResource(R.color.White);
                    }
                }
                //if it was none of those senarios then its invalid input and display the error messege
                if (runMe){
                    text.setText("ERROR");
                    text.setBackgroundResource(R.color.Red);
                }

            }});



        //OCTAL BUTTON
        octalButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //if the Octal button is clicked
                //change the other buttons to red and the octal button to green
                ternaryButton.setBackgroundResource(R.drawable.red_drawable);
                octalButton.setBackgroundResource(R.drawable.green_drawable);
                decimalButton.setBackgroundResource(R.drawable.red_drawable);
                //get the text string that the user inputed
                String input =  text.getText().toString();
                boolean runMe = true;
                //if there is nothing in the text field then display error messege
                if (input.equals("")){
                    text.setText("ERROR");
                    text.setBackgroundResource(R.color.Red);
                }
                //if the user did not enter the right number of characters (there needs to be it least 3)
                //then display the error messege
                if(text.length()<3) {
                    text.setText("ERROR");
                    text.setBackgroundResource(R.color.Red);
                }
                //there are at least three characters inputed

                else{
                    //make an array from the input
                    //each character inputed is its own element in the array
                    CharSequence textArray = text.getText();
                    //get the first second characters from the array
                    char firstCharValue = textArray.charAt(0);
                    char secondCharValue = textArray.charAt(1);
                    //if the first character is not either o or d or t or the second charecter is not : then display the error messege
                    if (!((firstCharValue == 'd' || firstCharValue == 'o' || firstCharValue == 't' ) && (secondCharValue  == ':'))){
                        text.setText("ERROR");
                        text.setBackgroundResource(R.color.Red);
                    }
                    //check if all the character  are numbers and not a letter or symbol
                    //change each charecter to its ascii value and make sure its within the correct range
                    else{
                        for (int i = 0; i<textArray.length() ; i++){
                            if ((int)textArray.charAt(i)<48 || (int)textArray.charAt(i)>57){
                                runMe = false;
                            }
                        }
                    }
                    if ((firstCharValue == 'd' || firstCharValue == 'o' || firstCharValue == 't' ) && (secondCharValue  == ':') && !runMe){
                        //get the number of characters inputed
                        //from that, calculate the number of digits in the inputed number
                        int numOfChars = textArray.length();
                        int numOfDigits = numOfChars-2;
                        //make an array of the inputed numbers
                        int[] numbers = new int [numOfDigits];
                        //fill the array in with the numbers from the input
                        for (int i = 0; i < numOfDigits ; i++){
                            numbers[i] = Integer.parseInt(String.valueOf(textArray.charAt(i+2)));
                        }
                        //change the array of integers into the actual entered number
                        int number = change.intArrayToInt(numbers, numOfDigits);
                        // if user entered a decimal number and wants an octal number
                        if(firstCharValue == 'd'){
                            //convert the decimal number to octal and then to a string
                            text.setText("o:"+Integer.toString(change.decimalToOctal(number, numOfDigits)));
                        }
                        //if the user entered an octal number and wants an octal number
                        else if(firstCharValue == 'o'){
                            //output the inputed number
                            text.setText("o:"+Integer.toString(number));
                        }
                        //the user entered a ternary number to be converted to octal
                        else if (firstCharValue == 't'){
                            //convert the ternary number to decimal number then to an octal integer and then to a string
                            int decimalNum = change.ternaryToDecimal(number);
                            //change the decimal number to an array where each digit is its own element
                            int [] decimalArray = new int [String.valueOf(decimalNum).length()];
                            for (int i=0; i<String.valueOf(decimalNum).length(); i++){
                                decimalArray[i] = (int)String.valueOf(decimalNum).charAt(i);
                            }
                            //output the string
                            text.setText("o:"+Integer.toString(change.decimalToOctal(decimalNum, String.valueOf(decimalNum).length())));
                        }
                        //set the text feild back to white (if it had changed to red)
                        text.setBackgroundResource(R.color.White);
                    }
                }
                //if it was none of those senarios then its invalid input and display the error messege
                if (runMe){
                    text.setText("ERROR");
                    text.setBackgroundResource(R.color.Red);
                }

            }});


    }













}
