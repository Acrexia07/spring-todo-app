package com.marlonb.spring_todo.service;

import com.marlonb.spring_todo.model.Todo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();
    private static int taskCount = 0;
    // todos.jsp: Service to the Main page (Display list of to-do tasks)
    public List<Todo> findByUsername (String username) {

        Predicate<? super Todo> predicate =
                todo -> todo.getUsername().equals(username);

        return todos.stream().filter(predicate).toList();
    }

    /*--- To-do Operations Services ---*/

    // Add item service
    public void addNewTask (String username,
                           String description,
                           LocalDate targetDate,
                           String taskStatus) {

        var newTodoTask = new Todo (++taskCount,
                                    username,
                                    description,
                                    targetDate,
                                    taskStatus);
        todos.add(newTodoTask);
    }

    // Delete item service
    public void deleteTaskById (int id) {

        Predicate<? super Todo> predicate =
                todo -> todo.getId() == id;

        todos.removeIf(predicate);
    }

    //Update selected item service
    public Todo findTaskForUpdateById (int id) {

        Predicate<? super Todo> predicate =
                todo -> todo.getId() == id;

        return todos.stream()
                        .filter(predicate)
                        .findFirst()
                        .get();
    }

    public void saveUpdatedTodoTask (@Valid Todo todo) {
        deleteTaskById(todo.getId());
        todos.add(todo);
    }
}
