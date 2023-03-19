package bullscows;

import java.util.ArrayList;

public class CodeGenerator {
    static String generateCode(int size,int charRange) {
        ArrayList<Character> val = new ArrayList<>(size);
        int tempForTypeSelection;
        char temp;

        for(int i=0;i<size;i++) {
            do{
                tempForTypeSelection = (int)(Math.floor(Math.random() * 10)) % 2;
                if(!(charRange <= 0) && tempForTypeSelection == 0) {
                    temp = (char)(97 + ((Math.floor(Math.random()) * 100) % charRange));
                } else {
                    temp = (char) (48 + Math.floor(Math.random() * 10) % 10);
                }
            }while(val.contains(temp));

            val.add(temp);
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : val) {
            sb.append(character);
        }

        return sb.toString();

    }
}
