package dpawebservices.pojo;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * @author abhilash
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;

	public User(String username, String pass) {
		super();
		this.username = username;
		this.pass = pass;
	}

	private String pass;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public User() {
		
	}

}
