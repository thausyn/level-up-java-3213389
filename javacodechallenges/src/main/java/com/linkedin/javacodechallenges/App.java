package com.linkedin.javacodechallenges;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.swing.RowFilter.Entry;

import com.google.gson.Gson;
/**
 * Hello world!
 *
 */
public class App {
    public static boolean isEven(int userNum) {
        return userNum % 2 == 0;
        // return (userNum & 1) == 0;
    }

    public static boolean isComplex(String p) {
        if (p.length() < 6) {
            return false;
        }

        boolean hasNumber = false;
        boolean hasLowercaseLetter = false;
        boolean hasUppercaseLetter = false;

        for (int i = 0; i < p.length() || !hasLowercaseLetter && !hasUppercaseLetter && !hasNumber; i++) {
            char current = p.charAt(i);

            if (Character.isDigit(current)) {
                hasNumber = true;
            } else if (Character.isLowerCase(current)) {
                hasLowercaseLetter = true;
            } else if (Character.isUpperCase(current)) {
                hasUppercaseLetter = true;
            }
        }

        return hasNumber && hasLowercaseLetter && hasUppercaseLetter;
    }

    public static LocalDate calculateHundredDaysFromNow(LocalDate today) {
        Period hundredDays = Period.ofDays(100);
        return today.plus(hundredDays);
    }

    public static double calculateWaterBill(double usage) {
        double currUsage = 18.84;
        double gallonsUsed = Math.ceil(usage / 748);

        if (gallonsUsed > 2) {
            currUsage += (gallonsUsed - 2) * 3.9;
        }

        return currUsage;
    }

    public static List<String> findStudentWithIncompleteVolunteerEvents(
            List<String> students, Map<String, List<String>> attendeesMapping) {
        Map<String, Integer> studentEventsCount = students.stream().collect(Collectors.toMap(r -> r, i -> 0));
        attendeesMapping.values().forEach(list -> list.stream()
                .filter(student -> studentEventsCount.containsKey(student))
                .forEach(filteredStudent -> studentEventsCount
                        .put(filteredStudent, studentEventsCount.get(filteredStudent) + 1)));
        return studentEventsCount.entrySet().stream().filter(map -> map.getValue() < 2)
                .map(studentsWithIncompleteVolunteerEventsMap -> studentsWithIncompleteVolunteerEventsMap.getKey())
                .collect(Collectors.toList());
    }

    public static double calculateAverageChangeInvested(List<Double> purchases){
        return purchases.stream()
            .mapToDouble(x -> Math.ceil(x) - x)
            .average().orElse(0);
    }

    private static Optional<String> parseJoke(String responseBody) {
        try{
            JokeResponse jokeResponse = new Gson().fromJson(responseBody, JokeResponse.class);
            String joke = jokeResponse.getJoke();
            if(joke != null){
                return Optional.of(jokeResponse.getJoke());
            }
            return Optional.empty();
        }catch(Exception e){
            System.out.println("Must be out of jokes for now.");
            return Optional.empty();
        }
    }
    
    public static final Map<Character, Integer> letterPoints = Map.ofEntries(Map.entry('A', 1),
        Map.entry('B', 3), Map.entry('C', 3), Map.entry('D', 2));

    public static int wordScoreCalculator(String word){
        String normalized = word.toUpperCase();
        AtomicInteger score = new AtomicInteger(0);
 
        normalized.chars()
        .filter(Character::isAlphabetic)
        .mapToObj(n -> (char) n)
        .forEachOrdered(letter -> {
            if(letterPoints.containsKey(letter)){
                score.getAndAdd(letterPoints.get(letter));
            }else{
                System.out.println("Looks like we need to add " + letter);
            }
        });
 
        return score.get();
    }

    public static void main(String[] args) throws IOException, InterruptedException{
        System.out.println("Enter a word and we'll tell you how many points it will earn!");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        System.out.println("Your word " + word + " will earn " + wordScoreCalculator(word));
        scanner.close();

        // var client = HttpClient.newHttpClient();
        // var request = HttpRequest.newBuilder(
        //     URI.create("https://icanhazdadjoke.com/"))
        //     .header("accept", "application/json")
        //     .build();
        // var response = client.send(request, BodyHandlers.ofString());
        // Optional<String> jokeOpt = parseJoke(response.body());
        // jokeOpt.ifPresent(System.out::println);

        // Team team1 = new Team("Sally", "Roger");
        // Team team2 = new Team("Eric", "Rebecca");
        // Team team3 = new Team("Tony", "Shannon");

        // List<Team> teams = List.of(team1, team2, team3);
        // int numberOfRounds = 4;

        // TeamUtils.generateTeamsScores(teams, numberOfRounds);
        // TeamUtils.revealResults(teams);
        // List<Double> purchases = List.of(12.38, 38.29, 5.27, 3.21);
        // System.out.println(calculateAverageChangeInvested(purchases));

        // List<StoreItem> items = List.of(
        //         new StoreItem("T-Shirt", 19.99, .4),
        //         new StoreItem("Dress", 34.99, .75),
        //         new StoreItem("Record Player", 92.99, .75),
        //         new StoreItem("Hat", 23.99, .1),
        //         new StoreItem("Jeans", 54.99, .65));

        // Optional<StoreItem> leastExpensiveOpt = StoreItem.findLeastExpensive(items);
        // if (leastExpensiveOpt.isPresent()) {
        //     System.out.println("The least expensive item is " + leastExpensiveOpt.get());
        // }

        // List<String> students = List.of("Sally", "Polly", "Molly", "Tony", "Harry");

        // Map<String, List<String>> attendeesMapping = Map.of("Farmer's Market",
        // List.of("Sally", "Polly"),
        // "Car Wash", List.of("Polly", "Molly", "Tony"),
        // "Cooking", List.of("Polly", "Molly", "Sally"),
        // "Midnight", List.of("Polly", "Molly"));

        // System.out.println(findStudentWithIncompleteVolunteerEvents(students,
        // attendeesMapping));
        // Scanner scanner = new Scanner(System.in);
        // System.out.println("How many gallons of water did you use this month?");
        // double usage = scanner.nextDouble();
        // System.out.println("Your water bill is " + calculateWaterBill(usage));
        // scanner.close();
        // LocalDate today = LocalDate.now();
        // System.out.println("100 days from now is... " +
        // calculateHundredDaysFromNow(today));
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
