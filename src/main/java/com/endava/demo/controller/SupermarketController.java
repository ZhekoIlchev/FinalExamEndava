package com.endava.demo.controller;

import com.endava.demo.dto.AddItemsDto;
import com.endava.demo.dto.SupermarketDto;
import com.endava.demo.dto.AddedItemsDto;
import com.endava.demo.service.SupermarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/supermarkets")
public class SupermarketController {

    private final SupermarketService supermarketService;

    @PostMapping()
    ResponseEntity<SupermarketDto> createSupermarket(@Valid @RequestBody SupermarketDto newSupermarket) {
        return supermarketService.createSupermarket(newSupermarket);
    }

    @PostMapping("/addItems")
    ResponseEntity<AddedItemsDto> addItemsToSupermarket(@Valid @RequestBody AddItemsDto addItemsDto) {
        return supermarketService.addItems(addItemsDto);
    }
}