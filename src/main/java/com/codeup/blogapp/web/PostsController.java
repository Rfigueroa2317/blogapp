package com.codeup.blogapp.web;


import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.PostsRepository;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "/api/posts",headers = "Accept=application/json")
public class PostsController {

    private final PostsRepository postsRepository;

   public PostsController(PostsRepository postsRepository){
       this.postsRepository = postsRepository;
   }

    @GetMapping
    private List<Post> getPosts() {
        return postsRepository.findAll();
    }


    @GetMapping("/{id}")
    private Post getPostById(@PathVariable Long id){
        // /api/posts/1
        return postsRepository.getById(id);
    }

    @PostMapping
    private void createPost(@RequestBody Post newPost){
        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());
        postsRepository.save(newPost);
    }

    @PutMapping("{id}")
    private void updatePost(@PathVariable Long id, @RequestBody Post postToUpdate){
        System.out.println(postToUpdate.getTitle());
        System.out.println(postToUpdate.getContent());
        System.out.println(id);
        postsRepository.save(postToUpdate);
    }

    @DeleteMapping("{id}")
    private void deletePost(@PathVariable Long id){
        System.out.println(id);
        postsRepository.deleteById(id);
    }

    // curl is for your terminal to try


}
