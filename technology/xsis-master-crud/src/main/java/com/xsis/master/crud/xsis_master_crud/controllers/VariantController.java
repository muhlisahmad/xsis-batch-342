package com.xsis.master.crud.xsis_master_crud.controllers;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xsis.master.crud.xsis_master_crud.dtos.requests.NewVariantRequest;
import com.xsis.master.crud.xsis_master_crud.entities.Variant;
import com.xsis.master.crud.xsis_master_crud.services.VariantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/variant")
public class VariantController {
  @Autowired
  private VariantService variantService;

  @GetMapping("")
  public ResponseEntity<?> getAllVariants() {
    LinkedHashMap<String, Object> data = new LinkedHashMap<>();
    try {
      List<Variant> variants = variantService.findAllVariants();
      if (variants.isEmpty()) {
        data.put("code", 404);
        data.put("status", "failed");
        data.put("message", "Variant Data Not Found");
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
      } else {
        data.put("code", 200);
        data.put("status", "success");
        data.put("data", variants);
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
  public ResponseEntity<?> getVariantBySlug(@PathVariable("slug") String slug) {
    LinkedHashMap<String, Object> data = new LinkedHashMap<>();
    try {
      Variant variant = variantService.findVariantBySlug(slug);
      if (variant == null) {
        data.put("code", 404);
        data.put("status", "failed");
        data.put("message", "Cannot Find The Given Variant");
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
      } else {
        data.put("code", 200);
        data.put("status", "success");
        data.put("data", variant);
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
  public ResponseEntity<?> createNewVariant(@RequestBody NewVariantRequest variantReqBody) {
    LinkedHashMap<String, Object> data = new LinkedHashMap<>();
    try {
      Variant variant = variantService.createNewVariant(variantReqBody);
      if (variant == null) {
        data.put("code", 400);
        data.put("status", "failed");
        data.put("message", "Variant With Given Name Already Exists");
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
      } else {
        data.put("code", 201);
        data.put("status", "success");
        data.put("data", variant);
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
  
}
