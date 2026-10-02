package com.example.demo.model;

import java.time.LocalDate;

// ToDoを画面に表示するようのクラス
public class TaskListDisp {

    private String task;
    private LocalDate dueDate;
    private String priority;


    //  コンストラクタ
    public TaskListDisp(String task, LocalDate dueDate, String priority) {
        this.task = task;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    // getter
    public String getTask(){
        return task;
    }

    public LocalDate getDueDate(){
        return dueDate;
    }

    public String getPriority(){
        return priority;
    }


}
