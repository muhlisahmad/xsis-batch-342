package com.xsis.master.crud.xsis_master_crud.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Product extends AuditableEntity {
  public Product(Category category, String slug, String name) {
    this.category = category;
    this.slug = slug;
    this.name = name;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "category_id", referencedColumnName = "id")
  private Category category;

  @OneToMany(mappedBy = "product")
  private List<Variant> variants;

  @Column(length = 50, unique = true)
  private String slug;

  @Column(length = 50, unique = true)
  private String name;
}
