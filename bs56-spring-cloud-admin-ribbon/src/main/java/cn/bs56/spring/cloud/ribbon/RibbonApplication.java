package cn.bs56.spring.cloud.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author LiLei
 * @version 1.0
 * @exception
 * @Deprecated
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrixDashboard
public class RibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class,args);
    }

}
