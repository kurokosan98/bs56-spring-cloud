package cn.bs56.spring.cloud.admin.feign.service.hystrix;

import cn.bs56.spring.cloud.admin.feign.service.AdminService;
import org.springframework.stereotype.Component;

/**
 * @Component 表示该类交由spring来管理，（实例化bean和回收）
 *  熔断器的实现
 * @author LiLei
 * @version 1.0
 * @exception
 * @Deprecated
 **/
@Component
public class AdminServiceHystrix implements AdminService {


    @Override
    public String sayHi(String message) {
        return "Hi，your message is :\"" + message + "\" but request error.";
    }
}
