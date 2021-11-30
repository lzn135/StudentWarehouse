package org.lanqiao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	private int eid;
	private String ename;
	private int esex;
	private int eage;
	private String eaddress;
	private String ephone;
	private String email;
}
