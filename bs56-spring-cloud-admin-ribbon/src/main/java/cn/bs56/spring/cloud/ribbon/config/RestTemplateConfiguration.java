package cn.bs56.spring.cloud.ribbon.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 *  服务与服务的通讯是基于 http restful 的
 *  rebbon的通讯需要restTemplate的组合
 *
 * @author LiLei
 * @version 1.0
 * @exception
 * @Deprecated
 **/
@Configuration
public class RestTemplateConfiguration {


    /**
     *  @Bean  表示这个是javaBean，交由spring管理
     *  @LoadBalanced  开启负载均衡功能
     * @author LiLei
     * @date 11:46 2019/6/28
     * @return org.springframework.web.client.RestTemplate
     **/
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplateBean(){
        return  new RestTemplate();
    }

}
