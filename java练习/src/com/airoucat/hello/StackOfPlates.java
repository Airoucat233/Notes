package com.airoucat.hello;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
// 堆盘子
class StackOfPlates {
    private List<Stack<Integer>> stackList;
    private int cap;

    public StackOfPlates(int cap) {
        this.stackList = new ArrayList<>();
        this.cap = cap;
    }

    public void push(int val) {
        if (cap <= 0) {
            return;
        } else {
            if (!stackList.isEmpty() && stackList.get(stackList.size() - 1).size() != cap) {
                stackList.get(stackList.size() - 1).push(val);
            } else {
                Stack<Integer> s = new Stack<>();
                s.push(val);
                stackList.add(s);
            }
        }
    }

    public int pop() {
        Integer temp;
        if (stackList.isEmpty()) {
            return -1;
        } else {
            temp = stackList.get(stackList.size() - 1).pop();
            if (stackList.get(stackList.size() - 1).isEmpty()) {
                stackList.remove(stackList.size() - 1);
            }
        }
        return temp;
    }


    public int popAt(int index) {
        Integer temp;
        if(index>=stackList.size()){
            return -1;
        }
        temp = stackList.get(index).pop();
        if(stackList.get(index).isEmpty()){
            stackList.remove(index);
        }
        return temp;
    }

}
//
///**
// * Your StackOfPlates object will be instantiated and called as such:
// * StackOfPlates obj = new StackOfPlates(cap);
// * obj.push(val);
// * int param_2 = obj.pop();
// * int param_3 = obj.popAt(index);
// */