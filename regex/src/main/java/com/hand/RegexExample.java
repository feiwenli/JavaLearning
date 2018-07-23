package com.hand;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegexMatches{
    private static final String REGEX = "\\bcat\\b";
    private static final String INPUT = "cat cat cat cattie cat";

    public static void test(){
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT);
        int count = 0;

        while(m.find()){
            count++;
            System.out.println("Match number"+count);
            System.out.println("Start():"+m.start());
            System.out.println("end():"+m.end());
            // Start 方法返回在以前的匹配操作期间，由给定组所捕获的子序列的初始索引，end 方法最后一个匹配字符的索引加 1。
        }
    }
}
public class RegexExample {
    public static void main(String [] args){
        String content = "I am noob"+"from runoob.com.";
        String pattern = ".*runoob.*";

        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println( isMatch);

        String line = "This order was placed for QT3000! OK?";
        String p = "(\\D*)(\\d+)(.*)";

        // 创建Pattern对象
        Pattern pattern1 = Pattern.compile(p);

        // 创建macher对象
        Matcher matcher1 = pattern1.matcher(line);
        if (matcher1.find()){
            System.out.println("Found value:"+matcher1.group(0));
            System.out.println("Found value:"+matcher1.group(1));
            System.out.println("Found value:"+matcher1.group(2));
            System.out.println("Found value:"+matcher1.group(3));
        }else {
            System.out.println("NOT MATCH");
        }

        RegexMatches.test();
    }
}
