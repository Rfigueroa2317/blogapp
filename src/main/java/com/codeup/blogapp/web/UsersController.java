package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.User;
import com.codeup.blogapp.data.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {

   private final UserRepository userRepository;

    public UsersController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping
    private List<User> getUsers() {
        return userRepository.findAll();

    }

    @GetMapping("/{id}")
    private User getUserById(@PathVariable Long id){
        // /api/posts/1
       return userRepository.getById(id);
    }

    @PostMapping
    private void createUser(@RequestBody User newUser){
        System.out.println(newUser.getUsername());
        userRepository.save(newUser);
    }

    @PutMapping("{id}")
    private void updateUser(@PathVariable Long id, @RequestBody User userToUpdate){
//        System.out.println(user.getTitle());
//        System.out.println(user.getContent());
        System.out.println(id);
        userRepository.save(userToUpdate);
    }

    @DeleteMapping("{id}")
    private void deleteUser(@PathVariable Long id){
        System.out.println(id);
        userRepository.deleteById(id);
    }

    @GetMapping("/findByUsername")
    private void findByUsername(@RequestParam String username){
        System.out.println(username);
    }

    @GetMapping("/findByEmail")
    private void findByEmail(@RequestParam String email){
        System.out.println(email);
    }

    @PutMapping("/updatePassword/{id}")
    private void updatePassword(@PathVariable Long id, @RequestParam(required = false) String oldPassword, @Valid @Size(min = 3) @RequestParam String newPassword){
        System.out.println(newPassword);
    }

    // curl is for your terminal to try


}



