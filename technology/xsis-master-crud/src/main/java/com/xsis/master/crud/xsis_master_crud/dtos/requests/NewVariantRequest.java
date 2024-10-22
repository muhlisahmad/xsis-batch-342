package com.xsis.master.crud.xsis_master_crud.dtos.requests;

import lombok.Data;

@Data
public class NewVariantRequest {
  private String name;
  private String slug;
  private String product;
  private String description;
  private Long price;
  private Long stock;
}
