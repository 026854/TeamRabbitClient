package com.rabbitmq.client;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum BeforeType {
	
	doc,
	pdf,
	txt,
	xls,
	psd,
	ai;
	
	private static final List<BeforeType> VALUES = (List<BeforeType>) Collections.unmodifiableList(Arrays.asList(values()));
	
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();
	
	public static String randomBeforeType() {
		return VALUES.get(RANDOM.nextInt(SIZE)).toString();
	}
}
