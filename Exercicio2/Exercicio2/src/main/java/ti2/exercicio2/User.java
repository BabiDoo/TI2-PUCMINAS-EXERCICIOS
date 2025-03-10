package ti2.exercicio2;

public class User {
	
	private int id;
    private String login;
    private String password;
    private char gender;

    public User () {
        this.id = -1;
        this.login = "";
        this.password = "";
        this.gender = ' ';
    }
    
    public User(int id, String login, String password, char gender) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.gender = gender;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + ", gender=" + gender + "]";
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the gender
	 */
	public char getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(char gender) {
		this.gender = gender;
	}

	
}




 

