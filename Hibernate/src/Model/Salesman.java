package Model;

import java.util.Date;

public class Salesman {

	private Integer id;
	private String number;
	private String name;
	private String gender;
	private String birthDate;
	private String phone;
	private String address;
	private String employedDate;
	
	

	public Salesman() {
	}

	public Salesman(Integer id, String number, String name, String gender, String birthDate, String phone, String address,
			String employedDate) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
		this.gender = gender;
		this.birthDate = birthDate;
		this.phone = phone;
		this.address = address;
		this.employedDate = employedDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmployedDate() {
		return employedDate;
	}

	public void setEmployedDate(String employedDate) {
		this.employedDate = employedDate;
	}

	@Override
	public String toString() {
		return "Salesman [id=" + id + ", number=" + number + ", name=" + name + ", gender=" + gender + ", birthDate="
				+ birthDate + ", phone=" + phone + ", address=" + address + ", employedDate=" + employedDate + "]";
	}

}
