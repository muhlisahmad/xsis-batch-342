package com.xsis.master.crud.xsis_master_crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xsis.master.crud.xsis_master_crud.dtos.requests.NewProductRequest;
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
  public Product createNewProduct(NewProductRequest productData) {
    Category category = categoryRepository.findBySlug(productData.getCategory());
    Product checkProduct = productRepository.findBySlug(productData.getSlug());
    if (checkProduct == null) {
      Product newProduct = new Product(category, productData.getSlug(), productData.getName());
      return productRepository.save(newProduct);
    } else {
      return null;
    }
  }
}
