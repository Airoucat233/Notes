package com.airoucat.hello;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.lang.Math.max;
import static java.lang.Math.pow;

public class Solution {
//    强整数
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> l = new ArrayList<Integer>();
        for(int i=0;pow(x,i)<=bound;i++){
            for(int j=0;pow(y,j)<=bound;j++){
                if(pow(x,i)+pow(y,j)<=bound){
                    Integer target = (int)(pow(x,i)+pow(y,j));
                    if(!l.contains(target))
                    l.add((int)pow(x,i)+(int)pow(y,j));
                }
            }
        }
        for (Integer a:l
             ) {
            System.out.println(a);
        }
        return l;
    }
    //路径总和
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        Queue<TreeNode> queNode = new LinkedList<TreeNode>();
        Queue<Integer> queVal = new LinkedList<Integer>();
        queNode.offer(root);
        queVal.offer(root.val);
        while(!queNode.isEmpty()){
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            if(now.left==null&&now.right==null){
                if (temp==targetSum) return true;
                continue;
            }
            if(now.left!=null){
                queNode.offer(now.left);
                queVal.offer(now.left.val+temp);
            }
            if(now.right!=null){
                queNode.offer(now.right);
                queVal.offer(now.right.val+temp);
            }

        }


        return false;
    }

    //子数组异或查询
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] result=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            for(int j=queries[i][0];j<=queries[i][1];j++){
                result[i] = Xor(arr[j],result[i]);
            }

        }
        return result;
    }
    public int Xor(int a,int b) {
//        Queue<Integer> queue = new LinkedList<>();
        int result=0;
//        while (a != 0 || b != 0) {
//            if (a % 2 != b % 2) {
//                queue.offer(1);
//            } else {
//                queue.offer(0);
//            }
//            a = a / 2;
//            b = b / 2;
//        }
//        for(int i = 0;!queue.isEmpty();i++) {
//            result += queue.poll()*pow(2,i);
//        }
        for(int i=0;a != 0 || b != 0;i++){
            if (a % 2 != b % 2) {
                result += Math.pow(2,i);
            }
            a = a / 2;
            b = b / 2;
        }
        return result;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        return 0;
    }
}


