package cn.tulingxueyuan.controllers;

import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 *
 *
 * @RequestMapping 用来处理URL映射 将请求映射到处理方法中
 *
 */
@Controller
/**
 * @RequestMapping
 * 除了可以用在方法上，还可以用在类上：
 * （1）将请求的URL模块化
 * （2）解决请求重复的情况，因为基本每一个Controller类都会有增删查改
 *  如果加在类上面，该类所有请求方法的映射都必须加上类的映射：
 *      例如@RequestMapping("/mapping")，请求必须为 /mapping/xxx
 *  参数：
 *      （1）value：设置请求映射名字
 *      （2）method：设置请求方式 GET/POST
 *              可以同时设置多个请求方式：method = {RequestMethod.POST, RequestMethod.GET}
 *              如果不写，可以匹配所有请求方式
 *   从spring4.3开始，提供了一套请求方式的注解
 *     @GetMapping
 *     @PutMapping
 *     @DeleteMapping
 *   (例如@PostMapping("/mapping01")，等同于@RequestMapping(value = "/mapping01",method = {RequestMethod.POST}))
 *   直接通过URL的话是GET请求
 *   错误：HTTP Status 405 – Request method 'GET' not supported (method属性)
 *   params:设置请求必须携带的某些参数
 *      方式：1.必须要有某些参数 例如，必须要有username，params = {"username"}
 *            2.必须没有某些参数 例如，必须不能有username，params = {"!username"}
 *            3.某些参数的值必须要等于什么 例如，params = {"username=wxy"}
 *            4.某些参数的值必须不能等于什么 例如，params = {"username!=wxy"}
 *   headers：请求头必须包含每个值 例如，headers = {"Accept-Language=zh-CN,zh;q=0.9" }
 *   consumes：设置请求内容类型为指定值
 *              常见的请求内容类型：
 *                  1.application/x-www-form-urlencoded form表单提交默认的内容类型(getParameter)
 *                      `consumes = {"application/x-www-form-urlencoded" }
 *                  2.multipart/form-data form表单提交文件流的内容类型
 *                  3.application/json ajax提交的json内容类型
 *   错误：HTTP Status 415 – Unsupported Media Type (请求内容类型不匹配，consumes属性)
 *   produces：设置响应内容类型为指定值
 *      produces = {"application/json" }
 *  映射的URL还可以是通配符 /ANT style
 *      1.? 匹配单个字符(a-z0-9)1
 *      2.* 匹配任意多个字符(a-z0-9)1
 *      3** 匹配任意个字符任意层次 /** /
 *      如果映射存在包含关系，会优先交给更精确的那个映射处理
 *      none>?>*>**
 *      ant? ant*  /** /ant ant
 *      localhost:8080/springmvc/mapping/ant -> ant
 *      localhost:8080/springmvc/mapping/ant1 -> ant?
 *      localhost:8080/springmvc/mapping/ant12 -> ant*
 */
@RequestMapping("/mapping")
public class MappingController {
    //@PostMapping("/mapping01") 等同于下面的写法

    @RequestMapping(value = "/mapping01",method = {RequestMethod.POST, RequestMethod.GET})
    public String mapping01() {
        System.out.println("Mapping success!");
        return "/index.jsp";
    }

    @RequestMapping(value = "/params", params = {"username=wxy"})
    public String mapping03(){
        System.out.println("Request success!");
        return "/index.jsp";
    }

    @RequestMapping(value = "/headers", headers = {"Accept-Language=zh-CN,zh;q=0.9" })
    public String mapping04(){
        System.out.println("Request header mapping!");
        return "/index.jsp";
    }
//   请求的内容类型
    @RequestMapping(value = "/consumes", consumes = {"application/x-www-form-urlencoded" })
    public String mapping02(){
        System.out.println("Request content type mapping!");
        return "/index.jsp";
    }


    //   响应的内容类型
    @RequestMapping(value = "/produces", produces = {"application/json" })
    public String mapping05(){
        System.out.println("Response content type!");
        return "/index.jsp";
    }
    //通配符
    //localhost:8080/springmvc/mapping/ant1
    //?和*都能匹配时，?优先，他更具体，更细粒度
    @RequestMapping(value = "/ant?")
    public String mapping06(){
        System.out.println("通配符之?");
        return "/index.jsp";
    }
    @RequestMapping(value = "/ant*")
    public String mapping07(){
        System.out.println("通配符之*");
        return "/index.jsp";
    }
    @RequestMapping(value = "/**/ant")
    public String mapping08(){
        System.out.println("通配符之**");
        return "/index.jsp";
    }



//    @RequestMapping(value = "/mapping01",method = RequestMethod.POST)
//    public String mapping01() {
//        System.out.println("Mapping success!");
//        return "/index.jsp";
//    }


    //    @RequestMapping("/mapping01")
//    public String mapping01() {
//        System.out.println("Mapping success!");
//        return "/index.jsp";
//    }

}
