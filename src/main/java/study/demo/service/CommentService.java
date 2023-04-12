package study.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.demo.domain.Comment;
import study.demo.dto.CommentDto;
import study.demo.dto.CustomResponse;
import study.demo.mapper.CommentMapper;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CommentService {

    private final CommentMapper commentMapper;

    @Autowired
    public CommentService(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    // 댓글 생성
    @Transactional
    public CustomResponse createComment(CommentDto commentDto) {
        CustomResponse response;;
        try {
            response = setResponse(200, "success");
            commentMapper.createComment(commentDto);
        } catch (Exception e) {
            response = setResponse(500, "fail");
            e.printStackTrace();
        }
        return response;
    }

    // 특정 게시글 댓글 조회
    public List<Comment> findAllCommentByBoardId(Long boardId) {
        List<Comment> commentList = new ArrayList<>();
        try {
            commentList = commentMapper.findAllCommentByBoardId(boardId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return commentList;
    }

    // 댓글 수정
    @Transactional
    public CustomResponse updateComment(Map<String, Object> paramMap) {
        CustomResponse response;
        try {
            response = setResponse(200, "success");
            commentMapper.updateComment(paramMap);
        } catch (Exception e) {
            response = setResponse(500, "fail");
            e.printStackTrace();
        }
        return response;
    }

    // 댓글 삭제
    @Transactional
    public CustomResponse deleteComment(Long commentId) {
        CustomResponse response;
        try {
            response = setResponse(200, "success");
            commentMapper.deleteComment(commentId);
        } catch (Exception e) {
            response = setResponse(500, "fail");
            e.printStackTrace();
        }
        return response;
    }

    // 응답코드 반환
    private CustomResponse setResponse(int status, String message){
        CustomResponse response = new CustomResponse();
        response.setStatus(status);
        response.setMessage(message);
        return response;
    }


}
