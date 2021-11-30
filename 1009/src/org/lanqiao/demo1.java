package org.lanqiao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class demo1 {
	public static void main(String[] args) {
		//创建一个list合集
		List list = new ArrayList();
		//添加元素
		list.add(123);
		list.add(222);

		list.add(new student("name", 485));


		System.out.println(list);


		//索引删除
		list.remove(0);
		System.out.println(list);

		//元素删除
		list.remove(new Integer(222));
		System.out.println(list);

		//改
		list.set(0, 124);
		System.out.println(list);

		//查
		Object o = list.get(0);
		System.out.println(o);


		//遍历
		Iterator it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		//增强for循环
		for (Object obj : list) {
			System.out.println(obj);
		}


	}
}

class student {

	String name;
	int age;

	//构造方法
	public student(String name, int age) {
		this.name = name;
		this.age = age;

	}

	@Override
	public String toString() {
		return "student{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}




