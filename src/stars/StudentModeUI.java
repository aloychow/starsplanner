package stars;

import java.util.Scanner;

public class StudentModeUI implements PrintMenuUI, DisplayErrorMsgUI {
    public void showMenu(User user) {
        //TODO
        if (user != null) {
            //first use FileController to get student object reference by username
            //check if the student user !=null
            //if student is not null, then check if it is within access period. If true, display menu, else display error message
            int choice;
            Scanner sc = new Scanner(System.in);
            StudentModeController smc = new StudentModeController();

            do {
                System.out.println("");
                System.out.println("");
                System.out.println("Welcome to STARS Student Version! You may perform the following Actions:");
                System.out.println("--------------------------------------------------------");
                System.out.println("1: Add a Course");
                System.out.println("2: Drop a Course");
                System.out.println("3: Print Registered Courses");
                System.out.println("4: Check Vacancies");
                System.out.println("5: Change Index Number");
                System.out.println("6: Swap Index Number");
                System.out.println("7: Check Access Period");
                System.out.println("8: Quit");
                System.out.print("-------Please Enter your choice:");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        smc.addCourse();
                        break;
                    case 2:
                        smc.dropCourse();
                        break;
                    case 3:
                        smc.printRegisteredCourses();
                        break;
                    case 4:
                        smc.checkVacanciesAvailable();
                        break;
                    case 5:
                        smc.changeIndexNumber();
                        break;
                    case 6:
                        smc.swapIndexnumber();
                        break;
                    case 7:
                        smc.checkAccessPeriod();
                        break;
                    case 8:
                        System.out.println("Program terminating Ö.");
                        break;
                    default:
                        System.out.println("Error!");
                        break;
                }
            } while (choice != 8);
        }
        else
        {
            displayErrorMsg("You are not allowed to access this student menu. Sorry");
        }
        }
        public void displayErrorMsg(String errorMsg)
        {
            System.out.println(errorMsg);
        }


}
