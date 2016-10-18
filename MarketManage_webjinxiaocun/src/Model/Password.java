package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Password {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String account;
	private String password;
	private String protectquestion;
	private String protectanswer;
	
	public Password(String account, String password, String protectquestion, String protectanswer) {
		super();
		this.account = account;
		this.password = password;
		this.protectquestion = protectquestion;
		this.protectanswer = protectanswer;
	}

	public Password(int id, String account, String password, String protectquestion, String protectanswer) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
		this.protectquestion = protectquestion;
		this.protectanswer = protectanswer;
	}
	
	public Password() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProtectquestion() {
		return protectquestion;
	}

	public void setProtectquestion(String protectquestion) {
		this.protectquestion = protectquestion;
	}

	public String getProtectanswer() {
		return protectanswer;
	}

	public void setProtectanswer(String protectanswer) {
		this.protectanswer = protectanswer;
	}

	@Override
	public String toString() {
		return "Password [id=" + id + ", account=" + account + ", password=" + password + ", protectquestion="
				+ protectquestion + ", protectanswer=" + protectanswer + "]";
	}

	

}
