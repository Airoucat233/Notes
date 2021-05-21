package com.airoucat.hello;

import java.lang.reflect.Method;

public class RunTimeTest {

    public RunTimeTest(){
        long startTime = System.currentTimeMillis(); //获取开始时间
            new Solution().Xor(1,3); //测试的代码段
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); //输出程序运行时间
    }
    public RunTimeTest(int a){
        long startTime=System.nanoTime(); //获取开始时间

        new Solution().Xor(1,3); //测试的代码段

        long endTime=System.nanoTime(); //获取结束时间

        System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
    }
    public RunTimeTest(int a,int b){
        long startTime=System.nanoTime(); //获取开始时间

        a = 1^3; //测试的代码段

        long endTime=System.nanoTime(); //获取结束时间

        System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
    }
}
