package com.rabbitmq.client.vo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Core {

	BEAN,
	POWDER,
	TEA,
	SYRUP;

	
	private static final List<Core> VALUES = (List<Core>) Collections.unmodifiableList(Arrays.asList(values()));
	
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();
	
	public static String randomCoreType() {
		return VALUES.get(RANDOM.nextInt(SIZE)).toString();
	}
}
