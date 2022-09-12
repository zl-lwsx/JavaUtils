package com.lwsx.utils.function;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class StreamUtil {
    public static void main(String[] args) {
        //排序
//        testSort();
        //分组
//        testGroupBy();
        //去重
        testDistinct();
    }

    private static void testDistinct() {
//        List<StudentInfo> studentList = prepareData();
        List<String> list = Arrays.asList("AA", "BB", "CC", "BB", "CC", "AA", "AA");
        long l = list.stream().distinct().count();
        System.out.println("No. of distinct elements:"+l);
        String output = list.stream().distinct().collect(Collectors.joining(","));
        System.out.println(output);
    }

    private static void testGroupBy() {
        /**
         * 使用java8 stream groupingBy操作,按性别分组list
         */
        List<StudentInfo> studentList = prepareData();
//        Map<Boolean, List<StudentInfo>> employeesByCity =
//                studentList.stream().collect(Collectors.groupingBy(StudentInfo::getGender));
//        System.out.println(employeesByCity);
//        assertEquals(employeesByCity.get(false).size(), 2);


        /**
         * 使用java8 stream groupingBy操作,性别分组list统计count
         */
        Map<Boolean, Long> employeesByCity =
                studentList.stream().collect(Collectors.groupingBy(StudentInfo::getGender, Collectors.counting()));
        System.out.println(employeesByCity);
        assertEquals(employeesByCity.get(false).longValue(), 2L);
    }

    // 通过Comparator.thenComparing(Comparator<? super T> other) 实现多字段排序,并且使用Comparator.reverseOrder() 实现降序和升序
    private static void testSort() {
        //测试数据，请不要纠结数据的严谨性
        List<StudentInfo> studentList = prepareData();

//        //排序前输出
//        StudentInfo.printStudents(studentList);
//        //按年龄排序(Integer类型)
//        List<StudentInfo> studentsSortName = studentList.stream().sorted(Comparator.comparing(StudentInfo::getAge)).collect(Collectors.toList());
//        //排序后输出
//        StudentInfo.printStudents(studentsSortName);


//        //排序前输出
//        StudentInfo.printStudents(studentList);
////按年龄排序(Integer类型)
//        List<StudentInfo> studentsSortName = studentList.stream().sorted(Comparator.comparing(StudentInfo::getAge).reversed()).collect(Collectors.toList());
////排序后输出
//        StudentInfo.printStudents(studentsSortName);

        //排序前输出
        StudentInfo.printStudents(studentList);
        //按年龄排序(Integer类型)
        List<StudentInfo> studentsSortName = studentList.stream()
                .sorted(Comparator.comparing(StudentInfo::getAge).reversed().thenComparing(StudentInfo::getHeight))
                .collect(Collectors.toList());
        //排序后输出
        StudentInfo.printStudents(studentsSortName);
    }

    private static List<StudentInfo> prepareData() {
        //测试数据，请不要纠结数据的严谨性
        List<StudentInfo> studentList = new ArrayList<>();
        studentList.add(new StudentInfo("李小明", true, 18, 1.76, LocalDate.of(2001, 3, 23)));
        studentList.add(new StudentInfo("张小丽", false, 18, 1.61, LocalDate.of(2001, 6, 3)));
        studentList.add(new StudentInfo("王大朋", true, 19, 1.82, LocalDate.of(2000, 3, 11)));
        studentList.add(new StudentInfo("陈小青", false, 17, 1.67, LocalDate.of(2002, 10, 18)));
        return studentList;
    }
}
