package com.fish.blog.controller.admin;

import com.fish.blog.dao.AdminUserMapper;
import com.fish.blog.entity.AdminUser;
import com.fish.blog.service.*;
import com.fish.blog.util.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminUserService adminUserService;
    @Resource
    private BlogService blogService;
    @Resource
    private CategoryService categoryService;
    @Resource
    private LinkService linkService;
    @Resource
    private TagService tagService;
    @Resource
    private CommentService commentService;
    private static final String IMG_PATH = "/image";

    private static final String TEMP_IMG_PATH = "/templateImg/template.png";

    private static final Long IMG_CACHE_EX_TIME = 120L;


    @GetMapping({"/login"})
    public String login() {
        return "admin/login";
    }

    @GetMapping({"", "/", "/index", "/index.html"})
    public String index(HttpServletRequest request) {
        request.setAttribute("path", "index");
        request.setAttribute("categoryCount", categoryService.getTotalCategories());
        request.setAttribute("blogCount", blogService.getTotalBlogs());
        request.setAttribute("linkCount", linkService.getTotalLinks());
        request.setAttribute("tagCount", tagService.getTotalTags());
        request.setAttribute("commentCount", commentService.getTotalComments());
        return "admin/index";
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("password") String password,
                        @RequestParam("verifyCode") String verifyCode,
                        HttpSession session) {
        AdminUser adminUser = adminUserService.login(userName, password);
            if (adminUser != null) {
                String password1 =  MD5Util.MD5Encode(password);
                String passWord = adminUser.getLoginPassword();
                if (!password1.equals(passWord)) {
                    session.setAttribute("errorMsg", "????????????");
                    return "admin/login";
                }
                if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
                    session.setAttribute("errorMsg", "??????????????????????????????");
                    return "admin/login";
                }
                if (StringUtils.isEmpty(verifyCode)) {
                    session.setAttribute("errorMsg", "?????????????????????");
                    return "admin/login";
                }
                String kaptchaCode = session.getAttribute("verifyCode") + "";
                if (!verifyCode.equals(kaptchaCode)) {
                    session.setAttribute("errorMsg", "???????????????");
                    return "admin/login";
                }
                session.setAttribute("loginUser", adminUser.getNickName());
                session.setAttribute("loginUserId", adminUser.getAdminUserId());
                //session?????????????????????7200??? ????????????
                //session.setMaxInactiveInterval(60 * 60 * 2);
                return "redirect:/admin/index";
            } else {
                session.setAttribute("errorMsg", "????????????");
                return "admin/login";
            }
    }

    @GetMapping("/profile")
    public String profile(HttpServletRequest request) {
        Integer loginUserId = (int) request.getSession().getAttribute("loginUserId");
        AdminUser adminUser = adminUserService.getUserDetailById(loginUserId);
        if (adminUser == null) {
            return "admin/login";
        }
        request.setAttribute("path", "profile");
        request.setAttribute("loginUserName", adminUser.getLoginUserName());
        request.setAttribute("nickName", adminUser.getNickName());
        return "admin/profile";
    }

    @PostMapping("/profile/password")
    @ResponseBody
    public String passwordUpdate(HttpServletRequest request, @RequestParam("originalPassword") String originalPassword,
                                 @RequestParam("newPassword") String newPassword) {
        if (StringUtils.isEmpty(originalPassword) || StringUtils.isEmpty(newPassword)) {
            return "??????????????????";
        }
        Integer loginUserId = (int) request.getSession().getAttribute("loginUserId");
        if (adminUserService.updatePassword(loginUserId, originalPassword, newPassword)) {
            //?????????????????????session?????????????????????????????????????????????
            request.getSession().removeAttribute("loginUserId");
            request.getSession().removeAttribute("loginUser");
            request.getSession().removeAttribute("errorMsg");
            return "success";
        } else {
            return "????????????";
        }
    }

    @PostMapping("/profile/name")
    @ResponseBody
    public String nameUpdate(HttpServletRequest request, @RequestParam("loginUserName") String loginUserName,
                             @RequestParam("nickName") String nickName) {
        if (StringUtils.isEmpty(loginUserName) || StringUtils.isEmpty(nickName)) {
            return "??????????????????";
        }
        Integer loginUserId = (int) request.getSession().getAttribute("loginUserId");
        if (adminUserService.updateName(loginUserId, loginUserName, nickName)) {
            return "success";
        } else {
            return "????????????";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("loginUserId");
        request.getSession().removeAttribute("loginUser");
        request.getSession().removeAttribute("errorMsg");
        return "admin/login";
    }
}
