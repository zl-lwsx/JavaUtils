package com.lwsx.utils.calculate;

public class test2 {
    /****
     * 第二题打印9*9乘法表
     * */
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + j * i + "\t");
            }
            System.out.println();
        }
    }
}
