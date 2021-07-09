package com.airoucat.test;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Inherited
public @interface MyAnnotation {

}

