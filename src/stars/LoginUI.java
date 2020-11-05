package stars;

import java.util.*;

public class LoginUI {


//	private String enteredEmail;
//	private String enteredPassword;
//	private String typeOfUser;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        LoginController login = new LoginController();

        String enteredEmail;
        String enteredPassword;
        String typeOfUser;
        System.out.print("Enter your email: ");
        enteredEmail = sc.next();
        System.out.print("Enter your password: ");
        enteredPassword = sc.next();
        System.out.print("Enter type of User (Student/Admin): ");
        typeOfUser = sc.next();
        while (!login.validateLogin(enteredEmail, enteredPassword, typeOfUser)) {
            displayErrorMsg();
            System.out.print("Enter your email: ");
            enteredEmail = sc.next();
            System.out.print("Enter your password: ");
            enteredPassword = sc.next();
            System.out.print("Enter type of User (Student/Admin): ");
            typeOfUser = sc.next();

        }

        sc.close();

    }

    public static void displayErrorMsg() {
        // TODO
        System.err.println("Please enter valid inputs.");
        System.out.println("");
    }

}
