package com.danCode.toDoWebApp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class ToDoService {
    private static List<ToDo> todos = new ArrayList<>();

    private static int toDosCount=0;
    static {
        todos.add(new ToDo(++toDosCount,"sofi",LocalDate.now().plusYears(1), "learn Mongo DB",false));
        todos.add(new ToDo(++toDosCount,"sofi",LocalDate.now().plusYears(1), "learn AI DB",false));
        todos.add(new ToDo(++toDosCount,"dani",LocalDate.now().plusYears(1), "learn more frameworks and architectures",false));
    }

    public  List<ToDo> findByUsername(String username){
        return todos;
    }
    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
        ToDo todo=new ToDo(++toDosCount,username,targetDate,description,done);
        todos.add(todo);
    }

}
