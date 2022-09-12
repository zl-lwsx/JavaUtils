package com.lwsx.utils.calculate;

import org.junit.Test;

public class JlTest {
    //    Sort below string with the order input by user
//            abcdabcdabcd
//    For example,
//        if user input is dabc, then the ordered string is dddaaabbbccc
//        if user input is abcd, then the ordered string is aaabbbcccddd
//
//
//    Please create the unit test source code for your source code too.
//

    public static String test(String orderString) {
        String myData = "abcdabcdabcd";
        StringBuilder stringBuilder = new StringBuilder();
        for (char d : orderString.toCharArray()) {
            for (char c : myData.toCharArray()) {
                if (d == c)
                    stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    @Test
    public void testMy() {
        String orderString = "abcd";
        System.out.println(test(orderString));
    }
}
