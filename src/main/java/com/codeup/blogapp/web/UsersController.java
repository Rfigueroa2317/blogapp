package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.User;
import com.codeup.blogapp.data.UserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UsersController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    private List<User> getUsers() {
        return userRepository.findAll();

    }

    @GetMapping("/{id}")
    private User getUserById(@PathVariable Long id) {
        // /api/posts/1
        return userRepository.findById(id).get();
    }

    @GetMapping("/me")
    private User getCurrentUser(OAuth2Authentication authentication){
        String email = authentication.getName();
        return userRepository.findByEmail(email).get();
        // If you get errors this will probably be the reason \\
    }


    @PostMapping
    @PreAuthorize("!hasAuthority('USER')") // new line \\
    private void createUser(@RequestBody User newUser) {
        System.out.println(newUser.getUsername());
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userRepository.save(newUser);
    }

    @PutMapping("{id}")
    private void updateUser(@PathVariable Long id, @RequestBody User userToUpdate) {
//        System.out.println(user.getTitle());
//        System.out.println(user.getContent());
        System.out.println(id);
        userRepository.save(userToUpdate);
    }

    @DeleteMapping("{id}")
    private void deleteUser(@PathVariable Long id) {
        System.out.println(id);
        userRepository.deleteById(id);
    }

    @GetMapping("/findByUsername")
    private User findByUsername(@RequestParam String username, Collection<Post> posts) {
        System.out.println(username);
        if (username.equals("username")) {
            return new User(1L, "username", "username@email.com", "password", User.Role.USER, posts);
        }
        return null;
    }

    @GetMapping("/findByEmail")
    private User findByEmail(@RequestParam String email, Collection<Post> posts) {
        System.out.println(email);
        if (email.equals(" ")) {
            return new User(1L, "username", "username@email.com", "password", User.Role.USER, posts);
        }
        return null;
    }

    @PutMapping("/updatePassword/{id}")
    private void updatePassword(@PathVariable Long id, @RequestParam(required = false) String oldPassword, @Valid @Size(min = 3) @RequestParam String newPassword) {
        System.out.println(newPassword);
        userRepository.getById(id).setPassword(newPassword);
    }

    // curl is for your terminal to try


}



