package cn.tulingxueyuan.controllers;

import cn.tulingxueyuan.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
/**
 *
 * form 表单提交put和delete出现问题：会将put和delete作为get提交，因为html不支持put和delete
 *      解决：
 *          1.需要添加HiddenHttpMethodFilter过滤器
 *          2.需要在表单中添加一个隐藏域，<input type="hidden" value="put" name="_method"> value就是对应的请求方式
 *          3.将form的method设为post
 *          4.过滤器就会自动将post请求修改成隐藏域对应值（put/delete）得请求
 *
 * tomcat 7以上的版本对request.method更加严格：只支持get/post/head
 * HTTP Status 405 – Method Not Allowed
 *      解决方法1：
 *          1.同tomcat7
 *          2.不用转发用重定向（重定向有两次请求服务）
 *          3.将jsp的page指定isErrorPage属性改成true（isErrorPage，出现错误时，给用户一个友好的界面，后台记录日志）
 *          4.自己写一个filter过滤器，将request.method改回POST
 */

//加到IOC容器当中
@Controller
@RequestMapping("rest")
public class RestController {
    //    查询
    @GetMapping("/user/{id}")
    public String get(@PathVariable("id") Integer id){
        System.out.println("select from user "+id);
        return "/index.jsp";
    }
    //    新增
    @PostMapping("/user")
    public String add(User user){
        System.out.println("insert user "+user);
        return "/index.jsp";
    }
    //    修改
    @PutMapping("/user/{id}")
    public String update(User user){
        System.out.println("update user "+user);
        return "redirect:/index.jsp";
    }
    //    删除
    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable("id") Integer id){
        System.out.println("delete user "+id);
        return "redirect:/index.jsp";
    }


}
