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
            FileController fc=new FileController();
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
                System.out.println("8: Add Review");//new
                System.out.println("9: Edit Review");//new
                System.out.println("10: Delete Review");//new
                System.out.println("11: View Reviews");//new
                System.out.println("12: Quit");//new
                System.out.print("-------Please Enter your choice:");
                choice = sc.nextInt();
                Student student = (Student)user;
                Course c;
                Index i;
                switch (choice) {
                    case 1:
                        do {
                            System.out.println("Enter the course code for the course you wish to add");
                            String cCode = sc.nextLine().trim();
                            c=fc.getCourseByCode(cCode);
                            if(c==null)
                                System.out.println("This course code does not exist");
                        }while(c!=null);
                       do {
                           System.out.println("Enter the index number for the course you wish to add");
                           int indexNum=sc.nextInt();
                           i= fc.getIndexByID(indexNum);
                           if(i==null)
                               System.out.println("This index number does not exist");
                       }while(i!=null);


                        smc.addCourse(student,student.getRegCourses(),c,i);
                        break;
                    case 2:
                        do {
                            System.out.println("Enter the course code for the course you wish to add");
                            String cCode = sc.nextLine().trim();
                            c=fc.getCourseByCode(cCode);
                            if(c==null)
                                System.out.println("This course code does not exist");
                        }while(c!=null);
                        do {
                            System.out.println("Enter the index number for the course you wish to add");
                            int indexNum=sc.nextInt();
                            i= fc.getIndexByID(indexNum);
                            if(i==null)
                                System.out.println("This index number does not exist");
                        }while(i!=null);
                        smc.dropCourse(student, c,i);
                        break;
                    case 3:
                        smc.printRegisteredCourses(student);
                        break;
                    case 4:
                        System.out.println("Enter the index number you want to check vacancies for");
                        int index=sc.nextInt();
                        smc.checkVacanciesAvailable(index);
                        break;
                    case 5:
                        smc.changeIndexNumber();
                        break;
                    case 6:
                        smc.swapIndexNumber();
                        break;
                    case 7:
                        School school=student.getSchool();
                        smc.checkAccessPeriod(school);
                        break;
                    case 8:////new
                        smc.addReview(student);
                        break;
                    case 9:////new
                        smc.editReview(student);
                        break;
                    case 10://new
                        smc.deleteReview(student);
                        break;
                    case 11://new
                        smc.displayReviews();
                        break;
                    case 12://updated
                        System.out.println("Program terminating Ö.");
                        break;
                    default:
                        System.out.println("Error!");
                        break;
                }
            } while (choice != 12);
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
