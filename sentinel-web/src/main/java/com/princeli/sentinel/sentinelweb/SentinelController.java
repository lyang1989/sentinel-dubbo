package com.princeli.sentinel.sentinelweb;

import com.princeli.sentinel.SentinelService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : princeli
 * @version 1.0
 * @className SentinelController
 * @date 2019-10-26 20:30
 * @description: TODO
 */
@RestController
public class SentinelController {

    @Reference(timeout = 3000)
    SentinelService sentinelService;

    @GetMapping("/say")
    public String sayHello(){
        RpcContext.getContext().setAttachment("dubboApplication","sentinel-web");
        return sentinelService.sayHello("test");
    }

    @GetMapping("/say2")
    public String sayHello2(){
        return sentinelService.sayHello("test2");
    }


}
