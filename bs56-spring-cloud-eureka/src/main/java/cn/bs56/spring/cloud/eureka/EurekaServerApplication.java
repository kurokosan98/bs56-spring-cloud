package cn.bs56.spring.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *  @SpringBootApplication  表示是一个springboot项目
 *  @EnableEurekaServer 表明是一个注册发现的服务
 * @author LiLei
 * @version 1.0
 * @exception
 * @Description
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class,args);
    }
}
