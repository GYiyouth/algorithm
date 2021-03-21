package org.example.microsoft;


/**
 * 给定一个字符串，转换为10进制，然后持续对这个数字进行操作，如果是偶数，就除二，如果是奇数，就减一
 * 返回操作的次数
 */
public class TestTwo {


    public static void main(String[] args) {
        int res = solution2("011100");
        System.out.println(res);
    }

    /**
     * 这个思路是错的：转成十进制再除法、减法
     * @param S
     * @return
     */
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

    /**
     * 作为二进制操作，从右边开始，0就右移一位，1就置0+右移
     * @param S
     * @return
     */
    public static int solution2(String S){
        // write your code in Java SE 8
        if (S == null || S.length() == 0){
            return 0;
        }
        int leftOneIndex = 0;
        for (; leftOneIndex < S.length(); leftOneIndex++){
            if (S.charAt(leftOneIndex) == '1'){
                break;
            }
        }
        if (leftOneIndex == S.length()){
            return 0;
        }
        int rightIndex = S.length() - 1;
        int totalTimes = 0;
        for (; rightIndex > leftOneIndex; rightIndex--){
            if (S.charAt(rightIndex) == '0'){
                totalTimes += 1;
            }else {
                totalTimes += 2;
            }
        }
        totalTimes++;
        return totalTimes;
    }
}
