package com.xsis.master.crud.xsis_master_crud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xsis.master.crud.xsis_master_crud.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  @Query(value = "select * from master.products where deleted_at is null", nativeQuery = true)
  List<Product> findAllProducts();

  @Query(value = "select * from master.products where deleted_at is null and slug = ?1", nativeQuery = true)
  Product findBySlug(String slug);
}
