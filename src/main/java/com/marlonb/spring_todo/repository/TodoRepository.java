package com.marlonb.spring_todo.repository;

import com.marlonb.spring_todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

    List<Todo> findByUsername (String username);
}
