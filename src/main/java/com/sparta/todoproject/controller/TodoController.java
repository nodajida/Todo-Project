package com.sparta.todoproject.controller;


import com.sparta.todoproject.dto.todo.request.TodoSaveRequestDto;
import com.sparta.todoproject.dto.todo.request.TodoUpdateRequestDto;
import com.sparta.todoproject.dto.todo.response.TodoSaveResponseDto;
import com.sparta.todoproject.dto.todo.response.TodoSimpleResponseDto;
import com.sparta.todoproject.dto.todo.response.TodoUpdateResponseDto;
import com.sparta.todoproject.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todos")
    public ResponseEntity<TodoSaveResponseDto> saveBoard(@RequestBody TodoSaveRequestDto boardSaveRequestDto) {
        return ResponseEntity.ok(todoService.saveTodo(boardSaveRequestDto));
    }

    @GetMapping("/todos")
    public ResponseEntity<Page<TodoSimpleResponseDto>> getBoards(
            @RequestParam(defaultValue = "1", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int size
    ) {
        return ResponseEntity.ok(TodoService.getTodos(page, size));
    }

    @PutMapping("/todos/{todoId}")
    public ResponseEntity<TodoUpdateResponseDto> updateBoard(@PathVariable Long todoId, @RequestBody TodoUpdateRequestDto todoUpdateRequestDto) {
        return ResponseEntity.ok(todoService.updateTodo(todoId, todoUpdateRequestDto));
    }

    @DeleteMapping("/todos/{todoId}")
    public void deleteBoard(@PathVariable Long todoId) {
        todoService.deleteTodo(todoId);
    }
}
