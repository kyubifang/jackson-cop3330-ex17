/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Jamar Jackson
 */

package base;

import java.util.Scanner;

/*
Exercise 17 - Blood Alcohol Calculator

Sometimes you have to perform a more complex calculation based on some provided inputs and then use that result to make a determination.

Create a program that prompts for your weight, gender, total alcohol consumed (in ounces), and the amount of time since your last drink. Calculate your blood alcohol content (BAC) using this formula

BAC = (A × 5.14 / W × r) − .015 × H

where

    A is total alcohol consumed, in ounces (oz).
    W is body weight in pounds.
    r is the alcohol distribution ratio:
        0.73 for men
        0.66 for women
    H is number of hours since the last drink.

Display whether or not it’s legal to drive by comparing the blood alcohol content to 0.08.
Example Output

Enter a 1 is you are male or a 2 if you are female: 1
How many ounces of alcohol did you have? 3
What is your weight, in pounds? 175
How many hours has it been since your last drink? 1

Your BAC is 0.049323
It is legal for you to drive.



Enter a 1 is you are male or a 2 if you are female: 1
How many ounces of alcohol did you have? 5
What is your weight, in pounds? 175
How many hours has it been since your last drink? 1

Your BAC is 0.092206
It is not legal for you to drive.

Constraint

    Prevent the user from entering non-numeric values.

Challenges

    Handle metric units.
    Look up the legal BAC limit by state and prompt for the state. Display a message that states whether or not it’s legal to drive based on the computed BAC.
    Develop this as a mobile application that makes it easy to record each drink, updating the BAC each time a drink is entered.
*/
public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();
        try {
            int binary = myApp.gender();
            int oz = myApp.ounces();
            int lbs = myApp.weight();
            int hours = myApp.timeSinceLast();
            double ratio = myApp.genderRatio(binary);
            double bac = myApp.bloodAlcoholContent(oz, lbs, ratio, hours);
            String legal = (bac < 0.08) ? ("It is legal for you to drive.") : ("It is not legal for you to drive.");
            String outputString = myApp.generateOutputString(legal);
            myApp.printOutput(outputString);
        }catch(NumberFormatException ex) {
            System.out.println("Please enter only a numeric value.");
        }
    }

    public void printOutput(String outputString) {
        System.out.println(outputString);
    }

    public int gender() {
        int yourGender = 3;
        while(yourGender == 0 || yourGender > 2) {
            System.out.println("Enter a 1 if you are male or a 2 if you are female: ");
            switch (in.nextInt()) {
                case 1 -> yourGender = 1;
                case 2 -> yourGender = 2;
                default -> System.out.println("That is not a valid number.");
            }
        }
        return yourGender;
    }

    public int ounces() {
        System.out.println("How many ounces of alcohol did you have? ");
        return in.nextInt();
    }

    public int weight() {
        System.out.println("What is your weight, in pounds? ");
        return in.nextInt();
    }

    public int timeSinceLast() {
        System.out.println("How many hours has it been since your last drink? ");
        return in.nextInt();
    }

    public double genderRatio(int binary) {
        return (binary == 1) ? .73 : .66;
    }

    public double bloodAlcoholContent(int oz, int lbs, double ratio, int hours) {
        double one = oz * 5.14;
        double two = one / lbs;
        double three = two * ratio;
        double four = three - .015;
        double five = four * hours;
        five = Math.round(five * 1000000d) / 1000000d;
        System.out.println("Your BAC is " + five);
        return five;
    }

    public String generateOutputString(String legal) {
        return legal;
    }
}
