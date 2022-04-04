package com.endava.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AddedItemsDto {

    private String id;

    private List<String> itemNames = new ArrayList<>();
}