package com.airoucat.test.testRepeatable;

import java.lang.annotation.*;

/**
 * 玩家注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface People {
    Game[] value();
}
