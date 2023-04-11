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

@Service
public class BoardService {
    private final BoardMapper boardMapper;

    @Autowired
    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Transactional
    public CustomResponse createBoard(BoardDto boardDto) {
        CustomResponse response;

        try {
            response = setResponse(200, "success", null);
            boardMapper.createBoard(boardDto);
        } catch (Exception e) {
            e.printStackTrace();
            response = setResponse(500, "fail", null);
        }

        return response;
    }

    public List<Board> findBoardAll() {
        List<Board> boardList = new ArrayList<>();
        try {
            boardList = boardMapper.findBoardAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return boardList;
    }

    public Board findBoardById(Long boardId) {
        Board board = new Board();
        try {
            board = boardMapper.findBoardById(boardId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return board;
    }

    public CustomResponse updateBoard(Board board) {
        CustomResponse response;
        try {
            response = setResponse(200, "success", null);
            boardMapper.updateBoard(board);
        } catch (Exception e) {
            response = setResponse(500, "fail", null);
            e.printStackTrace();
        }
        return response;
    }


    public CustomResponse deleteBoard(Long boardId) {
        CustomResponse response;
        try {
            response = setResponse(200, "success", null);
            boardMapper.deleteBoard(boardId);
        } catch (Exception e) {
            response = setResponse(500, "fail", null);
            e.printStackTrace();
        }
        return response;
    }

    private CustomResponse setResponse(int status, String message, Object data){
        CustomResponse response = new CustomResponse();
        response.setStatus(status);
        response.setData(data);
        return response;
    }



}
