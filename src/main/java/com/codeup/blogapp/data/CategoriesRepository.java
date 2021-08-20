package com.codeup.blogapp.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Post, Long>{
}
