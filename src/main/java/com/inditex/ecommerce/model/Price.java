package com.inditex.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Price {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
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
