package com.xsis.master.crud.xsis_master_crud.services;

import java.util.List;

import com.xsis.master.crud.xsis_master_crud.dtos.requests.ProductRequest;
import com.xsis.master.crud.xsis_master_crud.entities.Product;

public interface ProductService {
  List<Product> findAllProducts();
  Product findProductBySlug(String slug);
  Product createNewProduct(ProductRequest productData);
  Product updateProductBySlug(String slug, ProductRequest productData);
}
