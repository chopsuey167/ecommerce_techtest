package com.inditex.ecommerce.service;


import com.inditex.ecommerce.dto.PriceFilterRequest;
import com.inditex.ecommerce.dto.PriceFilterResponse;
import com.inditex.ecommerce.mapper.PriceDtoMapper;
import com.inditex.ecommerce.model.Price;
import com.inditex.ecommerce.repository.PriceRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

  private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  private final PriceRepository priceRepository;

  private final PriceDtoMapper priceDtoMapper;

  @Override
  public PriceFilterResponse findPricesByFilters(PriceFilterRequest priceFilterRequest) {

    Price priceByFilter = priceRepository.findPriceByFilter(
        priceFilterRequest.getBrandId(),
        priceFilterRequest.getProductId(),
        LocalDateTime.parse(priceFilterRequest.getApplicationDate(), formatter));

    return priceDtoMapper.toPriceFilterResponse(priceByFilter);
  }


}
