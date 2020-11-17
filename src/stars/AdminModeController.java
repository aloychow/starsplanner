package stars;
import java.util.*;
import java.io.Console;
public class AdminModeController {
    Scanner sc=new Scanner(System.in);
    FileController fc=new FileController();
    public void editStudentAccessPeriod(String school, Date startDate, Date endDate) {
        //TODO
        if(school!=null)
        {
            School updateSchool=fc.getSchoolByName(school);
            if(updateSchool!=null)
            {
                updateSchool.setRegistrationStartPeriod(startDate);
                updateSchool.setRegistrationEndPeriod(endDate);
                fc.saveSchoolList();
                System.out.println("Access Period has been updated.");
            }
            else
            {
                System.out.println("School does not exist");
            }

        }
        else
        {
            System.out.println("School value cannot be null");
        }

    }
//method for admin to add a student
    public void addStudent() {
        //TODO
        // needs the email, password, username, matricNo, gender, nationality, name, year, school
        Student student=new Student();
        student.setTypeOfUser("Student");
        String username,email, matricNo, gender, nationality, name, schoolName;
        String choice="sendEmail";
        String recipient;
        int year;
        School school;
        String pass1,pass2;
        boolean passMatch=false;
        boolean validEmail=false;
        char ch;
        Student presentStudent;
        do {
            System.out.println("Please enter the student's username");
            username = sc.nextLine().trim().toUpperCase();
            presentStudent = fc.getStudentByUsername(username);
            if (presentStudent != null) {
                System.out.println("Error. Student with this username already exists.");
            }
        } while(presentStudent!=null);

       do{
           System.out.println("Please enter the student's email");
           email=sc.nextLine().trim();
           User user=student;
           validEmail=user.validateEmail(email);
           if(validEmail==false)
           {
               System.out.println("Error. You entered an invalid email");
           }
       }while(validEmail!=false);
       recipient=email;


        Console console = System.console();
        do {
            if (console != null) {
                System.out.print("Please enter the student's password ");
                char[] passString = console.readPassword();
                pass1 = new String(passString);
                System.out.print("Please confirm the password ");
                passString = console.readPassword();
                pass2 = new String(passString);

                if (pass1.equals(pass2))
                    passMatch = true;
                else
                    System.out.println("Error. The 2 passwords are not same. ");
            } else {
                System.out.print("Please enter the student's password ");
                pass1 = sc.nextLine().trim();
                System.out.print("Please confirm the password ");
                pass2 = sc.nextLine().trim();
                if (pass1.equals(pass2))
                    passMatch = true;
                else
                    System.out.println("Error. The 2 passwords are not same. ");
            }
        } while (passMatch != true);


        System.out.println("Enter the student's name ");
        name=sc.nextLine().trim();
        System.out.println("Enter the student's matriculation number");
        matricNo=sc.nextLine().trim();
        System.out.println("Enter the student's nationality");
        nationality=sc.nextLine().trim();
        System.out.println("Enter the student's year");
        year=sc.nextInt();
        do {
            System.out.println("Enter the student's gender");
            gender=sc.nextLine().trim().toLowerCase();
            if(gender!="female"&&gender!="male")
            {
                System.out.println("Gender must be male or female");
            }
        }while(gender!="female"&&gender!="male");

        do {
            System.out.println("Enter the student's school name ");
            schoolName=sc.nextLine().trim().toUpperCase();
            school=fc.getSchoolByName(schoolName);
            if(school==null)
            {
                System.out.println("Error. This school does not exist.");
            }
        }while(school!=null);
        do {
            System.out.println("Enter the student's preferred notification type (Email E/Telegram T/Whatsapp W");
           ch = sc.nextLine().charAt(0);
            switch (ch) {
                case 'E':
                    recipient = email;
                    choice = "sendEmail";
                    break;
                case 'T':
                    System.out.println("Enter the student's telegram number");
                    recipient = sc.nextLine().trim();
                    choice = "sendTele";
                    break;
                case 'W':
                    System.out.println("Enter the student's whatsapp number");
                    recipient = sc.nextLine().trim();
                    choice = "sendWhatsapp";
                    break;
                default:
                    System.out.println("Incorrect input. Try again.");
                    System.out.println("Enter the student's preferred notification type (Email E/Telegram T/Whatsapp W");
                    ch=sc.nextLine().charAt(0);
            }
        }while(ch!='T'&&ch!='W'&&ch!='E');
        //hashing of the password is done
        pass1=student.buildPasswordHash(pass1);

        student=school.addStudent(name, matricNo,gender, nationality, year, school,choice,recipient, email, pass1, "Student", username);
        fc.getStudentList().add(student);
        fc.saveStudentList();
        fc.saveSchoolList();
        //print the list of students after every new student is added
        fc.printStudentList();
    }



    public void addCourse() {
        //TODO
    }
    public void checkAvailableSlot() {
        //TODO
        System.out.println("Enter the Index you want to check vacancies for: ");
        int indexID = sc.nextInt();
        // convert string index to Index class
        // get the Index object from FileController
        Index i = null;
        if (i != null) {
            int vacancy = i.getVacancies();
            System.out.println("There are " + vacancy + " vacancies available for " + i.getIndexNum());
        } else {
            System.out.println("Index not found!");
        }
    }
    public void printStulisByIndex() {
        //TODO
    }
    public void printStulisByCourse() {
        //TODO
    }
}
