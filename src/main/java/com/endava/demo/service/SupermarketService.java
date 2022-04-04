package com.endava.demo.service;

import com.endava.demo.dto.AddItemsDto;
import com.endava.demo.dto.SupermarketDto;
import com.endava.demo.dto.AddedItemsDto;
import com.endava.demo.model.Supermarket;
import org.springframework.http.ResponseEntity;

public interface SupermarketService {

    Supermarket saveSupermarket(Supermarket supermarket);

    ResponseEntity<SupermarketDto> createSupermarket(SupermarketDto newSupermarket);

    ResponseEntity<AddedItemsDto> addItems(AddItemsDto addItemsDto);
}