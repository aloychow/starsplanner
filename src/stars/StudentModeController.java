package stars;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentModeController {
    Scanner sc=new Scanner(System.in);
    FileController fc=new FileController();
    public void addCourse() {

    }
    public void dropCourse()
    {

    }
    public void printRegisteredCourses(Student student) {
        //TODO
        System.out.println("   CourseID   CourseName   Index   ");
        System.out.println("===================================");
        ArrayList<RegisteredCourse> regCourses = student.getRegCourses();
        if (regCourses != null) {
            for (int i = 0; i < regCourses.size(); i++) {
                System.out.println(
                        "   " + regCourses.get(i).getRegIndex().getCourse().getCourseCode() + "       " + regCourses.get(i).getRegIndex().getCourse().getName()+ "         " + regCourses.get(i).getRegIndex());
            }
        } else {
            System.out.println("Sorry!,No Course Registered found for this Student");
        }
        return;
    }




    public void checkVacanciesAvailable(int index) {
        //TODO
        Index indObj = fc.findIndexFromSchools(index);
                if(indObj!=null){
                    System.out.println("Number Of Vacancies available" + indObj.getVacancies() + "outOf" + indObj.getTotalSlots());
                }
                else{
                    System.out.println("There is no Index with IndexNum"+index+"available");
                }



    }
    public void changeIndexNumber(){
        //TODO
    }
    public void swapIndexnumber() {
        //TODO
    }
    public void checkAccessPeriod(School school) {
        //TODO
        Date regStartDate=school.getRegistrationStartPeriod();
        Date regEndDate=school.getRegistrationEndPeriod();
        System.out.println("The registration access period is::  "+regStartDate+" to "+regEndDate);

    }

}
