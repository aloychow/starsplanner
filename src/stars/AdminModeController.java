package stars;
import java.text.ParseException;
import java.util.*;
import java.io.Console;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class AdminModeController implements DisplayErrorMsgUI{
    Scanner sc = new Scanner(System.in);
    FileController fc = new FileController();
    DisplayDataController dd= new DisplayDataController();
    SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy/HH/mm");
    public void editStudentAccessPeriod() {
        //TODO
        School updateSchool;
        Date convertedStartDate=null,convertedEndDate=null;
        do{
            System.out.println("Enter the School Name");
            String school=sc.nextLine().trim();
            updateSchool = fc.getSchoolByName(school);
            if(updateSchool==null)
                System.out.println("Error. This school does not exist.");
        }while(updateSchool==null);
        try {
                System.out.println("Enter the new registration start period in dd/mm/yyyy/hh/mm");
                String startDate=sc.next();
                convertedStartDate = format.parse(startDate);
                //System.out.println(convertedStartDate);
                //System.out.println(format.format(convertedStartDate));
                System.out.println("Enter the new registration end period in dd/mm/yyyy/hh/mm");
                String endDate=sc.next();
                convertedEndDate = format.parse(endDate);
                //System.out.println(convertedEndDate);
                //System.out.println(format.format(convertedEndDate));
            } catch (ParseException e) {
                e.printStackTrace();
                System.out.println("Invalid registration period format");
            }
            catch(NullPointerException e)
            {
                e.printStackTrace();
            }

                if(convertedStartDate.compareTo(convertedEndDate)<0) {
                    updateSchool.setRegistrationStartPeriod(convertedStartDate);
                    updateSchool.setRegistrationEndPeriod(convertedEndDate);
                    fc.saveSchoolList();
                    System.out.println("Access Period has been updated.");
                }
                else
                {
                    System.out.println("Registration end period must be after registration start period");
                }


    }

    //method for admin to add a student
    public void addStudent() {
        //TODO
        // needs the email, password, username, matricNo, gender, nationality, name, year, school
        Student student = new Student();
        student.setTypeOfUser("Student");
        String username, email, matricNo, gender, nationality, name, schoolName;
        String choice = "sendEmail";
        String recipient;
        int year;
        School school;
        String pass1, pass2;
        boolean passMatch = false;
        boolean validEmail = false;
        char ch;
        Student presentStudent;
        do {
            System.out.println("Please enter the student's username");
            username = sc.nextLine().trim().toUpperCase();
            presentStudent = fc.getStudentByUsername(username);
            if (presentStudent != null) {
                System.out.println("Error. Student with this username already exists.");
            }
        } while (presentStudent != null);

        do {
            System.out.println("Please enter the student's email");
            email = sc.nextLine().trim();
            User user = student;
            validEmail = user.validateEmail(email);
            if (validEmail == false) {
                System.out.println("Error. You entered an invalid email");
            }
        } while (validEmail != true);
        recipient = email;


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
        name = sc.nextLine().trim();
        System.out.println("Enter the student's matriculation number");
        matricNo = sc.nextLine().trim();
        System.out.println("Enter the student's nationality");
        nationality = sc.nextLine().trim();
        System.out.println("Enter the student's year");
        year = sc.nextInt();
        do {
            System.out.println("Enter the student's gender");
            gender = sc.nextLine().trim().toLowerCase();
            if (gender != "female" && gender != "male") {
                System.out.println("Gender must be male or female");
            }
        } while (gender != "female" && gender != "male");

        do {
            System.out.println("Enter the student's school name ");
            schoolName = sc.nextLine().trim().toUpperCase();
            school = fc.getSchoolByName(schoolName);
            if (school == null) {
                System.out.println("Error. This school does not exist.");
            }
        } while (school != null);
        do {
            System.out.println("Enter the student's preferred notification type (Email E/Telegram T/Whatsapp W");
            ch = sc.nextLine().charAt(0);
            switch (ch) {
                case 'E':
                    recipient = email;
                    choice = "SendEmail";
                    break;
                case 'T':
                    System.out.println("Enter the student's telegram number");
                    recipient = sc.nextLine().trim();
                    choice = "SendTele";
                    break;
                case 'W':
                    System.out.println("Enter the student's whatsapp number");
                    recipient = sc.nextLine().trim();
                    choice = "SendWhatsapp";
                    break;
                default:
                    System.out.println("Incorrect input. Try again.");
                    System.out.println("Enter the student's preferred notification type (Email E/Telegram T/Whatsapp W");
                    ch = sc.nextLine().charAt(0);
            }
        } while (ch != 'T' && ch != 'W' && ch != 'E');
        //hashing of the password is done
        pass1 = student.buildPasswordHash(pass1);

        student = school.addStudent(name, matricNo, gender, nationality, year, school, choice, recipient, email, pass1, "Student", username);
        fc.getStudentList().add(student);
        fc.saveStudentList();
        fc.saveSchoolList();
        //print the list of students after every new student is added
        fc.printStudentList();
    }


//    private void validateInt() {
//        while (!sc.hasNextInt()) {
//            String input = sc.next();
//            System.out.println(input + " is not a valid input. Enter again:");
//        }
//    }
    private int validateInt(int min, int max) {
        do {
            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                if (choice>=min && choice <=max) {
                    return choice;
                } else {
                    System.out.println("Invalid selection. Enter a valid input.");
                }
            }else {
                String input = sc.next();
                System.out.println("Invalid selection.Enter a valid input.");
            }
        } while(true);
    }
    private String validateCourseCodeFormat(String cCode) {
        if (cCode.length() == 6) {
            try {
                int d = Integer.parseInt(cCode.substring(2));
                if (d > 0) {
                    if ((Character.isLetter(cCode.charAt(0)) == true)) {
                        if ((Character.isLetter(cCode.charAt(1)) == true)) {
                            String formatted = cCode.substring(0, 2).toUpperCase() + cCode.substring(2);
                            return formatted;
                        }
                    }
                }
            } catch (NumberFormatException nfe) {
                return null;
            }
        }
        return null;
    }

    private void addStudyGroup(Index i, LessonType lessonType) {
        String venue, weekType;
        int dayOfWeek, startTime;
        int endTime = -1;
        System.out.println("Enter the following lesson details for index " + i.getIndexNum() + ":");
        System.out.println(lessonType + " venue:");
        venue = sc.next();
        System.out.println(lessonType + " start time:");
        startTime = validateInt(800,2000);
        System.out.println(lessonType + " lab end time:");
        boolean flag = true;
        do {
            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                if (choice>=800 && choice <=2000 && choice> startTime) {
                    flag = false;
                    endTime = choice;
                } else {
                    System.out.println("Invalid selection. Enter a valid input.");
                }
            }else {
                String input = sc.next();
                System.out.println("Invalid selection.Enter a valid input.");
            }
        } while(flag);
        System.out.println("Day of the week the " + lessonType + "  will take place:");//how to add for multiple days?
        dayOfWeek = validateInt(1,7);
        System.out.println("Week type of " + lessonType);
        weekType = sc.next();
        i.addStudyGroup(venue, startTime, endTime, dayOfWeek, weekType, lessonType);
    }

    private void addIndex(Course c) {
        System.out.println("Enter the following details of the Index you would like to add:");
        System.out.println("Index Number:");
        int indexNum = validateInt(0, 99999);
        System.out.println("Group Number:");
        String groupNum = sc.next();
        System.out.println("Vacancies:");
        int vacancy = validateInt(1,500);
        Index index = c.setIndex(indexNum, groupNum, vacancy);
        if (c.getCourseType().equals(CourseType.LEC_TUT_LAB)) {
            addStudyGroup(index, LessonType.LAB);
        }
        if (c.getCourseType().equals(CourseType.LEC_TUT)) {
            addStudyGroup(index, LessonType.TUTORIAL);
        }
        for (int i = 0; i < c.getnLectures(); i++) {
            addStudyGroup(index, LessonType.LECTURE);
        }


    }

    //	@SuppressWarnings("unused")
    public void addCourse() {
//        System.out.println("Enter the school you would like to add a course to:");
//        String schName = sc.next();
//        School s = fc.getSchoolByName(schName);
        School s = dd.schSelection();
        while (s == null){
            System.out.println("School does not exist");
            s = dd.schSelection();
        }

        if (s != null) {
            System.out.println("Enter the following details of the course you would like to add:");
            System.out.println("name:");
            String name = sc.next();
            System.out.println("Course Type (LEC, LEC_TUT, LEC_TUT_LAB) :");
            String cType = sc.next();
            String cTypes[] = {"LEC", "LEC_TUT", "LEC_TUT_LAB"};
            while (!Arrays.stream(cTypes).anyMatch(cType::equals)) {
                System.out.println("Invalid Input!");
                System.out.println("Course Type (LEC, LEC_TUT, LEC_TUT_LAB) :");
                cType = sc.next();
            }
            CourseType courseType = CourseType.valueOf(cType);

            System.out.println("Number of lectures per week:");
            int nLectures = validateInt(1,3);


            System.out.println("Course Code:");
            String n = sc.next();
            while (validateCourseCodeFormat(n) == null) {
                System.out.println(n + " is not a valid input. Enter again:");
                n = sc.next();
            }
            String courseCode = validateCourseCodeFormat(n);


            System.out.println("total AUs:");
            int totalAUs = validateInt(1,4);

            Course c = s.addCourse(name, courseCode, courseType, totalAUs, nLectures);


            System.out.println("Enter the number of indexes for Course " + c.getCourseCode());
            int nIndexes = validateInt(1,30);
            for (int i = 0; i < nIndexes; i++) {
                addIndex(c);
            }

        }
    }

    //	@SuppressWarnings("unused")
    public void updateCourse() {
//        System.out.println("Enter the Course Code of the course you would like to update: ");
//        String courseCode = sc.next();
//        // convert string index to Index class
//        Course c = fc.getCourseByCode(courseCode);
        School s = dd.schSelection();
        while (s == null){
            System.out.println("School does not exist");
            s = dd.schSelection();
        }
        Course c = dd.courseSelection(s);
        if (c != null) {
            System.out.println("1. Edit course information");
            System.out.println("2. Edit index information");
            System.out.println("----------choose one of the options above");
            int choice = validateInt(1,2);
            switch (choice) {
                case 1:
                    System.out.println("1. Edit course Name");
                    System.out.println("2. Edit course Type");
                    System.out.println("3. Edit total AUs");
                    System.out.println("4. Add index");
                    System.out.println("----------choose one of the options above");
                    choice = validateInt(1,4);
                    switch (choice) {
                        case 1:
                            System.out.println("Enter the new course name:");
                            String course_name = sc.next();
                            c.setName(course_name);
                            System.out.println("Course Name successfully changed");
                            break;
                        case 2:
                            CourseType past_type = c.getCourseType();
                            System.out.println("Enter the new course Type (LEC, LEC_TUT, LEC_TUT_LAB):");
                            String cType = sc.next();
                            String cTypes[] = {"LEC", "LEC_TUT", "LEC_TUT_LAB"};
                            while (!Arrays.stream(cTypes).anyMatch(cType::equals)) {
                                System.out.println("Invalid Input!");
                                System.out.println("Course Type (LEC, LEC_TUT, LEC_TUT_LAB) :");
                                cType = sc.next();
                            }
                            CourseType course_type = CourseType.valueOf(cType);

                            c.setCourseType(course_type);
                            System.out.println("Course type successfully changed");///need to loop through all the indexes to add/remove the study groups respctively??

                            if (c.getCourseType().equals(CourseType.LEC)) {
                                for (Index i : c.getIndex()) {
                                    i.deleteStudyGroup(LessonType.TUTORIAL);
                                    i.deleteStudyGroup(LessonType.LAB);
                                }
                            }
                            if (c.getCourseType().equals(CourseType.LEC_TUT)) {
                                for (Index i : c.getIndex()) {
                                    i.deleteStudyGroup(LessonType.LAB);
                                }
                            }
                            if (past_type.equals(CourseType.LEC)) {
                                if (c.getCourseType().equals(CourseType.LEC_TUT)) {
                                    for (Index i : c.getIndex()) {
                                        addStudyGroup(i, LessonType.TUTORIAL);
                                    }
                                } else if (c.getCourseType().equals(CourseType.LEC_TUT_LAB)) {
                                    for (Index i : c.getIndex()) {
                                        addStudyGroup(i, LessonType.TUTORIAL);
                                        addStudyGroup(i, LessonType.LAB);
                                    }
                                }
                            }
                            if (past_type.equals(CourseType.LEC_TUT)) {
                                if (c.getCourseType().equals(CourseType.LEC_TUT_LAB)) {
                                    for (Index i : c.getIndex()) {
                                        addStudyGroup(i, LessonType.LAB);
                                    }
                                }
                            }
                            break;

                        case 3:
                            System.out.println("Enter new total number of AUs:");
                            int aus = validateInt(1,4);
                            c.setTotalAUs(aus);
                            System.out.println("Number of AUs successfully changed");
                            break;
                        case 4:
                            addIndex(c);
                            break;
                        default:
                            System.out.println("invalid input");
                    }
                case 2:
//                    System.out.println("Enter the index ID you would like to update:");
//                    validateInt();
//                    int index_id = sc.nextInt();
//                    Index i = null;
//                    for (Index ind : c.getIndex()) {
//                        if (ind.getIndexNum() == index_id) {
//                            i = ind;
//                        }
//                    }
//				Index i = fc.getIndexByID(index_id);
                    Index i = dd.indexSelection(c);
                    if (i != null) {
                        System.out.println("1. Edit group number");
                        System.out.println("2. Add/remove vacancies");
                        System.out.println("3. delete Index");
                        //TO ADD: edit lecture/tutorial/lab details/
                        System.out.println("----------choose one of the options above");
                        choice = sc.nextInt();
                        switch (choice) {
                            case 1:
                                System.out.println("Enter the new group number:");
                                String grp_number = sc.next();
                                i.setGroupNum(grp_number);
                                System.out.println("Group Number successfully changed");
                                break;
                            case 2:
                                System.out.println("Enter the new vacancies");
                                int vacancies = validateInt(1,500);
                                int new_vacancies = i.getVacancies() + vacancies;
                                if (new_vacancies >= 0) {
                                    i.setVacancies(i.getVacancies() + vacancies);
                                    ///need to get add students from waitlist
                                } else {
                                    System.out.println("Cannot remove required vacancies. Students have already filled up the places.");
                                }
                                System.out.println("Vacancies successfully changed");
                                break;
                            case 3:
                                c.deleteIndex(i);
                                break;
                            default:
                                System.out.println("invalid input");
                                break;
                        }

                    } else {
                        System.out.println("Index does not exist!");
                    }
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        } else {
            System.out.println("Course does not exist!");
        }
    }

    public void removeCourse() {
//        System.out.println("Enter the Course Code of the course you would like to remove: ");
//        String courseCode = sc.next();
//        // convert string index to Index class
//        Course c = fc.getCourseByCode(courseCode);
        School s = dd.schSelection();
        while (s == null){
            System.out.println("School does not exist");
            s = dd.schSelection();
        }
        Course c = dd.courseSelection(s);

        if (c != null) {
//            School s = c.getSchool();
            s.deleteCourse(c);
        } else {
            System.out.println("Course doesnt exist!");
        }
    }

    public void checkAvailableSlot() {
        //TODO

        System.out.println("Enter the Index you want to check for: ");
        int indexID = sc.nextInt();
        Index i = fc.getIndexByID(indexID);
        if (i != null) {
            int vacancy = i.getVacancies();
            System.out.println("There are " + vacancy + " vacancies avalailable for " + i.getIndexNum());
        } else {
            System.out.println("Index not found!");
        }

    }

    /**
     * Print student list by a course.
     * @return ArrayList<String[]>
     */
    public ArrayList<String[]> printStulistByCourse() {
        //TODO
        ArrayList<String[]> stuList = new ArrayList<String[]>();
        School school = dd.schSelection();
        if (school != null) {
            Course course = dd.courseSelection(school);
            if (course != null) {
                ArrayList<Index> indexList = course.getIndex();
                for(int i = 0; i < indexList.size(); i++) {
                    Index index = indexList.get(i);
                    ArrayList<RegisteredCourse> regList = index.getRegisteredCourses();
                    for(int j = 0; j < regList.size(); j++) {
                        RegisteredCourse regCourse = regList.get(j);
                        String status = regCourse.getRegStatus();
                        if (status == "registered") {
                            Student student = regCourse.getStudent(); //added Student attribute in RegisteredCouse with getter and setter
                            String name = student.getName();
                            String gender = student.getGender();
                            String nationality = student.getNationality();
                            String[] stuDetails = new String[] {name, gender, nationality};
                            stuList.add(stuDetails);
                        }
                        else {
                            displayErrorMsg("Error. No registration was made.");
                        }
                    }
                }
                return stuList;
            }
            else {
                displayErrorMsg("There is no such index."); //maybe should setup NullPointerException
                return null;
            }
        }
        else {
            displayErrorMsg("Error");
            return null;
        }
    }
    /**
     * Print student list by index of a course.
     * @return ArrayList<String[]>
     */
    public ArrayList<String[]> printStulistByIndex() {
        //TODO
        ArrayList<String[]> stuList = new ArrayList<String[]>();
        School school = dd.schSelection();
        if(school != null) {
            Course course = dd.courseSelection(school);
            if(course != null) {
                Index index = dd.indexSelection(course);
                if (index != null) {
                    ArrayList<RegisteredCourse> regList = index.getRegisteredCourses();
                    for(int j = 0; j < regList.size(); j++) {
                        RegisteredCourse regCourse = regList.get(j);
                        String status = regCourse.getRegStatus(); //change spelling in sequence diagram
                        if (status == "registered") {
                            Student student = regCourse.getStudent(); //added Student attribute in RegisteredCouse with getter and setter
                            String name = student.getName();
                            String gender = student.getGender();
                            String nationality = student.getNationality();
                            String[] stuDetails = new String[] {name, gender, nationality};
                            stuList.add(stuDetails);
                        }
                        else {
                            System.out.println("Error. No registration was made.");
                        }
                    }
                    return stuList;
                }
                else {
                    System.out.println("Error. No such index."); //maybe should setup NullPointerException
                    return null;
                }
            }
            else {
                System.out.println("Error. No such course.");
                return null;
            }
        }
        else {
            System.out.println("Error.");
            return null;
        }
    }
    public void displayErrorMsg(String s)
    {   System.out.println("Error occurred");
        System.out.println(s);
    }

}
