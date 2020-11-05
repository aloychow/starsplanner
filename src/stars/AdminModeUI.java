package stars;

import java.util.Scanner;

public class AdminModeUI implements PrintMenuUI{
    public void showMenu(User user) {
        //TODO
        int choice;
        Scanner sc = new Scanner(System.in);
        AdminModeController amc = new AdminModeController();

        do {
            System.out.println("");
            System.out.println("");
            System.out.println("Welcome to STARS! You may perform the following Actions:");
            System.out.println("--------------------------------------------------------");
            System.out.println("1: Edit Student Access Period");
            System.out.println("2: Add Student");
            System.out.println("3: Add Course");
            System.out.println("4: Check Available Slots");
            System.out.println("5: Print Student List by Index");
            System.out.println("6: Print Student List by Course");
            System.out.println("7: Quit");
            System.out.print("-------Please Enter your choice:");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    amc.editStudentAccessPeriod();;
                    break;
                case 2:
                    amc.addStudent();
                    break;
                case 3:
                    amc.addCourse();
                    break;
                case 4:
                    amc.checkAvailableSlot();
                    break;
                case 5:
                    amc.printStulisByIndex();
                    break;
                case 6:
                    amc.printStulisByCourse();
                    break;
                case 7:
                    System.out.println("Program terminating Ö.");
                    break;
                default:
                    System.out.println("Error!");
                    break;
            }
        } while (choice != 7);
    }

}
