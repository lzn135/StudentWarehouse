import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class demo2 {
	/**
	 * 泛型类和接口
	 * 1.泛型类在实列化对象时候，如果没有指定类的泛型，那么默认改泛型Object
	 * 2.继承夫类（泛型）的子类。如果在继承的时候指定
	 */
	public static void main(String[] args) {
		Worker worker = new Worker();
		worker.setT("1");
		worker.setT("tqh");
		Map<Integer, Worker> map = new HashMap<>();
		map.put(1, new Worker<Integer>("lzn", 19, 2));
		Set<Map.Entry<Integer, Worker>> set1 = map.entrySet();
		Iterator<Map.Entry<Integer, Worker>> iterator = set1.iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, Worker> next = iterator.next();
			System.out.println(next.getKey() + "---" + next.getValue());
		}
	}
}

class Worker<T> {
	String name;
	int age;
	T t;

	public Worker(String name, int age, T t) {
		this.name = name;
		this.age = age;
		this.t = t;
	}

	public Worker() {

	}


	@Override
	public String toString() {
		return "Worker{" +
				"name='" + name + '\'' +
				", age=" + age +
				", t=" + t +
				'}';
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}