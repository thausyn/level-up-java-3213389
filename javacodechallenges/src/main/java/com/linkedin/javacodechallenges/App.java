package com.linkedin.javacodechallenges;


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

    public static void main( String[] args )
    {
        Person p1 = new Person();
        p1.introduceYourself();
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
        // scanner.close();
    }
}
