package com.xxx.lambda;

/**
 * @author Huangcz
 * @date 2018-05-25 17-34
 * @desc
 */
public class Student {

    private String name;

    private int age;

    private String sex;

    private int rmb;

    private float tuiLength;

    private String number;

    public Student(){}

    public Student(String name, int age, String sex, int rmb, float tuiLength) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.rmb = rmb;
        this.tuiLength = tuiLength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getRmb() {
        return rmb;
    }

    public void setRmb(int rmb) {
        this.rmb = rmb;
    }

    public float getTuiLength() {
        return tuiLength;
    }

    public void setTuiLength(float tuiLength) {
        this.tuiLength = tuiLength;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
