package com.codeup.blogapp.web;


import com.codeup.blogapp.data.Category;
import com.codeup.blogapp.data.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value= "/api/categories", headers = "Accept=application/json")
public class CategoriesController {

    List<Post> posts = new ArrayList<Post>(){{
        add(new Post(1L, "A new Post",
                "this is a brilliant post. 10/10", null, null));
        add(new Post(2L, "A new Post",
                "this is a brilliant post. 11/10", null, null));
        add(new Post(3L, "A new Post",
                "this is a brilliant post. 12/10", null, null));
    }};

    @GetMapping
    private List<Category> getCategories(){
        return new ArrayList<Category>(){{
            add (new Category(1L, "test"));
            add (new Category(2L, "test 2"));
            add (new Category(3L, "test 3"));
        }};
    }

    @GetMapping("/{id}")
    private Category getCategoryById(@PathVariable Long id){

        Category category = new Category(1L, "test");

        category.setPosts(posts);

        return category;
    }

    @GetMapping
    private Category getPostsByCategory(){

        return new Category(1L, "test");


        }
    }

