package org.dcistudent.employeemanagementsystem.repositories;

import org.dcistudent.employeemanagementsystem.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
