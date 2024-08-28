package com.sparta.todoproject.dto.todo.response;

import lombok.Getter;

@Getter
public class TodoSaveResponseDto {
    private final Long id;
    private final String title;
    private final String contents;

    public TodoSaveResponseDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }
}