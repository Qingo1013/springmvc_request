package cn.tulingxueyuan.controllers;

import cn.tulingxueyuan.entity.Role;
import cn.tulingxueyuan.entity.User;
import cn.tulingxueyuan.entity.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 *
 * 处理请求参数
 * 之前使用servlet 需要自己绑定参数
 * requset.getParameter("name")
 * 在spingmvc中只需要在处理方法中声明对应的参数就可以自动接受请求的参数并且自动转换类型
 * 自动转换体现在
 * servlet api:
 *  if(requset.getParameter("name")!=null){
 *      /转换
 *  }
 *  报错400：参数问题
 *  匹配规则：
 *  请求的参数名必须与处理方法的参数名一致
 *  如果未传入参数，会自动传入null
 *  如果请求的参数名必须与处理方法的参数名不一致：
 *  可以利用 @RequestParam 管理请求参数，用了此注解后，必须要传入参数值否则报错400
 *  value 用来重命名参数
 *  required 用来指定参数是否必须传入值
 *      true(default) 必须要传入，否则报错
 *      false 可以不传入
 *      ：
 *      注意：不用用基础类型，因为他不能接受null，要用包装类
 * defaultValue（默认值）:当参数为null时自动设置一个默认值
 *      注意：当设置了默认值时，可以省略flase
 *  处理请求参数乱码：
 *      GET：直接设置tomcat目录下conf/server.xml 里的<Connector URIEncoding="utf-8"></Connector>
 *      POST:
 *          (1)在使用servlet时期：
 *              在每个处理请求的方法内，获取参数之前，设置request.setCharacterEncoding("utf-8")
 *              这样，非常麻烦，所以我们选择使用过滤器解决编码问题（终极解决方式）
 *          (2)使用springmvc提供的编码过滤器解决乱码问题：CharacterEncodingFilter，在web.xml配置
 *    复杂数据类型
 *      对象：不用加上参数名字（不用对象的具体名字），直接传入该对象对应的属性名字
 *          如果是包装类的基础数据类型，直接输入属性名字=表单元素的name，如name="id"
 *          如果是数组，要保证这一组表单元素都是同样的name,如name="alias"
 *          List:必须加上[索引],如name="list[0]" List<User> ：name="list[0].name"
 *          Map:必须加上[key]，如name="map['key']"
 *          实体类：只能给某个属性去赋值 name="object.xxx"
 *      注意：如果出现多个对象参数的情况(如User user，Role role)，只能再次封装一层javaBean(DTO: data transfer object)
 */
@Controller
public class ParasController {
    @RequestMapping("/params01")
    public String params01(@RequestParam(value="username",required = false,defaultValue = "qqa") String name){
        System.out.println(name);
        return "/index.jsp";
        // return "redirect:index.jsp";
    }

    /**
     * 复杂数据类型参数自动绑定
     * @param
     * @return
     * User类有id,name；Role类也有id,name；无法正确的自动绑定
     * @param userDTO
     * @return
     */
    @RequestMapping("/params02")
    public String params02(UserDTO userDTO){//(User user, Role role){
        System.out.println(userDTO);
        return "/index.jsp";
    }

    /**
     * 抓取请求头信息
     * @RequestHeader 注解
     * 里面也有 required 和 defaultValue
     * servelt:request.getHeader()
     * @param host
     * @return
     */
    @RequestMapping("/header")
    public String header(@RequestHeader("Host") String host){
        System.out.println(host);
        return "/index.jsp";
    }

    /**
     *  抓取cookie的值
     *  servlet:
     *      Cookie [] cookies  = request.getCookies();
     *      for(Cookie cookie:cookies){
     *          if(cookie.getValue.equals("JSESSIONID")){
     *              //getName
     *          }
     *
     *      }
     * @param jsessionId
     * @return
     */
    @RequestMapping("/cookie")
    /*获取所有cookie：@CookieValue Map<Stirng,String>*/
    public String cookie(@CookieValue("JSESSIONID") String jsessionId){
        System.out.println(jsessionId);
        return "/index.jsp";
    }

    /**
     * servlet原生支持,获取servlet api
     * 可以和springmvc结合起来一起用，会自动绑定
     * @param username
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("/servlet")
    public String servlet(String username,HttpServletRequest request, HttpServletResponse response)throws IOException {
        request.getSession();
        request.getUserPrincipal();
        request.getLocale();
        response.getWriter();
        response.getOutputStream();
        String name = request.getParameter("name");
        request.setAttribute("name",name);
        System.out.println(name);
        return "/index.jsp";
    }
    /**
     *
     * @param user
     * @return
     *     @RequestMapping("/params02")
     *     public String params02(User user){
     *         System.out.println(user);
     *         return "/index.jsp";
     *     }
     */


    /**
     *     public String params01(@RequestParam("username") String name){
     *         System.out.println(name);
     *         return "/index.jsp";
     *         // return "redirect:index.jsp";
     *     }
     */

    /**
     *     public String params01(String name){
     *         System.out.println(name);
     *         return "/index.jsp";
     *         // return "redirect:index.jsp";
     *     }
     */


    /**
     *
     *     public String params01(Integer age){
     *         System.out.println(age);
     *         return "/index.jsp";
     *     }
     *
     *
     *
     */
}
