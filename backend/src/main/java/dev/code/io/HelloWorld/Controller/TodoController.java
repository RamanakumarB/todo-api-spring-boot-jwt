package dev.code.io.HelloWorld.Controller;

import dev.code.io.HelloWorld.Service.TodoService;
import dev.code.io.HelloWorld.models.Todo;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/v1/Todo")
@Slf4j
public class TodoController {
    @Autowired
    private TodoService todoService;
//    @GetMapping("/get")
//    String getTodo(){
//        return "Todo";
//    }

    // Path Variable
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Todo Retrieved Successfully"),
            @ApiResponse(responseCode = "404", description = "Todo was not found !!")
    })
    @GetMapping("/{id}")
    ResponseEntity<Todo> getTodoById(@PathVariable int id){
        try {
            Todo createdTodo=todoService.getTodoById(id);
            return new ResponseEntity<>(createdTodo, HttpStatus.OK);
        } catch (RuntimeException exception) {
            log.info("error");
            log.warn("");
            log.error("",exception);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    ResponseEntity<List<Todo>>getTodos(){
        return new ResponseEntity<List<Todo>>(todoService.getTodos(),HttpStatus.OK);
    }

    @GetMapping("/page")
    ResponseEntity<Page<Todo>> getTodosPaged(@RequestParam int page, @RequestParam int size){
        return new ResponseEntity<>(todoService.getAllTodosPages(page,size),HttpStatus.OK);

    }





//    //Request Param
//    @GetMapping
//    String getTodoByIdParam(@RequestParam("TodoId") int id){
//        return "Todo with Id " + id;
//    }


    @PostMapping("/create")
    ResponseEntity<Todo> createUser(@RequestBody Todo todo){
            Todo createdTodo=todoService.createTodo(todo);
            return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);
    }

    @PutMapping
    ResponseEntity<Todo> updateTodoById(@RequestBody Todo todo){
        return new ResponseEntity<>(todoService.updateTodo(todo),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteTodoById(@PathVariable int id){
        todoService.deleteTodoById(id);
    }
}
