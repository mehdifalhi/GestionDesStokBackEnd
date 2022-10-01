package com.fali.repositories;


import org.springframework.data.jpa.repository.JpaRepository;


import com.fali.entites.Category;

import java.util.Optional;


public interface CategoryRepository extends JpaRepository<Category,Long>{

    Optional<Category> findCategoryByCode(String code);
}
