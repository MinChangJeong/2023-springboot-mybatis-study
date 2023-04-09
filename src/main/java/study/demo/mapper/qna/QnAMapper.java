package study.demo.mapper.qna;

import org.apache.ibatis.annotations.Mapper;

import study.demo.common.CustomList;
import study.demo.common.CustomMap;
import study.demo.domain.qna.Question;

@Mapper
public interface QnAMapper {
    void writeQuestion(CustomMap param);
    void writeAnswer(CustomMap param);
    void deleteQuestion(int questionId);
    void deleteAnswer(int answerId);
    void updateQuestion(CustomMap param);
    void updateAnswer(CustomMap param);
    CustomList<Question> getAllQuestion();
    CustomMap getAnswersByQuestionId(int questionId);

}
