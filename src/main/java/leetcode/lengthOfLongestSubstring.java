package leetcode;

import java.util.HashMap;
import java.util.Map;

public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        int length  = lengthOfLongestSubstring("abcabcbb");
        System.out.println("length = " +length);
    }

    public static int lengthOfLongestSubstring(String s) {
        System.out.println(s);
        if(s ==null || s.length() ==0) return 0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int start = 0;
        int max = 0;
        for(int i = 0;i<s.length(); i++){
            char c = s.charAt(i);
            //初始化start 最长串起始位置,若重复则长度+1
            start = Math.max(start, (map.containsKey(c))?map.get(c)+1:0);
            System.out.println("start=="+start);

            //判断当前字符串长度是否为最长串长度,如果是则为最长串长度 否则为之前最长串长度
            //i-start +1 总长度减去起始长度
            max =Math.max(max,i-start +1 );
            System.out.println("max=="+max);
            //记录字符最后一次出现的位置
            map.put(c,i);
            System.out.println(map);
        }

        return max;
    }
}
