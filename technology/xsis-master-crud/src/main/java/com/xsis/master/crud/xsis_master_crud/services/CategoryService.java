package com.xsis.master.crud.xsis_master_crud.services;

import java.util.List;

import com.xsis.master.crud.xsis_master_crud.dtos.requests.CategoryRequest;
import com.xsis.master.crud.xsis_master_crud.entities.Category;

public interface CategoryService {
  List<Category> findAllCategories();
  Category findCategoryBySlug(String slug);
  Category createNewCategory(CategoryRequest categoryData);
  Category updateCategoryBySlug(String slug, CategoryRequest categoryRequest);
}
