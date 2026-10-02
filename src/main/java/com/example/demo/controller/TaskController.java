package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.service.TaskService;
import com.example.demo.model.TaskListDisp;

import jakarta.servlet.http.HttpSession;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        // TaskServiceをフィールドに保存
        this.taskService = taskService;
    }

    /**
     * メイン画面を表示する
     *
     * @param session HTTPセッション
     * @param model 画面へ渡すデータ
     * @return メイン画面
     */
    @GetMapping("/main")
    public String dispMain(HttpSession session, Model model) {

        // ログインチェック
        if (session.getAttribute("loginUser") == null) {
            return "redirect:/login";
        }

        // ログインユーザーIDを取得
        String userId = taskService.getUserId(session);

        // タスク一覧を取得
        List<TaskListDisp> taskList = taskService.getTaskList(userId);

        // 画面へタスク一覧を渡す
        model.addAttribute("taskList", taskList);

        return "main";
    }
}
