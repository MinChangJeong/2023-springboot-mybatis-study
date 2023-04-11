package study.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import study.demo.domain.Board;
import study.demo.dto.BoardDto;
import study.demo.dto.CustomResponse;
import study.demo.service.BoardService;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 게시글 전체 조회
    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Board>> findBoardAll() {
        List<Board> boardList = boardService.findBoardAll();
        return new ResponseEntity<>(boardList, HttpStatus.OK);
    }

    // 특정 게시글 조회
    @GetMapping("/{boardId}")
    @ResponseBody
    public ResponseEntity<Board> findBoardById(@PathVariable Long boardId) {
        Board findBoard = boardService.findBoardById(boardId);
        return new ResponseEntity(findBoard, HttpStatus.OK);
    }

    // 게시글 작성
    @PostMapping("/new")
    @ResponseBody
    public ResponseEntity<CustomResponse> createBoard(@RequestBody BoardDto boardDto) {
        CustomResponse response = boardService.createBoard(boardDto);
        return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
    }

    // 게시글 수정
    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<CustomResponse> updateBoard(@RequestBody Board board) {
        CustomResponse response = boardService.updateBoard(board);
        return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
    }

    // 게시글 삭제
    @DeleteMapping("/delete/{boardId}")
    @ResponseBody
    public ResponseEntity<CustomResponse> deleteBoard(@PathVariable Long boardId) {
        CustomResponse response = boardService.deleteBoard(boardId);
        return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
    }
}
