package org.dcistudent.employeemanagementsystem.repositories;

import org.dcistudent.employeemanagementsystem.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
  @Modifying
  @Query(
      "INSERT INTO Department (name, location) VALUES (:name, :location)"
  )
  void create(String name, String location);
}
