package com.augustoiseppe.dscommerce.dto;

import com.augustoiseppe.dscommerce.entities.Category;
import com.augustoiseppe.dscommerce.entities.Product;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {
    private Long id;
    @NotBlank(message = "Campo requerido")
    @Size(min = 3, max = 80, message = "O nome precisa ter de 3 a 8 caracteres")
    private String name;
    @NotBlank(message = "Campo requerido")
    @Size(min = 10, message = "A descrição precisa ter no mínimo 10 caracteres")
    private String description;
    @Positive(message = "O preço deve ser positivo")
    private double price;
    private String imgUrl;

    @NotEmpty(message = "Campo requerido - Deve haver pelo menos uma categoria")
    private List<CategoryDTO> categories = new ArrayList<>();

    public ProductDTO () {}

    public ProductDTO(Long id, String name, String description, double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        price = entity.getPrice();
        imgUrl = entity.getImgUrl();
        for (Category category : entity.getCategories()) {
            categories.add(new CategoryDTO(category));
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }
}
