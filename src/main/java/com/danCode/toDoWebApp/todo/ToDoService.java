package com.danCode.toDoWebApp.todo;

import java.time.LocalDate;
import java.util.List;

public class ToDoService {
    private static List<ToDo> todos;

    static {
        todos.add(new ToDo(1,"mongo db",LocalDate.now().plusYears(1), "learn Mongo DB",false));
        todos.add(new ToDo(2,"AI",LocalDate.now().plusYears(1), "learn AI DB",false));
        todos.add(new ToDo(1,"full stack",LocalDate.now().plusYears(1), "learn more frameworks and architectures",false));
    }

    public  List<ToDo> findByUsername(String username){
        return todos;
    }
}
