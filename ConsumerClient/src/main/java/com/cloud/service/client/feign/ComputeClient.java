package com.cloud.service.client.feign;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("micro-service-a")
public interface ComputeClient {

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    String add();

}
