package stars;
import java.util.*;

public class RegisteredCourse {
    private Index regIndex;
    private String regStatus;
    public RegisteredCourse(Index regIndex, String regStatus) {
        this.regIndex = regIndex;
        this.regStatus = regStatus;
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


}
