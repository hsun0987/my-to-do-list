package com.kitri.mytodolist.login;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/login")
public class LoginController {
    static HashMap<String, SignupFormDto> member = new HashMap<String, SignupFormDto>(){
        {
            put("123@naver.com", new SignupFormDto("123@naver.com", "키트리", "kitri123!", "kitri123!"));
        }
    };

    @GetMapping("")
    public String loginHome(){
        return "redirect:/login/login.html";
    }
    @PostMapping("")
    public String login(@Valid LoginDto form, BindingResult bindingResult, HttpServletRequest request, HttpServletRequest response){
        if(bindingResult.hasErrors()) {
            return "redirect:/login/fail.html";
        }
        if(member.containsKey(form.email) && member.get(form.email).getPw1().equals(form.pw)){
            HttpSession session = request.getSession();
            session.setAttribute("id", form);
            return "todo/todos";
        }
        return "redirect:/login/fail.html";
    }
    @GetMapping("/signup")
    public String sigupHome(){
        return "redirect:/join/signup.html";
    }
    @PostMapping("/signup")
    public String signup(@Valid SignupFormDto form, BindingResult bindingResult){
       if(bindingResult.hasErrors()) {
           return "redirect:/join/signup.html";
       }
       if(!member.containsKey(form.email) && form.pw1.equals(form.pw2)){
           member.put(form.email, form);
       }
        return "redirect:/join/join.html";
    }
    @PostMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session != null){
            session.invalidate();
        }
        return "redirect:/login/login.html";
    }

}
