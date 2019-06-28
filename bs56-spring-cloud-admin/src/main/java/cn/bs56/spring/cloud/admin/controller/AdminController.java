package cn.bs56.spring.cloud.admin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiLei
 * @version 1.0
 * @exception
 * @Deprecated
 **/
@RestController
public class AdminController {

    /**
     *  获取端口
     *
     * @author LiLei
     * @date 9:57 2019/6/28
     * @param
     * @return
     **/
    @Value("${server.port}")
    private String port;


    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "message") String message){
        return String.format("Hi，your message is : %s i am from port : %s", message,port);
    }





}
