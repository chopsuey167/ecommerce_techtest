package com.inditex.ecommerce.infrastructure.adapter.mapper;

import com.inditex.ecommerce.domain.model.Price;
import com.inditex.ecommerce.infrastructure.adapter.entity.PriceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceDBMapper {

  Price toPrice(PriceEntity priceEntity);
}
