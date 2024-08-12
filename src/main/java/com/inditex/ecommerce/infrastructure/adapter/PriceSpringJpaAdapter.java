package com.inditex.ecommerce.infrastructure.adapter;

import com.inditex.ecommerce.domain.model.Price;
import com.inditex.ecommerce.domain.port.PricePersistencePort;
import com.inditex.ecommerce.infrastructure.adapter.entity.PriceEntity;
import com.inditex.ecommerce.infrastructure.adapter.mapper.PriceDBMapper;
import com.inditex.ecommerce.infrastructure.adapter.repository.PriceRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceSpringJpaAdapter implements PricePersistencePort {

  private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  private final PriceRepository priceRepository;

  private final PriceDBMapper priceDBMapper;

  @Override
  public Price findPricesByFilters(long brandId, long productId, String applicationDate) {
    PriceEntity priceByFilter = priceRepository.findPriceByFilter(
        brandId,
        productId,
        LocalDateTime.parse(applicationDate, formatter));
    return priceDBMapper.toPrice(priceByFilter);
  }
}
