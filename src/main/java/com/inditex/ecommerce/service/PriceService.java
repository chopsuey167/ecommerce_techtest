package com.inditex.ecommerce.service;

import com.inditex.ecommerce.dto.PriceFilterRequest;
import com.inditex.ecommerce.dto.PriceFilterResponse;
import java.util.List;

public interface PriceService {

  List<PriceFilterResponse> findPricesByFilters(PriceFilterRequest priceFilterRequest);
}
