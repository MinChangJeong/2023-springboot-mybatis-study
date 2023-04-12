package study.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.demo.domain.Board;
import study.demo.dto.BoardDto;
import study.demo.dto.CustomResponse;
import study.demo.mapper.BoardMapper;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BoardService {
    private final BoardMapper boardMapper;

    @Autowired
    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    // 게시글 전체 조회
    public List<Board> findBoardAll() {
        List<Board> boardList = new ArrayList<>();
        try {
            boardList = boardMapper.findBoardAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return boardList;
    }

    // 특정 게시글 조회
    public Board findBoardById(Long boardId) {
        Board board = new Board();
        try {
            board = boardMapper.findBoardById(boardId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return board;
    }

    // 게시글 작성
    @Transactional
    public CustomResponse createBoard(BoardDto boardDto) {
        CustomResponse response;
        try {
            response = setResponse(200, "success");
            boardMapper.createBoard(boardDto);
        } catch (Exception e) {
            e.printStackTrace();
            response = setResponse(500, "fail");
        }

        return response;
    }

    // 게시글 수정
    @Transactional
    public CustomResponse updateBoard(Map<String, Object> paramMap) {
        CustomResponse response;
        try {
            response = setResponse(200, "success");
            boardMapper.updateBoard(paramMap);
        } catch (Exception e) {
            response = setResponse(500, "fail");
            e.printStackTrace();
        }
        return response;
    }


    // 게시글 삭제
    @Transactional
    public CustomResponse deleteBoard(Long boardId) {
        CustomResponse response;
        try {
            response = setResponse(200, "success");
            boardMapper.deleteBoard(boardId);
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
