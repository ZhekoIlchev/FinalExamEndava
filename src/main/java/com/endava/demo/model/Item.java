package com.endava.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @NotBlank(message = "Name is required field.")
    private String name;

    @NotNull(message = "Price is required field.")
    private Double price;

    @NotNull(message = "Type is required field.")
    @Enumerated(EnumType.STRING)
    private ItemType type;

    public enum ItemType {
        FOOD, DRINKS, TECHNOLOGY, HOUSEHOLD
    }
}