package org.example;

import java.util.Random;

public enum TypeEnum {
    WARN,
    INFO,
    ERROR,
    ;


    public static TypeEnum getRandomType() {
        Random random = new Random();

        random.nextInt();
        return TypeEnum.values()[random.nextInt(0, TypeEnum.values().length)];

    }
}


