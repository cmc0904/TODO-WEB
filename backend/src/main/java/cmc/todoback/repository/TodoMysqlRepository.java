package cmc.todoback.repository;

import cmc.todoback.domain.TodoContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class TodoMysqlRepository implements TodoRepository{
    private final JdbcTemplate jdbcTemplate;

    public TodoMysqlRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public TodoContent update(TodoContent todoContent) {
        String sql = "UPDATE hello_todo SET title = ? AND dt = ?";
        int result = jdbcTemplate.update(sql, todoContent.getTitle(), todoContent.getDate());

        return todoContent;
    }

    @Override
    public TodoContent upload(TodoContent todoContent) {
        String sql = "INSERT INTO hello_todo (title, dt) VALUES (?, ?)";
        int result = jdbcTemplate.update(sql, todoContent.getTitle(), todoContent.getDate());

        return todoContent;
    }

    @Override
    public String delete(String id) {
        String sql = "DELETE FROM hello_todo WHERE id = ?";
        int result = jdbcTemplate.update(sql, id);

        return id;
    }


    @Override
    public List<TodoContent> getTodoListByDate(String date) {
        List<TodoContent> result = jdbcTemplate.query(
                "SELECT *, CASE WHEN dt < NOW() THEN '만료됨' ELSE '유효함' END AS st FROM hello_todo WHERE DATE_FORMAT(dt, '%Y%m%d') = ?",
                todoContentRowMapper(), date
        );
        return result;
    }

    private RowMapper<TodoContent> todoContentRowMapper() {
        return (rs, rowNum) -> {
            TodoContent todoContent = new TodoContent();

            todoContent.setDate(rs.getString("dt"));
            todoContent.setId(rs.getInt("id"));
            todoContent.setTitle(rs.getString("title"));

            todoContent.setStatus(rs.getString("st"));

            return todoContent;
        };
    }
}
