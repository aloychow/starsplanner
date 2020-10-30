package stars;

public class User {
	private String password;
	private String email;
	private String typeOfUser;
	
	public User(String password, String email, String typeOfUser) {
		this.password = password;
		this.email = email;
		this.typeOfUser = typeOfUser;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getTypeOfUser() {
		return this.typeOfUser;
	}
	
	public void setTypeOfUser(String typeOfUser) {
		this.typeOfUser = typeOfUser;
	}
	
}

