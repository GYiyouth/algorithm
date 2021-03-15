package algorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 回文子串 {

    public static void main(String[] args) {
        最长回文子串();
    }

    /**
     *
     */
    public static void 最长回文子串(){
        String rawInput = "5655555566655556666uuouu";
        Map<Integer, List<Integer>> everyCharSubStrLength = new HashMap<>();

        if (rawInput == null || rawInput.length() < 1){
            System.out.println("最大回文子串长度为1：" + rawInput);
        }

        // 构建初始化长度
        for (int index=0; index < rawInput.length() ; index++){
            List<Integer> subStrLength = new ArrayList<>();
            subStrLength.add(1);
            everyCharSubStrLength.put(index, subStrLength);
        }

        // 从第二个开始遍历
        for (int index = 1; index < rawInput.length(); index ++){
            char currentChar = rawInput.charAt(index);
            /**
             * 做2种类型的对比，
             * 1，跟前一个字符串的所有回文子串做对比，看能否+2
             * 2，跟前一个字符串本身做对比，看能否+1
             * */
            List<Integer> workedSubstrLength = everyCharSubStrLength.get(index);
            // 第一种类型的对比
            List<Integer> subCharStrLengthList = everyCharSubStrLength.get(index - 1);
            for (Integer preSubStrLength : subCharStrLengthList) {
                Integer targetIndex = index - preSubStrLength - 1;
                if (targetIndex>=0){
                    char targetChar = rawInput.charAt(targetIndex);
                    if (targetChar==currentChar){
                        workedSubstrLength.add(preSubStrLength + 2);
                    }
                }
            }
            // 第二种类型的对比
            char preChar = rawInput.charAt( index - 1);
            if (preChar == currentChar){
                workedSubstrLength.add(2);
            }
        }
        // 做完了每个元素的值，遍历输出最大的那个
        int maxLength = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int index = 0; index < rawInput.length() ; index ++){
            List<Integer> workedSubstrLength = everyCharSubStrLength.get(index);
            int thisIndexMaxLength = workedSubstrLength.stream().max(Integer::compare).get();
            if (thisIndexMaxLength > maxLength){
                maxLength = thisIndexMaxLength;
                maxIndex = index;
            }
            System.out.println("字符串[" + rawInput.substring(0, index + 1) + "]的最大回文子串长度为" + maxLength + ",[" + rawInput.substring(maxIndex - maxLength +1 , maxIndex+1) + "]");
        }
    }
}
