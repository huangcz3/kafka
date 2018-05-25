package com.xxx.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Huangcz
 * @date 2018-05-25 17-36
 * @desc
 */
public class LambdaTest {


    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();
        Map<String,Student> studentMap = new HashMap<>();
        Student s1 = new Student("程序员汪汪",18,"男",10,1.0f);
        Student s2 = new Student("小芳",18,"女",1000,1.1f);
        Student s3 = new Student("小红",16,"女",50,1.2f);
        Student s4 = new Student("小雅",16,"女",10000,1.5f);

        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);

        studentMap.put("001",new Student("程序员汪汪",29,"男",10,1.5f));
        studentMap.put("002",new Student("小芳",18,"女",1000,1.5f));

        //学生名单
        List<String> name = studentList.stream().map(Student::getName).collect(Collectors.toList());

        //性别为女的student
        List<String> girlName = studentList.stream().filter(f -> "女".equals(f.getSex())).map(Student::getName).collect(Collectors.toList());

        //rmb大于1000的
        List<Student> s5 = studentList.stream().filter(f -> f.getRmb() > 1000).collect(Collectors.toList());

        List<Student> students = studentMap.entrySet().stream().map(stringStudentEntry -> {
           final Student ss = stringStudentEntry.getValue();
           final String num = stringStudentEntry.getKey();
           ss.setNumber(num);
           return ss;
        }).collect(Collectors.toList());

        System.out.println(girlName);

        System.out.println(students);

    }

}
