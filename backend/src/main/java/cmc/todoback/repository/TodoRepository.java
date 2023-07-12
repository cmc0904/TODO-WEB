package cmc.todoback.repository;

import cmc.todoback.domain.TodoContent;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
    TodoContent upload(TodoContent todoContent);

    TodoContent update(TodoContent todoContent);

    String delete(String id);
    List<TodoContent> getTodoListByDate(String date);
}
