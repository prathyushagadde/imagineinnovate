package imagineinnovate.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import imagineinnovate.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
