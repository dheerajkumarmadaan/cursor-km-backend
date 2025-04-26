package com.ttn.service;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ttn.common.enums.ErrorCode;
import com.ttn.common.exception.TTNException;
import com.ttn.model.Todo;
import com.ttn.repository.TodoRepository;

@Service
@Transactional
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo createTodo(Todo todo) {
        if (todo.getTitle() == null || todo.getTitle().trim().isEmpty()) {
            throw new TTNException(ErrorCode.MISSING_REQUIRED_FIELD);
        }
        return todoRepository.save(todo);
    }

    public Todo getTodoById(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new TTNException(ErrorCode.RESOURCE_NOT_FOUND));
    }

    public Todo updateTodo(Long id, Todo todoDetails) {
        Todo todo = getTodoById(id);
        todo.setTitle(todoDetails.getTitle());
        todo.setDescription(todoDetails.getDescription());
        todo.setCompleted(todoDetails.isCompleted());
        return todoRepository.save(todo);
    }

    public void deleteTodo(Long id) {
        Todo todo = getTodoById(id);
        todoRepository.delete(todo);
    }

    public ResponseEntity<Resource> downloadTodoAsTxt(Long id) {
        Todo todo = getTodoById(id);
        
        StringBuilder content = new StringBuilder();
        content.append("Title: ").append(todo.getTitle()).append("\n");
        content.append("Description: ").append(todo.getDescription()).append("\n");
        content.append("Status: ").append(todo.isCompleted() ? "Completed" : "Pending").append("\n");
        
        byte[] contentBytes = content.toString().getBytes(StandardCharsets.UTF_8);
        ByteArrayResource resource = new ByteArrayResource(contentBytes);
        
        String filename = "todo_" + id + ".txt";
        
        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                .body(resource);
    }

    public ResponseEntity<Resource> downloadAllTodosAsTxt() {
        List<Todo> todos = getAllTodos();
        if (todos.isEmpty()) {
            throw new TTNException(ErrorCode.RESOURCE_NOT_FOUND);
        }
        
        StringBuilder content = new StringBuilder();
        content.append("All Todos\n\n");
        
        todos.forEach(todo -> {
            content.append("ID: ").append(todo.getId()).append("\n");
            content.append("Title: ").append(todo.getTitle()).append("\n");
            content.append("Description: ").append(todo.getDescription()).append("\n");
            content.append("Status: ").append(todo.isCompleted() ? "Completed" : "Pending").append("\n");
            content.append("\n");
        });
        
        byte[] contentBytes = content.toString().getBytes(StandardCharsets.UTF_8);
        ByteArrayResource resource = new ByteArrayResource(contentBytes);
        
        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"all_todos.txt\"")
                .body(resource);
    }
} 