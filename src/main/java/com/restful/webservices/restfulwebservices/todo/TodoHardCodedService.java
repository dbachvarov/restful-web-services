package com.restful.webservices.restfulwebservices.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by danielbachvarov on 13/03/2022
 */
@Service // what is this about,Spring component
public class TodoHardCodedService {
    // creating static list of todos, this will act as our dataBase
    private static List<Todo> todos= new ArrayList<>();
    private static int idCounter = 0;

    static {
        todos.add(new Todo(++idCounter,"iceKing","learn to dance", new Date(), true  ));
        todos.add(new Todo(++idCounter,"iceKing","learn to React", new Date(), true  ));
        todos.add(new Todo(++idCounter,"iceKing","learn to AWSConnect", new Date(), true  ));
    }
    public List<Todo> findAll(){
        return todos;
    }
    // used for updates and inserts as well
    public Todo save(Todo t) { // this method is just a shortcut for the exercise
        if (t.getId() == -1) {
            t.setId(++idCounter);
            todos.add(t);
        } else {
            deleteById(t.getId());
            todos.add(t);
        }
        return null;
    }
    public Todo deleteById(long id){
        Todo todo= findById(id);
        if(todo != null) {
            todos.remove(todo);
            return todo;
        }
        return null;
    }

    public Todo findById(long id){
        for(Todo d: todos){
            if(d.getId()== id ){
                return d;
            }
        }
        return null;
    }


}
