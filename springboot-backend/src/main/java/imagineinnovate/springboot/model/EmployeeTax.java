package imagineinnovate.springboot.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name="employeestax")
public class EmployeeTax {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "First_Name", nullable = false)
	@NotBlank(message="firstName cannot be null")
	private String firstName;
	
	@Column(name = "Last_Name")
	@NotBlank(message="lastName cannot be null")
	private String lastName;
	
	@Column(name = "TaxAmount")
	private BigDecimal taxAmount;
	
	
	@Column(name = "CES_Amount")
	private BigDecimal cesAmount;
	
	@NotBlank(message="Salary cannot be null")
	@Column(name = "Salary")
	private BigDecimal salary;

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

	public BigDecimal getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	public BigDecimal getCesAmount() {
		return cesAmount;
	}

	public void setCesAmount(BigDecimal cesAmount) {
		this.cesAmount = cesAmount;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	
	
}
