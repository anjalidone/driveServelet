package drive.beans;

public class Loginpojo {
	String email;
	String pass;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String toString() {
		return "Loginpojo [email=" + email + ", pass=" + pass + "]";
	}

}
