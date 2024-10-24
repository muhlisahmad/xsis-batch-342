package com.xsis.master.crud.xsis_master_crud.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "variants")
@NoArgsConstructor
public class Variant extends AuditableEntity {
  public Variant(Product product, String slug, String name, String description, Long price, Long stock) {
    this.product = product;
    this.slug = slug;
    this.name = name;
    this.description = description;
    this.price = price;
    this.stock = stock;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  private Product product;

  @Column(length = 150, unique = true)
  private String slug;

  @Column(length = 150, unique = true)
  private String name;

  @Column(columnDefinition = "TEXT")
  private String description;

  @Column
  private Long price;

  @Column
  private Long stock;
}
