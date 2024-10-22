package com.xsis.master.crud.xsis_master_crud.dtos.requests;

import lombok.Data;

@Data
public class NewCategoryRequest {
  private String slug;
  private String name;
}
