package org.dcistudent.employeemanagementsystem.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "department")
public class Department {
  @Id
  @ColumnDefault("nextval('department_id_seq')")
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
  private String name;

  @Column(name = "location", nullable = false, length = Integer.MAX_VALUE)
  private String location;

  @ManyToOne(fetch = FetchType.LAZY)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "employee_id")
  private Department employee;

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return this.location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Department getEmployee() {
    return this.employee;
  }

  public void setEmployee(Department employee) {
    this.employee = employee;
  }

}