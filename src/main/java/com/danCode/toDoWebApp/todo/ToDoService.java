package com.danCode.toDoWebApp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class ToDoService {
    private static List<ToDo> todos = new ArrayList<>();

    static {
        todos.add(new ToDo(1,"sofi",LocalDate.now().plusYears(1), "learn Mongo DB",false));
        todos.add(new ToDo(2,"sofi",LocalDate.now().plusYears(1), "learn AI DB",false));
        todos.add(new ToDo(1,"sofi",LocalDate.now().plusYears(1), "learn more frameworks and architectures",false));
    }

    public  List<ToDo> findByUsername(String username){
        return todos;
    }
}
