package com.inditex.ecommerce.repository;

import com.inditex.ecommerce.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Long> {

  @Query("select p from Price p "
      + "where "
      + "p.brandId = :brandid and "
      + "p.productId = :productid and "
      + "p.startDate<= :applicationdate and "
      + "p.endDate>= :applicationdate")
  List<Price> findPriceByFilter(
      @Param("brandid") Long brandId,
      @Param("productid") Long productId,
      @Param("applicationdate") LocalDateTime applicationDate);
}
