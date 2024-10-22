package com.xsis.master.crud.xsis_master_crud.services;

import java.util.List;

import com.xsis.master.crud.xsis_master_crud.dtos.requests.NewVariantRequest;
import com.xsis.master.crud.xsis_master_crud.entities.Variant;

public interface VariantService {
  List<Variant> findAllVariants();
  Variant findVariantBySlug(String slug);
  Variant createNewVariant(NewVariantRequest variantData);
}
