package com.glp.controller.user;

import com.glp.anotation.NoRepeatSubmit;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zmm
 * @date 2019/12/12
 */
@RestController
public class UserController {
    @NoRepeatSubmit
    @RequestMapping(value = "/test1111", method = RequestMethod.GET)
    public String getUserInfo() {
        return "Hello ";

    }
}
