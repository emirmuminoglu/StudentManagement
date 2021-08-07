package com.emir.studentmanagement.student;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

@Entity
@Table
public class Student {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
    name = "UUID",
    strategy = "org.hibernate.id.UUIDGenerator"
  )
  @Column(name = "id", updatable = false, nullable = false)
  private UUID id;
  @Column(updatable = false, nullable = false)
  private String email;
  @Column(nullable = false)
  private String FullName;
  private LocalDate dateOfBirth;
  @Transient
  private Integer age;

  public Student(UUID id, String email, String fullName, LocalDate dateOfBirth) {
    this.id = id;
    this.email = email;
    FullName = fullName;
    this.dateOfBirth = dateOfBirth;
  }

  public Student() {
  }

  public Student(String email, String fullName, LocalDate dateOfBirth) {
    this.email = email;
    FullName = fullName;
    this.dateOfBirth = dateOfBirth;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFullName() {
    return FullName;
  }

  public void setFullName(String fullName) {
    FullName = fullName;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Integer getAge() {
    return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Student{" +
      "id=" + id +
      ", email='" + email + '\'' +
      ", FullName='" + FullName + '\'' +
      ", dateOfBirth=" + dateOfBirth +
      '}';
  }
}
