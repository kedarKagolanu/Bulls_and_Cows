package bullscows;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String sizeString = null;

        try{
            System.out.println("Input the length of the secret code:");
            sizeString = input.next();
            int size = Integer.parseInt(sizeString);
            System.out.println("Input the number of possible symbols in the code:");
            int range = input.nextInt();

            if(size == 0) {
                throw new Exception("Error; cannot create a code with zero size.");
            } else if(range > 36) {
                throw new Exception("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            } else if(size > range) {
                throw new Exception("Error: it's not possible to generate a code with a length of 6 with 5 unique symbols.");
            }

            if(size > 10) {
                System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
                return;
            }

            int charRange;
            if(range < 10) {
                charRange = 0;
            }else if(range < 26){
                charRange = (range - 10) % 26;
            } else {
                charRange = 26;
            }

            String secretCode = CodeGenerator.generateCode(size,charRange);
            System.out.println(secretCode);

            System.out.print("\nThe secret is prepared: ");
            for(int i=0;i<size;i++) {
                System.out.print("*");
            }
            System.out.print(" (0-9, a-" + (char)(97+charRange-1) + ").");
            System.out.println("Okay, let's start a game!");


            int noofbulls = 0;
            int noofcows;
            String inputCode;
            int noofturns = 0;
            while(noofbulls != size) {
                noofturns++;
                System.out.println("\nTurn " + noofturns + ":");
                inputCode = input.next();

                if(inputCode.length() != size) {
                    throw new Exception("Error: The length of input is not equal to the secretCode's length");
                }



                var list = CodeValidator.getBullsAndCowsCount(secretCode,inputCode);
                noofbulls = list.get(0);
                noofcows = list.get(1);

                GradePresenter.printGrade(noofbulls,noofcows);
            }
        } catch (NumberFormatException e) {
            System.out.print("Error : \"" + sizeString + "\" isn't a valid number.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Congratulations! You guessed the secret code.");
    }
}
