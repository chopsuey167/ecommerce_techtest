package com.inditex.ecommerce.application.usecase;

import com.inditex.ecommerce.domain.model.dto.PriceFilterRequest;
import com.inditex.ecommerce.domain.model.dto.PriceFilterResponse;

public interface PriceService {

  PriceFilterResponse findPricesByFilters(PriceFilterRequest priceFilterRequest);
}
