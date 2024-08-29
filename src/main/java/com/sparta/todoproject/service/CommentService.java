package com.sparta.todoproject.service;

import com.sparta.todoproject.dto.comment.request.CommentSaveRequestDto;
import com.sparta.todoproject.dto.comment.response.CommentResponseDto;
import com.sparta.todoproject.dto.comment.response.CommentSaveResponseDto;
import com.sparta.todoproject.entity.Comment;

import com.sparta.todoproject.repository.CommentRepository;
import com.sparta.todoproject.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {
    private final TodoRepository todoRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public CommentSaveResponseDto saveComment(Long todoId, CommentSaveRequestDto commentSaveRequestDto) {



        Comment newComment = new Comment(commentSaveRequestDto.getContents(), todo);
        Comment savedComment = commentRepository.save(newComment);

        return new CommentSaveResponseDto(savedComment.getId(), savedComment.getContents());
    }

    public List<CommentResponseDto> getComments() {
        List<Comment> commentList = commentRepository.findAll();

        List<CommentResponseDto> dtoList = new ArrayList<>();
        for (Comment comment : commentList) {
            dtoList.add(new CommentResponseDto(comment.getId(), comment.getContents()));
        }
        return dtoList;
    }
}
