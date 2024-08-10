package com.inditex.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class PriceFilterRequest {

  private String applicationDate;
  private Long productId;
  private Long brandId;
}
