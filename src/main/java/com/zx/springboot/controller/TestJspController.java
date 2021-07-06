package com.zx.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * </p>
 *
 * @author ZhangXuan
 * @since 2018/8/16 16:32
 */
@Controller
@RequestMapping(value ="/view")
public class TestJspController {

    @RequestMapping(value = "/hello")
    public String index(Model model) {
        model.addAttribute("name","zhangsan");
        return "hello ";
    }
}
