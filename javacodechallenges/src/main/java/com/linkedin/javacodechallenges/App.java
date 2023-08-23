package com.linkedin.javacodechallenges;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static boolean isEven(int userNum){
        return userNum % 2 == 0;
//        return (userNum & 1) == 0;
    }

    public static boolean isComplex(String p){
        if(p.length() < 6){
            return false;
        }

        boolean hasNumber = false;
        boolean hasLowercaseLetter = false;
        boolean hasUppercaseLetter = false;

        for(int i = 0; i < p.length() || !hasLowercaseLetter && !hasUppercaseLetter && !hasNumber; i++){
            char current = p.charAt(i);

            if(Character.isDigit(current)){
                hasNumber = true;
            }else if(Character.isLowerCase(current)){
                hasLowercaseLetter = true;
            }else if(Character.isUpperCase(current)){
                hasUppercaseLetter = true;
            }
        }

        return hasNumber && hasLowercaseLetter && hasUppercaseLetter;
    }

    public static LocalDate calculateHundredDaysFromNow(LocalDate today){
        Period hundredDays = Period.ofDays(100);
        return today.plus(hundredDays);
    }

    public static double calculateWaterBill(double usage){
        double currUsage = 18.84;
        double gallonsUsed = Math.ceil(usage / 748);

        if(gallonsUsed > 2){
            currUsage += (gallonsUsed - 2) * 3.9;
        }
        
        return currUsage;
    }

    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many gallons of water did you use this month?");
        double usage = scanner.nextDouble();
        System.out.println("Your water bill is " + calculateWaterBill(usage));
        scanner.close();

        // LocalDate today = LocalDate.now();
        // System.out.println("100 days from now is... " + calculateHundredDaysFromNow(today));
        // Person p1 = new Person("John", "Wong", 30);
        // p1.introduceYourself();
        // System.out.println( "Hello World!" );
        // DoubleOrNothing game = new DoubleOrNothing();
        // game.playGame();
        // Scanner scanner = new Scanner(System.in);
        // System.out.println("Enter a password: ");
        // String password = scanner.next();
        // System.out.println("Is the password complex? " + isComplex(password));
        // System.out.println("Enter a number: ");
        // int userNum = scanner.nextInt();
        // System.out.println("Is the number even? " + isEven(userNum));
    }
}
