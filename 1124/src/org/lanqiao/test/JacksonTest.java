package org.lanqiao.test;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.lanqiao.domain.Student;

import java.io.IOException;
import java.util.*;

public class JacksonTest {
	/**
	 * java对象转json
	 */
	@Test
	public void test1() throws IOException {
		//创建java对象
		Student s = new Student();
		s.setName("二狗子");
		s.setAge(20);
		s.setGender("男");
		s.setBirthday(new Date());


		//2.创建jackSon核心对象objectMapper
		ObjectMapper mapper = new ObjectMapper();


		//3.转换
		/*
				writeValue(参数1，Obj)
					参数1
						File:将obj对象转换成json,并保存到指定文件夹中
						write:将obj对象转换成json，并将json填充到字符输出流中
						outputStream:将obj对象转换成json,并将json填充到字节输出流中


				writeValuesString();将对象转换成json字符串

		 */

		String value = mapper.writeValueAsString(s);
		System.out.println(value);

		//mapper.writeValue(new File("E://a.txt),s)

		//mapper.writerValue(new FileWrite("E://b.txt"),S)
	}

	@Test
	public void test2() throws IOException {
		//1.创建java对象
		Student s = new Student();
		s.setName("三狗子");
		s.setAge(18);
		s.setGender("男");
		s.setBirthday(new Date());

		Student s1 = new Student();
		s.setName("四狗子");
		s.setAge(17);
		s.setGender("男");
		s.setBirthday(new Date());

		Student s2 = new Student();
		s.setName("五狗子");
		s.setAge(18);
		s.setGender("男");
		s.setBirthday(new Date());

		Student s3 = new Student();
		s.setName("六狗子");
		s.setAge(14);
		s.setGender("男");
		s.setBirthday(new Date());

		List<Student> list = new ArrayList<>();
		list.add(s);
		list.add(s1);
		list.add(s2);
		list.add(s3);

		//2.创建jackson核心对象 ObjectMapper

		ObjectMapper mapper = new ObjectMapper();

		//3.转换
		String value = mapper.writeValueAsString(list);
		System.out.println(value);

	}

	@Test
	public void test3() throws IOException {
		//1.创建java对象
		Map<String, Object> map = new HashMap<>();
		map.put("name", "虚心");
		map.put("age", 27);
		map.put("gender", "女");

		//2.创建jackson核心对象 ObjectMapper
		ObjectMapper mapper = new ObjectMapper();

		//3.转换
		String value = mapper.writeValueAsString(map);
		System.out.println(value);

	}

	@Test
	public void test4() throws IOException {
		//初始化json
		String json = "{\"gender\":女\",\"name\":\"虚心\",\"age\":27}";
		ObjectMapper mapper = new ObjectMapper();
		Student student = mapper.readValue(json, Student.class);
		System.out.println(student);

	}
}


