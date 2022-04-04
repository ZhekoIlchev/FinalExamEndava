package com.endava.demo.service.impl;

import com.endava.demo.dto.ItemDto;
import com.endava.demo.model.Item;
import com.endava.demo.repository.ItemRepository;
import com.endava.demo.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper = new ModelMapper();


    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public ResponseEntity<ItemDto> createItem(ItemDto newItem) {
        Item item = modelMapper.map(newItem, Item.class);
        Item createdItem = saveItem(item);
        ItemDto mappedDto = modelMapper.map(createdItem, ItemDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(mappedDto);
    }
}