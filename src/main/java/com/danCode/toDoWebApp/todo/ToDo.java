package com.danCode.toDoWebApp.todo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;


//this info will be mapped to a Database h2 and mysql but first in a static list
//ToDo Bean -> ToDo DataBase TABLE
//will be mapped if I use @Entity by JPA spb automatic configuration automatocally create tables on h2
//if I want to map another name to the table I can just @Entity(name=some)
@Entity(name = "todo")
public class ToDo {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "username") //if want to change column name
    private String userName;
    private LocalDate targetDate;
    @Size(min = 10 , message = "Enter at least 10 characters")
    private String description;
    private boolean done;

    public ToDo(int id, String userName, LocalDate targetDate, String description, boolean done) {
        this.id = id;
        this.userName = userName;
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
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
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
                ", username='" + userName + '\'' +
                ", targetDate=" + targetDate +
                ", description='" + description + '\'' +
                ", done=" + done +
                '}';
    }
}
