package com.kitri.mytodolist.todo.controller;

import com.kitri.mytodolist.login.LoginDto;
import com.kitri.mytodolist.login.SignupFormDto;
import com.kitri.mytodolist.todo.dto.RequestTodo;
import com.kitri.mytodolist.todo.dto.ResponseTodo;
import com.kitri.mytodolist.mappers.TodoMapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/todos/")
public class TodoApiController {

    @Autowired
    TodoMapper todoMapper;

    @GetMapping("")
    public ArrayList<ResponseTodo> todos(@SessionAttribute(name="id", required = false) SignupFormDto dto){
        ArrayList<ResponseTodo> list = (ArrayList<ResponseTodo>) todoMapper.findAll(dto.getId());
        return list;
    }
    @PostMapping("")
    public ArrayList<ResponseTodo> add(@RequestBody RequestTodo todo, @SessionAttribute(name="id", required = false) SignupFormDto dto){
        todo.setMemberId(dto.getId());
        todoMapper.save(todo);
        ArrayList<ResponseTodo> list = (ArrayList<ResponseTodo>) todoMapper.findAll(dto.getId());
        return list;
    }
    @PutMapping("{id}")
    public void finish(@PathVariable Long id){
        todoMapper.update(id);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        todoMapper.deleteById(id);
    }
}
