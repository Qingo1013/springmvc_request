package cn.tulingxueyuan.controllers;

import cn.tulingxueyuan.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/*
*   获取URL路径中的值
*   @PathVariable 是用在参数上面的(顾名思义，参数变量)
*   专门用来获取URL目录级别的参数
*   比如：http://localhost:8080/springmvc/path/user/123/qqa
*       想要获得123 @RequestMapping("/user/{id}") @PathVariable("id") Integer id
*
*       如果是单个参数接受的话，必须要使用@PathVariable来声明对应的参数占位符名字
*       如果是JavaBean，则可以省略@PathVariable，但是要保证占位符的名字与JavaBean属性名字一致对应
*
* */
@Controller
@RequestMapping("/path")
public class PathvariableController {
    /**
     *  获取用户实体 传入id
     */
    @RequestMapping("/user/{id}/{username}")
    public String path01(@PathVariable("id") Integer id, @PathVariable("username") String name ){
        System.out.println(id);
        System.out.println(name );
        return "/index.jsp";
    }

    @RequestMapping("/user02/{id}/{username}")
    public String path02(User user ){
        System.out.println(user);
        return "/index.jsp";
    }
}
