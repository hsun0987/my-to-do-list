package com.kitri.mytodolist.mappers;

import com.kitri.mytodolist.todo.dto.RequestTodo;
import com.kitri.mytodolist.todo.dto.ResponseTodo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// 기존 DAO 역할
@Mapper
public interface TodoMapper {
    List<ResponseTodo> findAll();
    ResponseTodo findById(Long id);
    void save(RequestTodo todo);
    void update(Long id);
    void deleteById(Long id);
}
