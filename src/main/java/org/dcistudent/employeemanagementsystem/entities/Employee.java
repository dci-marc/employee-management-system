package org.dcistudent.employeemanagementsystem.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "first_name", nullable = false)
  private String firstName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "phone", nullable = false)
  private String phone;

  @Column(name = "date_hire", nullable = false)
  private LocalDate dateHire;

  @Column(name = "salary", nullable = false)
  private BigDecimal salary;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "department_id", nullable = false)
  private Department department;

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return this.phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public LocalDate getHireDate() {
    return this.dateHire;
  }

  public void setHireDate(LocalDate dateHire) {
    this.dateHire = dateHire;
  }

  public BigDecimal getSalary() {
    return this.salary;
  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }

  public Department getDepartment() {
    return this.department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

}