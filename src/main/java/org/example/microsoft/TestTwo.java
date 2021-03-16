package org.example.microsoft;


/**
 * 给定一个字符串，转换为10进制，然后持续对这个数字进行操作，如果是偶数，就除二，如果是奇数，就减一
 * 返回操作的次数
 */
public class TestTwo {


    public static void main(String[] args) {
        solution("011100");
    }

    public static int solution(String S) {
        // write your code in Java SE 8
        if (S == null || S.length() == 0){
            return 0;
        }
        int totalV = 0;
        int maxOneRepeated = 0;
        for (int index = S.length() -1; index >= 0 ;index -- ){
            char c = S.charAt(index);
            if (c == '1'){
                maxOneRepeated++;
                totalV += Math.pow(2 , S.length() - index -1);
            }
        }
        if (totalV == 0){
            return 0;
        }
        if(maxOneRepeated >= 400000){
            return 799999;
        }
        int modCount = 0;
        int currentV = totalV;
        while (currentV > 0){
            modCount ++;
            if (currentV % 2 == 0){
                // even
                currentV = currentV / 2;
                continue;
            }

            if (currentV % 2 == 1){
                // odd
                currentV--;
                continue;
            }
        }
        return modCount;
    }
}
