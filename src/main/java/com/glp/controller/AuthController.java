package com.glp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zmm
 * @date 2019/12/16
 */

@RestController
public class AuthController {
    @GetMapping("/test11111")
    public String getINfo() {
        return "sttt1";
    }

    @GetMapping("/login")
    public String login() {
        return " login error";
    }
}
