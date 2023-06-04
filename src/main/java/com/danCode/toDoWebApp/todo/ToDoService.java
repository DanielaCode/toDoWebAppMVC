package com.danCode.toDoWebApp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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

    public void deleteById(int id){
        Predicate<? super ToDo> predicate=todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public ToDo findById(int id) {
        Predicate<? super ToDo> predicate=todo -> todo.getId() == id;
        ToDo todo=todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(ToDo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}
