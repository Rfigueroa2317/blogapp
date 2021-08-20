package com.codeup.blogapp.data;

import javax.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name="posts")
public class Post {

@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String title;

    @Column(nullable = false)
    private String content;

    @OneToOne
    private User user;

    private Collection<Category> categories;

    public Post(Long id, String title, String content, User user, Collection<Category> categories) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
        this.categories = categories;
    }

    public Post(String title, String content){
        this.title = title;
        this.content = content;
    }

    public Post(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCategories(Collection<Category> categories) {
        this.categories = categories;
    }

    public Collection<Category> getCategories() {
        return categories;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<PostImage> images;

    @Entity
    @Table(name = "post_images")
    public class PostImage {
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(nullable = false)
        private String path;

        @ManyToOne
        @JoinColumn (name = "post_id")
        private Post post;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="post_category",
            joinColumns={@JoinColumn(name="post_id")},
            inverseJoinColumns={@JoinColumn(name="category_id")}
    )
    private List<PostCategory> categories;

    @Entity
    @Table(name="categories")
    public class Category {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(nullable = false)
        private String name;

        @ManyToMany(mappedBy = "categories")
        private List<Post> posts;
    }


}


