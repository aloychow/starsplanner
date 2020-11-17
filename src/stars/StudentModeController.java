package stars;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentModeController {
    Scanner sc=new Scanner(System.in);
    FileController fc=new FileController();


        public void addCourse(Student student, ArrayList<RegisteredCourse> registeredCourses, Course course, Index index) {
            //TODO

            //Check for total AUS after addition of the course
            if (student.getNumberOfAUs() + course.getTotalAUs() > 21) {
                System.out.printf("You currently have %d AUs.\nYou are not allowed to exceed the AUs limit of 21.\n", student.getNumberOfAUs());
                return;
            }

            //Check if applied before (either accepted/waitlisted)


                for(RegisteredCourse registeredCourse : student.getRegCourses()) {
                    if(registeredCourse.getRegIndex().getCourse().equals(course)) {
                        System.out.printf("You have already been registered for index %d", registeredCourse.getRegIndex().getIndexNum());
                        System.out.printf("The current status is %s\n", registeredCourse.getRegStatus());
                        return;
                    }
                }



            //Check if clash with current timetable

            String status;
            //Get Vacancy
            if (index.getVacancies() <= 0) {

                System.out.println("There are no more vacancies for this index.");
                System.out.printf("There are currently %d people in the wait list.", index.getWaitList().size());
                System.out.println("Would you like to join the wait list? (Y/N)");

                Scanner sc = new Scanner(System.in);
                char answer = sc.next().charAt(0);

                if (answer == 'N') {
                    return;
                }

                //Add student into wait list
                status = "Waitlist";
                index.addToWaitList(student);
            } else {
                status = "Registered";
                //Set new number of AUs
                student.setNumberOfAUs(student.getNumberOfAUs()+course.getTotalAUs());
                index.setVacancies(index.getVacancies()-1);
            }

            //Create new Registered Course class
            RegisteredCourse registeredCourse = new RegisteredCourse(index, status, student);

            //Add course to student's list of registered courses
            student.addRegCourses(registeredCourse);

            //Set Registered
            System.out.printf("You have been registered for index %d\n", index.getIndexNum());
            System.out.printf("The current status for the course is %s\n", status);
            return;
        }
        public void dropCourse(Student student, Course course, Index index) {
            //TODO
            boolean isRegistered=false;
            for(int i=0;i<student.getRegCourses().size();i++)
                if(student.getRegCourses().get(i).getRegIndex()==index)
                    isRegistered=true;
            if (!isRegistered) {
                System.out.printf("You are not currently registered for index %d, course %s", index.getIndexNum(), index.getCourse().getCourseCode());
                return;
            } else {
                student.setNumberOfAUs(student.getNumberOfAUs()-course.getTotalAUs());
                //setTimetableSchedule();

                index.setVacancies(index.getVacancies()+1);

                index.allocateVacancies(course, index);
                System.out.println("The course has been dropped for you.");
            }
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
        Index indObj = fc.getIndexByID(index);
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
    public void swapIndexNumber() {
        //TODO
    }
    public void checkAccessPeriod(School school) {
        //TODO
        Date regStartDate=school.getRegistrationStartPeriod();
        Date regEndDate=school.getRegistrationEndPeriod();
        System.out.println("The registration access period is::  "+regStartDate+" to "+regEndDate);

    }

}
