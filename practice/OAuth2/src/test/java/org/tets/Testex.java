package org.tets;

import org.junit.Test;
import org.junit.runner.RunWith;


public  class Testex {
	@Test
	public void test(){
		int i =  2;
		int j = 3;
		i = i^j;
		j = i^j;
		i = j^i;
		System.out.println("i="+i+",j="+j);
	}
}
