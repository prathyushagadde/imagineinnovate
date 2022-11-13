package imagineinnovate.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import imagineinnovate.springboot.model.EmployeeTax;

public interface EmployeeTaxRepository extends JpaRepository<EmployeeTax, Long>{
	
	
}
