package com.codeup.blogapp.web;


import com.codeup.blogapp.data.CategoriesRepository;
import com.codeup.blogapp.data.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/categories", headers = "Accept=application/json")
public class CategoriesController {

    private final CategoriesRepository categoriesRepository;

    public CategoriesController(CategoriesRepository categoriesRepository){
        this.categoriesRepository = categoriesRepository;
    }

    @GetMapping
    private List<Category> getCategories() {
        return categoriesRepository.findAll();
    }

    @GetMapping("/{id}")
    private Category getCategoryById(@PathVariable Long id) {
        return categoriesRepository.getById(id);
    }

    @GetMapping("/{categories}")
    private Category getPostsByCategory(@RequestParam String categoryName) {

        return categoriesRepository.getById(id);

    }
}

