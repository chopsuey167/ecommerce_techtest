package com.inditex.ecommerce.controller;

import com.inditex.ecommerce.dto.PriceFilterRequest;
import com.inditex.ecommerce.dto.PriceFilterResponse;
import com.inditex.ecommerce.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/prices")
public class PriceController {

  private final PriceService priceService;

  @GetMapping
  public @ResponseBody ResponseEntity<?> getPriceByFilters(@RequestBody PriceFilterRequest priceFilterRequest) {

    PriceFilterResponse filteredPrice = priceService.findPricesByFilters(priceFilterRequest);

    if (filteredPrice == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    return new ResponseEntity<>(filteredPrice, HttpStatus.OK);
  }

}
