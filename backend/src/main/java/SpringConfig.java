import cmc.todoback.repository.TodoMysqlRepository;
import cmc.todoback.repository.TodoRepository;
import cmc.todoback.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Bean
    public TodoService todoService() {
        return new TodoService(todoMysqlRepository());
    }

    @Bean
    public TodoMysqlRepository todoMysqlRepository() {
        return new TodoMysqlRepository(dataSource);
    }
}
