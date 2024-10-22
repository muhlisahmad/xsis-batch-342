package com.xsis.master.crud.xsis_master_crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xsis.master.crud.xsis_master_crud.dtos.requests.ProductRequest;
import com.xsis.master.crud.xsis_master_crud.entities.Category;
import com.xsis.master.crud.xsis_master_crud.entities.Product;
import com.xsis.master.crud.xsis_master_crud.repositories.CategoryRepository;
import com.xsis.master.crud.xsis_master_crud.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  public List<Product> findAllProducts() {
    return productRepository.findAllProducts();
  }

  @Override
  public Product findProductBySlug(String slug) {
    return productRepository.findBySlug(slug);
  }

  @Override
  public Product createNewProduct(ProductRequest productData) {
    Category category = categoryRepository.findBySlug(productData.getCategory());
    Product checkProduct = productRepository.findBySlug(productData.getSlug());
    if (checkProduct == null) {
      Product newProduct = new Product(category, productData.getSlug(), productData.getName());
      return productRepository.save(newProduct);
    } else {
      return null;
    }
  }

  @Override
  public Product updateProductBySlug(String slug, ProductRequest productData) {
    Category category = categoryRepository.findBySlug(productData.getCategory());
    Product checkProduct = productRepository.findBySlug(slug);
    if (checkProduct == null) {
      return null;
    } else {
      checkProduct.setCategory(category);
      checkProduct.setName(productData.getName());
      checkProduct.setSlug(productData.getSlug());
      return productRepository.save(checkProduct);
    }
  }
  
}
