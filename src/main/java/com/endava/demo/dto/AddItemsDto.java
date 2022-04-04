package com.endava.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AddItemsDto {

    @NotBlank(message = "This field is required.")
    private String supermarketId;

    @NotEmpty()
    private List<String> itemsId = new ArrayList<>();
}