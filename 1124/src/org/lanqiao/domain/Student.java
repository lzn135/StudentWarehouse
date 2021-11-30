package org.lanqiao.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Student {
	private String name;
	private int age;
	private String gender;
	@JsonFormat(pattern = "yyy-MM-dd")
	private Date birthday;


}
