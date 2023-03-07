package com.lwsx.utils.function;

import java.io.UnsupportedEncodingException;

public class FullWidth2halfWidth {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(fullWidth2halfWidth("｀１２３４５６７８９０－＝［］＼＇；／．，＜＞？＂：｝｛｜～＠！＃＄％＾＆＊（）＿＿＿＿＿＋"));
        System.out.println(fullWidth2halfWidth("ａｂｃｄｅｆｇｈｉｊｋｌｍｎｏｐｑｒｓｔｕｖｗｘｙｚ"));
        System.out.println(fullWidth2halfWidth("你好啊。花飘万家雪，；好的；"));
        System.out.println("ａｂｃｄｅｆｇｈｉｊｋｌｍｎｏｐｑｒｓｔｕｖｗｘｙｚ".getBytes().length);
        System.out.println("abcdefghijklmnopqrstuvwxyz".getBytes().length);
//        String s = "ａｂ";
//        System.out.println(s.length());//2
//        System.out.println(s.getBytes("GBK").length);//4
//        System.out.println(s.getBytes("UTF-8").length);//6
//        System.out.println(s.getBytes("UTF-16").length);//6
//        System.out.println(s.getBytes("ISO8859-1").length);//2
    }

    /**
     * 全角字符串转换半角字符串
     *
     * @param fullWidthStr 非空的全角字符串
     * @return 半角字符串
     */
    private static String fullWidth2halfWidth(String fullWidthStr) {
        if (null == fullWidthStr || fullWidthStr.length() <= 0) {
            return "";
        }
        char[] charArray = fullWidthStr.toCharArray();
        //对全角字符转换的char数组遍历
        for (int i = 0; i < charArray.length; ++i) {
            int charIntValue = (int) charArray[i];
            //如果符合转换关系,将对应下标之间减掉偏移量65248;如果是空格的话,直接做转换
            if (charIntValue >= 65281 && charIntValue <= 65374) {
                charArray[i] = (char) (charIntValue - 65248);
            } else if (charIntValue == 12288) {
                charArray[i] = (char) 32;
            }
        }
        return new String(charArray);
    }
}
