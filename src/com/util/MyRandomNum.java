package com.util;

import java.util.Random;

public class MyRandomNum {
	public int createRandomNum(int numb) {
		Random random = new Random();
		numb = random.nextInt(numb);
		return numb;
	}
}
