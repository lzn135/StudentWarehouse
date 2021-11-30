package org.lanqiao.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {
	@TableId
	private Integer uid;
	private  String  username;
	private  String password;
}
