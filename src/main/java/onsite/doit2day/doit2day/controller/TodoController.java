package onsite.doit2day.doit2day.controller;

import onsite.doit2day.doit2day.data.Todo;
import onsite.doit2day.doit2day.service.ITodoService;
import onsite.doit2day.doit2day.service.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/service")
public class TodoController {
    // Hier müssen wir einen Service injeziert bekommen.
    // Evtl. gibt es den Service noch nicht...
    // Der Service soll im service Package leben.
    // Der Service soll das Repo benutzen.
    @Autowired
    ITodoService todoService;



    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return todoService.getTodos();
    }

    @GetMapping("/todo/{id}")
    public Todo getTodo(@PathVariable("id") Long id) {
        return todoService.getTodo(id).get();
    }

    @PostMapping("/todo")
    public String saveTodo(@RequestBody Todo todo) {
        System.out.println("Todo to save: "+todo);
        todoService.saveTodo(todo);
        return "";
    }

    @PostMapping("/todos")
    public String saveTodos(@RequestBody List<Todo> todos) {
        System.out.println("saved todos amount: "+todos.size());
        todoService.saveAllTodos(todos);
        return "";
    }

    @PutMapping("/todo")
    public String updateTodo(@RequestBody Todo todo) {
        System.out.println("Todo to update: "+todo);
        todoService.saveTodo(todo);
        return "";
    }

    @DeleteMapping("/todo/{id}")
    public String deleteTodo(@PathVariable("id") Long id) {
        todoService.deleteTodo(id);
        return "";
    }
    @DeleteMapping("/todo")
    public String deleteTodo(@RequestBody Todo todo) {
        todoService.deleteTodo(todo);
        return "";
    }
}
