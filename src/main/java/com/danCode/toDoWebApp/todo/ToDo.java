package com.danCode.toDoWebApp.todo;

import java.time.LocalDate;


//this info will be mapped to a Database h2 and mysql but first in a static list

public class ToDo {
    private int id;
    private String name;
    private LocalDate targetDate;
    private String description;
    private boolean done;

    public ToDo(int id, String name, LocalDate targetDate, String description, boolean done) {
        this.id = id;
        this.name = name;
        this.targetDate = targetDate;
        this.description = description;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return name;
    }

    public void setUsername(String username) {
        this.name = username;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", username='" + name + '\'' +
                ", targetDate=" + targetDate +
                ", description='" + description + '\'' +
                ", done=" + done +
                '}';
    }
}
