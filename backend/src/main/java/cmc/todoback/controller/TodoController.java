package cmc.todoback.controller;

import cmc.todoback.domain.TodoContent;
import cmc.todoback.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getTodoLists")
    public List<TodoContent> getAllTodoList(){
        List<TodoContent> list = todoService.getAllTodoList();

        return list;
    }

    @PostMapping(path = "/postTodoContent")
    public TodoContent postTodoContent(String title, String dt) {
        System.out.println(title + " " + dt);

        TodoContent todoContent = new TodoContent();

        todoContent.setTitle(title);
        todoContent.setDate(dt);

        todoService.addTodoContent(todoContent);

        return todoContent;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/updateTodoLists")
    public TodoContent updateTodoContent(String title, String dt) {
        TodoContent todoContent = new TodoContent();

        todoContent.setTitle(title);
        todoContent.setDate(dt);

        todoService.addTodoContent(todoContent);

        return todoContent;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/deleteTodoContent")
    public String deleteTodoContent(String id) {
        todoService.deleteTodoContent(id);

        return id;
    }
}
