package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Post;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts",headers = "Accept=application/json")
public class PostsController {

//    @GetMapping
//    private List<Post> getPosts() {
//        return new ArrayList<Post>(){{
//            add(new Post(1L, "A new Post",
//                    "this is a brilliant post. 10/10"));
//            add(new Post(2L, "A new Post",
//                    "this is a brilliant post. 11/10"));
//            add(new Post(3L, "A new Post",
//                    "this is a brilliant post. 12/10"));
//        }};
//    }


    @GetMapping("{id}")
    private Post getPostById(@PathVariable Long id){
        // /api/posts/1
        if(id == 1) {
            return new Post(1L, "A new Post",
                    "this is a brilliant post. 10/10");
        }else{
            return null;
        }
    }

    @GetMapping
    public List<Post> getPosts(){
        return new ArrayList<Post>(){{
            add(new Post(1L, "A new Post",
                    "this is a believable value"));
            add(new Post(2L, "A new Post 2",
                    "this is another believable value"));
            add(new Post(3L, "The new Post 3",
                    "this is the most believable value of the three"));
        }};

    }

}
