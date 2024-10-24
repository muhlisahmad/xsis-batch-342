package com.xsis.master.crud.xsis_master_crud.services;

import java.util.List;

import com.xsis.master.crud.xsis_master_crud.dtos.responses.CategoryResponseDto;
import com.xsis.master.crud.xsis_master_crud.dtos.responses.WebResponse;

public interface CategoryService {
  WebResponse<List<CategoryResponseDto>> findAllCategories(int page, int limit);
  WebResponse<CategoryResponseDto> findCategoryBySlug(String slug);
}
