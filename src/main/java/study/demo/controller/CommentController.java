package study.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.demo.domain.Board;
import study.demo.domain.Comment;
import study.demo.dto.CommentDto;
import study.demo.dto.CustomResponse;
import study.demo.service.CommentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    // 댓글 생성
    @PostMapping("/new")
    public ResponseEntity<CustomResponse> createComment(@RequestBody CommentDto commentDto) {
        CustomResponse response = commentService.createComment(commentDto);
        return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
    }

    // 특정 게시글 댓글 조회
    @GetMapping("/{boardId}")
    public ResponseEntity<Board> findAllCommentByBoardId(@PathVariable Long boardId) {
        List<Comment> commentList = commentService.findAllCommentByBoardId(boardId);
        return new ResponseEntity(commentList, HttpStatus.OK);
    }

    // 댓글 수정
    @PutMapping("/update/{commentId}")
    public ResponseEntity<CustomResponse> updateComment(@PathVariable Long commentId, @RequestBody CommentDto commentDto) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("commentId", commentId);
        paramMap.put("commentDto", commentDto);
        CustomResponse response = commentService.updateComment(paramMap);
        return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
    }

    // 댓글 삭제
    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity<CustomResponse> deleteComment(@PathVariable Long commentId) {
        CustomResponse response = commentService.deleteComment(commentId);
        return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
    }
}
