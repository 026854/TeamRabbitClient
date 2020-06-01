package com.rabbitmq.client.vo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public enum BeverageType {

    COFFEE,
    BLENDER,
    NORMAL;

    private static final List<BeverageType> VALUES = (List<BeverageType>) Collections.unmodifiableList(Arrays.asList(values()));

    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static String randomMachineType() {
        return VALUES.get(RANDOM.nextInt(SIZE)).toString();
    }

}
