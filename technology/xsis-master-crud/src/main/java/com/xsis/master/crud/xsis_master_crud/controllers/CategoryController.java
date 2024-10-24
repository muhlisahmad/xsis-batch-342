package com.xsis.master.crud.xsis_master_crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xsis.master.crud.xsis_master_crud.dtos.responses.CategoryResponseDto;
import com.xsis.master.crud.xsis_master_crud.dtos.responses.WebResponse;
import com.xsis.master.crud.xsis_master_crud.services.CategoryService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/v1/category")
@Slf4j
public class CategoryController {
  @Autowired
  private CategoryService categoryService;

  @GetMapping(
    path = "",
    produces = {MediaType.APPLICATION_JSON_VALUE}
  )
  public WebResponse<List<CategoryResponseDto>> getAllCategory(
      @RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "10") int limit
    ) {
      return categoryService.findAllCategories(page, limit);
  }
  
  @GetMapping(
    path = "/{slug}",
    produces = {MediaType.APPLICATION_JSON_VALUE}
  )
  public WebResponse<CategoryResponseDto> getCategoryBySlug(@PathVariable("slug") String slug) {
    return categoryService.findCategoryBySlug(slug);
  }
}
