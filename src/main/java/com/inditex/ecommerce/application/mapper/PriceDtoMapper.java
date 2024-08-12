package com.inditex.ecommerce.application.mapper;

import com.inditex.ecommerce.domain.model.Price;
import com.inditex.ecommerce.domain.model.dto.PriceFilterResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceDtoMapper {

  PriceFilterResponse toPriceFilterResponse(Price price);

}
