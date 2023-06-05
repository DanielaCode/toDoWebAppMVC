package com.danCode.toDoWebApp.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;


@Controller
@SessionAttributes("name")
public class ToDoControllerJpa {

    private  ToDoRepository toDoRepository;

    public ToDoControllerJpa(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
        List<ToDo> todos = toDoRepository.findByUserName(getLoggedInUserName());
        model.put("todos",todos);
        return "listToDos";
    }


    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model) {
        String username = getLoggedInUserName();
        ToDo todo = new ToDo(0, username, LocalDate.now().plusYears(1), "", false);
        model.addAttribute("todo", todo);
        return "toDo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid ToDo todo, BindingResult result){
        if (result.hasErrors()){
            return "redirect:add-todo";
        }
        todo.setUserName(getLoggedInUserName());
        toDoRepository.save(todo);
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id){
        toDoRepository.deleteById(id);
        return "redirect:list-todos";
    }
    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodo(@RequestParam int id,ModelMap model){
        ToDo todo= toDoRepository.findById(id).get();
        model.addAttribute("todo",todo);
        return "toDo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid ToDo todo, BindingResult result){
        if (result.hasErrors()){
            return "toDo";
        }
        String userName=getLoggedInUserName();;
        todo.setUserName(userName);
        toDoRepository.save(todo);
        return "redirect:list-todos";
    }

    private String getLoggedInUserName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
}
