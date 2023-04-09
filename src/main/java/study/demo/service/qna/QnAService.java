package study.demo.service.qna;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.demo.domain.qna.Answer;
import study.demo.domain.qna.Question;
import study.demo.dto.common.CustomResponse;
import study.demo.common.CustomMap;
import study.demo.dto.qna.AnswerDto;
import study.demo.dto.qna.QuestionDto;
import study.demo.mapper.qna.QnAMapper;

@Service
public class QnAService{
    @Autowired
    private QnAMapper qnaMapper;

    @Transactional
    public CustomResponse writeQuestion(QuestionDto question){
        CustomResponse response;
        try {
            ObjectMapper mapper = new ObjectMapper();
            CustomMap param =mapper.convertValue(question, new TypeReference<CustomMap>() {});

            qnaMapper.writeQuestion(param);
            response = setResponse(200, "success", null);

        } catch (Exception e) {
            response = setResponse(500, "fail", null);
        }
        return response;

    }
    public CustomResponse writeAnswer(AnswerDto answer){
        CustomResponse response;
        try {
            ObjectMapper mapper = new ObjectMapper();
            CustomMap param =mapper.convertValue(answer, new TypeReference<CustomMap>() {});

            qnaMapper.writeAnswer(param);
            response = setResponse(200, "success", null);

        } catch (Exception e) {
            response = setResponse(500, "fail", null);
        }
        return response;
    }
    public CustomResponse deleteQuestion(int questionId){
        CustomResponse response;
        try {
            ObjectMapper mapper = new ObjectMapper();

            qnaMapper.deleteQuestion(questionId);
            response = setResponse(200, "success", null);

        } catch (Exception e) {
            response = setResponse(500, "fail", null);
        }
        return response;
    }
    public CustomResponse deleteAnswer(int answerId){
        CustomResponse response;
        try {
            ObjectMapper mapper = new ObjectMapper();

            qnaMapper.deleteAnswer(answerId);
            response = setResponse(200, "success", null);

        } catch (Exception e) {
            response = setResponse(500, "fail", null);
        }
        return response;
    }
    public CustomResponse updateQuestion(Question question){
        CustomResponse response;
        try {
            ObjectMapper mapper = new ObjectMapper();
            CustomMap param =mapper.convertValue(question, new TypeReference<CustomMap>() {});

            qnaMapper.updateQuestion(param);
            response = setResponse(200, "success", null);

        } catch (Exception e) {
            response = setResponse(500, "fail", null);
        }
        return response;
    }
    public CustomResponse updateAnswer(Answer answer){
        CustomResponse response;
        try {
            ObjectMapper mapper = new ObjectMapper();
            CustomMap param =mapper.convertValue(answer, new TypeReference<CustomMap>() {});

            qnaMapper.updateAnswer(param);
            response = setResponse(200, "success", null);

        } catch (Exception e) {
            response = setResponse(500, "fail", null);
        }
        return response;
    }
    public CustomResponse getAllQuestions(){
        CustomResponse response;
        try {
            qnaMapper.getAllQuestion();
            response = setResponse(200, "success", null);

        } catch (Exception e) {
            response = setResponse(500, "fail", null);
        }
        return response;
    }
    public CustomResponse getAnswersByQuestionId(int questionId){
        CustomResponse response;
        try {
            qnaMapper.getAnswersByQuestionId(questionId);
            response = setResponse(200, "success", null);

        } catch (Exception e) {
            response = setResponse(500, "fail", null);
        }
        return response;
    }

    private CustomResponse setResponse(int status, String message, Object data){
        CustomResponse response = new CustomResponse();
        response.setStatus(status);
        response.setMessage(message);
        response.setData(data);
        return response;
    }
}