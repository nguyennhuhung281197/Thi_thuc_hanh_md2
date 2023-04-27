package model;

import java.io.Serializable;

public class Student implements Serializable {

    private String code;
    private String name;
    private int age;
    private String sex;
    private String address;

    private double mediumScore;

    public Student() {
    }

    public Student(String code, String name, int age, String sex, String address, double mediumScore) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.mediumScore = mediumScore;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMediumScore() {
        return mediumScore;
    }

    public void setMediumScore(double mediumScore) {
        this.mediumScore = mediumScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", mediumScore=" + mediumScore +
                '}';
    }
}
