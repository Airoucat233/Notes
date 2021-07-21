package com.airoucat.ssmdemo.controller;

import com.airoucat.ssmdemo.entity.User;
import com.airoucat.ssmdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getList")
    public String getList(Model model) {
        // 将数据存到model对象里，这样jsp就能访问数据
        model.addAttribute("userList", userService.getAll());
        // 返回jsp文件名
        return "index";
    }

    @GetMapping("/getJson")
    @ResponseBody
    public List<User> getList() {
        // 如果想做前后端分离的话可以加上@ResponseBody注解，直接返回数据对象，这样前端就可以通过获取json来渲染数据了
        return userService.getAll();
    }
}
