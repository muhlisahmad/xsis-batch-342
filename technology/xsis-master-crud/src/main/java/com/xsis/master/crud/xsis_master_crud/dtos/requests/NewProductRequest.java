package com.xsis.master.crud.xsis_master_crud.dtos.requests;

import lombok.Data;

@Data
public class NewProductRequest {
  private String name;
  private String slug;
  private String category;
}
