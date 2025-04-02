package org.dcistudent.employeemanagementsystem.repositories;

import org.dcistudent.employeemanagementsystem.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
  @Modifying
  @Query(
      "INSERT INTO Client (name, industry, email, phone) VALUES (:name, :industry, :email, :phoneNumber)"
  )
  void create(String name, String industry, String email, String phoneNumber);
}
