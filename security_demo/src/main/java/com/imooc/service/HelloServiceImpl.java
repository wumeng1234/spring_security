package com.imooc.service;

import org.springframework.stereotype.Service;

/**
 * Created by 吴猛
 * Date:2019/1/29
 */
@Service
public class HelloServiceImpl implements HelloService{
    @Override
    public void hello(String name) {
        System.out.println("hello:"+name);
    }
}
