package com.jpa.hibernate.app.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="Student")
public class Student {
  @Id
  @GeneratedValue
  private Long id;
  @Column(name="name", nullable = false)
  private String name;

  @OneToOne
  private Passport passport;

  public Student() {
  }

  public Student(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public Passport getPassport() {
    return passport;
  }

  public void setPassport(Passport passport) {
    this.passport = passport;
  }

  @Override
  public String toString() {
    return "Student{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
