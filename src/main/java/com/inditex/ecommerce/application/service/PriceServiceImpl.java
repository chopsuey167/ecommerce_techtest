package com.inditex.ecommerce.application.service;


import com.inditex.ecommerce.application.mapper.PriceDtoMapper;
import com.inditex.ecommerce.application.usecase.PriceService;
import com.inditex.ecommerce.domain.model.Price;
import com.inditex.ecommerce.domain.model.dto.PriceFilterRequest;
import com.inditex.ecommerce.domain.model.dto.PriceFilterResponse;
import com.inditex.ecommerce.domain.port.PricePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

  private final PricePersistencePort pricePersistencePort;

  private final PriceDtoMapper priceDtoMapper;

  @Override
  public PriceFilterResponse findPricesByFilters(PriceFilterRequest priceFilterRequest) {

    Price priceByFilter = pricePersistencePort.findPricesByFilters(
        priceFilterRequest.getBrandId(),
        priceFilterRequest.getProductId(),
        priceFilterRequest.getApplicationDate());

    return priceDtoMapper.toPriceFilterResponse(priceByFilter);
  }


}
