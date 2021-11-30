package cn.lanqiao;

public class demo1 {

	public static void main(String[] args) {
		Sex boy1 = Sex.Boy;

		System.out.println(boy1);

	}
}

class Sex {
	//1私有化变量
	private final String sexName;
	private final String sexDesc;


	//2.私有化构造器
	private Sex(String sexName, String sexDesc) {
		this.sexName = sexName;
		this.sexDesc = sexDesc;

	}

	//3在类的内部创建枚举类的实例。声明为：public static final
	public static final Sex Boy = new Sex("join", "男");


	public String getSexName() {
		return sexName;
	}

	public String getSexDesc() {
		return sexDesc;
	}

	@Override
	public String toString() {
		return "Sex{" +
				"sexName='" + sexName + '\'' +
				", sexDesc='" + sexDesc + '\'' +
				'}';
	}
}




