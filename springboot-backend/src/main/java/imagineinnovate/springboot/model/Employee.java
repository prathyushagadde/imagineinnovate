package imagineinnovate.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
@Entity
@Table(name="employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "First_Name", nullable = false)
	@NotBlank(message="firstName cannot be null")
	private String firstName;
	
	@Column(name = "Last_Name")
	@NotBlank(message="lastName cannot be null")
	private String lastName;
	
	@Column(name = "Email")
	@Email(message="Invalid Email address")
	private String email;
	
	@Pattern(regexp = "^\\d{10}$", message = "Invalid Phone Number")
	@Column(name = "PhoneNumber")
	private String phoneNumber;
	
	@NotBlank(message="Date of joining cannot be null")
	@Column(name = "DOJ")
	private String doj;
	
	@NotBlank(message="Salary cannot be null")
	@Column(name = "Salary")
	private String salary;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
}
