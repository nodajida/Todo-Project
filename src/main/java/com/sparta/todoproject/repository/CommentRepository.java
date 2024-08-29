package com.sparta.todoproject.repository;

import com.sparta.todoproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByTodoId(Long id);
}
