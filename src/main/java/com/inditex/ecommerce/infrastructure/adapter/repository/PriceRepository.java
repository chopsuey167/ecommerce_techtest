package com.inditex.ecommerce.infrastructure.adapter.repository;

import com.inditex.ecommerce.infrastructure.adapter.entity.PriceEntity;
import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

  @Query("select p from PriceEntity p "
      + "where "
      + "p.brandId = :brandid and "
      + "p.productId = :productid and "
      + "p.startDate<= :applicationdate and "
      + "p.endDate>= :applicationdate order by p.priority desc limit 1")
  PriceEntity findPriceByFilter(
      @Param("brandid") Long brandId,
      @Param("productid") Long productId,
      @Param("applicationdate") LocalDateTime applicationDate);
}
