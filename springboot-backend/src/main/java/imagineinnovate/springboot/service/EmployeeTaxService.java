package imagineinnovate.springboot.service;

import java.util.List;

import imagineinnovate.springboot.model.EmployeeTax;

public interface EmployeeTaxService {
	EmployeeTax saveEmployeeTax(EmployeeTax employeeTax);
	List<EmployeeTax> getAllEmployeesTax();
	EmployeeTax getEmployeeTaxById(long id);
	EmployeeTax updateEmployeeTax(EmployeeTax employeeTax, long id);
	void deleteEmployeeTax(long id);
}
