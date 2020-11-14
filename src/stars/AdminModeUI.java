package stars;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class AdminModeUI implements PrintMenuUI, DisplayErrorMsgUI{
    public void showMenu(User user) {
        //TODO
        if(user !=null)
        {
            //retrieve admin object from file controller
            //if admin object is not null
            int choice;
            Scanner sc = new Scanner(System.in);
            AdminModeController amc = new AdminModeController();
            SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy/HH/mm");
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

                        try {
                            System.out.println("Enter the School Name");
                            String school=sc.next();
                            System.out.println("Enter the new registration start period in dd/mm/yyyy/hh/mm");
                            String startDate=sc.next();
                            Date convertedStartDate = format.parse(startDate);
                            System.out.println(convertedStartDate);
                            System.out.println(format.format(convertedStartDate));
                            System.out.println("Enter the new registration end period in dd/mm/yyyy/hh/mm");
                            String endDate=sc.next();
                            Date convertedEndDate = format.parse(endDate);
                            System.out.println(convertedEndDate);
                            System.out.println(format.format(convertedEndDate));
                            amc.editStudentAccessPeriod(school, convertedStartDate, convertedEndDate);
                        } catch (ParseException e) {
                            e.printStackTrace();
                            System.out.println("Invalid registration period format");
                        }
                        catch(NullPointerException e)
                        {
                            e.printStackTrace();
                        }
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
        else
            {
                displayErrorMsg("You are not allowed to access this admin menu. Sorry");
            }
        }
        public void displayErrorMsg(String errorMsg)
        {
                System.out.println(errorMsg);
        }


}
