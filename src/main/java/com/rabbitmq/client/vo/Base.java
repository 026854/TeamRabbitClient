package com.rabbitmq.client.vo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Base {
	
	MILK,
	WATER,
	ADE;
	
	private static final List<Base> VALUES = (List<Base>) Collections.unmodifiableList(Arrays.asList(values()));
	
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();
	
	public static String randomBaseType() {
		return VALUES.get(RANDOM.nextInt(SIZE)).toString();
	}
}
