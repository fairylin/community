package life.fairy.community.mapper;

import life.fairy.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Insert("insert into question (title, description, gmt_create, gmt_modified, creator, view_count, like_count, comment_count, tag) values(#{title}, #{description}, #{gmtCreate}, #{gmtModified}, #{creator}, #{viewCount}, #{likeCount}, #{commentCount},#{tag})")
    void create(Question question);

    @Select("select * from question limit #{offset}, #{size}")
    List<Question> list(Integer offset, Integer size);
}
