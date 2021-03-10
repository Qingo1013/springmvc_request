package cn.tulingxueyuan.controllers;

import cn.tulingxueyuan.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

/**
 * 基于服务api的方式使用restful api
 * 返回的不是视图名字，而是返后一个json数据
 *
 */

//加到IOC容器当中
@RestController
@RequestMapping("restful")
public class RestfulController {
    //    查询
    @GetMapping("/user/{id}")
    public String get(@PathVariable("id") Integer id){
        System.out.println("select from user "+id);
        return "{'id':'001','name':'qqa'}";
    }
    //    新增
    @PostMapping("/user")
    public String add(User user){
        System.out.println("insert user "+user);
        return "{'msg':'success'}";
    }
    //    修改
    @PutMapping("/user/{id}")
    public String update(User user){
        System.out.println("update user "+user);
        return "{'msg':'success'}";
    }
    //    删除
    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable("id") Integer id){
        System.out.println("delete user "+id);
        return "{'msg':'success'}";
    }


}
