package study.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import study.demo.domain.Board;
import study.demo.dto.BoardDto;
import study.demo.dto.CommentDto;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {

    List<Board> findBoardAll();
    Board findBoardById(Long boardId);
    void createBoard(BoardDto boardDto);
    void deleteBoard(Long boardId);
    void updateBoard(Map<String, Object> paramMap);

}
