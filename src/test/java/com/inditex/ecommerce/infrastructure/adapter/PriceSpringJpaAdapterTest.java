package com.inditex.ecommerce.infrastructure.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.inditex.ecommerce.domain.model.Price;
import com.inditex.ecommerce.infrastructure.adapter.entity.PriceEntity;
import com.inditex.ecommerce.infrastructure.adapter.exception.PriceNotFoundException;
import com.inditex.ecommerce.infrastructure.adapter.mapper.PriceDBMapper;
import com.inditex.ecommerce.infrastructure.adapter.mapper.PriceDBMapperImpl;
import com.inditex.ecommerce.infrastructure.adapter.repository.PriceRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PriceSpringJpaAdapterTest {

  private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
  @InjectMocks
  private PriceSpringJpaAdapter priceSpringJpaAdapter;
  @Mock
  private PriceRepository priceRepository;
  @Spy
  private PriceDBMapper priceDBMapper = new PriceDBMapperImpl();

  @Test
  void findPricesByFilters_validParameters_returnPrice() {
    //Given
    PriceEntity priceEntity = new PriceEntity(
        1,
        1,
        LocalDateTime.parse("2020-06-14 00:00:00", formatter),
        LocalDateTime.parse("2020-12-31 23:59:59", formatter),
        1,
        35455,
        0,
        35.50,
        "EUR");

    Price expected = new Price(
        1,
        1,
        LocalDateTime.parse("2020-06-14 00:00:00", formatter),
        LocalDateTime.parse("2020-12-31 23:59:59", formatter),
        1,
        35455,
        0,
        35.50,
        "EUR");

    when(priceRepository.findPriceByFilter(1L, 35455L, LocalDateTime.parse("2020-06-14 10:00:00", formatter)))
        .thenReturn(Optional.of(priceEntity));
    //When

    Price actual = priceSpringJpaAdapter.findPricesByFilters(1L, 35455L, "2020-06-14 10:00:00");

    //Then
    assertNotNull(actual);
    assertEquals(expected, actual);
  }

  @Test
  void findPricesByFilters_validParameters_returnNotFoundException() {
    //Given

    when(priceRepository.findPriceByFilter(1L, 35455L, LocalDateTime.parse("2020-06-14 10:00:00", formatter)))
        .thenThrow(PriceNotFoundException.class);
    //When

    Executable executable = () -> priceSpringJpaAdapter.findPricesByFilters(1L, 35455L, "2020-06-14 10:00:00");

    //Then

    var exception = assertThrows(PriceNotFoundException.class, executable);
    assertEquals(PriceNotFoundException.class, exception.getClass());
  }
}