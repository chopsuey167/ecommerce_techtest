package com.inditex.ecommerce.domain.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Price {

  private long id;
  private long brandId;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private long priceListId;
  private long productId;
  private Integer priority;
  private Double price;
  private String curr;

}
