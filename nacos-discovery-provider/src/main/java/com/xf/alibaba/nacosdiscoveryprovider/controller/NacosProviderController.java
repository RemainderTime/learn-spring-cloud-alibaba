package com.xf.alibaba.nacosdiscoveryprovider.controller;

/**
 * @author RemainderTime
 * @date 2019/12/14 11:05
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("provider")
public class NacosProviderController {

    @GetMapping(value = "/demo")
    public String getData(String name){
        return "name:"+name;
    }
}
