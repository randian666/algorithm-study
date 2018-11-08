package com.algorithm.study.demo.algorithm;

import com.sun.deploy.util.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 祖玛消除算法
 * @Author: liuxun
 * @CreateDate: 2018/11/6 下午3:58
 * @Version: 1.0
 */
public class ZumaProject {
    public static void main(String[] args) {
        String[] is = new String[50];
        Random ra =new Random();
        for(int i=0;i<50;i++){
            is[i]=ra.nextInt(3)+"";
        }
        //把输入的数据转换成字符串。这样可以利用正则表达式去查找重复数字
        String input=StringUtils.join(Arrays.asList(is),"");
        System.out.println("初始化数据："+input);
        String newInput=matcher(input);
        System.out.println("去掉初始化数据连续出现三次级以上数字后的结果："+newInput);

        Scanner sc = new Scanner(System.in);
        System.out.println("输入需要消除的数字下标:");
        int index=sc.nextInt();
        String findInput=find(index,newInput);
        System.out.println("消除后的结果："+findInput);


    }
    public static String matcher(String input)
    {
        //创建一个List 用于存放重复3次或者以上的的数字
        List<String> list = new ArrayList<String>();
        //创建匹配的模式
        Pattern pattern = Pattern.compile("(\\w)\\1{2,}");
        //匹配器
        Matcher matcher = pattern.matcher(input);
        //查找与该模式匹配的子序列。从input 里面 查找出 与 此模式 "(\w)\1{2,}"  相匹配的 子序列。如果存在，返回true，如果不存在，返回false.
        while (matcher.find())
        {
            //返回匹配的子序列，并加入到list里面。
            list.add(matcher.group());
        }
        if (list.isEmpty()){
            System.out.println("当前数据没有出现连续三次或以上的数字");
            return input;
        }
        System.out.println("当前连续三次或以上出现的数字为："+list);
        //找到连续重复的字符,加入到数组中。
        String[] strings = list.toArray(new String[0]);
        //找出连续并且重复的子序列。并且把这些连续重复的子序列用空字符串替换。
        for(int i=0 ;i<=strings.length-1;i++){
            if(strings[i].length()>1){
//                System.out.println(strings[i]);
                input=input.replace(strings[i],"");
//                System.out.println(input);
            }
        }
        //返回把连续重复的字符赐除掉的字符序列。
        return input;
    }

    /**
     * 删除字符串指定index的元素
     * @param index
     * @param Str
     * @return
     */
    public static String removeChar(int index,String Str) {
        Str = Str.substring(0, index) + Str.substring(index + 1, Str.length());//substring的取值范围是:[,)
        return Str;
    }
    /**
     * 用户需要消除的数字下标以及数字
     * 思路就是删掉用户查找的那个数字然后返回新的字符串
     * 比如{11212}，用户传入下标为2的数字2返回"1112"
     * 然后把字符串继续重复调用matcher即可
     * @param index
     * @return
     */
    public static String find(int index,String array){
        String newArr=removeChar(index,array);
        String matcherArr = matcher(newArr);
        if (newArr.equals(matcherArr)){
            //如果用户输入数据后没有发现连续三次级以上的数据就返回原始数据
            return array;
        }
        return matcherArr;
    }
}
