package com.restful.webservices.restfulwebservices.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by danielbachvarov on 13/03/2022
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoResource {
    @Autowired // we are wiring this service to the TodoHardCodedService method findAll()
    private TodoHardCodedService todoService ; // creating a service
    @GetMapping ("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username){

        return todoService.findAll();
    }
    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id){
        return todoService.findById(id);
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void>  deleteTod(@PathVariable String username, @PathVariable long id){
        Todo todo =todoService.deleteById(id);
        if(todo !=null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    // Edit/ Update a Todo
    //Put /users/{username}/todos/{id}
    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo){
                Todo to= todoService.save(todo);
                return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }
}
