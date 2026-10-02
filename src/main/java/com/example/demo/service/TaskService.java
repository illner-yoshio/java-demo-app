package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.TaskEntity;
import com.example.demo.model.TaskListDisp;
import com.example.demo.repository.TaskRepository;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

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
    public List<TaskListDisp> getTaskList(String userId) {
        // DBから未完了・未削除のタスクを取得する
        List<TaskEntity> taskList = 
        taskRepository
            .findByUserIdAndCompleteFlgAndDelFlgOrderByTaskIdAsc(
                userId,
                '0',
                '0'
                );

        //  画面表示用のリストを作成
        List<TaskListDisp> taskListDisp = new ArrayList<>();

        // TaskEntityを1件ずつTaskListDispに変換してリストに追加
        taskList.forEach(taskEntity -> {
            TaskListDisp disp = convertToDisp(taskEntity);
            taskListDisp.add(disp);
        });

        return taskListDisp;
    }

    /**
     * priorityを画面表示用に変換する
     */

    public TaskListDisp convertToDisp(TaskEntity taskEntity){

        String task = taskEntity.getTask();
        LocalDate dueDate = taskEntity.getDueDate();
        int priority = taskEntity.getPriority();
        String priorityConverted;

        switch (priority) {
            case 1:
                priorityConverted = "高";
                break;

            case 2:
                priorityConverted = "中";
                break;

            case 3:
                priorityConverted = "低";
                break;

            default:
                priorityConverted = "その他";
                break;
        }

        TaskListDisp taskListDisp = new TaskListDisp(task,dueDate,priorityConverted);
        return taskListDisp;

    }

}
