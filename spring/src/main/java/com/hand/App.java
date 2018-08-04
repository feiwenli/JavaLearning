package com.hand;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;

public class App 
{
    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/helloMessage.xml");
        Person p = beanFactory.getBean(Person.class);
        System.out.println(p.sayHello());

        //1.创建spring的ioc容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/helloMessage.xml");
        //2.从ioc容器中获取bean实例
        Person person = (Person) applicationContext.getBean("person");
        String s = person.sayHello();
        System.out.println("The Person is currently saying "+s);


        // Bean 继承 Test
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/helloMessage.xml");
        HelloWorld world = (HelloWorld)context.getBean("helloWorld");
        System.out.println(world.getMessage1());
        System.out.println(world.getMessage2());

        HelloChina china = (HelloChina)context.getBean("helloChina");
        System.out.println(china.getMessage1());
        System.out.println(china.getMessage2());
        System.out.println(china.getMessage3());

        // 集合Test
        JavaCollection jc = (JavaCollection)context.getBean("javaCollection");
        jc.getAddressList();
        jc.getAddressMap();
        jc.getAddressProp();
        jc.getAddressSet();



    }
}
