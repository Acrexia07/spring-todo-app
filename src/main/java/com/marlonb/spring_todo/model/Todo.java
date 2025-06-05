package com.marlonb.spring_todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Todo {

    @Id
    @GeneratedValue
    private int id;

    private String username;
    private String description;
    private LocalDate targetDate;
    private String taskStatus;

    public Todo () {}

    public Todo(int id, String username, String description, LocalDate targetDate, String taskStatus) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.taskStatus = taskStatus;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + this.getId() +
                ", username='" + this.getUsername() + '\'' +
                ", description='" + this.getDescription() + '\'' +
                ", targetDate=" + this.getTargetDate() +
                ", taskStatus='" + this.getTaskStatus() + '\'' +
                '}';
    }
}
