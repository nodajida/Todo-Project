package com.sparta.todoproject.dto.todo.response;

import com.sparta.todoproject.dto.comment.response.CommentResponseDto;
import com.sparta.todoproject.entity.Comment;
import lombok.Getter;
import org.hibernate.annotations.Comments;

import java.util.List;

@Getter
public class TodoSimpleResponseDto {

    private final Long id;
    private final String title;
    private final List<CommentResponseDto> comments;


    public TodoSimpleResponseDto(String title, Long id, List<CommentResponseDto> comments) {
        this.title = title;
        this.id = id;
        this.comments = comments;
    }


}
