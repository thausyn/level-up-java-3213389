package com.linkedin.javacodechallenges;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    public static List<String> findStudentWithIncompleteVolunteerEvents(
        List<String> students, Map<String, List<String>> attendeesMapping){
        Map<String, Integer> studentEventsCount = students.stream().collect(Collectors.toMap(s -> s, n -> 0));
        attendeesMapping.values().forEach(list -> list.stream()
        .filter(student -> studentEventsCount.containsKey(student))
        .forEach(filteredStudent -> studentEventsCount
        .put(filteredStudent, studentEventsCount.get(filteredStudent) + 1)));
        return studentEventsCount.entrySet().stream().filter(map -> map.getValue() < 2)
        .map(studentsWithIncompleteVolunteerEventsMap -> studentsWithIncompleteVolunteerEventsMap.getKey())
        .collect(Collectors.toList());
    }

    public static void main( String[] args )
    {
        List<String> students = List.of("Sally", "Polly", "Molly", "Tony", "Harry");

        Map<String, List<String>> attendeesMapping = Map.of("Farmer's Market", List.of("Sally", "Polly"),
            "Car Wash", List.of("Polly", "Molly", "Tony"),
            "Cooking", List.of("Polly", "Molly", "Sally"),
            "Midnight", List.of("Polly", "Molly"));

        System.out.println(findStudentWithIncompleteVolunteerEvents(students, attendeesMapping));
        // Scanner scanner = new Scanner(System.in);
        // System.out.println("How many gallons of water did you use this month?");
        // double usage = scanner.nextDouble();
        // System.out.println("Your water bill is " + calculateWaterBill(usage));
        // scanner.close();
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
