package stars;
import java.util.*;
import java.io.Serializable;
public class RegisteredCourse implements Serializable {
    private Index regIndex;
    private String regStatus;
    private Student student;
    private Index index;
    public RegisteredCourse(Index regIndex, String regStatus, Student student, Index index) {
        this.regIndex = regIndex;
        this.regStatus = regStatus;
        this.student=student;
        this.index=index;
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
    public void setIndex(Index index)
    {
        this.index=index;
    }
    public Index getIndex()
    {
        return index;
    }

}
