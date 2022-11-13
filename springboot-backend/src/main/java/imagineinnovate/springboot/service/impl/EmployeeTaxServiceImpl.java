package imagineinnovate.springboot.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import imagineinnovate.springboot.exception.ResourceNotFoundException;
import imagineinnovate.springboot.model.EmployeeTax;
import imagineinnovate.springboot.repository.EmployeeTaxRepository;
import imagineinnovate.springboot.service.EmployeeTaxService;

@Service
public class EmployeeTaxServiceImpl implements EmployeeTaxService{

	private EmployeeTaxRepository employeeTaxRepository;
	
	public EmployeeTaxServiceImpl(EmployeeTaxRepository employeeTaxRepository) {
		super();
		this.employeeTaxRepository = employeeTaxRepository;
	}

	@Override
	public EmployeeTax saveEmployeeTax(EmployeeTax employeeTax) {
		return employeeTaxRepository.save(employeeTax);
	}

	@Override
	public List<EmployeeTax> getAllEmployeesTax() {
		List<EmployeeTax> employeeTaxList = employeeTaxRepository.findAll();
		return employeeTaxList;
	}

	@Override
	public EmployeeTax getEmployeeTaxById(long id) {
		Optional<EmployeeTax> employeeTaxById = employeeTaxRepository.findById(id);
		EmployeeTax emptax = new EmployeeTax();
		BigDecimal salary = employeeTaxById.get().getSalary();
		BigDecimal taxPercent1 = new BigDecimal("250000");
		BigDecimal taxPercent2 = new BigDecimal("500000");
		BigDecimal taxPercent3 = new BigDecimal("1000000");
		BigDecimal taxAmount = BigDecimal.ZERO;
		BigDecimal cesAmount = BigDecimal.ZERO;
		if(((salary.compareTo(taxPercent1)) >= 0 )&& salary.compareTo(taxPercent2) <=0) {
			taxAmount = salary.subtract(salary.multiply(new BigDecimal("0.05")));
			cesAmount = taxAmount.subtract(taxAmount.multiply(new BigDecimal("0.02")));
		} else if (((salary.compareTo(taxPercent2)) >= 0 )&& salary.compareTo(taxPercent3) <=0){
			taxAmount = salary.subtract(salary.multiply(new BigDecimal("0.10")));
			cesAmount = taxAmount.subtract(taxAmount.multiply(new BigDecimal("0.02")));
		}else if (salary.compareTo(taxPercent3) >= 0) {
			taxAmount = salary.subtract(salary.multiply(new BigDecimal("0.20")));
			cesAmount = taxAmount.subtract(taxAmount.multiply(new BigDecimal("0.02")));
		}
		emptax.setId(id);
		emptax.setFirstName(employeeTaxById.get().getFirstName());
		emptax.setLastName(employeeTaxById.get().getLastName());
		emptax.setTaxAmount(salary.subtract(taxAmount));
		emptax.setSalary(employeeTaxById.get().getSalary());
		emptax.setCesAmount(salary.subtract(cesAmount));
		return emptax;
		
	}

	@Override
	public EmployeeTax updateEmployeeTax(EmployeeTax employeeTax, long id) {
		
		EmployeeTax existingEmployeeTax = employeeTaxRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("EmployeeTax", "Id", id)); 
		
		existingEmployeeTax.setFirstName(employeeTax.getFirstName());
		existingEmployeeTax.setLastName(employeeTax.getLastName());
		existingEmployeeTax.setTaxAmount(employeeTax.getTaxAmount());
		existingEmployeeTax.setCesAmount(employeeTax.getCesAmount());
		existingEmployeeTax.setSalary(employeeTax.getSalary());
		employeeTaxRepository.save(existingEmployeeTax);
		return existingEmployeeTax;
	}

	@Override
	public void deleteEmployeeTax(long id) {
		
		employeeTaxRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("Employee", "Id", id));
		employeeTaxRepository.deleteById(id);
	}
	
}
