package com.sporty_shoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sporty_shoes.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
