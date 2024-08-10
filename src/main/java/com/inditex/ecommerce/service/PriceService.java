package com.inditex.ecommerce.service;

import com.inditex.ecommerce.dto.PriceFilterRequest;
import com.inditex.ecommerce.dto.PriceFilterResponse;

public interface PriceService {

  PriceFilterResponse findPricesByFilters(PriceFilterRequest priceFilterRequest);
}
