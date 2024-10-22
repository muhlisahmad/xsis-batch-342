package com.xsis.master.crud.xsis_master_crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xsis.master.crud.xsis_master_crud.dtos.requests.CategoryRequest;
import com.xsis.master.crud.xsis_master_crud.entities.Category;
import com.xsis.master.crud.xsis_master_crud.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
  @Autowired
  private CategoryRepository categoryRepository;

  
  @Override
  public Category findCategoryBySlug(String slug) {
    return categoryRepository.findBySlug(slug);
  }

  @Override
  public List<Category> findAllCategories() {
    return categoryRepository.findAllCategories();
  }

  @Override
  public Category createNewCategory(CategoryRequest categoryData) {
    Category category = categoryRepository.findBySlug(categoryData.getSlug());
    if (category == null) {
      Category newCategory = new Category(categoryData.getSlug(), categoryData.getName());
      return categoryRepository.save(newCategory);
    } else {
      return null;
    }
  }

  @Override
  public Category updateCategoryBySlug(String slug, CategoryRequest categoryRequest) {
    Category category = categoryRepository.findBySlug(slug);
    if (category == null) {
      return null;
    } else {
      category.setName(categoryRequest.getName());
      category.setSlug(categoryRequest.getSlug());
      return categoryRepository.save(category);
    }
  }
}
