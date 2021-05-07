package com.test.fishmarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @GetMapping(value = "/message")
    @ResponseBody
    public String testByResponseBody() {
        String message = "안녕하세요. 잠시 후에 화면에서 만나요!";
        return message;
    }

}