package com.xsis.master.crud.xsis_master_crud.services;

import java.util.List;

import com.xsis.master.crud.xsis_master_crud.dtos.requests.VariantRequest;
import com.xsis.master.crud.xsis_master_crud.entities.Variant;

public interface VariantService {
  List<Variant> findAllVariants();
  Variant findVariantBySlug(String slug);
  Variant createNewVariant(VariantRequest variantData);
  Variant updateVariantBySlug(String slug, VariantRequest variantData);
  Variant deleteVariantBySlug(String slug);
}
