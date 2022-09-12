package com.lwsx.utils.function;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class JavaStreamTest {
    //而Stream输出的元素可能并没有预先存储在内存中，而是实时计算出来的。
    public static void main(String[] args) {
        List<Integer> lis = Arrays.asList(1,3,6,8,10);
        lis.stream() // 创建Stream
                .filter(n -> n % 2 == 0) // 任意个转换
                .map(n -> n * n) // 任意个转换
                .limit(3); // 任意个转换
//                .sum(); // 最终计算结果
        System.out.println(lis);
    }
}
