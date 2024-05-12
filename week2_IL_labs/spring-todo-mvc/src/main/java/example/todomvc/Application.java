
package example.todomvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.map.repository.config.EnableMapRepositories;

@SpringBootApplication
@EnableMapRepositories
public class Application {

	public static void main(String[] args) throws Exception {

		var context = SpringApplication.run(Application.class, args);
		var todos = context.getBean(Todos.class);

		todos.save(new Todo("Completed").toggleCompletion());
		todos.save(new Todo("Incomplete"));
	}
}
