package onsite.doit2day.doit2day.service;

import onsite.doit2day.doit2day.data.Todo;
import onsite.doit2day.doit2day.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements ITodoService {

    @Autowired
    TodoRepository todoRepo;


    @Override
    public List<Todo> getTodos() {
        return todoRepo.findAll();
    }

    @Override
    public Optional<Todo> getTodo(Long id) {
        return todoRepo.findById(id);
    }

    @Override
    public List<Todo> getTodosCompleted() {
        return todoRepo.findAllByCompleted(true);
    }

    @Override
    public void saveTodo(Todo todo) {
        todoRepo.save(todo);
    }

    @Override
    public void saveTodoList(List<Todo> todoList) {
        todoRepo.saveAll(todoList);
    }

    @Override
    public void deleteTodo(Long id) {
        todoRepo.deleteById(id);
    }

    @Override
    public void deleteTodo(Todo todo) {
        todoRepo.delete(todo);
    }

    @Override
    public void saveAllTodos(List<Todo> todos) {
        todoRepo.saveAll(todos);
    }
}
