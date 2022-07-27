package com.example.demo.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  int Id;

    @NotNull(message = "待辦事項不可為空")
    private String taskName;

    private boolean isCompleted = false;

    private Timestamp deadlineTime;

    @CreationTimestamp
    private Timestamp createdAt;

    public String getTaskName() {
        return taskName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Timestamp getDeadlineTime() {
        return deadlineTime;
    }

    public void setDeadlineTime(Timestamp deadlineTime) {
        this.deadlineTime = deadlineTime;
    }

    @UpdateTimestamp
    private Timestamp updatedAt;
}
