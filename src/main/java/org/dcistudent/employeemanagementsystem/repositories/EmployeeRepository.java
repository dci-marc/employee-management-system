package org.dcistudent.employeemanagementsystem.repositories;

import org.dcistudent.employeemanagementsystem.entities.Department;
import org.dcistudent.employeemanagementsystem.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  @Modifying
  @Query(
      "INSERT INTO Employee (firstName, lastName, email, phone, dateHire, salary, department) " +
      "VALUES (:firstName, :lastName, :email, :phone, :dateHire, :salary, :department)"
  )
  void create(
      String firstName,
      String lastName,
      String email,
      String phone,
      LocalDate hireDate,
      BigDecimal salary,
      Department department
  );
}
