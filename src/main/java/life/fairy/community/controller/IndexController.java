package life.fairy.community.controller;

import life.fairy.community.dto.PaginationDTO;
import life.fairy.community.dto.QuestionDTO;
import life.fairy.community.mapper.UserMapper;
import life.fairy.community.model.User;
import life.fairy.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(
            HttpServletRequest request,
            Model model,
            @RequestParam(name = "page", defaultValue = "1") Integer page, // 获取的参数 显示的page
            @RequestParam(name = "size", defaultValue = "5") Integer size  // 获取的参数 每一页显示的数据量
    ) {
        // 判断是否已经存在登陆cookie内容，如果已经登陆，直接放回登陆信息
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("token", token);
                    }
                    break;
                }
            }
        }

        // 通过中间层 pagination 进行返回到html页面数据的封装
        PaginationDTO pagination = questionService.list(page, size);
        model.addAttribute("pagination", pagination);
        return "index";
    }

}
