package com.xsis.master.crud.xsis_master_crud.controllers;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xsis.master.crud.xsis_master_crud.dtos.requests.CategoryRequest;
import com.xsis.master.crud.xsis_master_crud.entities.Category;
import com.xsis.master.crud.xsis_master_crud.services.CategoryService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/api/v1/category")
@Slf4j
public class CategoryController {
  @Autowired
  private CategoryService categoryService;

  @GetMapping("")
  public ResponseEntity<?> getAllCategory() {
    LinkedHashMap<String, Object> data = new LinkedHashMap<>();
    try {
      List<Category> categories = categoryService.findAllCategories();
      if (categories.isEmpty()) {
        data.put("code", 404);
        data.put("status", "failed");
        data.put("message", "Category Data Not Found");
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
      } else {
        data.put("code", 200);
        data.put("status", "success");
        data.put("data", categories);
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
  public ResponseEntity<?> getCategoryBySlug(@PathVariable("slug") String slug) {
    LinkedHashMap<String, Object> data = new LinkedHashMap<>();
    try {
      Category category = categoryService.findCategoryBySlug(slug);
      if (category == null) {
        data.put("code", 404);
        data.put("status", "failed");
        data.put("message", "Cannot Find The Given Category");
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
      } else {
        data.put("code", 200);
        data.put("status", "success");
        data.put("data", category);
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
  public ResponseEntity<?> createNewCategory(@RequestBody CategoryRequest categoryReqBody) {
      LinkedHashMap<String, Object> data = new LinkedHashMap<>();
      try {
        Category category = categoryService.createNewCategory(categoryReqBody);
        if (category == null) {
          data.put("code", 400);
          data.put("status", "failed");
          data.put("message", "Category With Given Name Already Exists");
          return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
        } else {
          data.put("code", 201);
          data.put("status", "success");
          data.put("data", category);
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
  public ResponseEntity<?> updateCategoryBySlug(@PathVariable String slug, @RequestBody CategoryRequest categoryReqBody) {
    LinkedHashMap<String, Object> data = new LinkedHashMap<>();
    try {
      Category category = categoryService.updateCategoryBySlug(slug, categoryReqBody);
      if (category == null) {
        data.put("code", 404);
        data.put("status", "failed");
        data.put("message", "Category Data Not Found");
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
      } else {
        data.put("code", 202);
        data.put("status", "success");
        data.put("data", category);
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
}
