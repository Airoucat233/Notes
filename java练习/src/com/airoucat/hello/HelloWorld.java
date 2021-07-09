package com.airoucat.hello;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class HelloWorld {
    public static void main(String[] args){
        //RunTimeTest.RunTimeTesta();
        // new RunTimeTest(1,2);
        //System.out.println("hello");
//        String s = new Solution().arrangeWords("Keep calm and code on");
//        System.out.println(s);
        //Class<?> a = String.class;
//        Class[] interfaces = {String.class,int.class,boolean.class};
//        for(Class c:interfaces) {
//            System.out.println(c);
//        }
        int[] nums = {1,2,6};
        System.out.println(new Solution().firstMissingPositive(nums));
    }
//public static void main(String[] args) {
//    System.out.println("111");
//    List<Stack<Integer>> stackList=new ArrayList<>();
//    Stack a = new Stack();
//    a.add(111);
//    a.add(222);
//    stackList.add(a);
//    Stack temp=stackList.get(0);
//    System.out.println(temp)
//    }
}
