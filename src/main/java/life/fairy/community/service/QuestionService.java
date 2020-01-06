package life.fairy.community.service;

import life.fairy.community.dto.QuestionDTO;
import life.fairy.community.mapper.QuestionMapper;
import life.fairy.community.mapper.UserMapper;
import life.fairy.community.model.Question;
import life.fairy.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;


    public List<QuestionDTO> list(Integer page, Integer size) {
        // size*(page-1)
        Integer offset = size * (page - 1);

        List<Question> questions = questionMapper.list(offset, size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            // questionDTO.setTitle(question.getTitle());
            BeanUtils.copyProperties(question, questionDTO);
            questionDTOList.add(questionDTO);
            questionDTO.setUser(user);
        }
        return questionDTOList;
    }
}
