package com.inditex.ecommerce.mapper;

import com.inditex.ecommerce.dto.PriceFilterResponse;
import com.inditex.ecommerce.model.Price;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceDtoMapper {

    PriceFilterResponse toPriceFilterResponse(Price price);

}
