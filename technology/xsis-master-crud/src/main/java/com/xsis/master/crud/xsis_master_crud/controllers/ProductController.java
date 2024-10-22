package com.xsis.master.crud.xsis_master_crud.controllers;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xsis.master.crud.xsis_master_crud.dtos.requests.ProductRequest;
import com.xsis.master.crud.xsis_master_crud.entities.Product;
import com.xsis.master.crud.xsis_master_crud.services.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
  @Autowired
  private ProductService productService;

  @GetMapping("")
  public ResponseEntity<?> getAllProducts() {
    LinkedHashMap<String, Object> data = new LinkedHashMap<>();
    try {
      List<Product> products = productService.findAllProducts();
      if (products.isEmpty()) {
        data.put("code", 404);
        data.put("status", "failed");
        data.put("message", "Product Data Not Found");
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
      } else {
        data.put("code", 200);
        data.put("status", "success");
        data.put("data", products);
        return new ResponseEntity<>(data, HttpStatus.OK);
      }
    } catch (Exception e) {
      data.put("code", 500);
      data.put("status", "error");
      data.put("error", e);
      data.put("stack", e.getStackTrace().toString());
      return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/{slug}")
  public ResponseEntity<?> getProductBySlug(@PathVariable("slug") String slug) {
    LinkedHashMap<String, Object> data = new LinkedHashMap<>();
    try {
      Product product = productService.findProductBySlug(slug);
      if (product == null) {
        data.put("code", 404);
        data.put("status", "failed");
        data.put("message", "Cannot Find The Given Product");
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
      } else {
        data.put("code", 200);
        data.put("status", "success");
        data.put("data", product);
        return new ResponseEntity<>(data, HttpStatus.OK);
      }
    } catch (Exception e) {
      data.put("code", 500);
      data.put("status", "error");
      data.put("error", e);
      data.put("stack", e.getStackTrace().toString());
      return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("")
  public ResponseEntity<?> createNewProduct(@RequestBody ProductRequest productReqBody) {
      LinkedHashMap<String, Object> data = new LinkedHashMap<>();
      try {
        Product product = productService.createNewProduct(productReqBody);
        if (product == null) {
          data.put("code", 400);
          data.put("status", "failed");
          data.put("message", "Product With Given Name Already Exists");
          return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
        } else {
          data.put("code", 201);
          data.put("status", "success");
          data.put("data", product);
          return new ResponseEntity<>(data, HttpStatus.CREATED);
        }
      } catch (Exception e) {
        data.put("code", 500);
        data.put("status", "error");
        data.put("error", e);
        data.put("stack", e.getStackTrace().toString());
        return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }

  @PutMapping("/{slug}")
  public ResponseEntity<?> updateProductBySlug(@PathVariable String slug, @RequestBody ProductRequest ProductReqBody) {
      LinkedHashMap<String, Object> data = new LinkedHashMap<>();
      try {
        Product product = productService.updateProductBySlug(slug, ProductReqBody);
        if (product == null) {
          data.put("code", 404);
          data.put("status", "failed");
          data.put("message", "Cannot Find The Given Product");
          return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
        } else {
          data.put("code", 202);
          data.put("status", "success");
          data.put("data", product);
          return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        }
      } catch (Exception e) {
        data.put("code", 500);
        data.put("status", "error");
        data.put("error", e);
        data.put("stack", e.getStackTrace().toString());
        return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }

  @DeleteMapping("/{slug}")
  public ResponseEntity<?> deleteProductBySlug(@PathVariable String slug) {
    LinkedHashMap<String, Object> data = new LinkedHashMap<>();
    try {
      Product product = productService.deleteProductBySlug(slug);
      if (product == null) {
        data.put("code", 404);
        data.put("status", "failed");
        data.put("message", "Product Data Not Found");
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
      } else {
        data.put("code", 200);
        data.put("status", "success");
        data.put("data", product);
        return new ResponseEntity<>(data, HttpStatus.OK);
      }
    } catch (Exception e) {
      data.put("code", 500);
      data.put("status", "error");
      data.put("error", e);
      data.put("stack", e.getStackTrace().toString());
      return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
