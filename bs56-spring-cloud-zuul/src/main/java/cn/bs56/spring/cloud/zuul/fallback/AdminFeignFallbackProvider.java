package cn.bs56.spring.cloud.zuul.fallback;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 *  路由转发失败时的回调
 *
 * @author LiLei
 * @version 1.0
 * @exception
 * @Deprecated
 **/
@Component
public class AdminFeignFallbackProvider implements FallbackProvider {


    /**
     *  支持转发失败回调的服务，返回ServiceId，如果需要所有调用都支持回退，则 return "*" 或 return null
     *
     * @author LiLei
     * @date 14:04 2019/6/28
     * @return java.lang.String
     **/
    @Override
    public String getRoute() {
//        对单个服务的支持的配置
//        return "bs56-spring-cloud-admin-ribbon";
        return null;
    }

    /**
     *  如果请求服务失败，则返回指定的信息给调用者
     *
     * @author LiLei
     * @date 14:07 2019/6/28
     * @param route   路由
     * @param cause   异常配置
     * @return org.springframework.http.client.ClientHttpResponse
     **/
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {

            /**
             *  返回状态码
             *
             *  网关对服务的调用失败，但是UI客户端（浏览器）对网关的调用是成功的
             *  故不应该把API服务返回给网关的400,500等错误码直接返回给客户端
             *
             * @author LiLei
             * @date 14:10 2019/6/28
             * @return org.springframework.http.HttpStatus
             **/
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            /**
             *  状态码的值
             *
             * @author LiLei
             * @date 14:15 2019/6/28
             * @return int
             **/
            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            /**
             *  状态的描述
             *
             * @author LiLei
             * @date 14:15 2019/6/28
             * @return java.lang.String
             **/
            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            /**
             *  返回给前端的错误信息
             *
             * @author LiLei
             * @date 14:16 2019/6/28
             * @return java.io.InputStream
             **/
            @Override
            public InputStream getBody() throws IOException {
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, Object> map = new HashMap<>();
                map.put("status", 200);
                map.put("message", "无法连接，请检查您的网络");
                return new ByteArrayInputStream(objectMapper.writeValueAsString(map).getBytes("UTF-8"));
            }

            /**
             *  对请求头设置编码格式
             *
             * @author LiLei
             * @date 14:17 2019/6/28
             * @return org.springframework.http.HttpHeaders
             **/
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                // 和 getBody 中的内容编码一致
                headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return headers;
            }
        };
    }
}
