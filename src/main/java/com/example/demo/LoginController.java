package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.AuthenticationService;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;

@Controller
public class LoginController {

    private final AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/login")
    public String dispLogin(
        @RequestParam(required = false) String error,
        Model model) {

        if ("true".equals(error)) {
            model.addAttribute("errorMessage",
                    "ユーザーIDまたはパスワードが違います");
        }
        return "login";
    }


    // @GetMapping("/login")
    // public String dispLogin() {
    //     return "login";
    // }

    @PostMapping("/login")
    public String execLogin(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session) {

        // DBのユーザー情報を使ってログイン認証
        if (authenticationService.authenticate(username, password)) {

            // ログイン状態をSessionに保存
            session.setAttribute("loginUser", username);

            // メイン画面へリダイレクト
            return "redirect:/main";
        }

        // ログイン失敗の場合は、エラーを返す
        return "redirect:/login?error=true";
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
    public String execLogout(HttpSession session) {

        session.invalidate();

        // loginページへ
        return "redirect:/login";
    }
}