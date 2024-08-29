package com.sparta.todoproject.controller;


import com.sparta.todoproject.dto.comment.request.CommentSaveRequestDto;
import com.sparta.todoproject.dto.comment.response.CommentResponseDto;
import com.sparta.todoproject.dto.comment.response.CommentSaveResponseDto;
import com.sparta.todoproject.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/todos/{todoId}/comments")
    public CommentSaveResponseDto saveComment(@PathVariable Long todoId, @RequestBody CommentSaveRequestDto commentSaveRequestDto) {
        return commentService.saveComment(todoId, commentSaveRequestDto);
    }

    @GetMapping("/todos/comments")
    public List<CommentResponseDto> getComments() {
        return commentService.getComments();
    }
}

