package com.sparta.todoproject.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String title;
    private String contents;


    @OneToMany(mappedBy = "todo")
    private List<Comment> comments = new ArrayList<>();


    public Todo(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }




    public void update(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
