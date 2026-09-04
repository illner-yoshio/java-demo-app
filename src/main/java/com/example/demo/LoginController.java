package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String dispLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String execLogin(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session) {

        // 仮のログイン認証
        if ("admin".equals(username) && "password".equals(password)) {

            // ログイン状態をSessionに保存
            session.setAttribute("loginUser", username);

            // メイン画面へリダイレクト
            return "redirect:/main";
        }

        // ログイン失敗の場合は、ログイン画面へ 
        return "redirect:/login";
    }

    @GetMapping("/main")
    public String dispMain(HttpSession session) {

        // Sessionにログイン情報がなければ、loginページにリダイレクトする。
        if (session.getAttribute("loginUser") == null) {
            return "redirect:/login";
        }
        
        return "main";
    }

    @PostMapping("/logout") 
    public String execLogout(HttpSession session){

        session.invalidate();

        // loginページへ
        return "redirect:/login";
    }
}
