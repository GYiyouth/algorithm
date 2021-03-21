package org.example.paypal;

/**
 * Java内存模型小测试
 */
public class JavaMemoryTest {

    public static void main(String[] args){
        int a = 1;
        Integer b = new Integer(1);
        System.out.println(a);
        System.out.println(b);
    }

    public static void change(int a, int b){
        a = 10;
        b = 10;
        a++;
        b++;
    }
}
