package cmc.todoback.service;

import cmc.todoback.domain.TodoContent;
import cmc.todoback.repository.TodoMysqlRepository;
import cmc.todoback.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.time.LocalDate;
import java.time.ZoneId;
@Service
public class TodoService {

    private final TodoMysqlRepository todoRepository;

    public TodoService(TodoMysqlRepository todoMysqlRepository) {
        this.todoRepository = todoMysqlRepository;
    }

    public TodoContent addTodoContent(TodoContent todoContent) {
        todoRepository.upload(todoContent);

        return todoContent;
    }
    public TodoContent updateTodoContent(TodoContent todoContent) {
        todoRepository.update(todoContent);

        return todoContent;
    }

    public String deleteTodoContent(String id) {
        todoRepository.delete(id);

        return id;
    }
    public List<TodoContent> getAllTodoList() {

        LocalDate SeoulNow = LocalDate.now(ZoneId.of("Asia/Seoul"));

        List<TodoContent> result = todoRepository.getTodoListByDate(
                SeoulNow.toString().replace("-", "")
        );

        return result;
    }

    public List<TodoContent> getAllTodoList(String dt) {


        List<TodoContent> result = todoRepository.getTodoListByDate(dt);

        return result;
    }
}
