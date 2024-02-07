package com.kitri.mytodolist.mappers;

import com.kitri.mytodolist.login.SignupFormDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    SignupFormDto findMember(String email);

    void addMember(SignupFormDto member);

}
