package com.hhuc.crowdcount.controller;

import com.hhuc.crowdcount.model.User;
import com.hhuc.crowdcount.service.UserService;
import com.hhuc.crowdcount.util.common.MD5Util;
import com.hhuc.crowdcount.util.common.PicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class IndexController {

    @Autowired
    UserService userService;


    @RequestMapping(value = {"/", "login"}, method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    /**
     * 生成验证码
     */
    @RequestMapping("/code/getCaptchaCode")
    public ModelAndView getCaptchaCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");

        ServletOutputStream out = response.getOutputStream();
        String code = MD5Util.generateVerifyCode(4, null);
        PicUtil.outputImage(100, 40, out, code);

        session.setAttribute("code", code);

        try {
            out.flush();
        } finally {
            out.close();
        }
        return null;
    }

    /**
     * 登录验证
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public int loginCheck(@RequestParam("account") String user_id, @RequestParam("password") String user_password, @RequestParam(value = "code") String code, HttpServletRequest request) {
        User user = new User();
        user.setUser_id(user_id);
        user.setUser_password(user_password);
        boolean isLogin = userService.login(user);
        HttpSession session = request.getSession();
        String realCode = "";
        if (session.getAttribute("code") != null)
            realCode = (String) session.getAttribute("code");
        if (!realCode.toLowerCase().trim().equals(code.toLowerCase().trim()))
            return -1;//验证码错误
        else if (isLogin == true && realCode.toLowerCase().trim().equals(code.toLowerCase().trim())) {
            session.setAttribute("user_id", user_id);
            //如果正确以后，开启端口，查看当前
            return 1;//正确
        }
        return 0;//账号或密码错误
    }

    /**
     * 返回主页面
     */
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String mainPage(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user_id") != null) {
            User user = new User();
            String user_id = (String) session.getAttribute("user_id");
            user.setUser_id(user_id);
            user = userService.getUserById(user_id);
            model.addAttribute("user", user);
            return "main";
        }

        return "redirect:login";
    }

    /**
     * 注册页面
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage() {
        return "register";
    }

    /**
     * 注册
     * 0 验证码错误，-1 账号已存在，1插入成功
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public int register(User user, @RequestParam(value = "VerifyCode") String code, HttpServletRequest request) {
        System.out.println(user);
        System.out.println(code);
        HttpSession session = request.getSession();
        String realCode = "";
        if (session.getAttribute("code") != null)
            realCode = (String) session.getAttribute("code");
        if (!realCode.toLowerCase().trim().equals(code.toLowerCase().trim()))
            return 0;//验证码错误
        else return userService.register(user);
    }

}
