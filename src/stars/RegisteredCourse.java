package stars;
import java.util.*;
import java.io.Serializable;
public class RegisteredCourse implements Serializable {
    private Index regIndex;
    private String regStatus;
    private Student student;

    public RegisteredCourse(Index regIndex, String regStatus, Student student) {
        this.regIndex = regIndex;
        this.regStatus = regStatus;
        this.student=student;

    }
    public Index getRegIndex() {
        return regIndex;
    }
    public void setRegIndex(Index regIndex) {
        this.regIndex = regIndex;
    }
    public String getRegStatus() {
        return regStatus;
    }
    public void setRegStatus(String regStatus) {
        this.regStatus = regStatus;
    }
    public void setStudent(Student student)
    {
        this.student=student;
    }
    public Student getStudent()
    {
        return student;
    }


}
