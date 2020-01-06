package life.fairy.community.controller;

import life.fairy.community.dto.QuestionDTO;
import life.fairy.community.mapper.QuestionMapper;
import life.fairy.community.mapper.UserMapper;
import life.fairy.community.model.Question;
import life.fairy.community.model.User;
import life.fairy.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "size", defaultValue = "1") Integer size
    ) {
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

        List<QuestionDTO> questionList = questionService.list(page, size);
        model.addAttribute("questions", questionList);
        return "index";
    }

}
