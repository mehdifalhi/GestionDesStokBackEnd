package com.fali.repositories;

import com.fali.entites.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fali.entites.Category;

import java.util.Optional;


public interface CategoryRepository extends JpaRepository<Category,Long>{

    Optional<Category> findCategoryByCode(String code);
}
