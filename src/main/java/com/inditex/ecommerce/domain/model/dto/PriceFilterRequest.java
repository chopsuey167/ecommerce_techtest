package com.inditex.ecommerce.domain.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class PriceFilterRequest {

  @NotBlank
  private String applicationDate;
  @NotNull
  private Long productId;
  @NotNull
  private Long brandId;
}
