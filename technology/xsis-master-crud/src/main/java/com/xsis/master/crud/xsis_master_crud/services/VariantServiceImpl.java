package com.xsis.master.crud.xsis_master_crud.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xsis.master.crud.xsis_master_crud.dtos.requests.VariantRequest;
import com.xsis.master.crud.xsis_master_crud.entities.Product;
import com.xsis.master.crud.xsis_master_crud.entities.Variant;
import com.xsis.master.crud.xsis_master_crud.repositories.ProductRepository;
import com.xsis.master.crud.xsis_master_crud.repositories.VariantRepository;

@Service
public class VariantServiceImpl implements VariantService {
  @Autowired
  private VariantRepository variantRepository;

  @Autowired
  private ProductRepository productRepository;

  @Override
  public List<Variant> findAllVariants() {
    return variantRepository.findAllVariants();
  }

  @Override
  public Variant findVariantBySlug(String slug) {
    return variantRepository.findBySlug(slug);
  }

  @Override
  public Variant createNewVariant(VariantRequest variantData) {
    Product product = productRepository.findBySlug(variantData.getProduct());
    Variant checkVariant = variantRepository.findBySlug(variantData.getSlug());
    if (checkVariant == null) {
      Variant newVariant = new Variant(product, variantData.getSlug(), variantData.getName(), variantData.getDescription(), variantData.getPrice(), variantData.getStock());
      return variantRepository.save(newVariant);
    } else {
      return null;
    }
  }

  @Override
  public Variant updateVariantBySlug(String slug, VariantRequest variantData) {
    Product product = productRepository.findBySlug(variantData.getProduct());
    Variant checkVariant = variantRepository.findBySlug(slug);
    if (checkVariant == null) {
      return null;
    } else {
      checkVariant.setProduct(product);
      checkVariant.setName(variantData.getName());
      checkVariant.setSlug(variantData.getSlug());
      checkVariant.setDescription(variantData.getDescription());
      checkVariant.setPrice(variantData.getPrice());
      checkVariant.setStock(variantData.getStock());
      return variantRepository.save(checkVariant);
    }
  }

  @Override
  public Variant deleteVariantBySlug(String slug) {
    Variant variant = variantRepository.findBySlug(slug);
    if (variant == null) {
      return null;
    } else {
      variant.setDeletedAt(LocalDateTime.now());
      return variantRepository.save(variant);
    }
  }
}
