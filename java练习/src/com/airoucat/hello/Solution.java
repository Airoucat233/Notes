package com.airoucat.hello;
import com.sun.deploy.util.StringUtils;
import sun.font.TrueTypeFont;

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
    /*520. 检测大写字母
    给定一个单词，你需要判断单词的大写使用是否正确。

    我们定义，在以下情况时，单词的大写用法是正确的：

    全部字母都是大写，比如"USA"。
    单词中所有字母都不是大写，比如"leetcode"。
    如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
    否则，我们定义这个单词没有正确使用大写字母。

    示例 1:

    输入: "USA"
    输出: True
    示例 2:

    输入: "FlaG"
    输出: False
    注意: 输入是由大写和小写拉丁字母组成的非空单词。*/
    public boolean detectCapitalUse(String word) {
        int num = 0;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)<=90&&word.charAt(i)>=65){
                num++;
            }
        }
        if(num==word.length()||(num==1&&word.charAt(0)<=90&&word.charAt(0)>=65||num==0))
            return true;
        else
            return false;
    }
    /*41. 缺失的第一个正数
    给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。

    请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。


    示例 1：

    输入：nums = [1,2,0]
    输出：3
    示例 2：

    输入：nums = [3,4,-1,1]
    输出：2
    示例 3：

    输入：nums = [7,8,9,11,12]
    输出：1*/
    public int firstMissingPositive(int[] nums) {
        boolean change = true;
        while(change==true){
            change=false;
            for(int i = 0;i<nums.length-1;i++){
                if(nums[i]>nums[i+1]){
                    int temp = nums[i+1];
                    nums[i+1]=nums[i];
                    nums[i]=temp;
                    change = true;
                }
            }
        }
        int[] newnums=new int[nums.length];
        int j=0;
        for(int i : nums) {
            if (i > 0){
                newnums[j] = i;
                j++;
            }
        }
        int k=1;
//        for(int i=0;i<newnums.length;i++){
//            if(k==newnums[i]){
//            }
//            else if(i!=0&&newnums[i]-k==1){k++;}
//            else if(i!=0)return k+1;
//            else return k;
//        }
//        return k+1;
        for(int i=0;i<newnums.length;i++){
            if(k==newnums[i]){
            }
            else if(i!=0){
                if(newnums[i]-k==1){k++;}
                else return k+1;
            }
            else return k;
        }
        return k+1;
    }
}


