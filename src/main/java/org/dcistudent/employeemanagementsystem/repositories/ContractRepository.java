package org.dcistudent.employeemanagementsystem.repositories;

import org.dcistudent.employeemanagementsystem.entities.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}
