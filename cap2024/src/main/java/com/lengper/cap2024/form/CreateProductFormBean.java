package com.lengper.cap2024.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class CreateProductFormBean {

    @NotEmpty(message = "Name is required")
    private String name;

    @NotNull(message = "Price is required")
    private Double price;

    private String image;

    @NotEmpty(message = "Description is required")
    private String description;
}
