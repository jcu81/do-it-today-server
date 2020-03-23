package onsite.doit2day.doit2day;

import onsite.doit2day.doit2day.data.Todo;
import onsite.doit2day.doit2day.repositories.TodoRepository;
import onsite.doit2day.doit2day.service.ITodoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Doit2dayApplicationTests {

	@Autowired
	TodoRepository todoRepository;

	@Autowired
	ITodoService todoService;

	@Test
	void contextLoads() {
	}

	@Test void todoRepoAddToDB() {
		this.todoRepository.deleteAll();
		List<Todo> todos = new ArrayList<Todo>();
		Todo t = new Todo();
		t.setTitle("Blumen kaufen");
		t.setCompleted(Boolean.FALSE);
		todos.add(t);
		this.todoRepository.saveAll(todos);

		List<Todo> todosFromRepo = this.todoRepository.findAll();
		assert (null!= todosFromRepo);
		assert(todosFromRepo.size() == 1);
	}

	@Test
	public void saveNewTodoWithService(){
		// amount before
		long amountBefore = todoRepository.count();


		// create a new todo
		final Todo newTodo = new Todo();
		newTodo.setCompleted(false);
		newTodo.setImportant(false);
		newTodo.setDescription("Grillen im Garten");
		newTodo.setTitle("Grillen");
		newTodo.setUrgent(false);

		// save
		todoService.saveTodo(newTodo);
		long amountAfter = todoRepository.count();
		assert(amountAfter-amountBefore == 1);
	}
}
