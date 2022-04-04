package com.endava.demo.service.impl;

import com.endava.demo.dto.AddItemsDto;
import com.endava.demo.dto.SupermarketDto;
import com.endava.demo.dto.AddedItemsDto;
import com.endava.demo.exception.SupermarketAlreadyExistException;
import com.endava.demo.exception.SupermarketNotFoundException;
import com.endava.demo.model.Item;
import com.endava.demo.model.Supermarket;
import com.endava.demo.repository.ItemRepository;
import com.endava.demo.repository.SupermarketRepository;
import com.endava.demo.service.SupermarketService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SupermarketServiceImpl implements SupermarketService {

    private final SupermarketRepository supermarketRepository;
    private final ModelMapper modelMapper = new ModelMapper();
    private final ItemRepository itemRepository;


    @Override
    public Supermarket saveSupermarket(Supermarket supermarket) {
        return supermarketRepository.save(supermarket);
    }

    @Override
    public ResponseEntity<SupermarketDto> createSupermarket(SupermarketDto newSupermarket) {
        Supermarket supermarket = modelMapper.map(newSupermarket, Supermarket.class);
        Optional<Supermarket> optionalSupermarket = supermarketRepository.findByName(supermarket.getName());
        if(optionalSupermarket.isPresent()) {
            throw new SupermarketAlreadyExistException(newSupermarket.getName());
        }

        Supermarket supermarketCreated = saveSupermarket(supermarket);
        SupermarketDto mappedSupermarket = modelMapper.map(supermarketCreated, SupermarketDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(mappedSupermarket);
    }

    @Override
    public ResponseEntity<AddedItemsDto> addItems(AddItemsDto addItemsDto) {
        Optional<Supermarket> supermarketOptional = supermarketRepository.findById(addItemsDto.getSupermarketId());
        if(supermarketOptional.isEmpty()) {
            throw new SupermarketNotFoundException("Supermarket does not found.");
        }

        Supermarket supermarket = supermarketOptional.get();
        List<String> itemsId = addItemsDto.getItemsId();

        for (String id : itemsId) {
            Optional<Item> item = itemRepository.findItemById(id);
            if(item.isPresent()) {
                Item currentItem = item.get();
                supermarket.getItems().add(currentItem);
                saveSupermarket(supermarket);
            }
        }

        AddedItemsDto supermarketWithAddedItemsDto = new AddedItemsDto();
        supermarketWithAddedItemsDto.setId(supermarket.getId());
        supermarket.getItems().stream().forEach(e -> supermarketWithAddedItemsDto.getItemNames().add(e.getName()));
        return ResponseEntity.ok(supermarketWithAddedItemsDto);
    }
}