package com.sparta.todoproject.dto.todo.response;

import lombok.Getter;

@Getter
public class TodoSimpleResponseDto {

    private final Long id;
    private final String title;
    public TodoSimpleResponseDto(String title, Long id) {
        this.title = title;
        this.id = id;
    }


}
