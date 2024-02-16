package com.kitri.mytodolist.login;

import com.kitri.mytodolist.mappers.LoginMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class LoginApiController {
    @Autowired
    LoginMapper loginMapper;

    @PostMapping("")
    public boolean login(@RequestBody @Valid LoginDto form, BindingResult bindingResult, HttpServletRequest request, HttpServletRequest response){
        if(bindingResult.hasErrors()) {
            return false;
        }
        if(loginMapper.findMember(form.email) != null && loginMapper.findMember(form.email).getPw1().equals(form.pw)){
            HttpSession session = request.getSession();
            session.setAttribute("id", loginMapper.findMember(form.email));
            System.out.println(session);
            return true;
        }
        return false;
    }
    @GetMapping("/signup")
    public String signupHome(){
        return "redirect:/join/signup.html";
    }
    @PostMapping("/signup")
    public String signup(@Valid SignupFormDto form, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "redirect:/join/signup.html";
        }
        if(loginMapper.findMember(form.email) == null && form.pw1.equals(form.pw2)){
            loginMapper.addMember(form);
            return "redirect:/join/join.html";
        }
        return "redirect:/join/signup.html";
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
