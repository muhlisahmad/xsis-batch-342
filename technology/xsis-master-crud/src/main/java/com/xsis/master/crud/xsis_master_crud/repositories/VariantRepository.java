package com.xsis.master.crud.xsis_master_crud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xsis.master.crud.xsis_master_crud.entities.Variant;


@Repository
public interface VariantRepository extends JpaRepository<Variant, Long> {
  @Query(value = "select * from master.variants where deleted_at is null", nativeQuery = true)
  List<Variant> findAllVariants();

  @Query(value = "select * from master.variants where deleted_at is null and slug = ?1", nativeQuery = true)
  Variant findBySlug(String slug);
}
