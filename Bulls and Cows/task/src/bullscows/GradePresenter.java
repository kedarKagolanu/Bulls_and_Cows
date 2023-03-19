package bullscows;

public class GradePresenter {
    static void printGrade(int noofbulls,int noofcows) {
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
}
