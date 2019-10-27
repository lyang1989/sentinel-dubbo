package com.princeli.sentinel.sentinelprovider;

import com.princeli.sentinel.SentinelService;
import org.apache.dubbo.config.annotation.Service;

import java.time.LocalDateTime;

/**
 * @author : princeli
 * @version 1.0
 * @className SentinelServiceImpl
 * @date 2019-10-26 20:01
 * @description: TODO
 */
@Service
public class SentinelServiceImpl implements SentinelService {
    @Override
    public String sayHello(String txt) {
        return "hello world:"+ LocalDateTime.now();
    }
}
