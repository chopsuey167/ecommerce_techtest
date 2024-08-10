package com.inditex.ecommerce.repository;

import com.inditex.ecommerce.model.Price;
import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PriceRepository extends JpaRepository<Price, Long> {

  @Query("select p from Price p "
      + "where "
      + "p.brandId = :brandid and "
      + "p.productId = :productid and "
      + "p.startDate<= :applicationdate and "
      + "p.endDate>= :applicationdate order by p.priority desc limit 1")
  Price findPriceByFilter(
      @Param("brandid") Long brandId,
      @Param("productid") Long productId,
      @Param("applicationdate") LocalDateTime applicationDate);
}
