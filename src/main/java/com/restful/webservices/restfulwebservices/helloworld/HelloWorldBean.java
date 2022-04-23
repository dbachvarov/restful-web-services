package com.restful.webservices.restfulwebservices.helloworld;

/**
 * Created by danielbachvarov on 21/01/2022
 */
public class HelloWorldBean {
    private String message;
    public HelloWorldBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message+'1';
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
//        return "HelloWorldBean{" +
//                "message='" + message + '\'' +
//                '}';
        return String.format("HelloWorldBean [message=%s]",message);
    }
}
