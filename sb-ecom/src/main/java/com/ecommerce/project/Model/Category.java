package com.ecommerce.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long categoryId;

    @NotBlank
    private String categoryName;

    // Since we are using Lombok we don't need to write below constructors and Getters & Setters manually
    // public Category(Long categoryId, String categoryName) {
    //     this.categoryId = categoryId;
    //     this.categoryName = categoryName;
    // }
    
    // public Category() {
        
    // }

    // public Long getCategoryId() {
    //     return categoryId;
    // }
    // public void setCategoryId(Long categoryId) {
    //     this.categoryId = categoryId;
    // }
    // public String getCategoryName() {
    //     return categoryName;
    // }
    // public void setCategoryName(String categoryName) {
    //     this.categoryName = categoryName;
    // }
}
