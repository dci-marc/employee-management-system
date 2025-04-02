package org.dcistudent.employeemanagementsystem.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "client")
public class Client {
  @Id
  @ColumnDefault("nextval('client_id_seq')")
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
  private String name;

  @Column(name = "industry", nullable = false, length = Integer.MAX_VALUE)
  private String industry;

  @Column(name = "email", nullable = false, length = Integer.MAX_VALUE)
  private String email;

  @Column(name = "phone", nullable = false, length = Integer.MAX_VALUE)
  private String phone;

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

  public String getIndustry() {
    return this.industry;
  }

  public void setIndustry(String industry) {
    this.industry = industry;
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

}