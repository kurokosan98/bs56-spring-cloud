package cn.bs56.spring.cloud.ribbon.service.impl;

import cn.bs56.spring.cloud.ribbon.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author LiLei
 * @version 1.0
 * @exception
 * @Deprecated
 **/
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     *
     *
     * @author LiLei
     * @date 11:52 2019/6/28
     * @param message  传入的消息
     * @return java.lang.String  返回的信息
     **/
    @Override
    public String sayHi(String message) {
        return restTemplate.getForObject("http://BS56-SPRING-CLOUD-ADMIN/hello?message=" + message, String.class);
    }
}
