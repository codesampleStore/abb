package com.jpa.hibernate.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Review")
public class Review {
  @Id
  @GeneratedValue
  private Long id;
  private String rating;
  @Column(name="description")
  private String description;

  public Review() {
  }

  public Review(String rating, String description) {
    this.description = description;
    this.rating = rating;
  }

  public String getName() {
    return description;
  }

  public void setName(String description) {
    this.description = description;
  }

  public Long getId() {
    return id;
  }


  public String getRating() {
    return rating;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }

  @Override
  public String toString() {
    return "Review{" +
        "id=" + id +
        ", name='" + description + '\'' +
        '}';
  }
}
