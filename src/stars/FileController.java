package stars;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import java.lang.String;
public class FileController {
    private static final String adminFileLoc= "./source/Admin.dat";
    private static final String studentFileLoc = "./source/Student.dat";
    private static final String schoolFileLoc = "./source/School.dat";

    private static ArrayList<Admin> adminList = new ArrayList<Admin>();
    private static ArrayList<Student> studentList = new ArrayList<Student>();
    private static ArrayList<School> schoolList = new ArrayList<School>();
    private static User currentUser;

    public ArrayList<Admin> getAdminList() {
        return adminList;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }
    public ArrayList<School> getSchoolList() {

        return schoolList;
    }
    public User getCurrentUser() {
        return currentUser;
    }
    //method to save admins to the dat file

    public void saveAdminList(){
        try {
            FileOutputStream fos = new FileOutputStream(adminFileLoc);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(adminList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //method to save students to the dat file
    public void saveStudentList(){
        try {
            FileOutputStream fos = new FileOutputStream(studentFileLoc);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(studentList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //method to save schools to the dat file
    public void saveSchoolList(){
        try {
            FileOutputStream fos = new FileOutputStream(schoolFileLoc);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(schoolList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //method to retrieve admin info from files into the system
    public void RetrieveAdmins(){
        try {
            FileInputStream fis = new FileInputStream(adminFileLoc);
            ObjectInputStream ois = new ObjectInputStream(fis);
            adminList = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            System.out.println("Sorry file does not exist");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Sorry class does not exist");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //method to retrieve school info from files into the system
    public void RetrieveStudents(){

        try {
            FileInputStream fis = new FileInputStream(studentFileLoc);
            ObjectInputStream ois = new ObjectInputStream(fis);
            studentList = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            System.out.println("Sorry file does not exist");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Sorry class does not exist");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //method to retrieve school info from files into the system
    public void RetrieveSchools(){

        try {
            FileInputStream fis = new FileInputStream(schoolFileLoc);
            ObjectInputStream ois = new ObjectInputStream(fis);
            schoolList = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            System.out.println("Sorry file does not exist");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Sorry class does not exist");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //function to get the Student object reference by username
    public Student getStudentByUsername(String userName)
    {
        for (int i=0;i<studentList.size();i++) {
            if (studentList.get(i).getUserName() != null && studentList.get(i).getUserName().equals(userName))
                return studentList.get(i);
        }
        return null;
    }

//function to get the Admin object reference by username
    public Admin getAdminByUsername(String userName)
    {
        for (int i=0;i<adminList.size();i++) {
            if (adminList.get(i).getUserName() != null && adminList.get(i).getUserName().equals(userName))
                return adminList.get(i);
        }
        return null;
    }

    //function to get the School object reference by username
    public School getSchoolByName(String name)
    {
        for (int i=0;i<schoolList.size();i++) {
            if (schoolList.get(i).getName() != null && schoolList.get(i).getName().equals(name))
                return schoolList.get(i);
        }
        return null;
    }

    public void populate(){
        // write to serialized file - update/insert/delete
        // example - add one more Admin
        //Admin(String email, String password, String typeOfUser, String userName, String adminID)
        Admin ad1 = new Admin("rach@ntu.edu.sg", "password123", "Admin", "Rachel_green", "1234");
        // add to list
        adminList.add(ad1);
        // list.remove(p);  // remove if p equals object in the list

        saveAdminList();
    }


    // get a specific index from the list of schools


    public Index findIndexFromSchools(int index){
        Index ix = null ;
        for (int s=0; s<schoolList.size();s++){
            for (int c=0; c<schoolList.get(s).getCourses().size();c++){
                for (int i=0; i<schoolList.get(s).getCourses().get(c).getIndex().size();i++){
                    if (schoolList.get(s).getCourses().get(c).getIndex().get(i).getIndexNum()==index){
                        ix = schoolList.get(s).getCourses().get(c).getIndex().get(i);
                    }
                }
            }
        }
        return ix;
    }

}
