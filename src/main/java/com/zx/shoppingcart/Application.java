package com.zx.shoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    //把控制权交给spring
    //初始化所有的组件，根据依赖关系把所有组件所依赖的所有组件初始化，然后注入

}
