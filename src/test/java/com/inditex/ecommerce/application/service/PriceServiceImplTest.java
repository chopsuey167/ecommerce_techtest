package com.inditex.ecommerce.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import com.inditex.ecommerce.application.mapper.PriceDtoMapper;
import com.inditex.ecommerce.application.mapper.PriceDtoMapperImpl;
import com.inditex.ecommerce.domain.model.Price;
import com.inditex.ecommerce.domain.model.dto.PriceFilterRequest;
import com.inditex.ecommerce.domain.model.dto.PriceFilterResponse;
import com.inditex.ecommerce.domain.port.PricePersistencePort;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PriceServiceImplTest {

  private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
  @InjectMocks
  private PriceServiceImpl priceService;
  @Mock
  private PricePersistencePort pricePersistencePort;
  @Spy
  private PriceDtoMapper priceDtoMapper = new PriceDtoMapperImpl();

  @Test
  void findPricesByFilters_validParameters_success() {
    //Given
    PriceFilterRequest inputValues = new PriceFilterRequest(
        "2020-06-14 10:00:00",
        35455L,
        1L);

    Price price = new Price(
        1,
        1,
        LocalDateTime.parse("2020-06-14 00:00:00", formatter),
        LocalDateTime.parse("2020-12-31 23:59:59", formatter),
        1,
        35455,
        0,
        35.50,
        "EUR");

    PriceFilterResponse expected = new PriceFilterResponse(35455,
        1L,
        1L,
        LocalDateTime.parse("2020-06-14 00:00:00", formatter),
        LocalDateTime.parse("2020-12-31 23:59:59", formatter),
        35.50);

    when(pricePersistencePort.findPricesByFilters(inputValues.getBrandId(), inputValues.getProductId(),
        inputValues.getApplicationDate())).thenReturn(price);

    //When
    PriceFilterResponse actual = priceService.findPricesByFilters(inputValues);

    //Then
    assertNotNull(actual);
    assertEquals(expected, actual);
  }

}