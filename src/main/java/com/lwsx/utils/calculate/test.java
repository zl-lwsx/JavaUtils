package com.lwsx.utils.calculate;

import java.util.*;

public class test {
//    给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//    如果你*最多只允许完成一笔交易*（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
//    注意：你不能在买入股票前卖出股票。
//    [7,6,4,3,1]
//[7,1,5,3,6,4]

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
//        System.out.print("Your input is : " + sc.next());
        String lineText = sc.next();
        String[] dataStringArr = lineText.split(",");
        int[] data = Arrays.asList(dataStringArr).
                stream().mapToInt(Integer::parseInt).toArray();

//        int[] data = new int[]{7,1,5,3,6,4};

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                int temp = data[i] - data[j];
                list.add(temp);
            }
        }
        Collections.sort(list);
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(Math.abs(list.get(0)));

    }
}
