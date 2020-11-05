package stars;

public class Admin extends User {
	private String adminID;
	
	public Admin(String email, String password, String typeOfUser, String adminID) {
		super(email, password, typeOfUser);
		this.adminID = adminID;
	}
	
	public void editStudentAccessPeriod() {
		return;
	}
	
	public void addStudent() {
		return;
	}
	
	public void addCourse() {
		return;
	}
	
	public void checkAvailableSlot() {
		return;
	}
	
	public void printStuListByIndex() {
		return;
	}
	
	public void printStuListByCourse() {
		return;
	}
}

// we never pass in type of user as constructor for User in class diagram
// method signature of Admin class incomplete as well in class diagram
// also missing Admin constructor in class diagram