package com.airoucat.hello;
import com.sun.deploy.util.StringUtils;

import java.time.temporal.Temporal;
import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.pow;

import java.beans.Transient;

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

    /*重新排列句子中的单词
    「句子」是一个用空格分隔单词的字符串。给你一个满足下述格式的句子 text :
        句子的首字母大写
        text 中的每个单词都用单个空格分隔。
    请你重新排列 text 中的单词，使所有单词按其长度的升序排列。如果两个单词的长度相同，则保留其在原句子中的相对顺序。
    请同样按上述格式返回新的句子。
    示例：
    输入：text = "Keep calm and code on"
    输出："On and keep calm code"*/
    public String arrangeWords(String text) {
        List<String> a = new ArrayList<>(Arrays.asList(text.split(" ")));
        int orglen=a.size();
        List<String> b = new ArrayList<>();
        List<Integer> lengths=new ArrayList<>();
        for(int i=0;i<a.size();i++){
            lengths.add(i, a.get(i).length());
        }
        List<Integer> min_indexs = new ArrayList<>();
        while(b.size()!=orglen){
            for(int j=0,min_temp=lengths.get(0);j<lengths.size();j++){
                if(j==0){
                    min_indexs.add(0);
                    continue;
                }
                if(lengths.get(j)>min_temp){
                    continue;
                }
                if(lengths.get(j)==min_temp){
                    min_indexs.add(j);
                }
                if(lengths.get(j)<min_temp){
                    min_temp=lengths.get(j);
                    min_indexs.clear();
                    min_indexs.add(j);
                }
            }
            for(int i:min_indexs){
                b.add(a.get(i));
            }
            for(int i=0;i<min_indexs.size();i++){
                a.remove(min_indexs.get(i)-i);
                lengths.remove(min_indexs.get(i)-i);
            }
            min_indexs.clear();
            
        }
        //String temresult = StringUtils.join(b, " ");
        String temresult="";
        for(int i=0;i<b.size();i++){
            if(i==b.size()-1)
                temresult+=b.get(i);
            else
            temresult+=b.get(i)+" ";
        }
//        char[] cs=temresult.toCharArray();
//        cs[0]-=32;
//        String result=String.valueOf(cs);
        String result = temresult.substring(0,1).toUpperCase()+temresult.substring(1).toLowerCase();
        System.out.println(result);
        return result;
    }
}


