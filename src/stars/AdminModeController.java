package stars;
import java.util.*;

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

    public void addStudent() {
        //TODO
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
