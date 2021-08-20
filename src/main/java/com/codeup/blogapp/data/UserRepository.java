package com.codeup.blogapp.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Post, Long> {


}
