package imagineinnovate.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import imagineinnovate.springboot.model.EmployeeTax;
import imagineinnovate.springboot.service.EmployeeTaxService;

@RestController
@RequestMapping("/api/employeesTax")
@Validated
public class EmployeeTaxController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private EmployeeTaxService employeeTaxService;

	public EmployeeTaxController(EmployeeTaxService employeeTaxService) {
		super();
		this.employeeTaxService = employeeTaxService;
	}
	
	@PostMapping()
	public ResponseEntity<EmployeeTax> saveEmployeeTax(@RequestBody @Valid EmployeeTax employeeTax){
		return new ResponseEntity<EmployeeTax>(employeeTaxService.saveEmployeeTax(employeeTax), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<EmployeeTax> getAllEmployees(){
		
				List<EmployeeTax> allEmployeeList=employeeTaxService.getAllEmployeesTax();
				if(allEmployeeList == null) {
					log.info("No employee details found in DB");
				}
				return allEmployeeList;
	}
	
	@GetMapping("{id}")
	public ResponseEntity<EmployeeTax> getEmployeeTaxById(@PathVariable("id") long employeeId){
		return new ResponseEntity<EmployeeTax>(employeeTaxService.getEmployeeTaxById(employeeId), HttpStatus.OK);
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<EmployeeTax> updateEmployeeTax(@PathVariable("id") long id
												  ,@RequestBody EmployeeTax employeeTax){
		return new ResponseEntity<EmployeeTax>(employeeTaxService.updateEmployeeTax(employeeTax, id), HttpStatus.OK);
	}
	
	
}
