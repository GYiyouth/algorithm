package org.example.microsoft;

/**
 * 给定一个数组，代表一串硬币，比如[1110]，每枚硬币可以翻转，如果要让它变成1010、或者0101这种顺序，最少翻转多少次？
 */
public class TestOne {

    public static void main(String[] args) {
        TestOne testOne = new TestOne();
        testOne.solution(new int[]{1,1,0,1,1});
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        if(A == null || A.length <= 2){
            return 0;
        }

        int[] reserveLength = new int[A.length + 1];
        for (int index = 0 ; index <= A.length ; index++) {
            if (index <= 2){
                // 长度为0、1、2都不需要交换
                reserveLength[index] = 0;
            }else {
                // 长度为3，开始需要交换
                reserveLength[index] = reserveLength[index - 2];
            }
        }

        for (int index = 1; index<A.length ; index++){
            int targetValue = A[index];
            int preValue = A[index - 1];
            if (targetValue - preValue != 0){
                // 符合条件，当前这个元素不需要额外的次数
                reserveLength[index + 1] = reserveLength[index ];
            }else {
                A[index] = 1 - targetValue;
                reserveLength[index + 1] =reserveLength[index] + 1;
            }
        }
        // 如果翻转的次数比所有元素都多，则其实可以逆翻转。
        return Math.min( reserveLength[A.length], A.length - reserveLength[A.length] );
    }
}
