package com.withstudy.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class MemberCreateForm {
    @NotBlank(message = "사용자 ID는 필수 입력 항목입니다.")
    private String memberID;

    @NotBlank(message = "이름을 입력해주세요.")
    private String memberName;

    @NotBlank(message = "비밀번호는 필수 입력 항목입니다.")
    private String memberPwd;

    @NotBlank(message = "다시 한번 비밀번호를 입력해 주세요.")
    private String memberPwd2;

    @NotBlank(message = "이메일은 필수 입력 항목입니다.")
    @Email(message = "이메일을 입력해주세요.")
    private String memberEmail;
}
