package top.imlgw.demo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.imlgw.demo.pojo.User;

import javax.servlet.http.HttpSession;
import java.util.Optional;


/**
 * @author imlgw.top
 * @date 2019/11/18 20:41
 */
@Controller
public class TestController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/index")
    public String index(){ //登陆之后才能访问
        return  "index";
    }


    @RequestMapping("/admin")
    @ResponseBody
    public String admin(){ //只有admin角色的用户可以访问
        return  "admin success";
    }

    @RequestMapping("unauthorized")
    public String unauthorized(){ //未授权页面
        return "unauthorized";
    }

    @RequestMapping("edit")
    @ResponseBody
    public String edit(){ //只有具有edit权限的用户才能访问
        return "edit success !!!";
    }

    @RequestMapping("/logout")
    public String logout() {//登出
        Subject subject = SecurityUtils.getSubject();
        Optional.ofNullable(subject).ifPresent(Subject::logout);
        return  "login";
    }

    @RequestMapping("/doLogin")
    public String loginUser(@RequestParam("username") String username, @RequestParam("password") String password,
                            HttpSession session){
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        System.out.println(token);
        Subject subject =SecurityUtils.getSubject();
        try{
            subject.login(token);
            User user= (User) subject.getPrincipal();
            session.setAttribute("user",user);
            return "index";
        }catch (Exception e){
            e.printStackTrace();
            return "login";
        }
    }

}
