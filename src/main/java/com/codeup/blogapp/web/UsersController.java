package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {

    @GetMapping
    private List<User> getUser() {
        return new ArrayList<User>() {{

            add(new User(1L, "Random",
                    "randomemail", "password", User.Role.USER));

            add(new User(2L, "Random",
                    "random email", "password", User.Role.USER));

            add(new User(3L, "Random",
                    "random email", "password", User.Role.USER));
        }};
    }

    @GetMapping("/{id}")
    private Post getUserById(@PathVariable Long id){
        // /api/posts/1
        if(id == 1) {
            return new Post(1L, "A new User",
                    "this is a brilliant post. 10/10");
        }else{
            return null;
        }
    }

    @PostMapping
    private void createUser(@RequestBody User newUser){
        System.out.println(newUser.getUsername());
    }

    @PutMapping("{id}")
    private void updateUser(@PathVariable Long id, @RequestBody User user){
//        System.out.println(user.getTitle());
//        System.out.println(user.getContent());
        System.out.println(id);
    }

    @DeleteMapping("{id}")
    private void deleteUser(@PathVariable Long id){
        System.out.println(id);
    }

    // curl is for your terminal to try


}



