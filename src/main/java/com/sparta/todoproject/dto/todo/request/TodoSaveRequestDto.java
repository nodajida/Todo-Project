package com.sparta.todoproject.dto.todo.request;

import lombok.Getter;

@Getter
public class TodoSaveRequestDto {
    private String title;
    private String contents;
    private String username;
}
