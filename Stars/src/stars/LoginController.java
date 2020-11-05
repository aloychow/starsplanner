package stars;

public class LoginController {
	public boolean validateLogin(String Email, String enteredPassword, String typeOfUser) {
		System.out.println("/"+typeOfUser + "/");
		StudentModeUI smui = new StudentModeUI();
		AdminModeUI amui = new AdminModeUI();
		if (typeOfUser.compareTo("Student") == 0) {
			//TODO
			smui.showMenu();
			return true;
		} else if (typeOfUser.compareTo("Admin") == 0) {
			//TODO
			amui.showMenu();
			return true;
			
		}
		else {return false;}
	}

}
