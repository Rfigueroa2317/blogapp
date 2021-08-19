package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {


    @GetMapping
    private List<User> getUsers() {
        User user = new User(1L,"hello","random email","password", User.Role.USER, null);
        List<Post> posts = new ArrayList<>(){{
            add(new Post(1L, "Random",
                    "random email", user));

            add(new Post(2L, "Random",
                    "random email", user));

            add(new Post(3L, "Random",
                    "random email", user));
        }};
        return new ArrayList<>() {{
            add(new User(1L, "Random",
                    "random email", "password", User.Role.USER, posts));

            add(new User(2L, "Random",
                    "random email", "password", User.Role.USER, posts));

            add(new User(3L, "Random",
                    "random email", "password", User.Role.USER, posts));
        }};
    }

    @GetMapping("/{id}")
    private User getUserById(@PathVariable Long id){
        // /api/posts/1
        if(id == 1) {
            return new User(1L, "Random",
                    "random email", "password", User.Role.USER, null);
        }else{
            return null;
        }
    }

//    @PostMapping
//    private void createUser(@RequestBody User newUser){
//        System.out.println(newUser.getUsername());
////        return new User;
//    }
//
//    @PutMapping("{id}")
//    private void updateUser(@PathVariable Long id, @RequestBody User user){
////        System.out.println(user.getTitle());
////        System.out.println(user.getContent());
//        System.out.println(id);
//
//    }
//
//    @DeleteMapping("{id}")
//    private void deleteUser(@PathVariable Long id){
//        System.out.println(id);
////        return new User;
//    }

//    @RequestMapping
//    private void findByUsername(@RequestParam String username){
//        System.out.println(username);
//    }
//
//    @RequestMapping
//    private void findByEmail(@RequestParam String email){
//        System.out.println(email);
//    }
//
//    @RequestMapping
//    private void updatePassword(@PathVariable Long id, @RequestParam(required = false) String oldPassword, @Valid @Size(min = 3) @RequestParam String newPassword){
//        System.out.println(newPassword);
//    }

    // curl is for your terminal to try


}



