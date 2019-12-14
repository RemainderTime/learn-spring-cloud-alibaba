package com.xf.alibaba.nacosdiscoveryconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @program: learn-alibaba
 * @author: RemainderTime(xiongfeng)
 * @date: 2019-12-14 11:13
 * @description: 服务消费者
 **/
@RestController
@RequestMapping("consumer")
public class NacosConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/test")
    public String test(String name){
        ServiceInstance choose = loadBalancerClient.choose("navos-discovery-provider");
        URI uri = choose.getUri();
        return restTemplate.getForObject(uri+"provider/demo/?name="+name,String.class);
    }

}
