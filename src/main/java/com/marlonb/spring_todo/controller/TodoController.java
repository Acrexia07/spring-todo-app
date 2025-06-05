package com.marlonb.spring_todo.controller;

import com.marlonb.spring_todo.model.Todo;
import com.marlonb.spring_todo.repository.TodoRepository;
import jakarta.validation.Valid;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class TodoController {

    private TodoRepository todoRepository;

    public TodoController (TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // todos.jsp: Main page (Display list of to-do tasks)
    @RequestMapping(value = "main-page")
    public String viewMainTodoPage (ModelMap modelMap) {

        String username = getLoggedInByUsername(modelMap);

        List<Todo> todoList = todoRepository.findByUsername(username);

        modelMap.addAttribute("todos", todoList);

        return "todos";
    }

    // Default to-do contents: mapping with GET Httpmethod
    @RequestMapping(value = "add-new-task", method = RequestMethod.GET)
    public String displayDefaultTodoContent (ModelMap modelMap) {

        String username = getLoggedInByUsername(modelMap);

        var defaultTodoContent = new Todo(0,
                                          username,
                                          "",
                                          LocalDate.now(),
                                          "Not started");

        // insert default values on the to-do item
        modelMap.put("todo", defaultTodoContent);

        return "todo-item";
    }

    // To-do task: ADD ITEM
    @RequestMapping(value = "add-new-task", method = RequestMethod.POST)
    public String addNewTodoTask (ModelMap modelMap,
                                  @Valid Todo todo,
                                  BindingResult result) {

        if (result.hasErrors()) {
            return "todo-item";
        }

        String username = getLoggedInByUsername(modelMap);

        todo.setUsername(username);
        todoRepository.save(todo);

        return "redirect:main-page";
    }

    // To-do task: UPDATE ITEM
    @RequestMapping(value = "update-task", method = RequestMethod.GET)
    public String viewTodoItemToUpdate (ModelMap modelMap,
                                        @RequestParam int id) {

        String username = getLoggedInByUsername(modelMap);

        var todo = todoRepository.findById(id).get();

        modelMap.addAttribute(todo);

        return "todo-item";
    }

    // To-do task: SAVE UPDATED ITEM
    @RequestMapping(value = "update-task", method = RequestMethod.POST)
    public String saveUpdatedTodoTask (ModelMap modelMap,
                                       @Valid Todo todo,
                                       BindingResult result) {

        String username = getLoggedInByUsername(modelMap);

        todo.setUsername(username);

        todoRepository.save(todo);

        return "redirect:main-page";
    }

    // To-do task: DELETE ITEM
    @RequestMapping("delete-task")
    public String deleteTodoTaskByID (@RequestParam int id) {

        //Delete to-do task item
        todoRepository.deleteById(id);

        return "redirect:main-page";
    }

    // Returns the username of the currently authenticated user from the security context.
    public String getLoggedInByUsername (ModelMap modelMap) {

        var authentication = SecurityContextHolder.getContext()
                                                  .getAuthentication();
        return authentication.getName();
    }
}
