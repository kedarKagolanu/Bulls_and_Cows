package bullscows;

import java.util.ArrayList;

public class CodeValidator {
    static ArrayList<Integer> getBullsAndCowsCount(final String secretCode,final String inputCode) {
        ArrayList<Integer> counts = new ArrayList<>();
        int size = secretCode.length();
        int noofbulls = 0;
        int noofcows = 0;

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

        counts.add(noofbulls);
        counts.add(noofcows);

        return counts;
    }

    static void validateInput(String inputCode) throws Exception{
        for(int i=0;i<inputCode.length();i++) {
            int temp = (int) inputCode.charAt(i);
            if(!((temp >= 48 && temp <= 57) || (temp >= 97 && temp <= 122 ))) {
                throw new Exception("Error: The input contains invalid symbols.");
            }
        }
    }

}
