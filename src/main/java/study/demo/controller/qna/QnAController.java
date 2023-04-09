package study.demo.controller.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import study.demo.domain.qna.Answer;
import study.demo.domain.qna.Question;
import study.demo.dto.common.CustomResponse;
import study.demo.dto.qna.AnswerDto;
import study.demo.dto.qna.QuestionDto;
import study.demo.service.qna.QnAService;

@Controller
@RequestMapping("/qna")
public class QnAController
{
    @Autowired
    QnAService qnaService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<CustomResponse> writeQuestion(@RequestBody QuestionDto question)
    {
        CustomResponse response = qnaService.writeQuestion(question);
        return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
    }
    @PostMapping
    @ResponseBody
    public ResponseEntity<CustomResponse> writeAnswer(@RequestBody AnswerDto answer)
    {
        CustomResponse response = qnaService.writeAnswer(answer);
        return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
    }
    @ResponseBody
    @PutMapping
    public ResponseEntity<CustomResponse> updateQuestion(@RequestBody Question question)
    {
        CustomResponse response = qnaService.updateQuestion(question);
        return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
    }
    @ResponseBody
    @PutMapping
    public ResponseEntity<CustomResponse> updateAnswer(@RequestBody Answer answer)
    {
        CustomResponse response = qnaService.updateAnswer(answer);
        return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
    }
    @ResponseBody
    @DeleteMapping
    public ResponseEntity<CustomResponse> deleteQuestion(@RequestParam int questionId)
    {
        CustomResponse response = qnaService.deleteQuestion(questionId);
        return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
    }
    @ResponseBody
    @DeleteMapping
    public ResponseEntity<CustomResponse> deleteAnswer(@RequestParam int answerId)
    {
        CustomResponse response = qnaService.deleteAnswer(answerId);
        return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
    }
    @ResponseBody
    @GetMapping
    public ResponseEntity<CustomResponse> getAllQuestion()
    {
        CustomResponse response = qnaService.getAllQuestions();
        return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
    }
    @ResponseBody
    @GetMapping
    public ResponseEntity<CustomResponse> getAnswersByQuestionId(@RequestParam int questionId)
    {
        CustomResponse response = qnaService.getAnswersByQuestionId(questionId);
        return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
    }

}
