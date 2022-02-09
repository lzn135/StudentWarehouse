package com.fish.blog.entity;


import javax.validation.constraints.NotNull;
import lombok.Data;

import javax.validation.constraints.Size;


@Data

public class AdminUser {

	@NotNull(message = "用户ID不能为空")
    private Integer adminUserId;
    @NotNull(message = "管理员账户不能为空")
	@Size(min =6,max = 11,message = "账号长度必须是6-11个字符")
    private String loginUserName;

    private String loginPassword;

    private String nickName;

    private Byte locked;

}