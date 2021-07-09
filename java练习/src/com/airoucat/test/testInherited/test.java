package com.airoucat.test.testInherited;

/**
 * 测试子类获取父类自定义注解
 */
public class test {
    public static void main(String[] args) {

        //获取Son的class对象
        Class<Son> sonClass = Son.class;
        // 获取Son类上的注解MyTestAnnotation可以执行成功
        MyAnnotation annotation = sonClass.getAnnotation(MyAnnotation.class);
        System.out.println(annotation);
    }
}
