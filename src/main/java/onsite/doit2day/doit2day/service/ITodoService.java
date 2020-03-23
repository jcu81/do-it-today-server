package onsite.doit2day.doit2day.service;

import onsite.doit2day.doit2day.data.Todo;

import java.util.List;
import java.util.Optional;

public interface ITodoService {

    public List<Todo> getTodos();
    public Optional<Todo> getTodo(Long id);
    public List<Todo> getTodosCompleted();
    public void saveTodo(Todo todo);
    public void saveTodoList(List<Todo> todoList);
    public void deleteTodo(Long id);
    public void deleteTodo(Todo todo);
    public void saveAllTodos(List<Todo> todos);
}
