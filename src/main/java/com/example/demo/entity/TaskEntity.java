package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "task_list")
public class TaskEntity {

    @Id
    @Column(name = "task_id")
    private Long taskId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "task")
    private String task;

    @Column(name = "due_date")
    private LocalDate dueDate;
    
    @Column(name = "priority")
    private int priority;

    @Column(name = "complete_flg")
    private char completeFlg;

    @Column(name = "del_flg")
    private char delFlg;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    // getter / setter
    public Long getTaskId(){
        return taskId;
    }

    public String getTask(){
        return task;
    }

    public LocalDate getDueDate(){
        return dueDate;
    }

    public int getPriority(){
        return priority;
    }

}
