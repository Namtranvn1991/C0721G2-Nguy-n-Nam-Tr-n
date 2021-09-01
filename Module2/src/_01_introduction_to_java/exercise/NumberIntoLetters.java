package _01_introduction_to_java.exercise;

import java.util.Scanner;

public class NumberIntoLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("input ");
        int input = scanner.nextInt();
        String output;
        int units = input % 10;
        int dozens = (input % 100 - units) / 10;
        int hundreds = (input % 1000 - dozens - units) / 100;
//        System.out.printf("" + units + "\n");
//        System.out.printf("" + dozens + "\n");
//        System.out.printf("" + hundreds + "\n");
        String unitString = "";
        switch (units){
            case 0:
                unitString = "";
                break;
            case 1:
                unitString = "one";
                break;
            case 2:
                unitString = "two";
                break;
            case 3:
                unitString = "three";
                break;
            case 4:
                unitString = "four";
                break;
            case 5:
                unitString = "five";
                break;
            case 6:
                unitString = "six";
                break;
            case 7:
                unitString = "seven";
                break;
            case 8:
                unitString = "eight";
                break;
            case 9:
                unitString = "nine";
                break;
        }
        String dozensString = null;
        switch (dozens){
            case 1:
                switch (units){
                    case 0:
                        dozensString = "ten";
                        unitString = "";
                        break;
                    case 1:
                        dozensString = "eleven";
                        unitString = "";
                        break;
                    case 2:
                        dozensString = "twelve";
                        unitString = "";
                        break;
                    case 3:
                        dozensString = "thirteen";
                        unitString = "";
                        break;
                    case 4:
                        dozensString = "fourteen";
                        unitString = "";
                        break;
                    case 5:
                        dozensString = "fifteen";
                        unitString = "";
                        break;
                    case 6:
                        dozensString = "sixteen";
                        unitString = "";
                        break;
                    case 7:
                        dozensString = "seventeen";
                        unitString = "";
                        break;
                    case 8:
                        dozensString = "eightteen";
                        unitString = "";
                        break;
                    case 9:
                        dozensString = "nineteen";
                        unitString = "";
                        break;

                }
                break;
            case 2:
                dozensString = "twenty";
                break;
            case 3:
                dozensString = "thirty";
                break;
            case 4:
                dozensString = "fourty";
                break;
            case 5:
                dozensString = "fifty";
                break;
            case 6:
                dozensString = "sixty";
                break;
            case 7:
                dozensString = "seventy";
                break;
            case 8:
                dozensString = "eighty";
                break;
            case 9:
                dozensString = "ninety";
                break;
        }
        String hundredsString = "";
        switch (hundreds){
            case 1:
                hundredsString = "one";
                break;
            case 2:
                hundredsString = "two";
                break;
            case 3:
                hundredsString = "three";
                break;
            case 4:
                hundredsString = "four";
                break;
            case 5:
                hundredsString = "five";
                break;
            case 6:
                hundredsString = "six";
                break;
            case 7:
                hundredsString = "seven";
                break;
            case 8:
                hundredsString = "eight";
                break;
            case 9:
                hundredsString = "nine";
                break;
        }


        if (input>=0){
            if (input<20){
                switch (input){
                    case 0:
                        System.out.printf("zero");
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        System.out.printf("%s", unitString);
                        break;
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 15:
                    case 14:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                        System.out.printf("%s", dozensString);
                        break;
                }
            } else if (input<100){
                System.out.printf("%s %s",dozensString,unitString);
            } else if (input<1000){
                System.out.printf("%s hundred and %s %s",hundredsString,dozensString,unitString);
            } else {
                System.out.printf("out of ability");
            }
        } else {
            System.out.printf("out of ability");
        }
    }
}
