package com.springboot.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by yash.gupta on 7/30/2019.
 */
@EnableJpaRepositories(basePackages = "com.springboot.App.repository")
@SpringBootApplication
@EntityScan("com.springboot.App.domain")
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
