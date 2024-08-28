package com.sparta.todoproject.service;

import com.sparta.todoproject.dto.todo.request.TodoSaveRequestDto;
import com.sparta.todoproject.dto.todo.request.TodoUpdateRequestDto;
import com.sparta.todoproject.dto.todo.response.TodoSaveResponseDto;
import com.sparta.todoproject.dto.todo.response.TodoSimpleResponseDto;
import com.sparta.todoproject.dto.todo.response.TodoUpdateResponseDto;
import com.sparta.todoproject.entity.Todo;
import com.sparta.todoproject.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoService {

    private final TodoRepository todoRepository;


    @Transactional
    public TodoSaveResponseDto saveTodo(TodoSaveRequestDto todoSaveRequestDto) {
        Todo newTodo = new Todo(
                TodoSaveRequestDto.getTitle(),
                TodoSaveRequestDto.getContents()
        );
        Todo savedTodo = TodoRepository.save(newTodo);

        return new TodoSaveResponseDto(savedTodo.getId(), savedTodo.getTitle(), savedTodo.getContents());
    }

    public static Page<TodoSimpleResponseDto> getTodos(int page, int size) {
    }

    @Transactional
    public TodoUpdateResponseDto updateTodo(Long boardId, TodoUpdateRequestDto boardUpdateRequestDto) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("없습니다"));
        todo.update(todoUpdateRequestDto.getTitle(), todoUpdateRequestDto.getContents());

    }

    public void deleteTodo(Long boardId) {
    }
}
