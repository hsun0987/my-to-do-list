package com.kitri.mytodolist.login;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupFormDto {
    @NotEmpty(message = "이메일 입력은 필수 입니다.")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식에 맞지 않습니다.")
    String email;

    @NotNull
    String name;

    @NotEmpty(message = "비밀번호 입력은 필수 입니다.")
    @Size(min = 8, message = "비밀번호는 최소 8자 이상이어야 합니다.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,20}$", message = "비밀번호는 8~20자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    String pw1;

    @NotEmpty(message = "비밀번호 입력은 필수 입니다.")
    @Size(min = 8, message = "비밀번호는 최소 8자 이상이어야 합니다.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,20}$", message = "비밀번호는 8~20자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    String pw2;

    public SignupFormDto(String email, String name, String pw1, String pw2) {
        this.email = email;
        this.name = name;
        this.pw1 = pw1;
        this.pw2 = pw2;
    }
}
