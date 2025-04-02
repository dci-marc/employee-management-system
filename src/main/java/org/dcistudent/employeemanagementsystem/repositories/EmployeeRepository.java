package org.dcistudent.employeemanagementsystem.repositories;

import org.dcistudent.employeemanagementsystem.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
