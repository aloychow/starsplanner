package stars;
import java.util.*;
import de.zabuza.grawlox.*;
import java.io.*;
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
            ArrayList<StudyGroup> s = student.getStudyGroups();
            if (checkClash(index, s)) {
                return;
            }

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
    private Review reviewSelection(Student student) {
        int reviewSelection;
        boolean flag = true;

        ArrayList<Review> reviews = student.getMyReviews();

        do {
            // Get user's selection of courses
            System.out.println("Select the Review you would like to make changes to:");
            for(int i = 0; i < reviews.size(); i++) {
                System.out.println(i+1 + ". " + reviews.get(i));
            }
            reviewSelection = sc.nextInt();

            if (reviewSelection > 0 && reviewSelection < reviews.size() + 1) {
                Review review = reviews.get(reviewSelection - 1);
                flag = false;
                return review;
            }
            else {
                System.out.println("Invalid selection.");
            }
        } while(flag);
        return null;
    }

    private Course reviewCourseSelection(Student student) {
        int courseSelection;
        boolean flag = true;

        ArrayList<Course> courses = student.getPastCourses();

        do {
            // Get user's selection of courses
            System.out.println("Select the course you would like to add/edit/remove review for:");
            for(int i = 0; i < courses.size(); i++) {
                System.out.println(i+1 + ". " + courses.get(i));
            }
            courseSelection = sc.nextInt();

            if (courseSelection > 0 && courseSelection < courses.size() + 1) {
                Course course = courses.get(courseSelection - 1);
                flag = false;
                return course;
            }
            else {
                System.out.println("Invalid selection.");
            }
        } while(flag);
        return null;
    }
    private boolean getRec() {
        do {
            System.out.println("Would you recommend the course? (1/0)");
            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                switch(choice) {
                    case 0:
                        return false;
                    case 1:
                        return true;

                    default:
                        System.out.println("Invalid selection.");
                        break;
                }
            }else {
                String input = sc.next();
                System.out.println("Invalid selection.");
            }
        } while(true);
    }
    private String filterReview(String input){
        try{
            Grawlox grawlox = Grawlox.createFromDefault();
            return grawlox.filter(input);
        } catch (IOException e) {
            System.out.println("Invalid inout");
            return null;
        }

    }
    public void addReview(Student student){
        //print all the courses(previously taken courses) and get course choice to add review to
        Course c = reviewCourseSelection(student);
        System.out.println("Enter your review below:");
        String r = sc.next();
        r = filterReview(r);
        boolean rec = getRec();
        Review rev = new Review(r, rec, student, c);
    }
    public void editReview(Student student) {
        Course c = reviewCourseSelection(student);
        Review rev = reviewSelection(student);
        System.out.println("1. Change review.");
        System.out.println("2. Ammend recommended status.");
        boolean flag = true;
        do {
            System.out.println("Input a choice (1/2)");
            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                switch(choice) {
                    case 1:
                        flag = false;
                        System.out.println("Enter your edited review below:");
                        String r = sc.next();
                        r = filterReview(r);
                        rev.setReview(r);
                        break;
                    case 2:
                        flag = false;
                        boolean rec = getRec();
                        rev.setRecommended(rec);
                        break;

                    default:
                        System.out.println("Invalid selection.");
                        break;
                }
            }else {
                String input = sc.next();
                System.out.println("Invalid selection.");
            }
        } while(flag);
    }

    public void deleteReview(Student student) {
        Course c = reviewCourseSelection(student);
        Review rev = reviewSelection(student);
        student.deleteReview(rev);
        c.deleteReview(rev);

    }
    /**
     * Allows user to sort courses by number of reviews or percentage recommended and make selection.
     * The, display the reviews.
     */
    public void displayReviews() {
        int select; int courseSelection;
        boolean flag = true;
        DisplayDataController dd = new DisplayDataController();
        Scanner sc = new Scanner(System.in);
        School sch = dd.schSelection();
        ArrayList<Course> schCourses = sch.getCourses();
        do {
            System.out.println("Select the sorting method");
            System.out.println("1. Sort by number of reviews");
            System.out.println("2. Sort by percentage recommended");
            select = sc.nextInt();

            switch (select) {
                case 1:
                    schCourses.sort(new NumReviewsSorter());
                    flag = false;
                    break;
                case 2:
                    schCourses.sort(new PercRecommendedSorter());
                    flag= false;
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
        } while(flag);
        do {
            // Get user's selection of courses
            System.out.println("Select the course:");
            for(int i = 0; i < schCourses.size(); i++) {
                System.out.println(i+1 + ". " + schCourses.get(i));
            }
            courseSelection = sc.nextInt();

            if (courseSelection > 0 && courseSelection < schCourses.size() + 1) {
                Course course = schCourses.get(courseSelection - 1);
                ArrayList<Review> reviewList = course.getReviews();
                for(int i = 0; i< reviewList.size();i++) {
                    System.out.println(i+1 + "Review: " + reviewList.get(i).getReview());
                }
            }
            else {
                System.out.println("Invalid selection.");
            }
        } while(flag);
    }
    /*
       Prints the timetable for a student.
        */
    public void getTimetable(ArrayList<StudyGroup> studyGroups) {

        String time_1, time_2;

        Collections.sort(studyGroups, Comparator
                .comparing(StudyGroup::getDayOfWeek)
                .thenComparing(StudyGroup::getStartTime));

        Map<Integer, String> week = new HashMap<>();
        week.put(1, "Monday");
        week.put(2, "Tuesday");
        week.put(3, "Wednesday");
        week.put(4, "Thursday");
        week.put(5, "Friday");
        week.put(6, "Saturday");
        week.put(7, "Sunday");

        for (Map.Entry<Integer, String> day : week.entrySet()) {

            System.out.printf("%d\n",day.getValue());

            for(StudyGroup studyGroup : studyGroups) {
                if (studyGroup.getDayOfWeek() == day.getKey()) {

                    time_1 = String.valueOf(studyGroup.getStartTime());
                    time_2 = String.valueOf(studyGroup.getEndTime());

                    while (time_1.length() < 4) {
                        time_1 = "0" + time_1;
                    }

                    while (time_2.length() < 4) {
                        time_2 = "0" + time_2;
                    }

                    System.out.printf("%s - %s: ", time_1, time_2);
                    System.out.printf("%s (%d)", studyGroup.getIndex().getCourse().getCourseCode(), studyGroup.getIndex().getIndexNum());

                    //prints week type if not weekly (i.e. biweekly)
                    if (studyGroup.getWeekType() != "Weekly") {
                        System.out.printf("\t %s", studyGroup.getWeekType());
                    }
                    System.out.println("");
                }
            }

        }

    }
    /*
    Check for clashes in timetable: Compares whether there exists an overlapping range and prints all clashes. Returns true if there is clash
     */
    private boolean checkClash(Index index, ArrayList<StudyGroup> studyGroups) {

        String time_1, time_2, time_3, time_4;
        boolean clash = false;
        ArrayList<String> day = new ArrayList<>();
        day.add(1,"Monday");
        day.add(2,"Tuesday");
        day.add(3,"Wednesday");
        day.add(4,"Thursday");
        day.add(5,"Friday");
        day.add(6,"Saturday");
        day.add(7,"Sunday");


        for (StudyGroup studyGroup : index.getStudyGroup()) {
            for (StudyGroup studyGroup2 : studyGroups) {
                if (studyGroup.getDayOfWeek() == studyGroup2.getDayOfWeek()) {
                    if (studyGroup.getStartTime() <= studyGroup2.getEndTime()
                            && studyGroup.getEndTime() <= studyGroup2.getStartTime()) {

                        time_1 = String.valueOf(studyGroup.getStartTime());
                        time_2 = String.valueOf(studyGroup.getEndTime());
                        time_3 = String.valueOf(studyGroup2.getEndTime());
                        time_4 = String.valueOf(studyGroup2.getEndTime());

                        while (time_1.length() < 4) {
                            time_1 = "0" + time_1;
                        }

                        while (time_2.length() < 4) {
                            time_2 = "0" + time_2;
                        }

                        while (time_3.length() < 4) {
                            time_1 = "0" + time_1;
                        }

                        while (time_4.length() < 4) {
                            time_2 = "0" + time_2;
                        }

                        System.out.printf("The index you are trying to add %d (%s) clashes with index %d (%s)\n",
                                index.getIndexNum(), index.getCourse().getName(), studyGroup2.getIndex().getIndexNum(), studyGroup2.getIndex().getCourse().getName());

                        System.out.printf("%d\n", day.get(studyGroup.getDayOfWeek()));

                        System.out.printf("Index %d time: %d - %d\n", time_1, time_2);
                        System.out.printf("Index %d time: %d - %d\n\n", time_3, time_4);

                        clash = true;
                    }
                }
            }
        }
        if (clash == true) {
            return true;
        } else {
            return false;
        }
    }

}
