package com.alan.ribbonconsumer.controller;

import com.alan.ribbonconsumer.lisenter.LoginLisenter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : <a href="mailto:liuqi@ebnew.com">liuqi</a>
 * @version : v1.0
 * @date :  2020-01-15 10:25
 * @description :
 */
@Controller
public class UserController {

    @Value("${application.message:Hello World}")
    private String message;

    @GetMapping("/asd/{name}")
    public String welcome(@PathVariable String name,Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", this.message);
        return "welcome";
    }

    @RequestMapping("/login")
    @ResponseBody
    public Object foo(){
        return "login";
    }

    @RequestMapping("/index")
    @ResponseBody
    public Object index(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        session.setAttribute("zxc", "zxc");
        return "index";
    }

    @RequestMapping("/onLine")
    @ResponseBody
    public Object onLine(){
        return "当前在线人数:"+ LoginLisenter.onLine;
    }
}
