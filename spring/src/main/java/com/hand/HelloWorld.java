package com.hand;

public class HelloWorld implements IHelloMessage{

    private String message1;
    private String message2;

    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    public String getMessage1() {
        return message1;
    }

    public String getMessage2() {
        return message2;
    }


    @Override
    public String sayHello() {
        return "Hello World";
    }
}
