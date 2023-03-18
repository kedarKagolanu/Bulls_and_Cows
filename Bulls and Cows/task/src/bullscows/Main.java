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

        Set<Integer> set = new HashSet<Integer>();
        int val = 0;
        long pseudoRandomNumber = System.nanoTime() % 9;
        for(int i=0;i<size;i++) {
            while(set.contains((int)pseudoRandomNumber) || (i==0 && pseudoRandomNumber==0)) {
                pseudoRandomNumber = System.nanoTime() % 9;
            }
            val = val*10 + (int)pseudoRandomNumber;
            set.add((int)pseudoRandomNumber);
        }
        String secretCode = Integer.toString(val);


        System.out.println("Okay, let's start a game!");
        int noofbulls = 0;
        int noofcows = 0;
        String inputCode;
        int noofturns = 0;
        while(noofbulls != size) {
            noofturns++;
            System.out.println("\nTurn " + noofturns + ":");
            inputCode = input.next();

            char temp;
            String tempString = inputCode;
            if(tempString.length() < size) {
                continue;
            }
            for(int i=0;i<size;i++) {
                temp = tempString.charAt(i);

                if(temp == '_')
                    continue;

                if(secretCode.charAt(i) == temp) {
                    noofbulls++;
                } else if(secretCode.contains(Character.toString(temp))) {
                    noofcows++;
                    tempString = tempString.replace(temp, '_');
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
