package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.TaskEntity;
import com.example.demo.repository.TaskRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        // TaskRepositoryをフィールドに保存
        this.taskRepository = taskRepository;
    }

    /**
     * セッションからログインユーザーIDを取得する
     *
     * @param session HTTPセッション
     * @return ログインユーザーID
     */
    public String getUserId(HttpSession session) {
        return (String) session.getAttribute("loginUser");
    }

    /**
     * ログインユーザーのタスク一覧を取得する
     *
     * @param userId ログインユーザーID
     * @return タスク一覧
     */
    public List<TaskEntity> getTaskList(String userId) {
        return taskRepository
                .findByUserIdAndCompleteFlgAndDelFlgOrderByTaskIdAsc(
                        userId,
                        '0',
                        '0'
                );
    }
}
