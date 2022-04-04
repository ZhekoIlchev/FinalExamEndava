package com.endava.demo.service;

import com.endava.demo.dto.ItemDto;
import com.endava.demo.model.Item;
import org.springframework.http.ResponseEntity;

public interface ItemService {
    Item saveItem(Item item);

    ResponseEntity<ItemDto> createItem(ItemDto newItem);
}