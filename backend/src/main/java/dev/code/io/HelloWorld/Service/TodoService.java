package dev.code.io.HelloWorld.Service;

import dev.code.io.HelloWorld.models.Todo;
import dev.code.io.HelloWorld.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    //Autowire
    @Autowired
    private TodoRepository todoRepository;

    //Create
    public Todo createTodo(Todo todo){
        return todoRepository.save(todo);
    }

    //Read
    public Todo getTodoById(Integer id){
        return todoRepository.findById(id).orElseThrow(()->new RuntimeException("Todo not found"));
    }

    // Reads page wise
    public Page<Todo> getAllTodosPages(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        return todoRepository.findAll(pageable);
    }

    public List<Todo> getTodos(){
        return  todoRepository.findAll();
    }

    //Update
    public Todo updateTodo(Todo todo){
        return todoRepository.save(todo);
    }

    //Delete
    public  void deleteTodoById(Integer id){

        todoRepository.delete(getTodoById(id));
    }

    public void deleteTodo(Todo todo){
        todoRepository.delete(todo);
    }
}
