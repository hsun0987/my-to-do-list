package com.kitri.mytodolist.todo.controller;

import com.kitri.mytodolist.todo.dto.RequestTodo;
import com.kitri.mytodolist.todo.dto.ResponseTodo;
import com.kitri.mytodolist.mappers.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/todos/")
public class TodoApiController {

    @Autowired
    TodoMapper todoMapper;

    @GetMapping("")
    public ArrayList<ResponseTodo> todos(){
        ArrayList<ResponseTodo> list = (ArrayList<ResponseTodo>) todoMapper.findAll();
        return list;
    }
    @PostMapping("")
    public void add(@RequestBody RequestTodo todo){
        todoMapper.save(todo);
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
