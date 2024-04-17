package com.jpa.hibernate.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Passport")
public class Passport {
  @Id
  @GeneratedValue
  private Long id;
  @Column(name="number", nullable = false)
  private String number;

  public Passport() {
  }

  public Passport(String number) {
    this.number = number;
  }

  public String getName() {
    return number;
  }

  public void setName(String number) {
    this.number = number;
  }

  public Long getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Passport{" +
        "id=" + id +
        ", name='" + number + '\'' +
        '}';
  }
}
