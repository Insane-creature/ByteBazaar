package com.ecommerce.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.project.model.Category;

// @Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{  //  <Type of entity, type of primary key of the entity>
    
}
