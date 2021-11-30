import java.util.ArrayList;
import java.util.List;

public class demo1 {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("haha");
		list.add(123);
		list.add(654);

		for (Object obj : list
		) {
			System.out.println((Integer) obj);
		}

		List<String> list1 = new ArrayList<String>();
		list1.add("adasd");
		list.add("shsh");

		List<Student> list2 = new ArrayList<Student>();
		list2.add(new Student("哈哈", 17));
	}
}

class Student {
	String name;
	int age;

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}