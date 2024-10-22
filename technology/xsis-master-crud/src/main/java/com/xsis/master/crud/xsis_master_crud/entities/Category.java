package com.xsis.master.crud.xsis_master_crud.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "categories")
@NoArgsConstructor
public class Category extends AuditableEntity {
  public Category(String slug, String name) {
    this.slug = slug;
    this.name = name;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 50, unique = true)
  private String slug;

  @Column(length = 50, unique = true)
  private String name;

  @OneToMany(mappedBy = "category")
  @JsonManagedReference
  private List<Product> products;
}
