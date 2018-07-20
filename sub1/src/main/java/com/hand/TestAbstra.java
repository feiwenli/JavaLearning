package com.hand;

import java.time.LocalDate;

/**
 * 抽象类的一个测试
 * equals方法判断两个对象是否相等
 */

interface Comparable<T>{
    int compareTo(T other);
}

abstract class Person{
    public abstract String getDescription();
    public String name;

    public Person(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}

class Employee extends Person implements Comparable<Employee>{
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary, int year, int month, int day){
        super(name);
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }


    @Override
    public String getDescription() {
        return String.format("an employee with salary of $%.2f", salary);
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public boolean equals(Object otherObject){

        // java 核心技术 卷1 P68-169
        // 检测是否引用同一个对象
        if (this == otherObject) return true;

        if (otherObject == null) return false;

        // 检测是否属于同一个类
        // getClass 返回一个对象所属的类
        if (getClass() != otherObject.getClass()) return false;

        Employee other = (Employee) otherObject;

        return name.equals(other.name) && salary == other.salary && hireDay.equals(other.hireDay);

    }

    @Override
    public int compareTo(Employee other) {
        return Double.compare(salary, other.salary);
    }
}

class Manage extends Employee{

    private double bonus;

    public Manage(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonus = 0;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (! super.equals(otherObject)) return false;
        Manage other = (Manage)otherObject;
        return bonus == other.bonus;
    }
}

class Student extends Person{
    private String major;

    public Student(String name, String major) {
        super(name);
        this.major = major;
    }

    @Override
    public String getDescription() {
        return "a student majoring in "+major+" .";
    }
}

public class TestAbstra {
    public static void main (String [] args){
        Employee e = new Employee("李四", 2000, 1998, 9, 15);
        System.out.println(e.getDescription());
        Student s = new Student("王五","化学");
        System.out.println(s.getDescription());

        Person [] people = new Person[2];

        people[0] = new Employee("Heacker", 3000, 2001, 8, 2);
        people[1] = new Student("Ann", "化学");

        for (Person p : people){
            System.out.println(p.getName()+", "+p.getDescription());
        }

        System.out.println(people[0].equals(e));

        Manage m = new Manage("huoer", 9000, 1998, 8, 9);
        System.out.println(m.getName()+" , "+m.getDescription());
    }
}
