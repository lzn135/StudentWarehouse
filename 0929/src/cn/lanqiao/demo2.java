package cn.lanqiao;

public class demo2 {
	public static void main(String[] args) {
		Sex2 boy1 = Sex2.Boy;

		System.out.println(boy1);
		boy1.show();

		Sex2 Girl2 = Sex2.Girl;

		System.out.println(Girl2);
		Girl2.show();


	}
}

interface info {
	public void show();
}

enum Sex2 implements info {
	//在类的内部创建枚举的实列，声明为 public static final
	Boy("男", "男人") {
		@Override
		public void show() {
			System.out.println("男人就很有精神");
		}
	},
	Girl("女", "女人") {
		@Override
		public void show() {
			System.out.println("女人");
		}
	},
	Simon("join", "加入") {
		@Override
		public void show() {
			System.out.println("加入");
		}
	};

	//私有化实列变量
	private final String sexName;
	private final String sexDesc;


	//私有化构造器
	private Sex2(String sexName, String sexDesc) {
		this.sexName = sexName;
		this.sexDesc = sexDesc;

	}


	/* 特别要求，自动生成 alt+insert(ins) */

	public String getSexName() {
		return sexName;
	}

	public String getSexDesc() {
		return sexDesc;
	}

//    @Override
//    public String toString() {
//        return "Sex{" +
//                "sexName='" + sexName + '\'' +
//                ", sexDesc='" + sexDesc + '\'' +
//                '}';
//    }
}