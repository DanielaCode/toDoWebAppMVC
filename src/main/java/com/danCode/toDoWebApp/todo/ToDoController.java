package com.danCode.toDoWebApp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;

@Controller
@SessionAttributes("name")
public class ToDoController {

    private ToDoService todoService;

    public ToDoController(ToDoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
        model.put("todos",todoService.findByUsername("name"));
        return "listToDos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model) {
        String username = (String)model.get("name");
        ToDo todo = new ToDo(0, username, LocalDate.now().plusYears(1), "j", false);
        model.put("todo", todo);
        return "toDo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    //public String addNewTodo(@RequestParam String description,ModelMap model){
        //but what happens if I have a form and I need to catch a lot of parameters i should use a request-param for each, so it is not the best approach so I can bind it directly to ToDo.java

    public String addNewTodo(ModelMap model, @Valid ToDo todo, BindingResult result){
        if (result.hasErrors()){
            return "toDo";
        }

        todoService.addTodo((String)model.get("name"),todo.getDescription(), LocalDate.now().plusYears(1),false);

        //return "listToDos"; if I let like this whe return to list-todos it will be empty
        return "redirect:list-todos";
    }
}
