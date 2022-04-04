package com.endava.demo.dto;

import com.endava.demo.model.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class ItemDto {

    @NotBlank(message = "Name is required field.")
    private String name;

    @NotNull(message = "Price is required field.")
    private Double price;

    @NotNull(message = "Type is required field.")
    @Enumerated(EnumType.STRING)
    private Item.ItemType type;
}