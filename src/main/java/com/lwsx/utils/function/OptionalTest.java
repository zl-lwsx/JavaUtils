package com.lwsx.utils.function;

import java.util.Optional;
import java.util.function.Consumer;

public class OptionalTest {
    public static void main(String[] args) {
//        test1();
        test2();
        test3();
        test4();
        test5();
    }

    private static void test5() {
        //flatMap()：功能与map()相似，差别请看如下代码。flatMap方法与map方法类似，
        // 区别在于mapping函数的返回值不同。map方法的mapping函数返回值可以是任何类型T，而flatMap方法的mapping函数必须是Optional。
        Optional<Integer> optional1 = Optional.ofNullable(1);

        Optional<Optional<String>> str1Optional = optional1.map((a) -> {
            return Optional.<String>of("key" + a);
        });

        Optional<String> str2Optional = optional1.flatMap((a) -> {
            return Optional.<String>of("key" + a);
        });

        System.out.println(str1Optional.get().get());// key1
        System.out.println(str2Optional.get());// key1
    }

    private static void test4() {
        //map(Function)：对Optional中保存的值进行函数运算，并返回新的Optional(可以是任何类型)
        Optional<Integer> optional1 = Optional.ofNullable(1);
        Optional<Integer> optional2 = Optional.ofNullable(null);

        Optional<String> str1Optional = optional1.map((a) -> "key" + a);
        Optional<String> str2Optional = optional2.map((a) -> "key" + a);

        System.out.println(str1Optional.get());// key1
        System.out.println(str2Optional.isPresent());// false
    }

    private static void test3() {
        //filter(Predicate)：判断Optional对象中保存的值是否满足Predicate，并返回新的Optional。
        Optional<Integer> optional1 = Optional.ofNullable(1);
        Optional<Integer> optional2 = Optional.ofNullable(null);

        Optional<Integer> filter1 = optional1.filter((a) -> a == null);
        Optional<Integer> filter2 = optional1.filter((a) -> a == 1);
        Optional<Integer> filter3 = optional2.filter((a) -> a == null);
        System.out.println(filter1.isPresent());// false
        System.out.println(filter2.isPresent());// true
        System.out.println(filter2.get().intValue() == 1);// true
        System.out.println(filter3.isPresent());// false
    }

    //ifPresent(Consumer consumer)：如果option对象保存的值不是null，则调用consumer对象，否则不调用
    private static void test2() {
        Optional<Integer> optional1 = Optional.ofNullable(1);
        Optional<Integer> optional2 = Optional.ofNullable(null);

        // 如果不是null,调用Consumer
        optional1.ifPresent(new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                System.out.println("value is " + t);
            }
        });

        // null,不调用Consumer
        optional2.ifPresent(new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                System.out.println("value is " + t);
            }
        });
    }

    private static void test1() {
        /**
         * isPresent()：判断值是否存在
         */
        Optional<Integer> optional1 = Optional.ofNullable(1);
        Optional<Integer> optional2 = Optional.ofNullable(null);
        // isPresent判断值是否存在
        System.out.println(optional1.isPresent() == true);
        System.out.println(optional2.isPresent() == false);
        System.out.printf("ddd", optional1);
    }
}
