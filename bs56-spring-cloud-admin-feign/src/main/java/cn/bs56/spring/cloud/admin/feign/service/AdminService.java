package cn.bs56.spring.cloud.admin.feign.service;

import cn.bs56.spring.cloud.admin.feign.service.hystrix.AdminServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 *  @FeignClient("服务名")  通过该注解来指定调用哪个服务
 *  fallback 熔断器配置的具体实现，熔断器的本质是无法调用后续链式应用时，
 *  对数据进行统一的返回，标示该后续应用无法使用
 * @author LiLei
 * @version 1.0
 * @exception
 * @Deprecated
 **/
@FeignClient(value = "bs56-spring-cloud-admin", fallback = AdminServiceHystrix.class)
public interface AdminService {


    /**
     *  @RequestParam(value = "message")  必须要和被服务者一致，必须加RequestParam，否则无法获取到
     *
     * @author LiLei
     * @date 10:01 2019/6/28
     * @param message
     * @return java.lang.String
     **/
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHi(@RequestParam(value = "message") String message);

}
