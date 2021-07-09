package com.airoucat.test.testRepeatable;

import java.lang.annotation.*;

/**
 * 游戏注解
 */
@Repeatable(People.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Game {
    String value() default "";
}
