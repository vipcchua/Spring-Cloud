package com.cchuaspace.service;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

 

@Service
@Scope("prototype")
public class HelloService {

      

       /**

        * 启动的时候观察控制台是否打印此信息;

        */

       public HelloService() {

              System.out.println("HelloService2.HelloService2()");

              System.out.println("HelloService2.HelloService2()");

              System.out.println("HelloService2.HelloService2()");

       }

}