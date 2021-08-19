package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Category;
import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts",headers = "Accept=application/json")
public class PostsController {
   List<Category> categories = new ArrayList<Category>(){{
       add (new Category(1L, "test"));
       add (new Category(2L, "test 2"));
       add (new Category(3L, "test 3"));
   }};


    @GetMapping
    private List<Post> getPosts() {

        User user = new User(1L, "testy","testy@test.com","password", User.Role.USER, null);

        return new ArrayList<Post>(){{
            add(new Post(1L, "A new Post",
                    "this is a brilliant post. 10/10", user, categories));
            add(new Post(2L, "A new Post",
                    "this is a brilliant post. 11/10", user, categories));
            add(new Post(3L, "A new Post",
                    "this is a brilliant post. 12/10", user, categories));
        }};
    }


    @GetMapping("/{id}")
    private Post getPostById(@PathVariable Long id){
        // /api/posts/1
        User user = new User(1L, "testy","testy@test.com","password", User.Role.USER, null);

        if(id == 1) {
            return new Post(1L, "A new Post",
                    "this is a brilliant post. 10/10", user, categories);
        }else{
            return null;
        }
    }

    @PostMapping
    private void createPost(@RequestBody Post newPost){

        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());
    }

    @PutMapping("{id}")
    private void updatePost(@PathVariable Long id, @RequestBody Post post){
        System.out.println(post.getTitle());
        System.out.println(post.getContent());
        System.out.println(id);
    }

    @DeleteMapping("{id}")
    private void deletePost(@PathVariable Long id){
        System.out.println(id);
    }

    // curl is for your terminal to try


}
