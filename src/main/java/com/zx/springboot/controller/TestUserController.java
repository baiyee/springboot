package com.zx.springboot.controller;

import com.zx.springboot.entity.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;

@RestController
public class TestUserController {

    @GetMapping(value = "/index")
    public String index() {
        return "this is index page";
    }

    @PostMapping(value = "/user")
    public String testUserValidator(@Valid User user, BindingResult bindingResult) {
        StringBuffer stringBuffer = new StringBuffer();
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError : allErrors) {
                stringBuffer.append(objectError.getDefaultMessage());
                stringBuffer.append("---------");
            }

        }
        return stringBuffer != null ? stringBuffer.toString() : "";
    }

}
