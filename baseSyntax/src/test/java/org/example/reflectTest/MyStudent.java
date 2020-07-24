package org.example.reflectTest;

public class MyStudent {
    private String name;
    private String sex;
    private Integer age;

    public MyStudent(){
        System.out.println("MyStudent无参构造器");
    }

    public MyStudent(String name, String sex, Integer age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        System.out.println("MyStudent有参构造器");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyStudent{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
