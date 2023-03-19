package bullscows;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please, enter the secret code's length:");
        int size = input.nextInt();
        if(size > 10) {
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
            return;
        }
        double val = 0;
        double temp;
        Set<Double> set = new HashSet<>();
        temp = Math.floor(Math.random() * 10);
        for(int i=0;i<size;i++) {
            while(set.contains(temp)) {
                temp = Math.floor(Math.random() * 10);
            }
            set.add(temp);
            val = val * 10 + temp;
        }

        String secretCode = Double.toString(val);
        System.out.println(secretCode);

        System.out.println("Okay, let's start a game!");
        int noofbulls = 0;
        int noofcows = 0;
        String inputCode;
        int noofturns = 0;
        char tmp;
        while(noofbulls != size) {
            noofturns++;
            noofbulls = 0;
            noofcows = 0;
            System.out.println("\nTurn " + noofturns + ":");
            inputCode = input.next();

            String tempString = inputCode;
            if(tempString.length() != size) {
                continue;
            }
            for(int i=0;i<size;i++) {
                if(secretCode.charAt(i) == inputCode.charAt(i)) {
                    noofbulls++;
                    continue;
                }

                for(int j=0;j<size;j++) {
                    if(i==j) {
                        continue;
                    }

                    if(secretCode.charAt(i) == inputCode.charAt(j)){
                        noofcows++;
                    }
                }
            }

            System.out.print("Grade: ");
            if(noofbulls > 0) {
                System.out.print(noofbulls);
                if(noofbulls == 1) {
                    System.out.print(" bull");
                } else {
                    System.out.print(" bulls");
                }
            }
            if(noofbulls > 0 && noofcows > 0) {
                System.out.print(" and ");
            }
            if(noofcows > 0) {
                System.out.print(noofcows);
                if(noofcows == 1) {
                    System.out.print(" cow");
                } else {
                    System.out.print(" cows");
                }
            }

            if(noofbulls == 0 && noofcows == 0) {
                System.out.print("None.");
            }
        }

        System.out.println("Congratulations! You guessed the secret code.");
    }
}
