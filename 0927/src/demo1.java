
import java.util.Scanner;

public class demo1 {
	public static void main(String[] args) {


		Scanner SC = new Scanner(System.in);
		String S = SC.next();
		char[] cs = S.toCharArray();//转成 char数组

		for (int i = 0; i < cs.length; i++) {
			if ((int) cs[i] >= 97 || (int) cs[i] <= 122) {
				cs[i] -= 32;
			} else if ((int) cs[i] >= 65 || (int) cs[i] <= 90) {
				cs[i] += 32;
			}
			System.out.println(cs[i]);
		}


	}
}