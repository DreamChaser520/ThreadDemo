package com.zh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

import static com.zh.service.TestService.*;

@Controller
public class TestController {
    @RequestMapping("/hello")
    @ResponseBody
    public Map<String, String> showHelloWorld() {
        Map<String, String> map = new HashMap<>();
        map.put("msg", "HelloWorld");
        return map;
    }

    @RequestMapping("/sleep")
    @ResponseBody
    public Map<String, String> sleep() {
        sleepTest();
        Map<String, String> map = new HashMap<>();
        map.put("msg", "sleep");
        return map;
    }

    @RequestMapping("/deadLock")
    @ResponseBody
    public Map<String, String> deadLock() {
        return deadLockTest();
    }

    @RequestMapping("/multiThread")
    @ResponseBody
    public Map<String, String> multiThread() {
        return multiThreadTest();
    }
}
