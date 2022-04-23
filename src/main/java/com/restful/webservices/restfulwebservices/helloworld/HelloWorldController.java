package com.restful.webservices.restfulwebservices.helloworld;

import com.restful.webservices.restfulwebservices.helloworld.HelloWorldBean;
import org.springframework.web.bind.annotation.*;

/**
 * Created by danielbachvarov on 21/01/2022
 */
@RestController
//http://localhost:4200
@CrossOrigin(origins = "http://localhost:4200")
public class HelloWorldController {
    @RequestMapping
    public String helloWorld(){
        return "Hello World";
    }
    // Get
    //URI -/hi-world
    @RequestMapping(value ="/hi" ,method= RequestMethod.GET)
    public String hiWorld(){
        //throw new RuntimeException("Something went wrong"); // error 500
        return "Hi World";
    }
    //hello-world-bean
    @RequestMapping(value ="/hello-world-bean" ,method= RequestMethod.GET)
    public HelloWorldBean helloWorldBean(){
        // it the class has no getter it will not return
        return new HelloWorldBean("Hi World");
    }
    // path parameter example
    // path: /hello-world-bean/iceKing
    //@PathVariable
    @RequestMapping(value ="/hello-world-bean/path-variable/{name}" ,method= RequestMethod.GET)
    public HelloWorldBean helloWorldBeanPath(@PathVariable String name){
        // it the class has no getter it will not return

        return new HelloWorldBean(String.format("Hello World %s",name));
    }

    @GetMapping (value = "/bean/{name}")
    public String helloWorldBean(@PathVariable String name){
        HelloWorldBean hl= new HelloWorldBean(name);
        return hl.toString();
    }

}
