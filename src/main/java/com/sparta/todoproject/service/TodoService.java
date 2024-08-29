package com.sparta.todoproject.service;

import com.sparta.todoproject.dto.comment.response.CommentResponseDto;
import com.sparta.todoproject.dto.todo.request.TodoSaveRequestDto;
import com.sparta.todoproject.dto.todo.request.TodoUpdateRequestDto;
import com.sparta.todoproject.dto.todo.response.TodoSaveResponseDto;

import com.sparta.todoproject.dto.todo.response.TodoSimpleResponseDto;
import com.sparta.todoproject.dto.todo.response.TodoUpdateResponseDto;
import com.sparta.todoproject.entity.Comment;
import com.sparta.todoproject.entity.Todo;
import com.sparta.todoproject.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoService {

    private final TodoRepository todoRepository;


    @Transactional
    public TodoSaveResponseDto saveTodo(TodoSaveRequestDto todoSaveRequestDto) {
        Todo newTodo = new Todo(
                todoSaveRequestDto.getTitle(),
                todoSaveRequestDto.getContents()
        );
        Todo savedTodo = todoRepository.save(newTodo);

        return new TodoSaveResponseDto(savedTodo.getId(), savedTodo.getTitle(), savedTodo.getContents());
    }

    public List<TodoSimpleResponseDto> getTodos() {

    }

    List<Todo> todoList = todoRepository.findAll();

    List<TodoSimpleResponseDto> dtoList = new ArrayList<>()
        for(Todo todo :todoList)

    {
        List<Comment> commentList = todo.getComments();
        List<CommentResponseDto> commentdtoList = new ArrayList<>();

        for (Comment comment : commentList) {
            commentdtoList.add(new CommentResponseDto(comment.getId(), comment.getContents))
        }

        TodoSimpleResponseDto dto = new TodoSimpleResponseDto(
                todo.getTitle(),
                todo.getId(),
                commentdtoList
        );

        dtoList.add(dto);
    }
        return dtoList;
}

    @Transactional
    public TodoUpdateResponseDto updateTodo(Long todoId, TodoUpdateRequestDto todoUpdateRequestDto) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("없습니다"));
        todo.update(todoUpdateRequestDto.getTitle(), todoUpdateRequestDto.getContents());
        return new TodoUpdateResponseDto(todo.getId(), todo.getTitle(), todo.getContents());
    }
    @Transactional
    public void deleteTodo(Long todoId) {
        if (todoRepository.existsById(todoId)) {
            throw new NullPointerException("없음");
        }

        todoRepository.deleteById(todoId);
    }
}

