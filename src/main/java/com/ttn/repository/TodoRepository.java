package com.ttn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ttn.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
} 