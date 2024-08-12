package com.inditex.ecommerce.domain.port;

import com.inditex.ecommerce.domain.model.Price;

public interface PricePersistencePort {

  Price findPricesByFilters(long brandId, long productId, String applicationDate);
}
