package com.endava.demo.controller;

import com.endava.demo.dto.ItemDto;
import com.endava.demo.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @PostMapping()
    ResponseEntity<ItemDto> createItem(@Valid @RequestBody ItemDto newItem) {
        return itemService.createItem(newItem);
    }
}