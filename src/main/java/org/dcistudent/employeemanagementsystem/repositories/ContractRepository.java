package org.dcistudent.employeemanagementsystem.repositories;

import org.dcistudent.employeemanagementsystem.entities.Client;
import org.dcistudent.employeemanagementsystem.entities.Contract;
import org.dcistudent.employeemanagementsystem.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
  @Modifying
  @Query(
      "INSERT INTO Contract (name, dateStart, dateEnd, employee, client) " +
      "VALUES (:name, :dateStart, :dateEnd, :employee, :client)")
  void create(
      String name,
      LocalDate dateStart,
      LocalDate dateEnd,
      Employee employee,
      Client client
  );
}
