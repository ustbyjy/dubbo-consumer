package com.yjy.consumer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yanjingyang@zulong.com
 * Date: 2017/3/1
 * Time: 16:13
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("msg", "首页");

        return "index";
    }

}
