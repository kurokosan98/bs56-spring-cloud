package cn.bs56.spring.cloud.admin.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *  @EnableEurekaClient  表示这是服务的消费者（调用别人）
 *  @EnableDiscoveryClient  表示这是服务的消费者（调用别人）
 *  区别：1，@EnableDiscoveryClient注解是基于spring-cloud-commons依赖，并且在classpath中实现；
 *        2，@EnableEurekaClient注解是基于spring-cloud-netflix依赖，只能为eureka作用；
 *        如果你的classpath中添加了eureka，则它们的作用是一样的。
 *
 *  @EnableFeignClients   表示启用feign的客户端，开启 Feign 功能
 * @EnableHystrixDashboard  表示可以使用熔断器监控仪表盘
 * @author LiLei
 * @version 1.0
 * @exception
 * @Deprecated
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrixDashboard
public class AdminFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminFeignApplication.class,args);
    }
}
